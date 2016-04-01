package com.pretech.test.websockets;

import javax.websocket.Session;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TriangleTest</code> contains tests for the class <code>{@link Triangle}</code>.
 *
 * @generatedBy CodePro at 3/30/16 7:49 PM
 * @author carasperbeck
 * @version $Revision: 1.0 $
 */
public class TriangleTest {
	/**
	 * Run the Triangle(Point,double,double) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testTriangle_1()
		throws Exception {
		Point top = new Point(1, 1);
		double base = 1.0;
		double height = 1.0;

		Triangle result = new Triangle(top, base, height);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1.0, result.getHeight(), 1.0);
		assertEquals(1.0, result.getBase(), 1.0);
		assertEquals(0, result.getColor());
		assertEquals(0.0, result.getGirth(), 1.0);
		assertEquals(null, result.getAccountID());
	}

	/**
	 * Run the double getBase() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testGetBase_1()
		throws Exception {
		Triangle fixture = new Triangle(new Point(1, 1), 1.0, 1.0);
		fixture.color = 1;
		fixture.girth = 1.0;
		fixture.accountID = new Account(new Whiteboard(), new MessageSender((Session) null));

		double result = fixture.getBase();

		// add additional test code here
		assertEquals(1.0, result, 0.1);
	}

	/**
	 * Run the double getHeight() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testGetHeight_1()
		throws Exception {
		Triangle fixture = new Triangle(new Point(1, 1), 1.0, 1.0);
		fixture.color = 1;
		fixture.girth = 1.0;
		fixture.accountID = new Account(new Whiteboard(), new MessageSender((Session) null));

		double result = fixture.getHeight();

		// add additional test code here
		assertEquals(1.0, result, 0.1);
	}

	/**
	 * Run the Point getTop() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testGetTop_1()
		throws Exception {
		Triangle fixture = new Triangle(new Point(1, 1), 1.0, 1.0);
		fixture.color = 1;
		fixture.girth = 1.0;
		fixture.accountID = new Account(new Whiteboard(), new MessageSender((Session) null));

		Point result = fixture.getTop();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getY());
		assertEquals(1, result.getX());
	}

	/**
	 * Run the void setBase(double) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testSetBase_1()
		throws Exception {
		Triangle fixture = new Triangle(new Point(1, 1), 1.0, 1.0);
		fixture.color = 1;
		fixture.girth = 1.0;
		fixture.accountID = new Account(new Whiteboard(), new MessageSender((Session) null));
		double base = 1.0;

		fixture.setBase(base);

		// add additional test code here
	}

	/**
	 * Run the void setHeight(double) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testSetHeight_1()
		throws Exception {
		Triangle fixture = new Triangle(new Point(1, 1), 1.0, 1.0);
		fixture.color = 1;
		fixture.girth = 1.0;
		fixture.accountID = new Account(new Whiteboard(), new MessageSender((Session) null));
		double height = 1.0;

		fixture.setHeight(height);

		// add additional test code here
	}

	/**
	 * Run the void setTop(Point) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	@Test
	public void testSetTop_1()
		throws Exception {
		Triangle fixture = new Triangle(new Point(1, 1), 1.0, 1.0);
		fixture.color = 1;
		fixture.girth = 1.0;
		fixture.accountID = new Account(new Whiteboard(), new MessageSender((Session) null));
		Point top = new Point(1, 1);

		fixture.setTop(top);

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
		new org.junit.runner.JUnitCore().run(TriangleTest.class);
	}
}