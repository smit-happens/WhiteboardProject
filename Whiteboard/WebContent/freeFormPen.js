/**
 * Created by Aaron on 1/27/2016.
 */
var shapes = [];  //list of shape objects returned by the tool
var cShape = new Shape(); //should this be a blank shape?

var isDrawing = false; //are we currently drawing?

var color = "red"; //default color is red
var thickness = 2;

var tool = new Tool(color, thickness);

function setDrawingTrue(event) {

    anchorToBase();

    isDrawing= true;
    var canvas = document.getElementById("myCanvas");
    canvas.setAttribute("onmousemove", "recordEvent(event)"); //sets mouse listener for canvas. Tracks all mouse moves
    document.getElementById("myCanvas").removeAttribute("onmouseout");

    if (canvas.getContext) { //if HTML5 is supported
        var pixel = getCursorPosition(canvas , event); //gets starting pos
        cShape = tool.onStartDraw(new FreeFormShape(), pixel, canvas.getContext('2d')); //sets up drawing in Tool object
        tool.setThickness(thickness); //setup initial thickness
    }
    else {
        window.alert("HTML 5 is not supported"); //pops window in older versions of browsers that don't support html5
    }
}

function setDrawingFalse(event) {
    isDrawing= false;
    console.log("drawing ended");
    var canvas = document.getElementById("myCanvas");
    document.getElementById("myCanvas").removeAttribute("onmousemove"); //removes mouse listener

    if (canvas.getContext) { //if HTML5 is supported
        var pixel = getCursorPosition(canvas , event); //gets ending pos
        tool.onEndDraw(pixel, canvas.getContext('2d') );
    }
    else {
        window.alert("HTML 5 is not supported"); //pops window in older versions of browsers that don't support html5
    }
}

function anchorToBase() {
    var base = document.getElementById("underlay");
    var top = document.getElementById("myCanvas");
    base.getContext('2d').drawImage(top, 0, 0);
    top.getContext('2d').clearRect(0, 0, top.width, top.height);

}

function undo() { //rudimentary undo button
    var top = document.getElementById("myCanvas");
    top.getContext('2d').clearRect(0, 0, top.width, top.height);
}

function clearCanvas() {
    shapes = []; //clears all shapes from mem
    var canvas = document.getElementById("underlay"); //grabs canvas element
    if (canvas.getContext) { //if HTML5 is supported
        var ctx = canvas.getContext('2d'); //gets drawing context
        ctx.clearRect(0, 0, canvas.width, canvas.height); //clears the screen using the built in clearRect() function
        undo();
    }
    else {
        window.alert("HTML 5 is not supported"); //pops window in older versions of browsers that don't support html5
    }
}

function changeColor() {
    color = "#" + Math.random().toString(16).slice(2, 8);   //creates a random number, converts it into a string with base 16, and 'cuts' it to the correct length
    tool.setColor(color);
}

function colorButton(button_color) {
    color = button_color;
    tool.setColor(button_color);
}

function getThickness() {
    thickness = document.getElementById("thickness").value
    document.getElementById("thickDisplay").innerHTML = "<strong>" + thickness + "</strong>";
    tool.setThickness(thickness);
}

function recordEvent(event) { //calls tool to update shape
    var canvas = document.getElementById("myCanvas");
    var pixel = getCursorPosition(canvas , event);
    if (canvas.getContext) { //if HTML5 is supported
       cShape = tool.onRecordDraw(pixel, canvas.getContext('2d'));
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