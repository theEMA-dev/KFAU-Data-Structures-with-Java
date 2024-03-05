package LAB1.exercise3;

class Vehicle {
  private String make;
  private int year;

  public Vehicle(String make, int year) {
    this.make = make;
    this.year = year;
  }

  public String getMake() {
    return make;
  }

  public int getYear() {
    return year;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public void setYear(int year) {
    this.year = year;
  }
  
}

class Car extends Vehicle {
  private int numDoors;

  public Car(String make, int year, int numDoors) {
    super(make, year);
    this.numDoors = numDoors;
  }

  public int getNumDoors() {
    return numDoors;
  }

  public void setNumDoors(int numDoors) {
    this.numDoors = numDoors;
  }
}

class Motorcycle extends Vehicle {
  private String engineType;

  public Motorcycle(String make, int year, String engineType) {
    super(make, year);
    this.engineType = engineType;
  }

  public String getEngineType() {
    return engineType;
  }
  
  public void setEngineType(String engineType) {
    this.engineType = engineType;
  }
}

public class Main {
  public static void main(String[] args) {
    Car car = new Car("Tesla", 2022, 4);
    System.out.println("-- Car Info --");
    System.out.println("Car make: " + car.getMake());
    System.out.println("Car year: " + car.getYear());
    System.out.println("Number of doors: " + car.getNumDoors());
    System.out.println("");

    car.setMake("Toyota");
    car.setYear(2017);
    car.setNumDoors(2);

    System.out.println("-- Car Info --");
    System.out.println("Car make: " + car.getMake());
    System.out.println("Car year: " + car.getYear());
    System.out.println("Number of doors: " + car.getNumDoors());
    System.out.println("");

    Motorcycle motorcycle = new Motorcycle("Kuba", 2001, "gasoline");
    System.out.println("-- Motorcycle Info --");
    System.out.println("Motorcycle make: " + motorcycle.getMake());
    System.out.println("Motorcycle year: " + motorcycle.getYear());
    System.out.println("Engine type: " + motorcycle.getEngineType());
    System.out.println("");

    motorcycle.setMake("Yamaha");
    motorcycle.setYear(2015);
    motorcycle.setEngineType("electric");

    System.out.println("-- Motorcycle Info --");
    System.out.println("Motorcycle make: " + motorcycle.getMake());
    System.out.println("Motorcycle year: " + motorcycle.getYear());
    System.out.println("Engine type: " + motorcycle.getEngineType());
  }
}