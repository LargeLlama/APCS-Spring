//Wubin Peco
//APCS-2 pd02
//HW52 fun
//2018-05-22

//instance variables
//keep track of circle size
int xWidth = 0;
int yWidth = 0;
//determine whether to grow it or not
boolean grow = false;

//setsup the screen
void setup() {
 size(600, 400);
 background(0); 
}

void draw() {
  //clear it so the old circles are removed
  clear();
  //set color to blue for circle
  color c = color(0, 0, 255);
  fill(c);
  //if the grow variable is true and the width is greater than 0, keep expanding
  if (grow && xWidth > 0) {
    xWidth += 5;
    yWidth += 5;
  }else if (xWidth > 0) {   //otherwise, make sure it's still above zero and then decrease the size
    xWidth -= 5;
    yWidth -= 5;
  }
  //if it gets below zero we keep resetting to zero
  else {
    xWidth = 0;
    yWidth = 0;
  }
  //draw the circle with the specified size
  ellipse(300, 200, xWidth, yWidth);
}

void mouseClicked() {
  //start incrementing so its not equal to zero anymore
  xWidth++;
  yWidth++;
  //flip the grow boolean
  grow = !grow;
}
