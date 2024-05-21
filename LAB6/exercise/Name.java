package LAB6.exercise;

/**
   A class that represents a person's name.

   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 4.0
*/
public class Name implements Comparable<Name> {
	private String first; // First name
	private String last;  // Last name

	public Name()
	{
	} // end default constructor

	public Name(String firstName, String lastName)
	{
		first = firstName;
		last = lastName;
	} // end constructor

	public void setName(String firstName, String lastName)
	{
		setFirst(firstName);
		setLast(lastName);
	} // end setName

	public String getName()
	{
		return toString();
	} // end getName

	public void setFirst(String firstName)
	{
		first = firstName; 
	} // end setFirst

	public String getFirst()
	{
		return first;
	} // end getFirst

	public void setLast(String lastName)
	{
		last = lastName;
	} // end setLast

	public String getLast()
	{
		return last;
	} // end getLast

	public void giveLastNameTo(Name aName)
	{
		aName.setLast(last);
	} // end giveLastNameTo

	public String toString()
	{
		return first + " " + last;
	} // end toString

	@Override
	public int compareTo(Name name) {
		int lastCmp = last.compareTo(name.last);
		return (lastCmp != 0 ? lastCmp : first.compareTo(name.first));
	}

	@Override
	public boolean equals(Object name) {
		// If the object is compared with itself then return true
		if (name == this) {
			return true;
		}
		/* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
		if (!(name instanceof Name)) {
			return false;
		}

		return compareTo( (Name)name ) == 0;
	}
} // end Name