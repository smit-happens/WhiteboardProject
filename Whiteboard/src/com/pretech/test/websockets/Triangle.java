package com.pretech.test.websockets;

public class Triangle extends Shape{
	double base;
	double height;
	Point top;
	
	public Triangle(Point top, double base, double height) {
		this.top= top;
		this.base = base;
		this.height = height;
	}

	public Point getTop() {
		return top;
	}

	public void setTop(Point top) {
		this.top = top;
	}

	public double getBase() {
		return base;
	}
	
	public void setBase(double base) {
		this.base = base;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
}
