package LAB2.exercise3;

import java.util.Arrays;

public class Main {
  public static <T> void swap(T[] array, int index1, int index2) {
    if (index1 < 0 || index1 >= array.length || index2 < 0 || index2 >= array.length) {
      System.out.println("Invalid indices, cannot perform swap");
    } else {
      T temp = array[index1];
      array[index1] = array[index2];
      array[index2] = temp;
    }
  }

  public static void main(String[] args) {
    Integer[] intArray = {1, 2, 3, 4, 5};
    String[] stringArray = {"Jenifer", "John", "Joe"};
    Double[] doubleArray = {1.5, 2.5, 3.5, 4.5};

    System.out.println("-- Before swapping --");
    System.out.println("Integer array: " + Arrays.toString(intArray));
    System.out.println("String array: " + Arrays.toString(stringArray));
    System.out.println("Double array: " + Arrays.toString(doubleArray));

    System.out.println("\n-- After swapping --");
    swap(intArray, 1, 3);
    System.out.println("Integer array: " + Arrays.toString(intArray));
    swap(stringArray, -4, 2);
    System.out.println("String array: " + Arrays.toString(stringArray));
    swap(doubleArray, 2, 3);
    System.out.println("Double array: " + Arrays.toString(doubleArray));
  }
}