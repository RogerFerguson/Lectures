package week8;
//********************************************************************
//  Searching.java       Java Foundations
//
//  Contains various search algorithms that operate on an array of
//  Comparable objects.
//********************************************************************

public class SearchingP
{
   //-----------------------------------------------------------------
   //  Searches the specified array of objects using a linear search
   //  algorithm. Returns null if the target is not found.
   //-----------------------------------------------------------------
   public static Comparable linearSearch (Comparable[] data,
                                          Comparable target)
   {
      Comparable result = null;
      int index = 0;

      while (result == null && index < data.length)
      {
         if (data[index].compareTo(target) == 0)
            result = data[index];
         index++;
      }

      return result;
   }

   //-----------------------------------------------------------------
   //  Searches the specified array of objects using a binary search
   //  algorithm. Returns null if the target is not found.
   //-----------------------------------------------------------------
   public static Comparable binarySearch (Comparable[] data,
                                          Comparable target)
   {
      Comparable result = null;
      int first = 0, last = data.length-1, mid;

      while (result == null && first <= last)
      {
         mid = (first + last) / 2;  // determine midpoint
         if (data[mid].compareTo(target) == 0)
            result = data[mid];
         else
            if (data[mid].compareTo(target) > 0)
               last = mid - 1;
            else
               first = mid + 1;
      }

      return result;
   }
}
