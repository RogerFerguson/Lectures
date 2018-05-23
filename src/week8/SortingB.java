package week8;

public class SortingB {

	public static <T extends Comparable<T>> 
	void insertionSort (T[] data){
		for (int index = 1; index < data.length; index++) {
			T key = data[index];
			int position = index;
			// shift larger values to the right
			while (position > 0 && data[position-1]. compareTo(key) > 0)
			{
				data[position] = data[position-1];
				position--;
			}
			data[position] = key;
		}
	}
}
