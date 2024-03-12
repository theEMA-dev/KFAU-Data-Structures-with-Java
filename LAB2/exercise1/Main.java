package LAB2.exercise1;

public class Main {
  public static void main(String[] args) {
    Box<Integer> integerBox = new Box<>();
    integerBox.put(10);
    integerBox.printContents();

    Box<String> stringBox = new Box<>();
    stringBox.put("Hello, World!");
    stringBox.printContents();

    Box<Double> doubleBox = new Box<>();
    doubleBox.put(3.14);
    doubleBox.printContents();
  }
}