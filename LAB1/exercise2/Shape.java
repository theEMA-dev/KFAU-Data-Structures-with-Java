package LAB1.exercise2;

public interface Shape {
  double calculateArea();
  double calculatePerimeter();
}

class Circle implements Shape {
  private double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  public void printInfo() {
    System.out.println("-- Circle Info --");
    System.out.println("Radius: " + radius);
  }
  
  public double calculateArea() {
    return Math.PI * radius * radius;
  }

  public double calculatePerimeter() {
    return 2 * Math.PI * radius;
  }
}

class Rectangle implements Shape {
  private double length;
  private double width;

  public Rectangle(double length, double width) {
    this.length = length;
    this.width = width;
  }

  public void printInfo() {
    System.out.println("-- Rectangle Info --");
    System.out.println("Length: " + length);
    System.out.println("Width: " + width);
  }

  public double calculateArea() {
    return length * width;
  }

  public double calculatePerimeter() {
    return 2 * (length + width);
  }
}