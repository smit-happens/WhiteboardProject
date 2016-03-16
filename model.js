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
    this.fillColor = color; //nofill by default
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
        ctx.arc(xPos, yPos, radius, 0, (2.0 * Math.PI), false); //draws circle arc
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
            Shape.prototype.draw(context); //calls super function. Not important in this case but really important later

            context.lineWidth = this.thickness; //sets up drawing context
            context.strokeStyle = this.color;
            context.lineCap = 'round';
            context.lineJoin = 'round';

            context.moveTo(this.points[0].x, this.points[0].y); //draws line in between circles where the mouse listener isn't fast enough
            context.beginPath();
            if(this.points.length < 2) {
                this.drawCircle(context, this.points[0].getX(), this.points[0].getY(), (this.thickness/2.0), this.color );
                return;
            }
            context.clearRect(0, 0, 1600, 700); //clears the screen using the built in clearRect() function

            var i;
            for(i=0; i<this.points.length - 2; i++) { //loop over points
                var mx = (this.points[i].getX() + this.points[i+1].getX()) / 2.0;
                var my = (this.points[i].getY() + this.points[i+1].getY()) / 2.0;
                context.quadraticCurveTo(this.points[i].getX(), this.points[i].getY(), mx, my);
            }
            context.stroke();
            context.closePath();
        }
    }
} );  //free form smooth drawing interpreted from http://stackoverflow.com/questions/7054272/how-to-draw-smooth-curve-through-n-points-using-javascript-html5-canvas/7058606#7058606


function TriangleShape() {
    Shape.call(this);
}

TriangleShape.prototype = Object.create(Shape.prototype, {
    constructor: TriangleShape,

    draw : {
        value : function (context) { //overrides the shape draw
            Shape.prototype.draw(context); //calls super function. Not important in this case but really important later

            context.lineWidth = this.thickness; //sets up drawing context
            context.strokeStyle = this.color;
            context.lineCap = 'round';
            context.lineJoin = 'round';

            var x = this.points[0].getX();
            var y = this.points[0].getY();
            var x1 = this.points[this.points.length-1].getX();
            var y1 = this.points[this.points.length-1].getY();
            context.clearRect(0,0, 1500,700);
            context.beginPath();
                context.moveTo(x,y );
                context.lineTo(x1,y1);
                context.moveTo(x1,y1);
                context.lineTo(x, y1);
                context.moveTo(x, y1);
                context.lineTo(x,y);
            context.stroke();
            context.closePath();

        }
    }

} );


function Tool(color, thick) { //currently this is a SINGLETON. this will be changed later.
    //this.color = color;
    this.shape = new Shape();
    this.thickness = thick;
    this.color = color;
}

Tool.prototype = {
    constructor : Tool,

    onStartDraw : function(shape, point, context) {
        this.shape = shape;
        this.shape.setColor(this.color);
        this.shape.setThickness(this.thickness);

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
        this.shape.add(point);
        this.shape.draw(context); //redraw
        return this.shape;
    },

    setColor : function(color) { //THESE WILL GET REMOVED LATER, when not singleton
        this.color = color;
        this.shape.setColor(color);
    },

    setThickness : function(thick) {
        this.thickness = thick;
        this.shape.setThickness(thick);
    }

};