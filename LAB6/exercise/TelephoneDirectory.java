package LAB6.exercise;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class TelephoneDirectory {
  public class phoneBook implements DictionaryInterface<Name, String>{
    private DictionaryInterface<Name, String> phoneBook;
    public phoneBook(){
      phoneBook = new SortedArrayDictionary<>();
    }
    public String add(Name name, String number){
      return phoneBook.add(name, number);
    }
    public String remove(Name name){
      return phoneBook.remove(name);
    }
    public String getValue(Name name){
      return phoneBook.getValue(name);
    }
    public boolean contains(Name name){
      return phoneBook.contains(name);
    }
    public boolean isEmpty(){
      return phoneBook.isEmpty();
    }
    public int getSize(){
      return phoneBook.getSize();
    }
    public void clear(){
      phoneBook.clear();
    }
    public Iterator<Name> getKeyIterator(){
      return phoneBook.getKeyIterator();
    }
    public Iterator<String> getValueIterator(){
      return phoneBook.getValueIterator();
    }
  }
  public void readFile(TelephoneDirectory.phoneBook pb) {
    try {
      File file = new File("C:\\Users\\Emir\\Desktop\\Uni\\Data Structures with Java - COMP2002\\LAB6\\data.txt");
      Scanner scanner = new Scanner(file);
      
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] parts = line.split(" ");
        if (parts.length == 3) {
          String name = parts[0] + " " + parts[1];
          String number = parts[2];
          System.out.println(name + " and " + number);
          Name contactName = new Name(parts[0], parts[1]);
          pb.add(contactName, number);
        }
        System.out.println(line);
      }
  
      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found: " + e.getMessage());
    }
  }
  public int getPhoneNumber(TelephoneDirectory.phoneBook pb, String name){
      Name contactName = new Name(name, "");
      String number = pb.getValue(contactName);
      if (number != null) {
        return Integer.parseInt(number);
      } else {
        System.out.println("Name not found in the phone book");
        return -1; // or any other value indicating that the name was not found
      }
  }
}
