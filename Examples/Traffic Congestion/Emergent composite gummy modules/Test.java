package org.gummymodules.app;

import org.gummymodules.generated.*;
import java.util.ArrayList;
import java.util.Iterator;

// main class
public class Test {
	
	// main method
	public static void main(String[] arguments) {
		
		// start GummyJ
		try {
			org.gummymodules.core.runtime.GummyJ.introduce(TrafficCongestion.class, "Traffic_Congestion_Segment1", new SegmentCoordinate(0, 0, 100, 100));
			org.gummymodules.core.runtime.GummyJ.introduce(TrafficCongestion.class, "Traffic_Congestion_Segment2", new SegmentCoordinate(200, 200, 300, 300));
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
	
	
	/*
	Here, helper methods and classes are defined. 
	*/
	
	// car coordinate class
	public static class CarCoordinate {
		public int x = 0;
		public int y = 0;
		public CarCoordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	// road segment coordinate class
	public static class SegmentCoordinate {
		public int beginx = 0;
		public int beginy = 0;
		public int endx = 0;
		public int endy = 0;
		public SegmentCoordinate(int beginx, int beginy, int endx, int endy) {
			this.beginx = beginx;
			this.beginy = beginy;
			this.endx = endx;
			this.endy = endy;
		}
	}
	
	// car info class
	public static class CarInfo {
		public String id;
		public CarCoordinate coordinate; 
		public Long time;
		public CarInfo(CarEvent evt) {
			this.id = (String)(evt.get("id"));
			this.coordinate = (CarCoordinate)(evt.get("coordinate"));
			this.time = (Long)(evt.get("time"));
		}
	}
	
	// returns whether value x is between a and b. 
	public static boolean isInBetween(int a, int b, int x) {
		return (a < b ? (x >= a) && (x <= b) : (x >= b) && (x <= a));
	}
	
	// Returns the time difference between the time attribute of the CarInfo 
	// object and the time attribute of the CarEvent object. 
	public static Long computeTravelTime(CarInfo ci, CarEvent evt) {
		Long time = (Long)(evt.get("time"));
		return ( (ci.time > time) ? (ci.time - time) : (time - ci.time) );
	}
	
	// Computes the average value of all items in the passed list. 
	public static Long computeAverageTime(ArrayList<Long> times) {
		Long sum = new Long(0);
		Iterator<Long> it = times.iterator();
		while(it.hasNext()) {
			sum = sum + it.next();
		}
		if (times.size() == 0) return new Long(0);
		else return sum / times.size();
	}
}

class Client {
	
	// Car event producer function  
	private static void produceCarEvent(String id, Test.CarCoordinate coordinate, Long time) {
		CarEvent e = new CarEvent();
		e.set("id", id);
		e.set("coordinate", coordinate);
		e.set("time", time);
		try {
			org.gummymodules.core.runtime.GummyJ.publish(e, org.gummymodules.core.runtime.GummyJ.PublishingMode.ASYNCHRONOUS);
		}
		catch (Exception exception) {
			System.out.println("Fail: publishing event by client");
		}
	}
	
	// Log event producer function  
	private static void produceLogEvent() {
		LogEvent e = new LogEvent();
		try {
			org.gummymodules.core.runtime.GummyJ.publish(e, org.gummymodules.core.runtime.GummyJ.PublishingMode.ASYNCHRONOUS);
		}
		catch (Exception exception) {
			System.out.println("Fail: publishing event by client");
		}
	}
	
	// Display event producer function  
	private static void produceDisplayEvent() {
		DisplayEvent e = new DisplayEvent();
		try {
			org.gummymodules.core.runtime.GummyJ.publish(e, org.gummymodules.core.runtime.GummyJ.PublishingMode.ASYNCHRONOUS);
		}
		catch (Exception exception) {
			System.out.println("Fail: publishing event by client");
		}
	}
	
	// GetInfoEvent event producer function  
	private static void produceGetInfoEvent(Long waitingTime) {
		GetInfoEvent e = new GetInfoEvent();
		e.set("waitingTime", waitingTime);
		try {
			org.gummymodules.core.runtime.GummyJ.publish(e, org.gummymodules.core.runtime.GummyJ.PublishingMode.SYNCHRONOUS);
		}
		catch (Exception exception) {
			System.out.println("Fail: publishing event by client");
		}
	}
	
	// all gummy modules are reset. 
	private static void resetGummyModules() {
		try {
			org.gummymodules.core.runtime.GummyJ.remove("Traffic_Congestion_Segment1");
			org.gummymodules.core.runtime.GummyJ.introduce(TrafficCongestion.class, "Traffic_Congestion_Segment1", new Test.SegmentCoordinate(0, 0, 100, 100));
			org.gummymodules.core.runtime.GummyJ.remove("Traffic_Congestion_Segment2");
			org.gummymodules.core.runtime.GummyJ.introduce(TrafficCongestion.class, "Traffic_Congestion_Segment2", new Test.SegmentCoordinate(200, 200, 300, 300));
		}
		catch (Exception exception) {
			System.out.println("Fail: reset GummyJ");
		}
	};
	
	// run test
	public static void runTest() {
		try {
			
			// test started
			// Note: as car events are sent asynchronously, the thread wait function 
			// is used in order to be quite sure that all events are fully processed before 
			// starting the next test
			System.out.println("Traffic Congestion Test simulation started");
			System.out.println();
			System.out.println();

			// test case 1
			System.out.println("Test case 1: No output message expected!");
			produceCarEvent("car1", new Test.CarCoordinate(30, 70), new Long(0)); // car1 enters segment Traffic_Congestion_Segment1
			produceCarEvent("car1", new Test.CarCoordinate(60, 70), new Long(20)); // car1 leaves segment Traffic_Congestion_Segment1; average waiting time for Traffic_Congestion_Segment1: 20
			produceLogEvent();
			produceDisplayEvent();
			System.out.println();
			System.out.println();
			Thread.sleep(1000);
			
			// test case 2
			System.out.println("Test case 2: No output message expected!");
			resetGummyModules();
			produceCarEvent("car1", new Test.CarCoordinate(30, 70), new Long(0)); // car1 enters segment Traffic_Congestion_Segment1
			produceCarEvent("car3", new Test.CarCoordinate(210, 280), new Long(0)); // car3 enters segment Traffic_Congestion_Segment2
			produceCarEvent("car2", new Test.CarCoordinate(130, 70), new Long(3)); // car2 is outside the segments of Traffic_Congestion_Segment1 and Traffic_Congestion_Segment2
			produceCarEvent("car2", new Test.CarCoordinate(140, 70), new Long(19)); // car2 is outside the segments of Traffic_Congestion_Segment1 and Traffic_Congestion_Segment2
			produceCarEvent("car3", new Test.CarCoordinate(240, 290), new Long(29)); // car3 leaves segment Traffic_Congestion_Segment2; average waiting time for Traffic_Congestion_Segment2: 29
			produceCarEvent("car1", new Test.CarCoordinate(60, 70), new Long(20)); // car1 leaves segment Traffic_Congestion_Segment1; average waiting time for Traffic_Congestion_Segment1: 20
			produceLogEvent();
			produceDisplayEvent();
			System.out.println();
			System.out.println();
			Thread.sleep(6000);
			
			// test case 3
			// Note: due to car events being sent asynchronously, 
			// it is undefined which car events the module already 
			// received when handling the log or display event
			System.out.println("Test case 3: A module construction message expected!");
			resetGummyModules();
			produceCarEvent("car1", new Test.CarCoordinate(30, 70), new Long(0)); // car1 enters segment Traffic_Congestion_Segment1
			produceCarEvent("car2", new Test.CarCoordinate(50, 50), new Long(3)); // car2 enters segment Traffic_Congestion_Segment1
			produceCarEvent("car1", new Test.CarCoordinate(60, 70), new Long(29)); // car1 leaves segment Traffic_Congestion_Segment1; average waiting time car1: 29
			produceCarEvent("car2", new Test.CarCoordinate(50, 90), new Long(40)); // // car2 enters segment Traffic_Congestion_Segment1; average waiting time car2: 37, for both cars: 33
			produceCarEvent("car3", new Test.CarCoordinate(10, 80), new Long(50)); // car3 enters segment Traffic_Congestion_Segment1
			produceCarEvent("car4", new Test.CarCoordinate(210, 280), new Long(0)); // car4 enters segment Traffic_Congestion_Segment2
			produceCarEvent("car4", new Test.CarCoordinate(210, 280), new Long(29)); // car4 leaves segment Traffic_Congestion_Segment2; average waiting time car1: 29
			produceLogEvent();
			produceDisplayEvent();
			System.out.println();
			System.out.println();
			Thread.sleep(6000);
			
			// test case 4
			// Note: due to car events being sent asynchronously, 
			// it is undefined which car events the module already 
			// received when handling the log or display event. 
		
			System.out.println("Test case 4: A module construction and a module destruction message expected!");
			resetGummyModules();
			produceCarEvent("car1", new Test.CarCoordinate(30, 70), new Long(0)); // car1 enters segment Traffic_Congestion_Segment1
			produceCarEvent("car2", new Test.CarCoordinate(50, 50), new Long(3)); // car2 enters segment Traffic_Congestion_Segment1
			produceCarEvent("car1", new Test.CarCoordinate(60, 70), new Long(29)); // car1 leaves segment Traffic_Congestion_Segment1; average waiting time car1: 29
			produceCarEvent("car2", new Test.CarCoordinate(50, 90), new Long(40)); // car2 leaves segment Traffic_Congestion_Segment1; average waiting time car2: 37; for both cars: 33
			Thread.sleep(200);
			produceCarEvent("car3", new Test.CarCoordinate(10, 80), new Long(50)); // car3 enters segment Traffic_Congestion_Segment1
			produceCarEvent("car3", new Test.CarCoordinate(10, 80), new Long(53)); // car3 leaves segment Traffic_Congestion_Segment1; average waiting time car3: 3, for all cars: 23
			produceLogEvent();
			produceDisplayEvent();
			System.out.println();
			System.out.println();
			Thread.sleep(6000);
			
			// test finished
			System.out.println("Traffic Congestion Test simulation done");
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
					public void handle(org.gummymodules.core.types.EventType event) {
						;
					}
				}
			);
		}
		catch (Exception exception) {
			System.out.println("Fail: initialise Server");
		}
	}
}