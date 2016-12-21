int boxsize = 25;
PFont f;
int cols, rows;
 
void setup() {
  size(500, 500); // Always first call in setup()!
//  f = loadFont("ArialNarrow-48.vlw");
  f = createFont("Arial", 48); // Previous line OK, this one is just more convenient for tests
  textFont(f, 10); // No need to call it on each cell, if you don't change it
  textAlign(CENTER);
  cols = width/boxsize;
  rows = height/boxsize;
}
 
void draw() {
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