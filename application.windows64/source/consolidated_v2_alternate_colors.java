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

public class consolidated_v2_alternate_colors extends PApplet {


//import peasy.*;

//PeasyCam jCam;

Table table_jan;
Table table_feb;
Table table_mar;
Table table_apr;
Table table_may;
Table table_jun;
Table table_jul;
Table table_aug;
Table table_sep;
Table table_oct;
Table table_nov;
Table table_dec;


int amount = 50;
float[] x_jan = new float[amount];
float[] y_jan = new float[amount];
float[] z_jan = new float[amount];
float[] n_jan = new float[amount];

float[] x_feb = new float[amount];
float[] y_feb = new float[amount];
float[] z_feb = new float[amount];
float[] n_feb = new float[amount];

float[] x_apr = new float[amount];
float[] y_apr = new float[amount];
float[] z_apr = new float[amount];
float[] n_apr = new float[amount];

float[] x_mar = new float[amount];
float[] y_mar = new float[amount];
float[] z_mar = new float[amount];
float[] n_mar = new float[amount];

float[] x_may = new float[amount];
float[] y_may = new float[amount];
float[] z_may = new float[amount];
float[] n_may = new float[amount];

float[] x_jun = new float[amount];
float[] y_jun = new float[amount];
float[] z_jun = new float[amount];
float[] n_jun = new float[amount];

float[] x_jul = new float[amount];
float[] y_jul = new float[amount];
float[] z_jul = new float[amount];
float[] n_jul = new float[amount];

float[] x_aug = new float[amount];
float[] y_aug = new float[amount];
float[] z_aug = new float[amount];
float[] n_aug = new float[amount];

float[] x_sep = new float[amount];
float[] y_sep = new float[amount];
float[] z_sep = new float[amount];
float[] n_sep = new float[amount];

float[] x_oct = new float[amount];
float[] y_oct = new float[amount];
float[] z_oct = new float[amount];
float[] n_oct = new float[amount];

float[] x_nov = new float[amount];
float[] y_nov = new float[amount];
float[] z_nov = new float[amount];
float[] n_nov = new float[amount];

float[] x_dec = new float[amount];
float[] y_dec = new float[amount];
float[] z_dec = new float[amount];
float[] n_dec = new float[amount];

int currentMonth=0;

int stageX = 400;
int stageY = 300;
int stageZ = 150;

PFont font1;
PFont font2;


public void setup() {
  size(1900, 1200, OPENGL);
  //*
  font1 = loadFont("HelveticaNeue-Light-48.vlw");
  font2 = loadFont("HelveticaNeue-Bold-48.vlw"); //*/

  // for camera control with mouse 
  //jCam = new PeasyCam(this, 500);

  int a = PApplet.parseInt (random(0, width));
  int b = PApplet.parseInt (random(0, height));
  //int c = int (random(255));
  float sColor = map(a, 0, width, 0, 100);

  //colorMode(HSB, 100);
  background(0);
  noFill();
  //stroke(sColor,80,90);
  strokeWeight(1);
  smooth();
  //  frameRate(14);

  loadData();
  writeText();

  // for randomly creating points in 3D space
  //  for(int i = 0; i<amount; i++) {
  //    x[i] = int(random(-540, 540));
  //    y[i] = int(random(-390, 390));
  //    z[i] = int(random(-300, 300));
}



public void loadData() {
  // Load CSV file into a Table object
  // "header" option indicates the file has a header row
  table_jan = loadTable("points_jan.csv", "header");

  // You can access iterate over all the rows in a table
  int rowCount = 0;
  for (TableRow row : table_jan.rows ()) {
    // You can access the fields via their column name (or index)
    x_jan[rowCount] = row.getFloat("Max_temp");
    y_jan[rowCount] = row.getFloat("Min_temp");
    z_jan[rowCount] = row.getFloat("Rainfall");
    n_jan[rowCount] = row.getFloat("Year_Jan");
    rowCount++;
  }   

  table_feb = loadTable("points_feb.csv", "header");

  // You can access iterate over all the rows in a table
  rowCount = 0;
  for (TableRow row : table_feb.rows ()) {
    // You can access the fields via their column name (or index)
    x_feb[rowCount] = row.getFloat("Max_temp");
    y_feb[rowCount] = row.getFloat("Min_temp");
    z_feb[rowCount] = row.getFloat("Rainfall");
    n_feb[rowCount] = row.getFloat("Year_Feb");
    rowCount++;
  }  
  table_mar = loadTable("points_march.csv", "header");

  // You can access iterate over all the rows in a table
  rowCount = 0;
  for (TableRow row : table_mar.rows ()) {
    // You can access the fields via their column name (or index)
    x_mar[rowCount] = row.getFloat("Max_temp");
    y_mar[rowCount] = row.getFloat("Min_temp");
    z_mar[rowCount] = row.getFloat("Rainfall");
    n_mar[rowCount] = row.getFloat("Year_March");
    rowCount++;
  } 
  table_apr = loadTable("points_april.csv", "header");

  // You can access iterate over all the rows in a table
  rowCount = 0;
  for (TableRow row : table_apr.rows ()) {
    // You can access the fields via their column name (or index)
    x_apr[rowCount] = row.getFloat("Max_temp");
    y_apr[rowCount] = row.getFloat("Min_temp");
    z_apr[rowCount] = row.getFloat("Rainfall");
    n_apr[rowCount] = row.getFloat("Year_April");
    rowCount++;
  } 
  table_may = loadTable("points_may.csv", "header");

  // You can access iterate over all the rows in a table
  rowCount = 0;
  for (TableRow row : table_may.rows ()) {
    // You can access the fields via their column name (or index)
    x_may[rowCount] = row.getFloat("Max_temp");
    y_may[rowCount] = row.getFloat("Min_temp");
    z_may[rowCount] = row.getFloat("Rainfall");
    n_may[rowCount] = row.getFloat("Year_May");
    rowCount++;
  } 
  table_jun = loadTable("points_june.csv", "header");

  // You can access iterate over all the rows in a table
  rowCount = 0;
  for (TableRow row : table_jun.rows ()) {
    // You can access the fields via their column name (or index)
    x_jun[rowCount] = row.getFloat("Max_temp");
    y_jun[rowCount] = row.getFloat("Min_temp");
    z_jun[rowCount] = row.getFloat("Rainfall");
    n_jun[rowCount] = row.getFloat("Year_June");
    rowCount++;
  } 
  table_jul = loadTable("points_july.csv", "header");

  // You can access iterate over all the rows in a table
  rowCount = 0;
  for (TableRow row : table_jul.rows ()) {
    // You can access the fields via their column name (or index)
    x_jul[rowCount] = row.getFloat("Max_temp");
    y_jul[rowCount] = row.getFloat("Min_temp");
    z_jul[rowCount] = row.getFloat("Rainfall");
    n_jul[rowCount] = row.getFloat("Year_July");
    rowCount++;
  } 
  table_aug = loadTable("points_aug.csv", "header");

  // You can access iterate over all the rows in a table
  rowCount = 0;
  for (TableRow row : table_aug.rows ()) {
    // You can access the fields via their column name (or index)
    x_aug[rowCount] = row.getFloat("Max_temp");
    y_aug[rowCount] = row.getFloat("Min_temp");
    z_aug[rowCount] = row.getFloat("Rainfall");
    n_aug[rowCount] = row.getFloat("Year_August");
    rowCount++;
  } 
  table_sep = loadTable("points_sep.csv", "header");

  // You can access iterate over all the rows in a table
  rowCount = 0;
  for (TableRow row : table_sep.rows ()) {
    // You can access the fields via their column name (or index)
    x_sep[rowCount] = row.getFloat("Max_temp");
    y_sep[rowCount] = row.getFloat("Min_temp");
    z_sep[rowCount] = row.getFloat("Rainfall");
    n_sep[rowCount] = row.getFloat("Year_September");
    rowCount++;
  } 
  table_oct = loadTable("points_oct.csv", "header");

  // You can access iterate over all the rows in a table
  rowCount = 0;
  for (TableRow row : table_oct.rows ()) {
    // You can access the fields via their column name (or index)
    x_oct[rowCount] = row.getFloat("Max_temp");
    y_oct[rowCount] = row.getFloat("Min_temp");
    z_oct[rowCount] = row.getFloat("Rainfall");
    n_oct[rowCount] = row.getFloat("Year_October");
    rowCount++;
  } 
  table_nov = loadTable("points_nov.csv", "header");

  // You can access iterate over all the rows in a table
  rowCount = 0;
  for (TableRow row : table_nov.rows ()) {
    // You can access the fields via their column name (or index)
    x_nov[rowCount] = row.getFloat("Max_temp");
    y_nov[rowCount] = row.getFloat("Min_temp");
    z_nov[rowCount] = row.getFloat("Rainfall");
    n_nov[rowCount] = row.getFloat("Year_November");
    rowCount++;
  } 
  table_dec = loadTable("points_dec.csv", "header");

  // You can access iterate over all the rows in a table
  rowCount = 0;
  for (TableRow row : table_dec.rows ()) {
    // You can access the fields via their column name (or index)
    x_dec[rowCount] = row.getFloat("Max_temp");
    y_dec[rowCount] = row.getFloat("Min_temp");
    z_dec[rowCount] = row.getFloat("Rainfall");
    n_dec[rowCount] = row.getFloat("Year_December");
    rowCount++;
  } 
  //  println();

  //*/
}



public void draw() {

  //  smooth(); 

  //background(0);

  //  int a = int (random(0, width));
  //  int b = int (random(0, height));
  //  int c = int (random(255));
  //  float sColor = map(a, 0, width, 0, 100);
  //  stroke(sColor, 80, 90);

  //color(random(0,255), random(0,255), random(0,255));

  pushMatrix();
  translate(width/2, height/2);


  rotateY(frameCount/100.0f);
  //rotateZ(frameCount /100.0);
  rotateX(frameCount/100.0f);


  //box(300);
  for (int i = 0; i<amount; i++) {
    if (currentMonth==1) {
      point(map(x_jan[i], 0, 50, -stageX, stageX), map(y_jan[i], 0, 30, -stageY, stageY), map(z_jan[i], 0, 700, -stageZ, stageZ));
    } else if (currentMonth==2) {
      point(map(x_feb[i], 0, 50, -stageX, stageX), map(y_feb[i], 0, 30, -stageY, stageY), map(z_feb[i], 0, 700, -stageZ, stageZ));
    } else if (currentMonth==3) {     
      point(map(x_mar[i], 0, 50, -stageX, stageX), map(y_mar[i], 0, 30, -stageY, stageY), map(z_mar[i], 0, 700, -stageZ, stageZ));
    } else if (currentMonth==4) {     
      point(map(x_apr[i], 0, 50, -stageX, stageX), map(y_apr[i], 0, 30, -stageY, stageY), map(z_apr[i], 0, 700, -stageZ, stageZ));
    } else if (currentMonth==5) {     
      point(map(x_may[i], 0, 50, -stageX, stageX), map(y_may[i], 0, 30, -stageY, stageY), map(z_may[i], 0, 700, -stageZ, stageZ));
    } else if (currentMonth==6) {     
      point(map(x_jun[i], 0, 50, -stageX, stageX), map(y_jun[i], 0, 30, -stageY, stageY), map(z_jun[i], 0, 700, -stageZ, stageZ));
    } else if (currentMonth==7) {     
      point(map(x_jul[i], 0, 50, -stageX, stageX), map(y_jul[i], 0, 30, -stageY, stageY), map(z_jul[i], 0, 700, -stageZ, stageZ));
    } else if (currentMonth==8) {     
      point(map(x_aug[i], 0, 50, -stageX, stageX), map(y_aug[i], 0, 30, -stageY, stageY), map(z_aug[i], 0, 700, -stageZ, stageZ));
    } else if (currentMonth==9) {     
      point(map(x_sep[i], 0, 50, -stageX, stageX), map(y_sep[i], 0, 30, -stageY, stageY), map(z_sep[i], 0, 700, -stageZ, stageZ));
    } else if (currentMonth==10) {     
      point(map(x_oct[i], 0, 50, -stageX, stageX), map(y_oct[i], 0, 30, -stageY, stageY), map(z_oct[i], 0, 700, -stageZ, stageZ));
    } else if (currentMonth==11) {     
      point(map(x_nov[i], 0, 50, -stageX, stageX), map(y_nov[i], 0, 30, -stageY, stageY), map(z_nov[i], 0, 700, -stageZ, stageZ));
    } else if (currentMonth==12) {     
      point(map(x_dec[i], 0, 50, -stageX, stageX), map(y_dec[i], 0, 30, -stageY, stageY), map(z_dec[i], 0, 700, -stageZ, stageZ));
    }
  }
  popMatrix();
}

public void mousePressed() {

  //background(0);
  saveFrame("saved-2/"+currentMonth+"-##.png");
  //  int a = int (random(0, width));
  //  int b = int (random(0, height));
  //  //int c = int (random(255));
  //  float sColor = map(a, 0, width, 0, 100);
  //  stroke(sColor, 80, 90);
}

public void keyPressed() {

  //  if (key == 's') {
  //    saveFrame("saved-3/"+currentMonth+"-#.png");
  //  }

  writeText();

  if (key == '1') {
    stroke(39, 169, 225);    
    currentMonth = 1;
  } else if (key == '2') {
    stroke(0, 167, 157);     
    currentMonth = 2;
  } else if (key == '3') {
    stroke(0, 147, 68);     
    currentMonth = 3;
  } else if (key == '4') {
    stroke(56, 180, 73);     
    currentMonth = 4;
  } else if (key == '5') {
    stroke(140, 198, 62);     
    currentMonth = 5;
  } else if (key == '6') {
    stroke(214, 223, 35);    
    currentMonth = 6;
  } else if (key == '7') {
    stroke(248, 237, 49);     
    currentMonth = 7;
  } else if (key == '8') {
    stroke(251, 175, 63);    
    currentMonth = 8;
  } else if (key == '9') {
    stroke(247, 147, 29);    
    currentMonth = 9;
  } else if (key == 'a') {
    stroke(240, 90, 40);     
    currentMonth = 10;
  } else if (key == 'b') {
    stroke(239, 64, 54);     
    currentMonth = 11;
  } else if (key == 'c') {
    stroke(27, 117, 187);    
    currentMonth = 12;
  }
}

public void writeText() {

  background(0);

  stroke(255, 203, 30);
  line(300, (height/2-90), 300, (height/2+80));
 // line ((width - 140), (height/2 + 18), (width - 20), (height/2 + 18));
  //*

  if (key == '1') {  
    currentMonth = 1;
    textSize(24);
    text("January", (width-125), (height/2));
    textSize(60);
    text("1", (width-95), (height/2 + 82));
    line ((width - 140), (height/2 + 18), (width - 20), (height/2 + 18));
  } else if (key == '2') {  
    textSize(24);  
    text("February", (width-130), (height/2));
    textSize(60);
    text("2", (width-95), (height/2 + 82));
    line ((width - 140), (height/2 + 18), (width - 20), (height/2 + 18));
  } else if (key == '3') {
    textSize(24);
    text("March", (width-115), (height/2));
    textSize(60);
    text("3", (width-95), (height/2 + 82));
    line ((width - 140), (height/2 + 18), (width - 20), (height/2 + 18));
  } else if (key == '4') {
    textSize(24);
    text("April", (width-105), (height/2));
    textSize(60);
    text("4", (width-95), (height/2 + 82));
    line ((width - 140), (height/2 + 18), (width - 20), (height/2 + 18));
  } else if (key == '5') {
    textSize(24);
    text("May", (width-105), (height/2));
    textSize(60);
    text("5", (width-95), (height/2 + 82));
    line ((width - 140), (height/2 + 18), (width - 20), (height/2 + 18));
  } else if (key == '6') {
    textSize(24);
    text("June", (width-105), (height/2));
    textSize(60);
    text("6", (width-95), (height/2 + 82));
    line ((width - 140), (height/2 + 18), (width - 20), (height/2 + 18));
  } else if (key == '7') {
    textSize(24);
    text("July", (width-105), (height/2));
    textSize(60);
    text("7", (width-95), (height/2 + 82));
    line ((width - 140), (height/2 + 18), (width - 20), (height/2 + 18));
  } else if (key == '8') {
    textSize(24);
    text("August", (width-120), (height/2));
    textSize(60);
    text("8", (width-95), (height/2 + 82));
    line ((width - 140), (height/2 + 18), (width - 20), (height/2 + 18));
  } else if (key == '9') {
    textSize(24);
    text("September", (width-140), (height/2));
    textSize(60);
    text("9", (width-95), (height/2 + 82));
    line ((width - 140), (height/2 + 18), (width - 20), (height/2 + 18));
  } else if (key == 'a') {
    textSize(24);
    text("October", (width-125), (height/2));
    textSize(60);
    text("10", (width-110), (height/2 + 82));
    line ((width - 140), (height/2 + 18), (width - 20), (height/2 + 18));
  } else if (key == 'b') {
    textSize(24);
    text("November", (width-138), (height/2));
    textSize(60);
    text("11", (width-105), (height/2 + 82));
    line ((width - 145), (height/2 + 18), (width - 20), (height/2 + 18));
  } else if (key == 'c') {
    textSize(24);
    text("December", (width-142), (height/2));
    textSize(60);
    text("12", (width-110), (height/2 + 82));
    line ((width - 140), (height/2 + 18), (width - 20), (height/2 + 18));
  }



  textFont(font1, 18);
  // fill(#B5B5B1);
  fill(255);
  text("Press", 40, (height/2 - 80));
  textFont(font2, 18);
  fill(255, 203, 30);
  text("1 ", 95, (height/2 - 80));
  textFont (font1, 18);
  fill(255);
  text("to", 112, (height/2 - 80));
  textFont(font2, 18);
  fill(255, 203, 30);
  text("9", 138, (height/2 - 80));
  textFont(font1, 18);
  fill(255);
  text("and ", 158, (height/2 - 80));
  textFont(font2, 18);
  fill(255, 203, 30);
  text ("a, b, c", 198, (height/2 - 80));
  textFont(font1, 18);
  fill(255);
  text("to toggle between different ", 40, (height/2-40));
  text("months's", 40, (height/2));
  textFont(font2, 18);
  fill(255, 203, 30);
  text("visualisation", 130, (height/2));  

  text("Click", 40, (height/2 + 80));
  fill(255);
  textFont(font1, 18);
  text("to save a", 90, (height/2 + 80) );
  textFont(font2, 18);
  fill(255, 203, 30);
  text ("frame", 170, (height/2 + 80));
  //*/
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--stop-color=#cccccc", "consolidated_v2_alternate_colors" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
