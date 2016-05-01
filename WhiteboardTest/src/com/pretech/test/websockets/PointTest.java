package com.pretech.test.websockets;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>PointTest</code> contains tests for the class <code>{@link Point}</code>.
 *
 * @author carasperbeck
 */
public class PointTest {
	/**
	 * Run the Point(int,int) constructor test.
	 */
	@Test
	public void testPoint_1()
		throws Exception {
		int a = 1;
		int b = 1;

		Point result = new Point(a, b);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.getY());
		assertEquals(1, result.getX());
	}

	/**
	 * Run the int getX() method test.
	 */
	@Test
	public void testGetX_1()
		throws Exception {
		Point fixture = new Point(1, 1);

		int result = fixture.getX();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the int getY() method test.
	 */
	@Test
	public void testGetY_1()
		throws Exception {
		Point fixture = new Point(1, 1);

		int result = fixture.getY();

		// add additional test code here
		assertEquals(1, result);
	}

	/**
	 * Run the void setX(int) method test.
	 */
	@Test
	public void testSetX_1()
		throws Exception {
		Point fixture = new Point(1, 1);
		int x1 = 1;

		fixture.setX(x1);

		// add additional test code here
	}

	/**
	 * Run the void setY(int) method test.
	 */
	@Test
	public void testSetY_1()
		throws Exception {
		Point fixture = new Point(1, 1);
		int y1 = 1;

		fixture.setY(y1);

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
		new org.junit.runner.JUnitCore().run(PointTest.class);
	}
}