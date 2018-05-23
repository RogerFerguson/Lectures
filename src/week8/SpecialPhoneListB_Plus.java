package week8;

import java.util.*;
//********************************************************************
//  PhoneList.java       Author: Lewis/Loftus
//
//  Driver for testing a sorting algorithm.
//********************************************************************

public class SpecialPhoneListB_Plus
{
   //-----------------------------------------------------------------
   //  Creates an array of Contact objects, sorts them, then prints
   //  them.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      //MContact[] friends = new MContact[8];

      ArrayList<ContactB> friends = new ArrayList<ContactB>();
      
    friends.add(new ContactB ("John", "Smith", "610-555-7384"));
    friends.add(new ContactB ("Sarah", "Barnes", "215-555-3827"));
    friends.add(new ContactB ("Mark", "Riley", "733-555-2969"));
    friends.add(new ContactB ("Laura", "Getz", "663-555-3984"));
    friends.add(new ContactB ("Larry", "Smith", "464-555-3489"));
    friends.add(new ContactB ("Frank", "Phelps", "322-555-2284"));
    friends.add(new ContactB ("Mario", "Guzman", "804-555-9066"));
    friends.add(new ContactB ("Marsha", "Grant", "243-555-2837"));
      
//      friends[0] = new MContact ("John", "Smith", "610-555-7384");
//      friends[1] = new MContact ("Sarah", "Barnes", "215-555-3827");
//      friends[2] = new MContact ("Mark", "Riley", "733-555-2969");
//      friends[3] = new MContact ("Laura", "Getz", "663-555-3984");
//      friends[4] = new MContact ("Larry", "Smith", "464-555-3489");
//      friends[5] = new MContact ("Frank", "Phelps", "322-555-2284");
//      friends[6] = new MContact ("Mario", "Guzman", "804-555-9066");
//      friends[7] = new MContact ("Marsha", "Grant", "243-555-2837");

      
      SpecialSortingB.selectionSort(friends);
      
      Collections.sort(friends);
   
      System.out.println ("Output:");
      for (ContactB friend : friends)
   // 	if (friend.getFirstName().equalsIgnoreCase("frank"))  
    		System.out.println (friend);
   }
}
