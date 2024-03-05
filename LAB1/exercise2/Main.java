package LAB1.exercise2;

public class Main {
  public static void main(String[] args) {
    Circle circle = new Circle(5);
    circle.printInfo();
    System.out.println("Circle Area: " + circle.calculateArea());
    System.out.println("Circle Perimeter: " + circle.calculatePerimeter());

    Rectangle rectangle = new Rectangle(4, 6);
    rectangle.printInfo();
    System.out.println("Rectangle Area: " + rectangle.calculateArea());
    System.out.println("Rectangle Perimeter: " + rectangle.calculatePerimeter());
  }
}
