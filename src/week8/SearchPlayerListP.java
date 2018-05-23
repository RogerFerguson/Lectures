package week8;
//********************************************************************
//  SearchPlayerList.java       Java Foundations
//
//  Demonstrates a linear search of Comparable objects.
//********************************************************************

public class SearchPlayerListP
{
   //-----------------------------------------------------------------
   //  Creates an array of Contact objects, then searches for a
   //  particular player.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      ContactP[] players = new ContactP[7];

      players[0] = new ContactP ("Rodger", "Federer", "610-555-7384");
      players[1] = new ContactP ("Andy", "Roddick", "215-555-3827");
      players[2] = new ContactP ("Maria", "Sharapova", "733-555-2969");
      players[3] = new ContactP ("Venus", "Williams", "663-555-3984");
      players[4] = new ContactP ("Lleyton", "Hewitt", "464-555-3489");
      players[5] = new ContactP ("Eleni", "Daniilidou", "322-555-2284");
      players[6] = new ContactP ("Serena", "Williams", "243-555-2837");

      ContactP target = new ContactP ("Eleni", "Daniilidou", "");

 //     Contact found = (Contact)(players, target);
        ContactP found = null;
        
      if (found == null)
         System.out.println ("Player was not found.");
      else
         System.out.println ("Found: " + found);
   }
}
