package LAB4.exercise;
/**
    A class of bags whose entries are stored in a chain of linked nodes.
    The bag is never full.
    @author Frank M. Carrano
    @version 4.0
*/
public final class LinkedBag<T> implements BagInterface<T>
{
	private Node firstNode;       // Reference to first node
	private int numberOfEntries;

	public LinkedBag()
	{
		firstNode = null;
      numberOfEntries = 0;
	} // end default constructor

	/** Adds a new entry to this bag.
	    @param newEntry  The object to be added as a new entry.
	    @return  True. */
	public boolean add(T newEntry) // OutOfMemoryError possible
	{
      // Add to beginning of chain:
		Node newNode = new Node(newEntry);
		newNode.next = firstNode;  // Make new node reference rest of chain
                                 // (firstNode is null if chain is empty)
      firstNode = newNode;       // New node is at beginning of chain
		numberOfEntries++;
      
		return true;
	} // end add

	/** Retrieves all entries that are in this bag.
       @return  A newly allocated array of all the entries in this bag. */
	public T[] toArray()
	{
      // The cast is safe because the new array contains null entries.
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast
      
      int index = 0;
      Node currentNode = firstNode;
      while ((index < numberOfEntries) && (currentNode != null))
      {
         result[index] = currentNode.data;
         index++;
         currentNode = currentNode.next;
      } // end while
      
      return result;
      // Note: The body of this method could consist of one return statement,
      // if you call Arrays.copyOf
	} // end toArray
   
	/** Sees whether this bag is empty.
       @return  True if the bag is empty, or false if not. */
	public boolean isEmpty()
	{
		return numberOfEntries == 0;
	} // end isEmpty
   
	/** Gets the number of entries currently in this bag.
       @return  The integer number of entries currently in the bag. */
	public int getCurrentSize()
	{
		return numberOfEntries;
	} // end getCurrentSize
   
// STUBS:

	/** Removes one unspecified entry from this bag, if possible.
	 @return  Either the removed entry, if the removal was successful,
	 or null */
	public T remove()
	{
		T result = null;
		if (firstNode != null)
		{
			result = firstNode.data;
			firstNode = firstNode.next; // Remove first node from chain
			numberOfEntries--;
		} // end if

		return result;
	} // end remove

	// Locates a given entry within this bag.
	// Returns a reference to the node containing the entry, if located,
	// or null otherwise.
	private Node getReferenceTo(T anEntry)
	{
		boolean found = false;
		Node currentNode = firstNode;

		while (!found && (currentNode != null))
		{
			if (anEntry.equals(currentNode.data))
				found = true;
			else
				currentNode = currentNode.next;
		} // end while

		return currentNode;
	} // end getReferenceTo


	/** Removes one occurrence of a given entry from this bag, if possible.
	 @param anEntry  The entry to be removed.
	 @return  True if the removal was successful, or false otherwise. */
	public boolean remove(T anEntry)
	{
		boolean result = false;
		Node nodeN = getReferenceTo(anEntry);

		if (nodeN != null)
		{
			nodeN.data = firstNode.data; // Replace located entry with entry in first node
			firstNode = firstNode.next;  // Remove first node
			numberOfEntries--;
			result = true;
		} // end if

		return result;
	} // end remove

	/** Removes all entries from this bag. */
	public void clear()
	{
		while (!isEmpty())
			remove();
	} // end clear

	/** Counts the number of times a given entry appears in this bag.
	 @param anEntry  The entry to be counted.
	 @return  The number of times anEntry appears in the bag. */
	public int getFrequencyOf(T anEntry)
	{
		int frequency = 0;
		int loopCounter = 0;
		Node currentNode = firstNode;

		while ((loopCounter < numberOfEntries) && (currentNode != null))
		{
			if (anEntry.equals(currentNode.data))
			{
				frequency++;
			} // end if

			loopCounter++;
			currentNode = currentNode.next;
		} // end while

		return frequency;
	} // end getFrequencyOf

	/** Tests whether this bag contains a given entry.
	 @param anEntry  The entry to locate.
	 @return  True if the bag contains anEntry, or false otherwise. */
	public boolean contains(T anEntry)
	{
		boolean found = false;
		Node currentNode = firstNode;

		while (!found && (currentNode != null))
		{
			if (anEntry.equals(currentNode.data))
				found = true;
			else
				currentNode = currentNode.next;
		} // end while
		return found;
	} // end contains

	private class Node
	{
	  private T    data; // Entry in bag
	  private Node next; // Link to next node

		private Node(T dataPortion)
		{
			this(dataPortion, null);	
		} // end constructor
		
		private Node(T dataPortion, Node nextNode)
		{
			data = dataPortion;
			next = nextNode;	
		} // end constructor
	} // end Node
} // end LinkedBag



