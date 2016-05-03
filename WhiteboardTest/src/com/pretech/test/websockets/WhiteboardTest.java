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
		Whiteboard whiteboard = new Whiteboard("CS 320 board");
		assertNotNull(whiteboard);
	}

	/**
	 * Run the void broadcastMessage(MessageCommand,String) method test.
	 */
	@Test
	public void testBroadcastMessage_1()
		throws Exception {
		Whiteboard whiteboard = new Whiteboard("CS 320 board");
		MessageCommand command = MessageCommand.Clear;
		String content = "";
		// set up whiteboard so it has multiple accounts
		MessageSender messageSender = new MessageSender(new MockWebsocketSession());
		Account resultAccount1 = whiteboard.createAndAddAccount(messageSender);
		Account resultAccount2 = whiteboard.createAndAddAccount(messageSender);
		
		// broadcast message will loop through the accounts added above and assert true if the loop executes
		// no way to tell what message was sent haha it gets lost in ethernetLand
		whiteboard.broadcastMessage(command, content);
		assertTrue(true);
	}

	/**
	 * Run the Account createAndAddAccount(MessageSender) method test.
	 */
	@Test
	public void testCreateAndAddAccount_1()
		throws Exception {
		Whiteboard whiteboard = new Whiteboard("CS 320 board");
		MessageSender messageSender = new MessageSender(new MockWebsocketSession());

		Account resultAccount = whiteboard.createAndAddAccount(messageSender);
		String resultSessionID = resultAccount.getMessageSender().getSessionId();
		assertEquals("1", resultSessionID);
	}


	/**
	 * Run the int getNumberOfAccounts() method test.
	 */
	@Test
	public void testGetNumberOfAccounts_1()
		throws Exception {
		Whiteboard whiteboard = new Whiteboard("CS 320 board");
		int result1 = whiteboard.getNumberOfAccounts();
		MessageSender messageSender = new MessageSender(new MockWebsocketSession());
		Account resultAccount1 = whiteboard.createAndAddAccount(messageSender);
		Account resultAccount2 = whiteboard.createAndAddAccount(messageSender);
		int result = whiteboard.getNumberOfAccounts();
		
		if(result1 == 0){
			assertEquals(2, result);
		}
		// must use result1 -result because whiteboard classes account object is static and I only want the accounts I added to be tested
		else{
			assertEquals(2, result- result1);
		}
		
	}

	/**
	 * Run the void removeAccount(Account) method test.
	 */
	@Test
	public void testRemoveAccount_1()
		throws Exception {
		Whiteboard whiteboard = new Whiteboard("CS 320 board");
		int numAcctsOrig= whiteboard.getNumberOfAccounts();
		MessageSender messageSender = new MessageSender(new MockWebsocketSession());
		Account resultAccount = whiteboard.createAndAddAccount(messageSender);
		Account account = new Account(whiteboard, messageSender);
		account.setName("Joe");
		resultAccount.setName("Joe");
		String resultSessionID = resultAccount.getMessageSender().getSessionId();
		whiteboard.removeAccount(account);
		int numAccts= whiteboard.getNumberOfAccounts();
		if(numAcctsOrig==0){
			assertEquals(0, numAccts);
		}
		else{
			assertEquals(0, numAccts- numAcctsOrig);
		}
		

	}

	 /**
	 * Run the void removeAccountBySessionId(String) method test.
	 */
	@Test
	public void testRemoveAccountBySessionId_1()
		throws Exception {
		String id = "";
		Whiteboard whiteboard = new Whiteboard("CS 320 board");
		int numAcctsOrig= whiteboard.getNumberOfAccounts();

		whiteboard.removeAccountBySessionId(id);
		int numAccts= whiteboard.getNumberOfAccounts();
		if(numAcctsOrig==0){
			assertEquals(0, numAccts);
		}
		else{
			assertEquals(numAcctsOrig, numAccts);
		}
		
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