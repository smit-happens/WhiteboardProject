package com.pretech.test.websockets;

import javax.websocket.Session;
import org.junit.*;
import static org.junit.Assert.*;

import java.io.IOException;

/**
 * The class <code>WebSocketTestTest</code> contains tests for the class <code>{@link WebSocketTest}</code>.
 * 
 * @author carasperbeck
 */
public class WebSocketTestTest {
	/**
	 * Run the WebSocketTest() constructor test.
	 */
	@Test
	public void testWebSocketTest_1()
		throws Exception {

		WebSocketTest result = new WebSocketTest();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the void onClose() method test.
	 */
	@Test
	public void testOnClose_1()
		throws Exception {
		WebSocketTest fixture = new WebSocketTest();
		fixture.onOpen((Session) null);

		fixture.onClose(null);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.pretech.test.websockets.MessageSender.sendMessage(MessageSender.java:15)
		//       at com.pretech.test.websockets.Account.sendSingleAccountMessage(Account.java:53)
		//       at com.pretech.test.websockets.Whiteboard.broadcastMessage(Whiteboard.java:55)
		//       at com.pretech.test.websockets.Whiteboard.createAndAddAccount(Whiteboard.java:18)
		//       at com.pretech.test.websockets.WebSocketTest.onOpen(WebSocketTest.java:111)
	}


	/**
	 * Run the void onMessage(String,Session) method test.
	 */
	@Test
	public void testOnMessage_1()
		throws Exception {
		String message = "helloworld";
		Session session = new MockWebsocketSession();
		WebSocketTest fixture = new WebSocketTest();
		fixture.onOpen(session);
		

		fixture.onMessage(message, session);

	}


	/**
	 * Run the void onOpen(Session) method test.
	 */
	@Test
	public void testOnOpen_1()
		throws Exception {
		Session session = new MockWebsocketSession();
		WebSocketTest fixture = new WebSocketTest();
		fixture.onOpen(session);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.pretech.test.websockets.MessageSender.sendMessage(MessageSender.java:15)
		//       at com.pretech.test.websockets.Account.sendSingleAccountMessage(Account.java:53)
		//       at com.pretech.test.websockets.Whiteboard.broadcastMessage(Whiteboard.java:55)
		//       at com.pretech.test.websockets.Whiteboard.createAndAddAccount(Whiteboard.java:18)
		//       at com.pretech.test.websockets.WebSocketTest.onOpen(WebSocketTest.java:111)
	}

	/**
	 * Perform pre-test initialization.
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(WebSocketTestTest.class);
	}
}