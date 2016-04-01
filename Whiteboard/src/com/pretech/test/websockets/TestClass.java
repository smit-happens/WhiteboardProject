package com.pretech.test.websockets;

import org.apache.commons.lang3.StringUtils;

public class TestClass {

	public void testMe(String message){
		String command = StringUtils.substringBefore(message, "|");
		String commandData = StringUtils.substringAfter(message, "|");
		switch (command) {
		case "Update" :
			String shape = StringUtils.substringBefore(commandData, "|"); // circle
			String shapeData = StringUtils.substringAfter(commandData, "|"); // radius | center | girth | color

			if(shape.equals("Circle")){

				String[] circleDataArrStr = StringUtils.splitByWholeSeparatorPreserveAllTokens(shapeData, "|");
				double radius = Double.parseDouble(circleDataArrStr[0]); 
				int centerX = Integer.parseInt(circleDataArrStr[1]);
				int centerY = Integer.parseInt(circleDataArrStr[2]);
				double girth = Double.parseDouble(circleDataArrStr[3]); 
				double color = Double.parseDouble(circleDataArrStr[4]);

			}
			// Update | Rectangle | topLeft X | topleft Y | width | height| girth(#) | color(#)
			if(shape.equals("Rectangle")){
				String[] rectangleDataArrStr = StringUtils.splitByWholeSeparatorPreserveAllTokens(shapeData, "|");
				int topLeftX = Integer.parseInt(rectangleDataArrStr[0]); 
				int topLeftY = Integer.parseInt(rectangleDataArrStr[1]); 
				double width = Double.parseDouble(rectangleDataArrStr[2]); 
				double height = Double.parseDouble(rectangleDataArrStr[3]); 
				double girth = Double.parseDouble(rectangleDataArrStr[4]); 
				double color = Double.parseDouble(rectangleDataArrStr[5]); 
			}
			// Update | Triangle | top X | top Y | base | height| girth(#) | color(#)
			if(shape.equals("Triangle")){
				String[] triangleDataArrStr = StringUtils.splitByWholeSeparatorPreserveAllTokens(shapeData, "|");
				int topX = Integer.parseInt(triangleDataArrStr[0]); 
				int topY = Integer.parseInt(triangleDataArrStr[1]);
				double base = Double.parseDouble(triangleDataArrStr[2]); 
				double height = Double.parseDouble(triangleDataArrStr[3]);
				double girth = Double.parseDouble(triangleDataArrStr[4]); 
				double color = Double.parseDouble(triangleDataArrStr[5]);
			}
			break;
		}

	}

	public static void main(String[] args) {
		TestClass test = new TestClass();
		//test.testMe("Update|Circle|5.4|6|8|3.2|9.54|");
		//test.testMe("Update|Rectangle|5|6|7.6|3.4|6.5|8.1|");
		test.testMe("Update|Triangle|1|2|8.9|6.7|5.4|3.1|");
	}

}
