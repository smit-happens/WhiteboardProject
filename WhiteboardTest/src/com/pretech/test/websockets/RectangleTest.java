package com.pretech.test.websockets;

import javax.websocket.Session;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>RectangleTest</code> contains tests for the class <code>{@link Rectangle}</code>.
 *
 * @author carasperbeck
 */
public class RectangleTest {
	/**
	 * Run the Rectangle(Point,double,double) constructor test.
	 */
	@Test
	public void testRectangle_1()
		throws Exception {
		Point topLeft = new Point(1, 1);
		double width = 1.0;
		double height = 1.0;

		Rectangle result = new Rectangle(topLeft, width, height);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1.0, result.getHeight(), 1.0);
		assertEquals(1.0, result.getWidth(), 1.0);
		assertEquals(0, result.getColor());
		assertEquals(0.0, result.getGirth(), 1.0);
		assertEquals(null, result.getAccountID());
	}

	/**
	 * Run the double getHeight() method test.
	 */
	@Test
	public void testGetHeight_1()
		throws Exception {
		Rectangle fixture = new Rectangle(new Point(1, 1), 1.0, 1.0);
		fixture.color = 1;
		fixture.accountID = new Account(new Whiteboard(), new MessageSender((Session) null));
		fixture.girth = 1.0;

		double result = fixture.getHeight();

		// add additional test code here
		assertEquals(1.0, result, 0.1);
	}

	/**
	 * Run the Point getTopLeft() method test.
	 */
	@Test
	public void testGetTopLeft_1()
		throws Exception {
		Rectangle fixture = new Rectangle(new Point(1, 1), 1.0, 1.0);
		fixture.color = 1;
		fixture.accountID = new Account(new Whiteboard(), new MessageSender((Session) null));
		fixture.girth = 1.0;

		Point result = fixture.getTopLeft();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getY());
		assertEquals(1, result.getX());
	}

	/**
	 * Run the double getWidth() method test.
	 */
	@Test
	public void testGetWidth_1()
		throws Exception {
		Rectangle fixture = new Rectangle(new Point(1, 1), 1.0, 1.0);
		fixture.color = 1;
		fixture.accountID = new Account(new Whiteboard(), new MessageSender((Session) null));
		fixture.girth = 1.0;

		double result = fixture.getWidth();

		// add additional test code here
		assertEquals(1.0, result, 0.1);
	}

	/**
	 * Run the void setHeight(double) method test.
	 */
	@Test
	public void testSetHeight_1()
		throws Exception {
		Rectangle fixture = new Rectangle(new Point(1, 1), 1.0, 1.0);
		fixture.color = 1;
		fixture.accountID = new Account(new Whiteboard(), new MessageSender((Session) null));
		fixture.girth = 1.0;
		double height = 1.0;

		fixture.setHeight(height);

		// add additional test code here
	}

	/**
	 * Run the void setTopLeft(Point) method test.
	 */
	@Test
	public void testSetTopLeft_1()
		throws Exception {
		Rectangle fixture = new Rectangle(new Point(1, 1), 1.0, 1.0);
		fixture.color = 1;
		fixture.accountID = new Account(new Whiteboard(), new MessageSender((Session) null));
		fixture.girth = 1.0;
		Point topLeft = new Point(1, 1);

		fixture.setTopLeft(topLeft);

		// add additional test code here
	}

	/**
	 * Run the void setWidth(double) method test.
	 */
	@Test
	public void testSetWidth_1()
		throws Exception {
		Rectangle fixture = new Rectangle(new Point(1, 1), 1.0, 1.0);
		fixture.color = 1;
		fixture.accountID = new Account(new Whiteboard(), new MessageSender((Session) null));
		fixture.girth = 1.0;
		double width = 1.0;

		fixture.setWidth(width);

		// add additional test code here
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
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(RectangleTest.class);
	}
}