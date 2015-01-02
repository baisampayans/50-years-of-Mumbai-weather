
Table table; 



int amount = 51;

PVector[] positions_x = new PVector[amount];
PVector[] positions_y = new PVector[amount];
PVector[] positions_z = new PVector[amount];

float[] x = new float[amount];
float[] y = new float[amount];
float[] z = new float[amount];
String[] n = new String[amount];


void setup() {
  size(1080, 780);



  background(0);
  noFill();
  strokeWeight(.5);
  smooth();

  loadData();
  graphData();

 
}



void loadData() {
  // Load CSV file into a Table object
  // "header" option indicates the file has a header row
  table = loadTable("points_jul.csv", "header");

  // You can access iterate over all the rows in a table
  int rowCount = 0;
  for (TableRow row : table.rows ()) {
    // You can access the fields via their column name (or index)
    x[rowCount] = row.getFloat("Max_temp");
    y[rowCount] = row.getFloat("Min_temp");
    z[rowCount] = row.getFloat("Rainfall");
    //n[rowCount] = row.getString("Year_Jan");
    rowCount++;
  }
}


void draw() {

  for (int i = 0; i<amount; i++) {
    fill(#FC4349);
    noStroke();
    ellipse(positions_x[i].x, positions_x[i].y, 10, 10); 
    
    fill(#314678);
    ellipse(positions_y[i].x, positions_y[i].y, 10, 10); 
    fill(#D7DADB);
    ellipse(positions_z[i].x, positions_z[i].y, 10, 10); 
    stroke(255, 255,255, 2);
    line (positions_x[i].x, positions_x[i].y, positions_z[i].x, positions_z[i].y );
    
 
  }
}

void mousePressed() {

 // background(0);
  saveFrame("save1/line-####.png");
  

//  int a = int (random(0, width));
//  int b = int (random(0, height));
//  //int c = int (random(255));
//  float sColor = map(a, 0, width, 0, 100);
//  stroke(sColor, 80, 90);
}



void graphData() {

  float xMin = 0.0;
  float xMax = 35.0;
  float yMin = min(y);
  float yMax = max(y);
  float zMin = 0.0;
  float zMax = 1500.0;

  //    println(xMin);
  //    println(xMax);

  int margin = 50;
  int graphHeight = height - margin * 2;
  int xGutter = width - margin * 2;

  for ( int i = 0; i < amount; i++) {

    // mapping x, y, z according to the coordinates of the graph size
    float xMap = map (x[i], xMin, xMax, 0, graphHeight);
    float xYPos = height - margin - xMap;
    float xXPos =  margin*i/2.7 + width/12;
    
    float yMap = map (y[i], xMin, xMax, 0, graphHeight);
    float yYPos = height - margin - yMap;
    float yXPos =  margin*i/2.7 + width/12;
    
    float zMap = map (z[i], zMin, zMax, 0, graphHeight);
    float zYPos = height - margin - zMap;
    float zXPos =  margin*i/2.7 + width/12;
    
    
    
    positions_x[i] = new PVector(xXPos, xYPos);
    positions_y[i] = new PVector(yXPos, yYPos);
    positions_z[i] = new PVector(zXPos, zYPos);
    
  }
}

