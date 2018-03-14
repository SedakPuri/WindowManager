/*Sedak Puri
 * Programming Project 5
 * March 16th, 2018
 * Computer Science 2
 */

import java.awt.Color;
import edu.princeton.cs.introcs.StdDraw;

public class Window {
	private double xCenter, yCenter, halfWidth, halfHeight;
	private Color color;
	
	//Constructor for a single window
	public Window(double xCenter, double yCenter, double halfWidth, double halfHeight, Color color) {
		this.xCenter = xCenter;
		this.yCenter = yCenter;
		this.halfWidth = halfWidth;
		this.halfHeight = halfHeight;
		this.color = color;
	}
	
	//Method that draws a window
	public void draw() {
		StdDraw.setPenColor(color);
		StdDraw.filledRectangle(xCenter, yCenter, halfWidth, halfHeight);
	}
	
	//Method that returns a boolean if there is a window at the locations x's and y's
	public boolean contains(double x, double y) {
		return (x >= xCenter - halfWidth) && (x <= xCenter + halfWidth) && (y >= yCenter - halfHeight) && (y <= yCenter + halfHeight);
	}
	
	//Getters
	public double getxCenter() {
		return xCenter;
	}
	public double getyCenter() {
		return yCenter;
	}

	//Setters
	public void setxCenter(double xCenter) {
		this.xCenter = xCenter;
	}
	public void setyCenter(double yCenter) {
		this.yCenter = yCenter;
	}
}
