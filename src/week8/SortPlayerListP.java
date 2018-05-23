package week8;

import java.util.Collection;
import java.util.Collections;

//********************************************************************
//  SortPlayerList.java       Java Foundations
//
//  Demonstrates a selection sort of Comparable objects.
//********************************************************************

public class SortPlayerListP
{
   //-----------------------------------------------------------------
   //  Creates an array of Contact objects, sorts them, then prints
   //  them.
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
      
      SortingP.selectionSort(players);

      for (Comparable player : players)
         System.out.println (player);
   }
}
