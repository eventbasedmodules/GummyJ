package org.gummymodules.app;

import org.gummymodules.generated.*;
import org.gummymodules.core.types.EventType;

// main class
public class Test {
	
	// main method
	public static void main(String[] arguments) {
		
		// start GummyJ and introduce instance manager to GummyJ back-end
		try {
			org.gummymodules.core.runtime.GummyJ.introduce(PremiumUsersEPAs.class, "epa1", "1", "1");
			org.gummymodules.core.runtime.GummyJ.introduce(PremiumUsersEPAs.class, "epa2", "2", "2");
		}
		catch (Exception exception) {
			System.out.println("Fail: start GummyJ");
		}
		
		// init server
		Server.init();
		
		// run test
		Client.runTest();
		
		// stop GummyJ
		try {
			Thread.sleep(1000); // wait in order to ensure that all events are fully processed before GummyJ is terminated
			org.gummymodules.core.runtime.GummyJ.terminate();
		}
		catch (Exception exception) {
			System.out.println("Fail: stop GummyJ");
		}
	}
}

class Client {
	
	// Event producer function. 
	private static void produce(String userID, String fileID, String userRole, String action) {
		EventType e = new EventType();
		if (action.equals("begin")) {
			e = new BeginEvent();
		}
		else if (action.equals("end")) {
			e = new EndEvent();
		}
		else if (action.equals("open")) {
			e = new OpenEvent();
			e.set("userID", userID);
			e.set("fileID", fileID);
			e.set("userRole", userRole);
		}
		else if (action.equals("close")) {
			e = new CloseEvent();
			e.set("userID", userID);
			e.set("fileID", fileID);
			e.set("userRole", userRole);
		}
		else if (action.equals("read")) {
			e = new ReadEvent();
			e.set("userID", userID);
			e.set("fileID", fileID);
			e.set("userRole", userRole);
		}
		else if (action.equals("write")) {
			e = new WriteEvent();
			e.set("userID", userID);
			e.set("fileID", fileID);
			e.set("userRole", userRole);
		}
		try {
			org.gummymodules.core.runtime.GummyJ.publish(e, org.gummymodules.core.runtime.GummyJ.PublishingMode.SYNCHRONOUS);
		}
		catch (Exception exception) {
			System.out.println("Fail: publishing event by client");
		}
	}
	
	// all user session and order checker modules are removed, 
	// the event history is removed. 
	private static void resetGummyModules() {
		try {
			org.gummymodules.core.runtime.GummyJ.publish(new ResetEvent(), org.gummymodules.core.runtime.GummyJ.PublishingMode.ASYNCHRONOUS);
			Thread.sleep(3000);
		}
		catch (Exception exception) {
			System.out.println("Fail: reset GummyJ");
		}
	};
	
	// run test
	public static void runTest() {
		try {
			
			// test started
			System.out.println("File Verification Test simulation started");
			System.out.println("Note: each test takes several seconds. Please be patient!");
			System.out.println();
			System.out.println();

			// test case 1
			System.out.println("Test case 1: No Output message expected!");
			produce("", "", "", "begin");
			produce("1", "1", "premium", "open"); 
			Thread.sleep(1000);
            produce("1", "1", "premium", "read");
			Thread.sleep(1000);
			produce("2", "2", "silver", "open"); 
			Thread.sleep(1000);
            produce("1", "1", "premium", "write");
			Thread.sleep(1000);
            produce("1", "1", "premium", "close");
			Thread.sleep(1000);
			produce("2", "2", "silver", "read");
			Thread.sleep(1000);
			produce("", "", "", "end");
			System.out.println();
			System.out.println();

			// test case 2
			System.out.println("Test case 2: Output messages for OutOfOrder event for userID=1 and fileID=1 and OutOfOrder event for userID=2 and fileID=2 expected!");
			resetGummyModules();
			produce("", "", "", "begin");
			produce("1", "1", "premium", "read"); // this event fails because there is no preceding open event for userID=1 and fileID=1
			Thread.sleep(1000);
			produce("2", "2", "premium", "open"); 
			Thread.sleep(1000);
			produce("2", "2", "premium", "close"); 
			Thread.sleep(1000);
			produce("2", "2", "premium", "write"); // this event fails because there is no preceding open event for userID=2 and fileID=2
			Thread.sleep(1000);
			produce("", "", "", "end");
			System.out.println();
			System.out.println();

			// test case 3
			System.out.println("Test case 3: Output message for Timeout event for userID=1 and fileID=1 expected!");
			resetGummyModules();
			produce("", "", "", "begin");
			produce("1", "1", "premium", "open");
			Thread.sleep(6000);
			produce("2", "2", "premium", "open"); 
			Thread.sleep(1000);
			produce("2", "2", "premium", "close"); 
			Thread.sleep(1000);
			produce("1", "1", "premium", "write"); // first timeout
			Thread.sleep(6000);
			produce("1", "1", "premium", "read"); // second timeout
			Thread.sleep(6000);
			produce("1", "1", "premium", "write"); // third timeout: timeout event is published
			Thread.sleep(6000);
			produce("", "", "", "end");
			System.out.println();
			System.out.println();

			// test case 4
			System.out.println("Test case 4: Output message for Timeout event for userID=1 and fileID=1 expected!");
			resetGummyModules();
			produce("", "", "", "begin");
			produce("1", "1", "premium", "open");
			produce("2", "2", "silver", "open"); 
			Thread.sleep(6000);
			produce("1", "1", "premium", "write"); // first timeout
			produce("2", "2", "silver", "write"); // first timeout
			Thread.sleep(6000);
			produce("1", "1", "premium", "read"); // second timeout
			produce("2", "2", "silver", "read"); // second timeout
			Thread.sleep(6000);
			produce("1", "1", "premium", "write"); // third timeout: timeout event is published
			produce("2", "2", "silver", "write"); // third timeout: no timeout event is published because the user has "silver" role
			Thread.sleep(6000);
			produce("", "", "", "end");
			System.out.println();
			System.out.println();

			// test finished
			System.out.println("Action Verification Test simulation done");
		}
		catch (Exception exception) {
			System.out.println("Fail: running GummyJ");
		}
	}
}

class Server {
	public static void init() {
		try {
			org.gummymodules.core.runtime.GummyJ.setHandler(
				new org.gummymodules.core.runtime.GummyJ.Handler() {
					public void handle(org.gummymodules.core.types.EventType e) {
						if (e instanceof OutOfOrderEvent) {
							System.out.println("[Output] event: " + e + ", userID = " + e.get("userID") + ", fileID = " + e.get("fileID"));
						}
						else if (e instanceof TimeoutEvent) {
							System.out.println("[Output] event: " + e + ", userID = " + e.get("userID") + ", fileID = " + e.get("fileID") + ", time = " + e.get("openTime"));
						}
					}
				}
			);
		}
		catch (Exception exception) {
			System.out.println("Fail: initialise Server");
		}
	}
}