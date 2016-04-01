/**
 * Created by Aaron on 3/31/2016.
 */



function Test(name) {
    this.name = name; //name of the test
    //TODO: CREATE table outline, open tests
    this.outputStream = "";
    this.outputStream += "<div class=\"test\">";
    this.outputStream += ("<p>" + name + "</p>");
    this.outputStream += "<table>";
    this.outputStream += "<tr ><td class=\"noBorder\">Test Name</td>";
    this.outputStream += "<td class=\"noBorder\">Condition</td>";
    this.outputStream += "<td class=\"noBorder\">Value</td>";


    this.canvasContent = '';
    this.copyName = '';
}

Test.prototype = {

    constructor : Test,

    testEqual : function(name, condition, value) {
        if( condition == value) {
            this.createTest(name, condition, value, true);
        }
        else {
            this.createTest(name, condition, value, false);
        }
    },

    testEqualString : function(name, condition, value) {
        if( condition === value) {
            this.createTest(name, condition, value, true);
        }
        else {
            this.createTest(name, condition, value, false);
        }
    },

    testGreater : function(name, condition, value) {
        if( value >= condition) {
            this.createTest(name, condition, value, true);
        }
        else {
            this.createTest(name, condition, value, false);
        }
    },

    testLesser : function(name, condition, value) {
        if( value <= condition) {
            this.createTest(name, condition, value, true);
        }
        else {
            this.createTest(name, condition, value, false);
        }
    },

    testEqualsPoint : function(name, condition, value) {
        if(condition.getX() == value.getX()) {
            if (condition.getY() == value.getY()) {
                this.createTest(name, "(" + condition.getX() + ", " + condition.getY() + ")", "(" + value.getX() + ", " + value.getY() + ")", true);
                return true;
            }
        }

        this.createTest(name, "(" + condition.getX() + ", " + condition.getY() + ")", "(" + value.getX() + ", " + value.getY() + ")", false);

    },

    testEqualColor : function(name, condition, value) {
        if(condition === value) {
            this.createColorTest(name, condition, value, true);
            return true;
        }
        this.createColorTest(name, condition, value, false);
    },


    createTest : function(name, condition, value, conditionMet) {
        //TODO: add table to div

        this.outputStream += "<tr>";
        this.outputStream += ("<td>" + name + "</td>");
        this.outputStream += ("<td>" + condition + "</td>");
        this.outputStream += ("<td>" + value + "</td>");

        if(conditionMet == true) {
            this.outputStream += "<td class=\"good\">";
        }
        else {
            this.outputStream += "<td class=\"bad\">";
        }

        this.outputStream += "</td>";

    },

    createCanvasTest : function(name, canvas) {
        this.outputStream += "<tr>";
        this.outputStream += "<td id=\"" + name + "\"></td>";
        this.outputStream += "</tr>";
        this.canvasContent = canvas;
        this.copyName = name;
    },

    createColorTest : function(name, condition, value, conditionMet) {
        this.outputStream += "<tr>";
        this.outputStream += ("<td>" + name + "</td>");

        this.outputStream += "<td style=\"background-color:" + condition + ";\" ></td>";
        //this.outputStream += "<td style=\"background-color:31B5FF\" ></td>";

        this.outputStream += "<td style=\"background-color:" + value + ";\" ></td>";

        if(conditionMet == true) {
            this.outputStream += "<td class=\"good\">";
        }
        else {
            this.outputStream += "<td class=\"bad\">";
        }

        this.outputStream += "</td>";
    },

    closeTests : function() {
        //TODO: append end to table/div
        this.outputStream += "</tr>";
        this.outputStream += "</table>";
        this.outputStream += "</div>";

       document.getElementById("content").innerHTML += this.outputStream;

        if(document.getElementById(this.copyName) != null) {
            var newCanvas = document.createElement('canvas');
            newCanvas.id = this.copyName + "canvas";
            newCanvas.height = 100;
            newCanvas.width = 100;
            newCanvas.getContext('2d').drawImage(document.getElementById("canvas"), 0,0);//this doesn't work for some reason


            document.getElementById(this.copyName).appendChild(newCanvas);

        }
    }

};