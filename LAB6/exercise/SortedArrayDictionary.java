package LAB6.exercise;

/**
   A class that implements the ADT dictionary by using a resizable sorted array.
   The dictionary has distinct search keys.
 
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 4.0
*/
public class SortedArrayDictionary<K extends Comparable<? super K>, V>
		extends ArrayDictionary<K, V> implements DictionaryInterface<K, V>
{
	/* < Constructors analogous to those in Listing 20-1. >
   . . . */
	public SortedArrayDictionary()
	{
		super();        // Call next constructor
	} // end default constructor

	public SortedArrayDictionary(int initialCapacity)
	{
		super(initialCapacity);
	} // end constructor




   // 20.11
	/** Precondition: key and value are not null. */
   public V add(K key, V value)
	{
		checkInitialization();
      if ((key == null) || (value == null))
         throw new IllegalArgumentException("Cannot add null to a dictionary.");
      else
      {
         V result = null;
         int keyIndex = locateIndex(key);
         if ( (keyIndex < numberOfEntries) && 
               key.equals(dictionary[keyIndex].getKey()) )
         {
            // Key found, return and replace entry's value
            result = dictionary[keyIndex].getValue(); // Old value
            dictionary[keyIndex].setValue(value); 		// Replace value
         }
         else // Key not found; add new entry to dictionary
         {  
            makeRoom(keyIndex); // Make room for new entry
            dictionary[keyIndex] = new Entry<K, V>(key, value); // Insert new entry in array
            numberOfEntries++;
            ensureCapacity(); // Ensure enough room for next add
         } // end if
         
         return result;
      } // end if
	} // end add

   /* < Implementations of other methods in dictionary.DictionaryInterface. >
    . . . */


   
   // 20.12
	// Returns the index of either the entry that contains key or
   // the location that should contain key, if no such entry exists.
	private int locateIndex(K key)
	{
      // Search until you either find an entry containing key or
      // pass the point where it should be
		int index = 0;
		while ( (index < numberOfEntries) && 
		         key.compareTo(dictionary[index].getKey()) > 0 )
		{
			index++;
		} // end while
		
		return index;
	} // end locateIndex


   // Makes room for a new entry at a given index by shifting
   // array entries towards the end of the array.
   // Precondition: keyIndex is valid; list length is old length.
	private void makeRoom(int keyIndex)
	{
		assert (keyIndex >= 1) && (keyIndex <= numberOfEntries + 1);
		int newIndex = keyIndex;
		int lastIndex = numberOfEntries;
		// Move each entry to next higher index, starting at end of
		// dictionary and continuing until the entry at newIndex is moved
		for (int index = lastIndex; index >= newIndex; index--)
			dictionary[index + 1] = dictionary[index];
	}  // end makeRoom


	// Removes an entry at a given index by shifting array
   // entries toward the entry to be removed.
	private void removeArrayEntry(int keyIndex)
	{
      // . . . To be implemented
	}  // end removeArrayEntry

} // end dictionary.SortedArrayDictionary