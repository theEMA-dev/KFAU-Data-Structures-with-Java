package LAB5.exercise;
/**
   A class that implements the ADT queue by using an expandable
   circular array with one unused location.
 
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 4.0
*/
public final class ArrayQueue<T> implements QueueInterface<T>
{
   private T[] queue; // Circular array of queue entries and one unused location
   private int frontIndex;
   private int backIndex;
   private boolean initialized = false;
   private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
   
   public ArrayQueue()
   {
      this(DEFAULT_CAPACITY);
   } // end default constructor
   
   public ArrayQueue(int initialCapacity)
   {
      checkCapacity(initialCapacity);
      
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempQueue = (T[]) new Object[initialCapacity + 1];
      queue = tempQueue;
      frontIndex = 0;
      backIndex = initialCapacity;
      initialized = true;
   } // end constructor

   public void enqueue(T newEntry)
   {
      checkInitialization();
      ensureCapacity();
      backIndex = (backIndex + 1) % queue.length;
      queue[backIndex] = newEntry;
   } // end enqueue

   public T getFront()
   {
      checkInitialization();
      if (isEmpty())
         throw new EmptyQueueException();
      else
         return queue[frontIndex];
   } // end getFront

   public T dequeue()
   {
      checkInitialization();
      if (isEmpty())
         throw new EmptyQueueException();
      else
      {
         T front = queue[frontIndex];
         queue[frontIndex] = null;
         frontIndex = (frontIndex + 1) % queue.length;
         return front;
      } // end if
   } // end dequeue

   // Doubles the size of the array queue if it is full
   // Precondition: checkInitialization has been called.
   private void ensureCapacity()
   {
      if (frontIndex == ((backIndex + 2) % queue.length)) // if array is full,
      {                                                   // double size of array
         T[] oldQueue = queue;
         int oldSize = oldQueue.length;
         int newSize = 2 * oldSize;
         checkCapacity(newSize);

         // The cast is safe because the new array contains null entries
         @SuppressWarnings("unchecked")
         T[] tempQueue = (T[]) new Object[2 * oldSize];
         queue = tempQueue;
         for (int index = 0; index < oldSize - 1; index++)
         {
            queue[index] = oldQueue[frontIndex];
            frontIndex = (frontIndex + 1) % oldSize;
         } // end for

         frontIndex = 0;
         backIndex = oldSize - 2;
      } // end if
   } // end ensureCapacity

   public boolean isEmpty()
   {
      return frontIndex == ((backIndex + 1) % queue.length);
   } // end isEmpty

   // Throws an exception if this object is not initialized.
   private void checkInitialization()
   {
      if (!initialized)
      {
         throw new SecurityException ("ArrayQueue object is not initialized properly.");
      }
   }

   // Throws an exception if the client requests a capacity that is too large.
   private void checkCapacity(int capacity)
   {
      if (capacity > MAX_CAPACITY)
      {
         throw new IllegalStateException("Attempt to create a queue " +
                 "whose capacity exceeds " +
                 "allowed maximum.");
      }
   }



   // Question 3, Chapter 11
   public void clear()
   {
      checkInitialization();
      if (!isEmpty())
      { // deallocates only the used portion
         for (int index = frontIndex; index != backIndex; index = (index + 1) % queue.length)
         {
            queue[index] = null;
         }

         queue[backIndex] = null;
      }

      frontIndex = 0;
      backIndex = queue.length - 1;
   }
   
   /*
       // Question 4, Chapter 11
       public void clear()
       {
           while (!isEmpty())
           {
                  dequeue();
           }
       }
   */

} // end ArrayQueue
