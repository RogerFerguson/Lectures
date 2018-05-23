package week3;

public class BasicExample {
   public static void main (String[] args) {
	     int[] intArray;
	     int[][]  array2Dints;
	     int[][][]  array3Dints;

		 Lock lock;
		 Lock[] arrayLocks;	
		 Lock[][] array2dStudents; 
		 
		intArray = new int[10];
		array2Dints = new int[10][10];
		array3Dints = new int[10][10][10];

		intArray[0] = 10;			
		intArray[3] = 20;
		
		for (int i = 0; i < 10; i++) 		
			intArray[i] = i;
		
		for (int r = 0; r < 10; r++)
			for (int c = 0; c < 10; c++)
				array2Dints[r][c] =  10 * c;
		
		for (int r = 0; r < 10; r++)
			for (int c = 0; c < 10; c++)
				for (int d = 0; d < 10; d++)
				array3Dints[r][c][d] = 0;
		
		System.out.println("------------------------------------------------");
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++)
				System.out.print(array2Dints[r][c] + "   ");
			System.out.println();
		}
		
		lock = new Lock("10");   
		arrayLocks = new Lock[10];
		
		for (int i = 0; i < 10; i++) 	
			arrayLocks[i] = new Lock("123" );
				
		array2dStudents = new Lock[4][3];
		for (int i = 0; i < 4; i++)		
			for (int j = 0; j < 3; j++) 
				array2dStudents[i][j] = new Lock("1234");
		}
	}
