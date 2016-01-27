package edu.ycp.cs320.whiteboardProject.backbone;

import javax.swing.JApplet;
import javax.swing.JLabel;

public class backbone extends JApplet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; //what is this shit?

	public static void main(String[] args) {
		//With an applet we do not need this (?)
	}
	
	public void init() {
		//System.out.println("Hello World");
		JLabel frame = new JLabel("Hello World");
		add(frame);
		//testing
	}

}
