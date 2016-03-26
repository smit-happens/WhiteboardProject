/**
 * Created by Aaron on 1/27/2016.
 */
var shapes = [];  //list of shape objects returned by the tool
var cShape = new Shape(); //should this be a blank shape?

var isDrawing = false; //are we currently drawing?

var color = "red"; //default color is red
var thickness = 2;

var tool = new Tool(color, thickness);
var cTool = 0; //stores type of shape being currently drawn

var messageConsole = new MessageConsole(14); //setup message console

function setDrawingTrue(event) {
    messageConsole.log("drawing started");

    anchorToBase(); //copies last drawn image on top canvas to bottom canvas

    isDrawing= true;
    var canvas = getTopCanvas();

    canvas.setAttribute("onmousemove", "recordEvent(event)"); //sets mouse listener for canvas. Tracks all mouse moves
    canvas.removeAttribute("onmouseout");

    var pixel = getCursorPosition(canvas , event); //gets starting pos
    switch(cTool) {
        case 0:
            cShape = tool.onStartDraw(new FreeFormShape(), pixel, getContext(canvas)); //sets up drawing in Tool object
            break;
        case 1:
            cShape = tool.onStartDraw(new TriangleShape(), pixel, getContext(canvas)); //sets up drawing in Tool object
            break;
        case 2:
            cShape = tool.onStartDraw(new CircleShape(), pixel, getContext(canvas));
            break;
        default :
            cShape = tool.onStartDraw(new FreeFormShape(), pixel, getContext(canvas)); //sets up drawing in Tool object
            break;

    }

    tool.setThickness(thickness); //setup initial thickness

}

function setDrawingFalse(event) {
    isDrawing= false;
    messageConsole.log("drawing ended");
    var canvas = getTopCanvas();
    canvas.removeAttribute("onmousemove"); //removes mouse listener

    var pixel = getCursorPosition(canvas , event); //gets ending pos
    cShape = tool.onEndDraw(pixel, getContext(canvas) );
    notify(cTool, cShape);
}

function anchorToBase() {
    var base = document.getElementById("underlay");
    var top = getTopCanvas();
    base.getContext('2d').drawImage(top, 0, 0);
    top.getContext('2d').clearRect(0, 0, top.width, top.height);

}

function undo() { //rudimentary undo button
    var top = getTopCanvas();
    top.getContext('2d').clearRect(0, 0, top.width, top.height);
    broadcastWhiteboardUndo(); //sends request to server
}

function clearCanvas() {
    shapes = []; //clears all shapes from mem
    var canvas = getCanvas();

    getContext(canvas).clearRect(0, 0, canvas.width, canvas.height); //clears the screen using the built in clearRect() function
    var top = getTopCanvas();
    top.getContext('2d').clearRect(0, 0, top.width, top.height); //can't call undo- this would send the wrong message to the server
    broadcastWhiteboardClear(); //sends request to server
}

function changeColor() {
    color = "#" + Math.random().toString(16).slice(2, 8);   //creates a random number, converts it into a string with base 16, and 'cuts' it to the correct length
    tool.setColor(color);
}

function colorButton(button_color) {
    color = button_color;
    tool.setColor(button_color);
}

function DisplayNumUsers(users) {
    document.getElementById("numClients").innerHTML = users;
    console.log("Number of clients displayed")
}

//depreciated

//function getThickness() {
//    thickness = document.getElementById("thickness").value;
//    document.getElementById("thickDisplay").innerHTML = "" +thickness;
//    tool.setThickness(thickness);
//}

function setSize(size) {
    thickness = size;
    //document.getElementById("thickDisplay").innerHTML = "" + size; //depreciated
    tool.setThickness(thickness);
}

function changeTool(tool) {
    cTool = tool;
}

function recordEvent(event) { //calls tool to update shape
    var canvas = getTopCanvas();
    var pixel = getCursorPosition(canvas , event);

    cShape = tool.onRecordDraw(pixel, getContext(canvas));
}

function createNetworkShape(type, thickness, color, startX, startY, endX, endY) {
    var start_point = new Point(startX, startY);
    var end_point = new Point(endX, endY);
    var netShape;

    switch (type) {
        case 'triangle':
            netShape = new TriangleShape();
            break;
        case 'circle':
            break;

    }
    netShape.setThickness(thickness);
    netShape.setColor(color);
    netShape.add(start_point);
    netShape.add(end_point);
    shapes.push(netShape);
    anchorToBase(); //remove the net shape from the temp canvas as fast as possible.
}

function notify(type, shape) {
    //TODO: send shape to server

}




function getCanvas() {
    return document.getElementById("underlay")
}

function getTopCanvas() {
    return document.getElementById("myCanvas");
}

function getContext(canvas) {
    if(canvas.getContext) {
        return canvas.getContext('2d');
    }
    else {
        window.alert("HTML 5 is not supported"); //pops window in older versions of browsers that don't support html5
    }
}

function getCursorPosition(canvas, event) { //grabs canvas mouse event location based on a bounding area around the canvas element
    var rect = canvas.getBoundingClientRect();
    var x = event.clientX - rect.left;
    var y = event.clientY - rect.top;
    return new Point(x,y);
}
//code used from http://stackoverflow.com/questions/55677/how-do-i-get-the-coordinates-of-a-mouse-click-on-a-canvas-element