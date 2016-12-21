import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class build extends PApplet {

int sqSize = 20;
int cols;
int rows;
PFont f;
PShape upperLeft, upperRight, lowerLeft, lowerRight;

public void setup(){
	size(800, 800);
	cols = width/sqSize;
	rows = height/sqSize;
	smooth();
	noFill();
	ellipseMode(CORNER);
	
	f = createFont("Arial", 48); 
    textFont(f, 10); 
    textAlign(CENTER);

    upperLeft = loadShape("upperLeft.svg");
    upperRight = loadShape("upperRight.svg");
    lowerLeft = loadShape("lowerLeft.svg");
    lowerRight = loadShape("lowerRight.svg");
}



public void draw(){

	background(0);

	for (int i = 0; i < cols; i++){
		for (int j = 0; j < rows; j++){

			int x = sqSize * i;
			int y = sqSize * j;

            println("i: "+ i % 2);

			if ((i + j) % 2 == 0 && i % 2 == 0){
				strokeWeight(3);
				stroke(0, 255, 255);
				noFill();
				//ellipse(x, y, sqSize, sqSize);
				shape(upperLeft, x, y, sqSize, sqSize);
				upperLeft.disableStyle();

   			} else if((i + j) % 2 == 0 && i % 2 == 1) {
   				stroke(255, 255, 0);
   				strokeWeight(3);
   				//ellipse(x, y, sqSize, sqSize);
   				shape(lowerRight, x, y, sqSize, sqSize);
				lowerRight.disableStyle();

   			} else if ((i + j) % 2 == 1 && i % 2 == 0){
   				stroke(255, 0, 255);
   				strokeWeight(3);
   				//ellipse(x, y, sqSize, sqSize);
   				shape(lowerLeft, x, y, sqSize, sqSize);
				lowerLeft.disableStyle();

   			} else if ((i + j) % 2 == 1 && i % 2 == 1){
   				stroke(0, 255, 0);
   				strokeWeight(3);
   				//ellipse(x, y, sqSize, sqSize);
   				shape(upperRight, x, y, sqSize, sqSize);
				upperRight.disableStyle();
   			} 
				
		}
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--stop-color=#cccccc", "build" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
