package org.gummymodules.app;

import java.util.Map;
import java.util.HashMap;
import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import org.gummymodules.generated.*;


/*
Test application server class
*/
public class Test extends WebSocketServer {
	
	public Test(int port) {
		super(new InetSocketAddress(port));
		System.err.println("Server will provide ws://localhost:" + port);
	}
	
	
	private void log(String action, String content) {
		String string = "";
		string += ("[" + new SimpleDateFormat("hh:mm:ss:SSS").format(System.currentTimeMillis()) + "]");
		string += " " + ("<" + action + ">");
		if (content != null) string += " " + (content);
		System.out.println(string);
	}
	
	
	private void log(String action) {
		this.log(action, null);
	}
	
	
	private void initialize_gummyj(final WebSocket websocket) {
		String userID = "foo";
		String fileID = "bar";
		try {
			org.gummymodules.core.metamodel.GummyModule module;
			
			// set event consumer
			org.gummymodules.core.runtime.GummyJ.setHandler(
				new org.gummymodules.core.runtime.GummyJ.Handler() {
					public void handle(org.gummymodules.core.types.EventType event) {
						websocket.send(Message.instance().write(event));
					}
				}
			);
			
			// introduce gummy module
			org.gummymodules.core.runtime.GummyJ.introduce(PremiumUsersEPAs.class, "index", userID, fileID);
			
			this.log("gummyj", "ready");
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
	
	private void terminate_gummyj(final WebSocket websocket) {
		try {
			System.out.println("before: " + java.lang.Thread.activeCount());
			org.gummymodules.core.runtime.GummyJ.terminate();
			Thread.sleep(2000); System.out.println("after: " + java.lang.Thread.activeCount());
			for (Thread thread : Thread.getAllStackTraces().keySet()) System.out.println("\t" + thread.toString());
			this.log("gummyj", "terminated");
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
	
	@Override
	public void onError(WebSocket websocket, Exception exception) {
		this.log("error", exception.toString());
	}
	
	
	@Override
	public void onOpen(WebSocket websocket, ClientHandshake handshake) {
		this.log("open");
		this.initialize_gummyj(websocket);
		websocket.send(Message.instance().write("opened"));
	}
	
	
	@Override
	public void onClose(WebSocket websocket, int code, String reason, boolean remote) {
		this.log("close");
		this.terminate_gummyj(websocket);
	}
	
	
	@Override
	public void onMessage(WebSocket websocket, String message) {
		try {
			
			// read message from client and transform to an event object
			org.gummymodules.core.types.EventType event = Message.instance().read(message);
			
			// publish the event
			org.gummymodules.core.runtime.GummyJ.publish(event);
		}
		catch (Exception exception) {
			System.out.println("couldn't process message '" + message + "'");
			exception.printStackTrace();
		}
	}
	
	
	public static Test testServer;
	
	public static void main(String[] arguments) {
		int port = (arguments.length >= 1) ? Integer.parseInt(arguments[0]) : 9999;
		org.gummymodules.core.helpers.Logging.verbosity = 0;
		Test.testServer = new Test(port);
		Test.testServer.start();
	}
	
}
