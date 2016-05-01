package com.pretech.test.websockets;

import javax.websocket.Session;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>WhiteboardTest</code> contains tests for the class <code>{@link Whiteboard}</code>.
 *
 * @author carasperbeck
 */
public class WhiteboardTest {
	/**
	 * Run the Whiteboard() constructor test.
	 */
	@Test
	public void testWhiteboard_1()
		throws Exception {
		Whiteboard result = new Whiteboard();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the void broadcastMessage(MessageCommand,String) method test.
	 */
	@Test
	public void testBroadcastMessage_1()
		throws Exception {
		Whiteboard fixture = new Whiteboard();
		MessageCommand command = MessageCommand.Clear;
		String content = "";

		fixture.broadcastMessage(command, content);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.pretech.test.websockets.MessageSender.sendMessage(MessageSender.java:15)
		//       at com.pretech.test.websockets.Account.sendSingleAccountMessage(Account.java:53)
		//       at com.pretech.test.websockets.Whiteboard.broadcastMessage(Whiteboard.java:55)
	}

	/**
	 * Run the void broadcastMessage(MessageCommand,String) method test.
	 */
	@Test
	public void testBroadcastMessage_2()
		throws Exception {
		Whiteboard fixture = new Whiteboard();
		MessageCommand command = MessageCommand.Clear;
		String content = "";

		fixture.broadcastMessage(command, content);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.pretech.test.websockets.MessageSender.sendMessage(MessageSender.java:15)
		//       at com.pretech.test.websockets.Account.sendSingleAccountMessage(Account.java:53)
		//       at com.pretech.test.websockets.Whiteboard.broadcastMessage(Whiteboard.java:55)
	}

	/**
	 * Run the void broadcastMessage(MessageCommand,String) method test.
	 */
	@Test
	public void testBroadcastMessage_3()
		throws Exception {
		Whiteboard fixture = new Whiteboard();
		MessageCommand command = MessageCommand.Clear;
		String content = "";

		fixture.broadcastMessage(command, content);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.pretech.test.websockets.MessageSender.sendMessage(MessageSender.java:15)
		//       at com.pretech.test.websockets.Account.sendSingleAccountMessage(Account.java:53)
		//       at com.pretech.test.websockets.Whiteboard.broadcastMessage(Whiteboard.java:55)
	}

	/**
	 * Run the Account createAndAddAccount(MessageSender) method test.
	 */
	@Test
	public void testCreateAndAddAccount_1()
		throws Exception {
		Whiteboard fixture = new Whiteboard();
		MessageSender messageSender = new MessageSender((Session) null);

		Account result = fixture.createAndAddAccount(messageSender);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.pretech.test.websockets.MessageSender.sendMessage(MessageSender.java:15)
		//       at com.pretech.test.websockets.Account.sendSingleAccountMessage(Account.java:53)
		//       at com.pretech.test.websockets.Whiteboard.broadcastMessage(Whiteboard.java:55)
		//       at com.pretech.test.websockets.Whiteboard.createAndAddAccount(Whiteboard.java:18)
		assertNotNull(result);
	}

	/**
	 * Run the Account createAndAddAccount(MessageSender) method test.
	 */
	@Test
	public void testCreateAndAddAccount_2()
		throws Exception {
		Whiteboard fixture = new Whiteboard();
		MessageSender messageSender = new MessageSender((Session) null);

		Account result = fixture.createAndAddAccount(messageSender);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.pretech.test.websockets.MessageSender.sendMessage(MessageSender.java:15)
		//       at com.pretech.test.websockets.Account.sendSingleAccountMessage(Account.java:53)
		//       at com.pretech.test.websockets.Whiteboard.broadcastMessage(Whiteboard.java:55)
		//       at com.pretech.test.websockets.Whiteboard.createAndAddAccount(Whiteboard.java:18)
		assertNotNull(result);
	}

	/**
	 * Run the int getNumberOfAccounts() method test.
	 */
	@Test
	public void testGetNumberOfAccounts_1()
		throws Exception {
		Whiteboard fixture = new Whiteboard();

		int result = fixture.getNumberOfAccounts();

		// add additional test code here
		assertEquals(2, result);
	}

	/**
	 * Run the void removeAccount(Account) method test.
	 */
	@Test
	public void testRemoveAccount_1()
		throws Exception {
		Whiteboard fixture = new Whiteboard();
		Account a = new Account(new Whiteboard(), new MessageSender((Session) null));
		a.setName("");

		fixture.removeAccount(a);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.pretech.test.websockets.MessageSender.sendMessage(MessageSender.java:15)
		//       at com.pretech.test.websockets.Account.sendSingleAccountMessage(Account.java:53)
		//       at com.pretech.test.websockets.Whiteboard.broadcastMessage(Whiteboard.java:55)
		//       at com.pretech.test.websockets.Whiteboard.removeAccount(Whiteboard.java:34)
	}

	/**
	 * Run the void removeAccount(Account) method test.
	 */
	@Test
	public void testRemoveAccount_2()
		throws Exception {
		Whiteboard fixture = new Whiteboard();
		Account a = new Account(new Whiteboard(), new MessageSender((Session) null));

		fixture.removeAccount(a);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.pretech.test.websockets.Whiteboard.removeAccount(Whiteboard.java:27)
	}

	/**
	 * Run the void removeAccount(Account) method test.
	 */
	@Test
	public void testRemoveAccount_3()
		throws Exception {
		Whiteboard fixture = new Whiteboard();
		Account a = new Account(new Whiteboard(), new MessageSender((Session) null));
		a.setName("");

		fixture.removeAccount(a);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.pretech.test.websockets.MessageSender.sendMessage(MessageSender.java:15)
		//       at com.pretech.test.websockets.Account.sendSingleAccountMessage(Account.java:53)
		//       at com.pretech.test.websockets.Whiteboard.broadcastMessage(Whiteboard.java:55)
		//       at com.pretech.test.websockets.Whiteboard.removeAccount(Whiteboard.java:34)
	}

	/**
	 * Run the void removeAccount(Account) method test.
	 */
	@Test
	public void testRemoveAccount_4()
		throws Exception {
		Whiteboard fixture = new Whiteboard();
		Account a = new Account(new Whiteboard(), new MessageSender((Session) null));
		a.setName("");

		fixture.removeAccount(a);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.pretech.test.websockets.MessageSender.sendMessage(MessageSender.java:15)
		//       at com.pretech.test.websockets.Account.sendSingleAccountMessage(Account.java:53)
		//       at com.pretech.test.websockets.Whiteboard.broadcastMessage(Whiteboard.java:55)
		//       at com.pretech.test.websockets.Whiteboard.removeAccount(Whiteboard.java:34)
	}

	/**
	 * Run the void removeAccountBySessionId(String) method test.
	 */
	@Test
	public void testRemoveAccountBySessionId_1()
		throws Exception {
		Whiteboard fixture = new Whiteboard();
		String id = "";

		fixture.removeAccountBySessionId(id);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.pretech.test.websockets.MessageSender.getSessionId(MessageSender.java:20)
		//       at com.pretech.test.websockets.Whiteboard.removeAccountBySessionId(Whiteboard.java:41)
	}

	/**
	 * Run the void removeAccountBySessionId(String) method test.
	 */
	@Test
	public void testRemoveAccountBySessionId_2()
		throws Exception {
		Whiteboard fixture = new Whiteboard();
		String id = "";

		fixture.removeAccountBySessionId(id);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.pretech.test.websockets.MessageSender.getSessionId(MessageSender.java:20)
		//       at com.pretech.test.websockets.Whiteboard.removeAccountBySessionId(Whiteboard.java:41)
	}

	/**
	 * Run the void removeAccountBySessionId(String) method test.
	 */
	@Test
	public void testRemoveAccountBySessionId_3()
		throws Exception {
		Whiteboard fixture = new Whiteboard();
		String id = "";

		fixture.removeAccountBySessionId(id);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.pretech.test.websockets.MessageSender.getSessionId(MessageSender.java:20)
		//       at com.pretech.test.websockets.Whiteboard.removeAccountBySessionId(Whiteboard.java:41)
	}

	/**
	 * Run the void removeAccountBySessionId(String) method test.
	 */
	@Test
	public void testRemoveAccountBySessionId_4()
		throws Exception {
		Whiteboard fixture = new Whiteboard();
		String id = "";

		fixture.removeAccountBySessionId(id);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.pretech.test.websockets.MessageSender.getSessionId(MessageSender.java:20)
		//       at com.pretech.test.websockets.Whiteboard.removeAccountBySessionId(Whiteboard.java:41)
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
		new org.junit.runner.JUnitCore().run(WhiteboardTest.class);
	}
}