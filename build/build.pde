int sqSize = 20;
int cols;
int rows;
PFont f;
PShape upperLeft, upperRight, lowerLeft, lowerRight;

void setup(){
	size(800, 800);
	rows = height/sqSize;
	cols = width/sqSize;
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



void draw(){

	//background(0);
  background (255/3);
	for (int i = 0; i < cols; i++){
		for (int j = 0; j < rows; j++){

			int x = sqSize * i;
			int y = sqSize * j;

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
