package com.pretech.test.websockets;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all
 * of the tests within its package as well as within any subpackages of its
 * package.
 *
 * @generatedBy CodePro at 3/30/16 7:49 PM
 * @author carasperbeck
 * @version $Revision: 1.0 $
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
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 3/30/16 7:49 PM
	 */
	public static void main(String[] args) {
		JUnitCore.runClasses(new Class[] { TestAll.class });
	}
}
