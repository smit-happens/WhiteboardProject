package com.pretech.test.websockets;

import javax.websocket.Session;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>MessageSenderTest</code> contains tests for the class <code>{@link MockMessageSender}</code>.
 *
 * @author carasperbeck
 */
public class MessageSenderTest {
	/**
	 * Run the MessageSender(Session) constructor test.
	 */
	@Test
	public void testMessageSender_1()
		throws Exception {
		Session session = new MockWebsocketSession();

		MockMessageSender result = new MockMessageSender(session);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String getSessionId() method test.
	 */
	@Test
	public void testGetSessionId_1()
		throws Exception {
		MockMessageSender fixture = new MockMessageSender((Session) null);

		String result = fixture.getSessionId();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.pretech.test.websockets.MessageSender.getSessionId(MessageSender.java:20)
		assertNotNull(result);
	}

	/**
	 * Run the void sendMessage(Message) method test.
	 */
	@Test
	public void testSendMessage_1()
		throws Exception {
		MockMessageSender fixture = new MockMessageSender((Session) null);
		Message message = new Message("");

		fixture.sendMessage(message);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.pretech.test.websockets.MessageSender.sendMessage(MessageSender.java:15)
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
		new org.junit.runner.JUnitCore().run(MessageSenderTest.class);
	}
}