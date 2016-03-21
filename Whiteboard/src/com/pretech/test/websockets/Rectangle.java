package com.pretech.test.websockets;

public class Rectangle extends Shape{
	// declare variables
	private double width1 = 0;
	private double height1 = 0; 
	private Point topleft1;

	// define constructor
	public Rectangle(Point topLeft, double width, double height) {
		this.width1= width;
		this.topleft1= topLeft;
		this.height1= height;
	}

	public Point getTopLeft() {
		return topleft1;
	}

	public void setTopLeft(Point topLeft) {
		topleft1= topLeft;
	}

	public double getWidth() {
		return width1;
	}

	public void setWidth(double width) {
		width1= width;
	}

	public double getHeight() {
		return height1;
	}

	public void setHeight(double height) {
		height1= height;
	}

}
