package com.pretech.test.websockets;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>MessageTest</code> contains tests for the class <code>{@link Message}</code>.
 *
 * @author carasperbeck
 */
public class MessageTest {
	/**
	 * Run the Message(String) constructor test.
	 */
	@Test
	public void testMessage_1()
		throws Exception {
		String string = "";

		Message result = new Message(string);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getString());
	}

	/**
	 * Run the String getString() method test.
	 */
	@Test
	public void testGetString_1()
		throws Exception {
		Message fixture = new Message("");

		String result = fixture.getString();

		// add additional test code here
		assertEquals("", result);
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
		new org.junit.runner.JUnitCore().run(MessageTest.class);
	}
}