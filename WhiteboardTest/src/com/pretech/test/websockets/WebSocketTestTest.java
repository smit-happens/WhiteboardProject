package com.pretech.test.websockets;

import javax.websocket.Session;
import org.junit.*;
import static org.junit.Assert.*;

import java.io.IOException;

/**
 * The class <code>WebSocketTestTest</code> contains tests for the class <code>{@link WebSocketTest}</code>.
 *
 * @generatedBy CodePro at 3/30/16 7:49 PM
 * @author carasperbeck
 * @version $Revision: 1.0 $
 */
public class WebSocketTestTest {
	/**
	 * Run the WebSocketTest() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
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
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testOnClose_1()
		throws Exception {
		WebSocketTest fixture = new WebSocketTest();
		fixture.onOpen((Session) null);

		fixture.onClose();

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
	 * Run the void onClose() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testOnClose_2()
		throws Exception {
		WebSocketTest fixture = new WebSocketTest();
		fixture.onOpen((Session) null);

		fixture.onClose();

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
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
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
	 * Run the void onMessage(String,Session) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testOnMessage_2()
		throws Exception {
			String message = "helloworld";
			Session session = new MockWebsocketSession();
			WebSocketTest fixture = new WebSocketTest();
			fixture.onOpen(session);

		fixture.onMessage(message, session);

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
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testOnMessage_3()
		throws Exception {
		String message = "helloworld";
		Session session = new MockWebsocketSession();
		WebSocketTest fixture = new WebSocketTest();
		fixture.onOpen(session);

		fixture.onMessage(message, session);

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
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testOnMessage_4()
		throws Exception {
		String message = "helloworld";
		Session session = new MockWebsocketSession();
		WebSocketTest fixture = new WebSocketTest();
		fixture.onOpen(session);

		fixture.onMessage(message, session);

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
	 * @throws IOException 
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testOnMessage_5() throws IOException{
	String message = "helloworld";
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
	 * Run the void onMessage(String,Session) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testOnMessage_6()
		throws Exception {
		String message = "helloworld";
		Session session = new MockWebsocketSession();
		WebSocketTest fixture = new WebSocketTest();
		fixture.onOpen(session);

		fixture.onMessage(message, session);

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
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testOnMessage_7()
		throws Exception {
		String message = "helloworld";
		Session session = new MockWebsocketSession();
		WebSocketTest fixture = new WebSocketTest();
		fixture.onOpen(session);

		fixture.onMessage(message, session);

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
	 * @throws IOException 
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testOnMessage_8() throws IOException{
	String message = "helloworld";
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
	 * Run the void onMessage(String,Session) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testOnMessage_9()
		throws Exception {
		String message = "helloworld";
		Session session = new MockWebsocketSession();
		WebSocketTest fixture = new WebSocketTest();
		fixture.onOpen(session);

		fixture.onMessage(message, session);

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
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testOnMessage_10()
		throws Exception {
		String message = "helloworld";
		Session session = new MockWebsocketSession();
		WebSocketTest fixture = new WebSocketTest();
		fixture.onOpen(session);

		fixture.onMessage(message, session);

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
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testOnMessage_11()
		throws Exception {
		String message = "helloworld";
		Session session = new MockWebsocketSession();
		WebSocketTest fixture = new WebSocketTest();
		fixture.onOpen(session);

		fixture.onMessage(message, session);

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
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testOnMessage_12()
		throws Exception {
		String message = "helloworld";
		Session session = new MockWebsocketSession();
		WebSocketTest fixture = new WebSocketTest();
		fixture.onOpen(session);

		fixture.onMessage(message, session);

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
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testOnMessage_13()
		throws Exception {
		String message = "helloworld";
		Session session = new MockWebsocketSession();
		WebSocketTest fixture = new WebSocketTest();
		fixture.onOpen(session);

		fixture.onMessage(message, session);

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
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testOnMessage_14()
		throws Exception {
		String message = "helloworld";
		Session session = new MockWebsocketSession();
		WebSocketTest fixture = new WebSocketTest();
		fixture.onOpen(session);

		fixture.onMessage(message, session);

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
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testOnMessage_15()
		throws Exception {
		String message = "helloworld";
		Session session = new MockWebsocketSession();
		WebSocketTest fixture = new WebSocketTest();
		fixture.onOpen(session);

		fixture.onMessage(message, session);

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
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testOnMessage_16()
		throws Exception {
		String message = "helloworld";
		Session session = new MockWebsocketSession();
		WebSocketTest fixture = new WebSocketTest();
		fixture.onOpen(session);

		fixture.onMessage(message, session);

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
	 * Run the void onOpen(Session) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
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
	 * Run the void onOpen(Session) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testOnOpen_2()
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
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(WebSocketTestTest.class);
	}
}