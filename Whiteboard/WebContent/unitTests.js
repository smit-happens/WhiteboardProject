/**
 * Created by Aaron on 3/31/2016.
 */
function startTest() {
    //var test = new Test("Test testing the tests");
    //
    //test.testEqual("example test true", true, true);
    //test.testEqual("example test false", false, true);
    //test.createColorTest("example color test", "orangered");
    //
    //test.testGreater("example test greater", 1, 3);
    //test.testLesser("example test lesser", 2, 1);
    //test.closeTests( );
    //
    //var test2 = new Test("A different test to test the testing code");
    //
    //test2.testEqual("example test equal", 45, 45);
    //test2.testEqual("example test not equal", 3.14, 2.89);
    //test2.createColorTest("example color test", "purple");
    //
    //test2.testGreater("example test greater", 1, 3);
    //test2.testLesser("example test lesser", 2, 1);
    //test2.closeTests();
    testPoint();
    testShapes();
    testTool();
    testMessageConsole();
}
//Test model.js code

function testPoint() {
    var p = new Point(100, 80);

    var p1 = new Point(570.3, 287.5);

    var p3 = new Point(100, 80);
    var pointTest = new Test("Point Object tests");

    pointTest.testEqual("point 1 X", 100, p.getX());
    pointTest.testEqual("point 1 Y", 80, p.getY());

    pointTest.testEqual("point 2 X", 570.3,  p1.getX());
    pointTest.testEqual("point 2 Y", 287.5, p1.getY());

    pointTest.testEqualsPoint("does p == p3",p, p3);

    pointTest.closeTests();
}

function testShapes() {
    var startPoint = new Point(0,0);
    var endPoint = new Point(10,10);

    var shape = new Shape();
    shape.add(startPoint);
    shape.add(endPoint);
    shape.setColor("#31B5FF");
    shape.setThickness(21);

    var shapeTest = new Test("Generic Shape Object tests")
    shapeTest.testEqualsPoint("start point", startPoint, shape.points[0]);
    shapeTest.testEqualsPoint("end point", endPoint, shape.points[shape.points.length-1]);
    shapeTest.testEqualColor("shape color", "#31B5FF", shape.color);
    shapeTest.testEqual("shape thickness (girth)", 21, shape.thickness);

    shapeTest.closeTests();
}

function testTriangle(startPoint, endPoint) {


}

function testCircle(startPoint, endPoint) {

}
function testRectangle(startPoint, endPoint) {

}
function testFreeform(startPoint, endPoint) {
    var startPoint = new Point(0,0);
    var endPoint = new Point(80,80);

    var collectPoint = new Point(18,25);
    var collectPoint2 = new Point(18,45);
    var collectPoint3 = new Point(75,87);

}

function testTool() {
    var tool = new Tool("red", 2 );

    var startPoint = new Point(0,0);
    var endPoint = new Point(80,80);

    var collectPoint = new Point(35,25);
    var collectPoint2 = new Point(18,45);
    var collectPoint3 = new Point(75,87);

    var canvas = document.getElementById("canvas");
    var shape = new FreeFormShape();

    tool.setColor("#68472a");
    tool.setThickness(3)

    tool.onStartDraw(shape, startPoint, canvas.getContext('2d'));
    tool.onRecordDraw(collectPoint, canvas.getContext('2d'));
    tool.onRecordDraw(collectPoint2, canvas.getContext('2d'));
    tool.onRecordDraw(collectPoint3, canvas.getContext('2d'));
    tool.onEndDraw(endPoint, canvas.getContext('2d'));


    var toolTest = new Test("Tool Tests");
    toolTest.testEqualsPoint("start point", startPoint, shape.points[0]);
    toolTest.testEqualsPoint("collect point", collectPoint, shape.points[1]);
    toolTest.testEqualsPoint("collect point", collectPoint2, shape.points[2]);
    toolTest.testEqualsPoint("collect point", collectPoint3, shape.points[3]);
    toolTest.testEqualsPoint("end point", endPoint, shape.points[shape.points.length-1]);
    toolTest.testEqualColor("shape color", "#68472a", shape.color);
    toolTest.testEqual("shape thickness (girth)", 3, shape.thickness);
    //toolTest.createCanvasTest("tool test output", canvas);

    toolTest.closeTests();
}

function testMessageConsole() {

    var messageTest = new Test("Message Console test");
    messageConsole.log("logging test");
    messageConsole.log("log test");

    var textArea = document.getElementById("messageWindow");
    var arrayOfLines = textArea.value.split("\n"); // arrayOfLines is array where every element

    messageTest.testEqualString("text sent to message console", "logging test", arrayOfLines[0]);
    messageTest.testEqualString("more text sent to message console", "log test", arrayOfLines[1]);
    messageTest.closeTests();

}