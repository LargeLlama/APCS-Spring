int xWidth = 0;
int yWidth = 0;
boolean grow = false;

void setup() {
 size(600, 400);
 background(0); 
}

void draw() {
  clear();
  color c = color(0, 0, 255);
  fill(c);
  if (grow && xWidth > 0) {
    xWidth += 5;
    yWidth += 5;
  }else if (xWidth > 0) {
    xWidth -= 5;
    yWidth -= 5;
  }
  else {
    xWidth = 0;
    yWidth = 0;
  }
  ellipse(300, 200, xWidth, yWidth);
}

void mouseClicked() {
  xWidth++;
  yWidth++;
  grow = !grow;
}
