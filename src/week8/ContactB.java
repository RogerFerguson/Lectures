package week8;
//********************************************************************
//  Contact.java       Author: Lewis/Loftus
//
//  Represents a phone contact.
//********************************************************************

public class ContactB implements Comparable<ContactB>
{
   private String firstName, lastName, phone;
   public ContactB (String first, String last, String telephone)
   {
      firstName = first;
      lastName = last;
      phone = telephone;
   }
   public String toString ()
   {
      return lastName + ", " + firstName + "  " + phone;
   }
   public boolean equals (Object other)
   {
      return (lastName.equals(((ContactB)other).getLastName()) &&
              firstName.equals(((ContactB)other).getFirstName()));
   }
   public int compareTo (ContactB other)
   {
      int result;

      String otherFirst = other.getFirstName();
      String otherLast = other.getLastName();

      if (this.lastName.equals(otherLast))
         result = firstName.compareTo(otherFirst);
      else
         result = lastName.compareTo(otherLast);

      return result;
   }

   //-----------------------------------------------------------------
   //  First name accessor.
   //-----------------------------------------------------------------
   public String getFirstName ()
   {
      return firstName;
   }

   //-----------------------------------------------------------------
   //  Last name accessor.
   //-----------------------------------------------------------------
   public String getLastName ()
   {
      return lastName;
   }
}
