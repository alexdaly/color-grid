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

public class test extends PApplet {

PShape s;

public void setup() {
  size(100, 100, P2D);

  // Make a shape
  s = createShape();
  s.beginShape();
  s.noStroke();

  // Exterior part of shape
  s.vertex(-50,-50);
  s.vertex(50,-50);
  s.vertex(50,50);
  s.vertex(-50,50);

  // Interior part of shape
  s.beginContour();
  s.vertex(-20,-20);
  s.vertex(20,-20);
  s.vertex(20,20);
  s.vertex(-20,20);
  s.endContour();

  // Finish off shape
  s.endShape();
}

public void draw() {
  background(52);
  translate(width/2, height/2);
  s.rotate(0.01f);
  shape(s);
}
int boxsize = 25;
PFont f;
int cols, rows;
 
public void setup() {
  size(500, 500); // Always first call in setup()!
//  f = loadFont("ArialNarrow-48.vlw");
  f = createFont("Arial", 48); // Previous line OK, this one is just more convenient for tests
  textFont(f, 10); // No need to call it on each cell, if you don't change it
  textAlign(CENTER);
  cols = width/boxsize;
  rows = height/boxsize;
}
 
public void draw() {
  for (int i = 0; i < cols; i++) {
    for (int j = 0; j < rows; j++) {
      int x = i*boxsize;
      int y = j*boxsize;
      fill(255);
      stroke(0);
      rect(x, y, boxsize, boxsize);
     
      fill(100, 150, 200);
      text(str(j * cols + i + 1), x + boxsize / 2, y + boxsize / 2);
      println("j * cols + i + 1: "+j * cols + i + 1);
    }
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--stop-color=#cccccc", "test" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
