package com.pretech.test.websockets;

public class Point {
	// declare variables
		private int x=0;
		private int y=0;

		// define constructor
		public Point(int a, int b) {
			this.x= a;
		    this.y=b;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
		
		public void setX(int x1) {
			this.x=x1;
		}
		public void setY(int y1) {
			this.y=y1;
		}
}
