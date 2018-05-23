package week3;

public class ArraylistAnswers {

	public static void main (String[] args) {

		int array1[]  = {1, 21, 4, 5, 28, 7, 8};

		System.out.println(multiplesOf7(array1));
		System.out.println(diff(array1));

		int array2[] = {1, 2, 3, 4, 5, 6, 7};

		switchThem(array1, array2);
		System.out.print("array1:");
		for (int i = 0; i < array1.length; i++)
			System.out.print(array1[i] + ",");
		System.out.print("\narray2:");
		for (int i = 0; i < array2.length; i++)
			System.out.print(array2[i] + ",");
		System.out.println("\n");

		String[][] strings = new String[2][2];

		strings[0][0] = "a";
		strings[0][1] = "b";
		strings[1][0] = "c";
		strings[1][1] = "d";

		System.out.println(strConcat(strings));
		System.out.println(diff(array1));

		int[][] ints = new int[2][3];
		array2 = foo(ints);
		for (int i = 0; i < array2.length; i++)
			System.out.print(array2[i] + ",");
		System.out.println("\n");
	}

	public static int multiplesOf7 (int [] array)  {
		int count = 0;
		for (int i = 0; i < array.length; i++)
			if (array[i] % 7 == 0)
				count++;

		return count;
	}

	public static int diff (int [] array)  {
		int smallest = array[0];
		int largest = array[0];

		for (int i = 0; i < array.length; i++){
			if (array[i] > largest)
				largest = array[i];
			if (array[i] < smallest)
				smallest = array[i];
		}

		return largest - smallest;
	}

	public static void switchThem (int [] array1, int array2[])  {
		for (int i = 0; i < array1.length; i++){
			int temp = array1[i];
			array1[i] = array2[i];
			array2[i] = temp;
		}
	}

	public static String strConcat (String[][] string) {

//		System.out.println (string.length);
//		System.out.println (string[0].length);
		String s = "";
		for (int r = 0; r < string.length; r++)
			for (int c = 0; c < string[0].length; c++)
				s += string[r][c];

		return s;
	}

	public static int[] foo(int[][] a) { 
		int[] temp = new int[a.length]; 

		for (int i = 0; i < a.length; i++) { 
			temp[i] = a[i].length; 
		} 

		return temp; 
		} 



}
