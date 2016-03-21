package com.pretech.test.websockets;

public class Circle extends Shape{
	// declare variables 
	private double radius1;
	private Point center1;

	// define constructor
	public Circle(Point center, double radius) {
		this.center1= center;
		this.radius1= radius;
	}

	public Point getCenter() {
		return center1;
	}

	public void setCenter(Point center) {
		center1= center;
	}

	public double getRadius() {
		return radius1;
	}

	public void setRadius(double radius) {
		radius1= radius;
	}

}
