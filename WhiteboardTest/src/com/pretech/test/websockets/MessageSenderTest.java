package com.pretech.test.websockets;

import javax.websocket.Session;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>MessageSenderTest</code> contains tests for the class <code>{@link MessageSender}</code>.
 *
 * @generatedBy CodePro at 3/30/16 7:49 PM
 * @author carasperbeck
 * @version $Revision: 1.0 $
 */
public class MessageSenderTest {
	/**
	 * Run the MessageSender(Session) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testMessageSender_1()
		throws Exception {
		Session session = new MockWebsocketSession();

		MessageSender result = new MessageSender(session);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the String getSessionId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testGetSessionId_1()
		throws Exception {
		MessageSender fixture = new MessageSender((Session) null);

		String result = fixture.getSessionId();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.pretech.test.websockets.MessageSender.getSessionId(MessageSender.java:20)
		assertNotNull(result);
	}

	/**
	 * Run the void sendMessage(Message) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testSendMessage_1()
		throws Exception {
		MessageSender fixture = new MessageSender((Session) null);
		Message message = new Message("");

		fixture.sendMessage(message);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.pretech.test.websockets.MessageSender.sendMessage(MessageSender.java:15)
	}

	/**
	 * Run the void sendMessage(Message) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testSendMessage_2()
		throws Exception {
		MessageSender fixture = new MessageSender((Session) null);
		Message message = new Message("");

		fixture.sendMessage(message);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.pretech.test.websockets.MessageSender.sendMessage(MessageSender.java:15)
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
		new org.junit.runner.JUnitCore().run(MessageSenderTest.class);
	}
}