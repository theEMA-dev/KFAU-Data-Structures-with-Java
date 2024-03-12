package LAB2.exercise2;

public class Main {
  public static void main(String[] args) {
    Tuple<String, Integer, String> tuple1 = new Tuple<>("Emir", 20, "Computer Engineer");
    tuple1.printPerson();
    tuple1.setItem1("Şamil");
    tuple1.setItem2(21);
    tuple1.printPerson();
    Tuple<String, Double, Boolean> tuple2 = new Tuple<>("5475", 20.7, true);
    tuple2.printProduct();
  }
}
