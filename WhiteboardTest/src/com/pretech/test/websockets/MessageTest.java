package com.pretech.test.websockets;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>MessageTest</code> contains tests for the class <code>{@link Message}</code>.
 *
 * @generatedBy CodePro at 3/30/16 7:48 PM
 * @author carasperbeck
 * @version $Revision: 1.0 $
 */
public class MessageTest {
	/**
	 * Run the Message(String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:48 PM
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
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:48 PM
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
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 3/30/16 7:48 PM
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
	 * @generatedBy CodePro at 3/30/16 7:48 PM
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
	 * @generatedBy CodePro at 3/30/16 7:48 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(MessageTest.class);
	}
}