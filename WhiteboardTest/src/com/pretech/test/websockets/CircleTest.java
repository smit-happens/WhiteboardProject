package com.pretech.test.websockets;

import javax.websocket.Session;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>CircleTest</code> contains tests for the class <code>{@link Circle}</code>.
 *
 * @generatedBy CodePro at 3/30/16 7:49 PM
 * @author carasperbeck
 * @version $Revision: 1.0 $
 */
public class CircleTest {
	/**
	 * Run the Circle(Point,double) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testCircle_1()
		throws Exception {
		Point center = new Point(1, 1);
		double radius = 1.0;

		Circle result = new Circle(center, radius);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1.0, result.getRadius(), 1.0);
		assertEquals(0, result.getColor());
		assertEquals(0.0, result.getGirth(), 1.0);
		assertEquals(null, result.getAccountID());
	}

	/**
	 * Run the Point getCenter() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testGetCenter_1()
		throws Exception {
		Circle fixture = new Circle(new Point(1, 1), 1.0);
		fixture.color = 1;
		fixture.accountID = new Account(new Whiteboard(), new MessageSender((Session) null));
		fixture.girth = 1.0;

		Point result = fixture.getCenter();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getY());
		assertEquals(1, result.getX());
	}

	/**
	 * Run the double getRadius() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testGetRadius_1()
		throws Exception {
		Circle fixture = new Circle(new Point(1, 1), 1.0);
		fixture.color = 1;
		fixture.accountID = new Account(new Whiteboard(), new MessageSender((Session) null));
		fixture.girth = 1.0;

		double result = fixture.getRadius();

		// add additional test code here
		assertEquals(1.0, result, 0.1);
	}

	/**
	 * Run the void setCenter(Point) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testSetCenter_1()
		throws Exception {
		Circle fixture = new Circle(new Point(1, 1), 1.0);
		fixture.color = 1;
		fixture.accountID = new Account(new Whiteboard(), new MessageSender((Session) null));
		fixture.girth = 1.0;
		Point center = new Point(1, 1);

		fixture.setCenter(center);

		// add additional test code here
	}

	/**
	 * Run the void setRadius(double) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testSetRadius_1()
		throws Exception {
		Circle fixture = new Circle(new Point(1, 1), 1.0);
		fixture.color = 1;
		fixture.accountID = new Account(new Whiteboard(), new MessageSender((Session) null));
		fixture.girth = 1.0;
		double radius = 1.0;

		fixture.setRadius(radius);

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
		new org.junit.runner.JUnitCore().run(CircleTest.class);
	}
}