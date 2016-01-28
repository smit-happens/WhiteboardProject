/**
 * Created by Aaron on 1/27/2016.
 */
var pixelArray = []; //stores location of pixels drawn over

var isDrawing = false; //are we currently drawing?

var color = "red"; //default color is red

function setDrawingTrue() {
    isDrawing= true;
    document.getElementById("myCanvas").setAttribute("onmousemove", "recordCircles(event)"); //sets mouse listener for canvas. Tracks all mouse moves
}

function setDrawingFalse() {
    pixelArray = []; //clears drawing array
    isDrawing= false;
    document.getElementById("myCanvas").removeAttribute("onmousemove"); //removes mouse listener
}

function clearCanvas() {
    pixelArray = [];
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
}

function recordCircles(event) { //records all mouse locations from the mouse listener
    var canvas = document.getElementById("myCanvas");
    var xy = getCursorPosition(canvas , event);
    pixelArray.push(xy);
    drawCircles();
    //console.log("PUSHED DATA");
}

function drawCircles() {
    var canvas = document.getElementById("myCanvas");
    var radius = 2; //radius is 2px
    if (canvas.getContext) {
        var ctx = canvas.getContext('2d');
        ctx.lineWidth = radius*2; //sets line connectors to 2px
        ctx.strokeStyle = color;  //hardcoded for now

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

function drawCircle(ctx, xPos, yPos, radius, fillStyle) {
    ctx.beginPath(); //begins drawing path
    ctx.arc(xPos, yPos, radius, 0, 2 * Math.PI, false); //draws circle arc
    ctx.fillStyle = fillStyle; //sets fill style
    ctx.fill(); //fills drawn arc path with fill style
    ctx.closePath();
}

function getCursorPosition(canvas, event) { //grabs canvas mouse event location based on a bounding area around the canvas element
    var rect = canvas.getBoundingClientRect();
    var x = event.clientX - rect.left;
    var y = event.clientY - rect.top;
    return {x, y};
}
//code used from http://stackoverflow.com/questions/55677/how-do-i-get-the-coordinates-of-a-mouse-click-on-a-canvas-element