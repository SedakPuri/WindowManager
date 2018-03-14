/*Sedak Puri
 * Programming Project 5
 * March 16th, 2018
 * Computer Science 2
 */

import java.util.ArrayList;
import edu.princeton.cs.introcs.StdDraw;

public class WindowDisplay {
	private ArrayList<Window> arr;
	private int canvasHeight, canvasWidth;
	private int incrementerClickStatus;
	private double deltaX;
	private double deltaY;

	private final static int NOT_PRESSED = 0;
	private final static int FIRST_FRAME = 1;
	private final static int HELD_DOWN = 2;

	//Constructor
	public WindowDisplay(int canvasHeight, int canvasWidth) {
		this.canvasHeight = canvasHeight;
		this.canvasWidth = canvasWidth;
		arr = new ArrayList<Window>();
		StdDraw.setXscale(0, canvasWidth);
		StdDraw.setYscale(0, canvasHeight);
		StdDraw.enableDoubleBuffering();
		incrementerClickStatus = NOT_PRESSED;
	}

	//Method to run the simulation (Effectively an animation loop)
	public void run() {
		double x, y;
		showWindow();
		while(true) {
			StdDraw.clear();
			x = StdDraw.mouseX();
			y = StdDraw.mouseY();
			mouseUpdater();
			moveWindow(x, y);
			showWindow();
			StdDraw.show();
		}
	}

	//Method to draw the window from bottom to top
	private void showWindow() {
		//Drawing the Squares
		for (int i = 0; i < arr.size(); i++) {
			arr.get(i).draw();
		}
	}

	//Method to move the window that is being clicked at locations x and y to the top location
	private void moveWindow(double x, double y) {
		//For loop that looks for window in at x and y starting at the end of the ArrayList
		for (int i = arr.size()-1; i >= 0;--i) {
			if (arr.get(i).contains(x, y)) {
				//When the window is initially clicked
				if(incrementerClickStatus == FIRST_FRAME) {
					Window temp = arr.get(i);
					deltaX = StdDraw.mouseX() - temp.getxCenter();
					deltaY = StdDraw.mouseY() - temp.getyCenter();
					arr.remove(i);
					arr.add(temp);
				//When the window is dragged
				} else if(incrementerClickStatus == HELD_DOWN) {
					Window temp;
					temp = arr.get(i);
					temp.setxCenter(StdDraw.mouseX() - deltaX);
					temp.setyCenter(StdDraw.mouseY() - deltaY);
					arr.remove(i);
					arr.add(temp);	
				}
				break;
			}
		}
	}

	//Handles the different states of if the mouse is not clicked, clicked, or held down
	private void mouseUpdater() { 
		if (!StdDraw.mousePressed()) {
			incrementerClickStatus = NOT_PRESSED;
		} else {
			if (incrementerClickStatus == NOT_PRESSED) {
				incrementerClickStatus = FIRST_FRAME;
			} else {
				incrementerClickStatus = HELD_DOWN;
			}
		}
	}

	//Method to add a window to the ArrayList
	public void addWindow(Window w) {
		arr.add(w);
	}
}