import processing.core.*; import java.applet.*; import java.awt.*; import java.awt.image.*; import java.awt.event.*; import java.io.*; import java.net.*; import java.text.*; import java.util.*; import java.util.zip.*; public class Constrain extends PApplet {// Constrain
// by REAS <http://reas.com>

// Move the mouse across the screen to move the circle.
// The program constrains the circle to its box.

// Updated 20 January 2003

float mx;
float my;
float delay = 40.0f;
float esize = 25.0f;
int box = 30;

public void setup() 
{
  size(200, 200);
  noStroke(); 
  smooth();
  ellipseMode(CENTER_RADIUS);  
}

public void draw() 
{ 
  background(51);
  
  if(abs(mouseX - mx) > 0.1f) {
    mx = mx + (mouseX - mx)/delay;
  }
  if(abs(mouseY - my) > 0.1f) {
    my = my + (mouseY- my)/delay;
  }
  
  float distance = esize * 2;
  mx = constrain(mx, box+distance, width-box-distance);
  my = constrain(my, box+distance, height-box-distance);
  fill(76);
  rect(box+esize, box+esize, box*3, box*3);
  fill(255);  
  ellipse(mx, my, esize, esize);
}
}