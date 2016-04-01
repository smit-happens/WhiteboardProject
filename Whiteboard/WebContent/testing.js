/**
 * Created by Aaron on 3/31/2016.
 */

function startTest() {
    var test = new Test("Test testing the tests");

    test.testEqual("example test true", true, true);
    test.testEqual("example test false", false, true);
    test.createColorTest("example color test", "orangered");

    test.testGreater("example test greater", 1, 3);
    test.testLesser("example test lesser", 2, 1);
    test.closeTests( );

    var test2 = new Test("Test testing the tests");

    test2.testEqual("example test true", true, true);
    test2.testEqual("example test false", false, true);
    test2.createColorTest("example color test", "orangered");

    test2.testGreater("example test greater", 1, 3);
    test2.testLesser("example test lesser", 2, 1);
    test2.closeTests();
}


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

    createColorTest : function(name, value) {
        this.outputStream += "<tr>";
        this.outputStream += ("<td>" + name + "</td>");
        this.outputStream += ("<td>" + value + "</td>");
        this.outputStream += ("<td>" + value + "</td>");

        this.outputStream += "<td style=\"background-color:" + value + ";\" ></td>"
    },

    closeTests : function() {
        //TODO: append end to table/div
        this.outputStream += "</tr>";
        this.outputStream += "</table>";
        this.outputStream += "</div>";

       document.getElementById("content").innerHTML += this.outputStream;
    }

};