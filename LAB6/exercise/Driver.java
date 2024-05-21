package LAB6.exercise;

public class Driver {
  public static void main(String[] args) {
    TelephoneDirectory td = new TelephoneDirectory();
    TelephoneDirectory.phoneBook pb = td.new phoneBook();
    td.readFile(pb);
    System.out.println(td.getPhoneNumber(pb, "Ali Koc"));
  }
}
