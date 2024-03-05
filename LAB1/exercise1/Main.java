package LAB1.exercise1;

class Point2D { 
  private double x; 
  private double y; 
 
  public Point2D(double x, double y) { 
    this.x = x; 
    this.y = y; 
  } 
 
  public double distance(double x, double y) { 
    return distance(new Point2D(x, y)); 
  } 
 
  public double distance(Point2D p) { 
    return distance(this, p); 
  } 
 
  public static double distance(Point2D p1, Point2D p2) { 
// Write code to implement it 
    double pointDistance = Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    return pointDistance;
  } 
 
  public Point2D midpoint(Point2D p) { 
// Write code to implement it
    double midX = (this.x + p.x) / 2;
    double midY = (this.y + p.y) / 2;
    return new Point2D(midX, midY);
  }
   
 
  public double getX() { 
    return x; 
  } 
 
  public double getY() { 
    return y; 
  } 
} 

public class Main { 
  public static void main(String[] args) { 
    Point2D p1 = new Point2D(1, 2); 
    Point2D p2 = new Point2D(1, 4); 
    System.out.println("Distance between p1 and p2: "+p1.distance(p2));
    System.out.println("Midpoint of p1 and p2: "+p1.midpoint(p2).getX()+","+p1.midpoint(p2).getY());
  }
}