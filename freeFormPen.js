/**
 * Created by Aaron on 1/27/2016.
 */
var shapes = [];  //list of shape objects returned by the tool
var cShape = new Shape(); //should this be a blank shape?

var isDrawing = false; //are we currently drawing?

var color = "red"; //default color is red
var thickness = 1;

var tool = new Tool(color, thickness);

function setDrawingTrue(event) {
    isDrawing= true;
    var canvas = document.getElementById("myCanvas");
    canvas.setAttribute("onmousemove", "recordEvent(event)"); //sets mouse listener for canvas. Tracks all mouse moves
    document.getElementById("myCanvas").removeAttribute("onmouseout");

    if (canvas.getContext) { //if HTML5 is supported
        var pixel = getCursorPosition(canvas , event); //gets starting pos
        cShape = tool.onStartDraw(new TriangleShape(), pixel, canvas.getContext('2d')); //sets up drawing in Tool object
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
        var pixel = getCursorPosition(canvas , event); //gets starting pos. Does the default event work?
       tool.onEndDraw(pixel, canvas.getContext('2d') );
    }
    else {
        window.alert("HTML 5 is not supported"); //pops window in older versions of browsers that don't support html5
    }

    anchorToBase();
}

function anchorToBase() {
    var base = document.getElementById("underlay");
    var top = document.getElementById("myCanvas");
    base.getContext('2d').drawImage(top, 0, 0);
    top.getContext('2d').clearRect(0, 0, top.width, top.height);

}

function clearCanvas() {
    shapes = []; //clears all shapes from mem
    var canvas = document.getElementById("myCanvas"); //grabs canvas element
    if (canvas.getContext) { //if HTML5 is supported
        var ctx = canvas.getContext('2d'); //gets drawing context
        ctx.clearRect(0, 0, canvas.width, canvas.height); //clears the screen using the built in clearRect() function
    }
    else {
        window.alert("HTML 5 is not supported"); //pops window in older versions of browsers that don't support html5
    }
}

function changeColor() {
    color = "#" + Math.random().toString(16).slice(2, 8);   //creates a random number, converts it into a string with base 16, and 'cuts' it to the correct length
    tool.setColor(color);
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
    //DEPRECIATED
    // pixelArray.push(xy);
    // drawCircles();
    //console.log("PUSHED DATA");
}

/*
function drawCircles() { //DEPRECIATED
    var canvas = document.getElementById("myCanvas");
    var radius = thickness;
    if (canvas.getContext) {
        var ctx = canvas.getContext('2d');
        ctx.lineWidth = radius*2; //sets line connectors to 2*radius
        ctx.strokeStyle = color;

        for(var i=1; i<pixelArray.length; i++) {

            ctx.beginPath();
            ctx.moveTo(pixelArray[i-1].x, pixelArray[i-1].y); //draws line in between circles where the mouse listener isn't fast enough
            ctx.lineTo( pixelArray[i].x, pixelArray[i].y);
            ctx.stroke();
            ctx.closePath();
            drawCircle(ctx, pixelArray[i].x, pixelArray[i].y, radius, color); //draws circle where mouse event location was
        }
    }

    else {
        window.alert("HTML 5 is not supported");
    }

}
*/

function getCursorPosition(canvas, event) { //grabs canvas mouse event location based on a bounding area around the canvas element
    var rect = canvas.getBoundingClientRect();
    var x = event.clientX - rect.left;
    var y = event.clientY - rect.top;
    return new Point(x,y);
}
//code used from http://stackoverflow.com/questions/55677/how-do-i-get-the-coordinates-of-a-mouse-click-on-a-canvas-element