




package week8;
//********************************************************************
//Contact.java       Java Foundations
//
//Represents a phone contact that implements the non-generic
//version of Comparable.
//********************************************************************

public class ContactP implements Comparable
{
	private String firstName, lastName, phone;

	//-----------------------------------------------------------------
	//  Sets up this contact with the specified information.
	//-----------------------------------------------------------------
	public ContactP (String first, String last, String telephone)
	{
		firstName = first;
		lastName = last;
		phone = telephone;
	}

	//-----------------------------------------------------------------
	//  Returns a string representation of this contact.
	//-----------------------------------------------------------------
	public String toString ()
	{
		return lastName + ", " + firstName + ":  " + phone;
	}

	//-----------------------------------------------------------------
	//  Uses both last and first names to determine lexical ordering.
	//-----------------------------------------------------------------
	public int compareTo (Object other)
	{
		int result;

		if (lastName.equals(((ContactP)other).lastName))
			result = firstName.compareTo(((ContactP)other).firstName);
		else
			result = lastName.compareTo(((ContactP)other).lastName);

		return result;
	}
}
