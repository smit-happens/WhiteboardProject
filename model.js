/**
 * Created by Aaron on 3/12/2016.
 */
function Point(x,y) {
    this.x = x;
    this.y = y;
}

Point.prototype = {
    constructor: Point,
    getX : function() {
        return this.x;
    },
    getY : function(){
        return this.y;
    },

    compare: function(point) {
        //TODO: compare two points?
    }
};

function Shape() {
    this.points = []; //list of drawable points
    this.color = "red"; //default color is red
    this.fillColor = ""; //nofill by default
    this.thickness = 1.25; //thickness as defined by subclasses
}

Shape.prototype = {
    constructor: Shape,
    draw : function(context) { //arg is context of canvas.
        //will be defined below
        //console.log("SUPER_DRAWN");
    },
    add : function(point) {
      this.points.push(point);  //adds new point object to list
    },
    setColor : function(color) {
        this.color = color;
    },
    setThickness : function(thickness) {
        this.thickness = thickness;
    },

    drawCircle : function drawCircle(ctx, xPos, yPos, radius, fillStyle) {
        ctx.beginPath(); //begins drawing path
        ctx.arc(xPos, yPos, radius, 0, 2 * Math.PI, false); //draws circle arc
        ctx.fillStyle = fillStyle; //sets fill style
        ctx.fill(); //fills drawn arc path with fill style
        ctx.closePath();
    }
};

function FreeFormShape() {
    Shape.call(this); //equivalent to java's super() (I think)
}

FreeFormShape.prototype = Object.create(Shape.prototype, {

    constructor: FreeFormShape,
    draw : {
        value : function (context) { //overrides the shape draw
            //console.log("DRAWN");

            Shape.prototype.draw(context); //calls super function. Not important in this case but really important later

            context.lineWidth = this.thickness; //sets up drawing context
            context.strokeStyle = this.color;

            for(var i=1; i<this.points.length; i++) { //loop over points

                context.beginPath();
                context.moveTo(this.points[i-1].x, this.points[i-1].y); //draws line in between circles where the mouse listener isn't fast enough
                context.lineTo( this.points[i].x, this.points[i].y);
                context.stroke();
                context.closePath();
                this.drawCircle(context, this.points[i].x, this.points[i].y, (this.thickness/2), this.color); //draws circle where mouse event location was
            }
            
        }
    }
} );

function Tool(color, thick, shape) { //currently this is a SINGLETON. this will be changed later.
    //this.color = color;
    this.shape = shape;
    this.shape.setThickness(thick); //sets up shape
    this.shape.setColor(color); //sets up shape
}

Tool.prototype = {
    constructor : Tool,

    onStartDraw : function(point, context) {
        this.shape.add(point);
        this.shape.draw(context); //redraw
        return this.shape; //sends shape back to whiteboard
    },

    onEndDraw : function(point, context) {
        this.shape.add(point);
        this.shape.draw(context); //redraw
        return this.shape; //sends shape back to whiteboard
    },

    onRecordDraw : function(point, context) {
        this.shape.add(point); //this may not be needed for other shapes like triangle and rectangle, but it works for freeform shapes
        this.shape.draw(context); //redraw
        return this.shape;
    },

    setColor : function(color) { //THESE WILL GET REMOVED LATER, when not singleton
        this.shape.setColor(color);
    },

    setThickness : function(thick) {
        this.shape.setThickness(thick);
    }

};