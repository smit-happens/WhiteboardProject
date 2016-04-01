package com.pretech.test.websockets;

import javax.websocket.Session;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>ShapeTest</code> contains tests for the class <code>{@link Shape}</code>.
 *
 * @generatedBy CodePro at 3/30/16 7:48 PM
 * @author carasperbeck
 * @version $Revision: 1.0 $
 */
public class ShapeTest {
	/**
	 * Run the Account getAccountID() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:48 PM
	 */
	@Test
	public void testGetAccountID_1()
		throws Exception {
		Circle fixture = new Circle(new Point(1, 1), 1.0);
		fixture.accountID = new Account(new Whiteboard(), new MessageSender((Session) null));
		fixture.girth = 1.0;
		fixture.color = 1;

		Account result = fixture.getAccountID();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getPassword());
		assertEquals(null, result.getName());
	}

	/**
	 * Run the int getColor() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:48 PM
	 */
	@Test
	public void testGetColor_1()
		throws Exception {
		Circle fixture = new Circle(new Point(1, 1), 1.0);
		fixture.accountID = new Account(new Whiteboard(), new MessageSender((Session) null));
		fixture.girth = 1.0;
		fixture.color = 1;

		int result = fixture.getColor();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the double getGirth() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:48 PM
	 */
	@Test
	public void testGetGirth_1()
		throws Exception {
		Circle fixture = new Circle(new Point(1, 1), 1.0);
		fixture.accountID = new Account(new Whiteboard(), new MessageSender((Session) null));
		fixture.girth = 1.0;
		fixture.color = 1;

		double result = fixture.getGirth();

		// add additional test code here
		assertEquals(1.0, result, 0.1);
	}

	/**
	 * Run the void setAccountID(Account) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:48 PM
	 */
	@Test
	public void testSetAccountID_1()
		throws Exception {
		Circle fixture = new Circle(new Point(1, 1), 1.0);
		fixture.accountID = new Account(new Whiteboard(), new MessageSender((Session) null));
		fixture.girth = 1.0;
		fixture.color = 1;
		Account accountID = new Account(new Whiteboard(), new MessageSender((Session) null));

		fixture.setAccountID(accountID);

		// add additional test code here
	}

	/**
	 * Run the void setColor(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:48 PM
	 */
	@Test
	public void testSetColor_1()
		throws Exception {
		Circle fixture = new Circle(new Point(1, 1), 1.0);
		fixture.accountID = new Account(new Whiteboard(), new MessageSender((Session) null));
		fixture.girth = 1.0;
		fixture.color = 1;
		int color = 1;

		fixture.setColor(color);

		// add additional test code here
	}

	/**
	 * Run the void setGirth(double) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:48 PM
	 */
	@Test
	public void testSetGirth_1()
		throws Exception {
		Circle fixture = new Circle(new Point(1, 1), 1.0);
		fixture.accountID = new Account(new Whiteboard(), new MessageSender((Session) null));
		fixture.girth = 1.0;
		fixture.color = 1;
		double girth = 1.0;

		fixture.setGirth(girth);

		// add additional test code here
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
		new org.junit.runner.JUnitCore().run(ShapeTest.class);
	}
}