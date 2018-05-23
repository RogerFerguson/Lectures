package week8;

import java.util.ArrayList;
//********************************************************************
//  Sorting.java       Author: Lewis/Loftus
//
//  Demonstrates the selection sort and insertion sort algorithms.
//********************************************************************
import java.util.Collection;

public class SpecialSortingB
{
	//-----------------------------------------------------------------
	//  Sorts the specified array of objects using the selection
	//  sort algorithm.
	//-----------------------------------------------------------------
//	public static void selectionSort (ArrayList<MContact>  list)
//	{
//		int min;
//		M2Contact temp;
//		
//		for (int index = 0; index < list.size()-1; index++)
//		{
//			min = index;
//			for (int scan = index+1; scan < list.size(); scan++) {
//				if ((list.get(scan)).compareTo(list.get(min)) < 0)
//					min = scan;
//			}
//			// Swap the values
//			
//			temp = list.get(min);
//			list.set(min, list.get(index));
//			list.set(index,temp);
//		}
//	}
//	
	public static <T extends Comparable<T>> void selectionSort
	(ArrayList<T>  list)
	{
		int min;
		T temp;
		
		for (int index = 0; index < list.size()-1; index++)
		{
			min = index;
			for (int scan = index+1; scan < list.size(); scan++) {
				if ((list.get(scan)).compareTo(list.get(min)) < 0)
					min = scan;
			}
			// Swap the values
			
			temp = list.get(min);
			list.set(min, list.get(index));
			list.set(index,temp);
		}
	}
	
	//-----------------------------------------------------------------
	//  Sorts the specified array of objects using the insertion
	//  sort algorithm.
	//-----------------------------------------------------------------
	 public static void insertionSort (ArrayList<ContactB>  list)
   {
      for (int index = 1; index < list.size(); index++)
      {
         ContactB key = list.get(index);
         int position = index;

         //  Shift larger values to the right
         while (position > 0 && key.compareTo(list.get(position-1)) < 0)
         {
            list.add(position, list.get(position-1));
            position--;
         }
            
         list.add(position, key);
      }
   }
	 
}
