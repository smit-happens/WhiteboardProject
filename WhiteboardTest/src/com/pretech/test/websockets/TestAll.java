package com.pretech.test.websockets;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all
 * of the tests within its package as well as within any subpackages of its
 * package.
 *
 * @author carasperbeck
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	AccountTest.class,
	RectangleTest.class,
	MessageTest.class,
	TriangleTest.class,
	WhiteboardTest.class,
	CircleTest.class,
	MessageSenderTest.class,
	TestClassTest.class,
	WebSocketTestTest.class,
	MessageCommandTest.class,
	PointTest.class,
	FreeformTest.class,
	ShapeTest.class,
})
public class TestAll {

	/**
	 * Launch the test.
	 */
	public static void main(String[] args) {
		JUnitCore.runClasses(new Class[] { TestAll.class });
	}
}
