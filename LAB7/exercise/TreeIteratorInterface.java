package LAB7.exercise;
import java.util.Iterator;
/**
   An interface of iterators for the ADT tree.
   
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 4.0
*/
public interface TreeIteratorInterface<T>
{
   // commented to be implemented as homework
   public Iterator<T> getPreorderIterator();
   public Iterator<T> getPostorderIterator();
   public Iterator<T> getInorderIterator();
   //public Iterator<T> getLevelOrderIterator();
} // end TreeIteratorInterface
