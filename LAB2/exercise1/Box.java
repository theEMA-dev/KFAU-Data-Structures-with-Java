package LAB2.exercise1;

public class Box<T> {
  private T object;

  public void put(T object) {
    this.object = object;
  }

  public T get() {
    return object;
  }

  public void printContents() {
    System.out.println("Box contains: " + object);
  }
}