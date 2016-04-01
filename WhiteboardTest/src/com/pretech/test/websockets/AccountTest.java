package com.pretech.test.websockets;

import java.util.List;
import javax.websocket.Session;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>AccountTest</code> contains tests for the class <code>{@link Account}</code>.
 *
 * @generatedBy CodePro at 3/30/16 7:49 PM
 * @author carasperbeck
 * @version $Revision: 1.0 $
 */
public class AccountTest {
	/**
	 * Run the Account(Whiteboard,MessageSender) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testAccount_1()
		throws Exception {
		Whiteboard whiteboard = new Whiteboard();
		MessageSender messageSender = new MessageSender((Session) null);

		Account result = new Account(whiteboard, messageSender);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getPassword());
		assertEquals(null, result.getName());
	}

	/**
	 * Run the MessageSender getMessageSender() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testGetMessageSender_1()
		throws Exception {
		Account fixture = new Account(new Whiteboard(), new MessageSender((Session) null));
		fixture.setName("");
		fixture.setPassword("");

		MessageSender result = fixture.getMessageSender();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the List<Message> getMessages() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testGetMessages_1()
		throws Exception {
		Account fixture = new Account(new Whiteboard(), new MessageSender((Session) null));
		fixture.setName("");
		fixture.setPassword("");

		List<Message> result = fixture.getMessages();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the String getName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testGetName_1()
		throws Exception {
		Account fixture = new Account(new Whiteboard(), new MessageSender((Session) null));
		fixture.setName("");
		fixture.setPassword("");

		String result = fixture.getName();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getPassword() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testGetPassword_1()
		throws Exception {
		Account fixture = new Account(new Whiteboard(), new MessageSender((Session) null));
		fixture.setName("");
		fixture.setPassword("");

		String result = fixture.getPassword();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the Whiteboard getWhiteboard() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testGetWhiteboard_1()
		throws Exception {
		Account fixture = new Account(new Whiteboard(), new MessageSender((Session) null));
		fixture.setName("");
		fixture.setPassword("");

		Whiteboard result = fixture.getWhiteboard();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.getNumberOfAccounts());
	}

	/**
	 * Run the void removeAccountFromWhiteboard() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testRemoveAccountFromWhiteboard_1()
		throws Exception {
		Account fixture = new Account(new Whiteboard(), new MessageSender((Session) null));
		fixture.setName("");
		fixture.setPassword("");

		fixture.removeAccountFromWhiteboard();

		// add additional test code here
	}

	/**
	 * Run the void removeAccountFromWhiteboard() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testRemoveAccountFromWhiteboard_2()
		throws Exception {
		Account fixture = new Account(new Whiteboard(), new MessageSender((Session) null));
		fixture.setName("");
		fixture.setPassword("");

		fixture.removeAccountFromWhiteboard();

		// add additional test code here
	}

	/**
	 * Run the void removeAccountFromWhiteboard() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testRemoveAccountFromWhiteboard_3()
		throws Exception {
		Account fixture = new Account((Whiteboard) null, new MessageSender((Session) null));
		fixture.setName("");
		fixture.setPassword("");

		fixture.removeAccountFromWhiteboard();

		// add additional test code here
	}

	/**
	 * Run the void sendSingleAccountMessage(MessageCommand,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testSendSingleAccountMessage_1()
		throws Exception {
		Account fixture = new Account(new Whiteboard(), new MessageSender((Session) null));
		fixture.setName("");
		fixture.setPassword("");
		MessageCommand command = MessageCommand.Clear;
		String content = "";

		fixture.sendSingleAccountMessage(command, content);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.pretech.test.websockets.MessageSender.sendMessage(MessageSender.java:15)
		//       at com.pretech.test.websockets.Account.sendSingleAccountMessage(Account.java:53)
	}

	/**
	 * Run the void sendSingleAccountMessage(MessageCommand,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testSendSingleAccountMessage_2()
		throws Exception {
		Account fixture = new Account(new Whiteboard(), new MessageSender((Session) null));
		fixture.setName("");
		fixture.setPassword("");
		MessageCommand command = MessageCommand.Clear;
		String content = "";

		fixture.sendSingleAccountMessage(command, content);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.pretech.test.websockets.MessageSender.sendMessage(MessageSender.java:15)
		//       at com.pretech.test.websockets.Account.sendSingleAccountMessage(Account.java:53)
	}

	/**
	 * Run the void sendSingleAccountMessage(MessageCommand,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test(expected = java.lang.NullPointerException.class)
	public void testSendSingleAccountMessage_3()
		throws Exception {
		Account fixture = new Account(new Whiteboard(), new MessageSender((Session) null));
		fixture.setName("");
		fixture.setPassword("");
		MessageCommand command = MessageCommand.Clear;
		String content = null;

		fixture.sendSingleAccountMessage(command, content);

		// add additional test code here
	}

	/**
	 * Run the void sendSingleAccountMessage(MessageCommand,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test(expected = java.lang.NullPointerException.class)
	public void testSendSingleAccountMessage_4()
		throws Exception {
		Account fixture = new Account(new Whiteboard(), new MessageSender((Session) null));
		fixture.setName("");
		fixture.setPassword("");
		MessageCommand command = null;
		String content = "";

		fixture.sendSingleAccountMessage(command, content);

		// add additional test code here
	}

	/**
	 * Run the void setName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testSetName_1()
		throws Exception {
		Account fixture = new Account(new Whiteboard(), new MessageSender((Session) null));
		fixture.setName("");
		fixture.setPassword("");
		String name = "";

		fixture.setName(name);

		// add additional test code here
	}

	/**
	 * Run the void setPassword(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testSetPassword_1()
		throws Exception {
		Account fixture = new Account(new Whiteboard(), new MessageSender((Session) null));
		fixture.setName("");
		fixture.setPassword("");
		String password = "";

		fixture.setPassword(password);

		// add additional test code here
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
		new org.junit.runner.JUnitCore().run(AccountTest.class);
	}
}