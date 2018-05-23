package week6a;

public class MathStuff {
	public int myMod(int x, int y)
	{
		// put your code here
		if (x < y) 
			return x;
		else 
			return myMod (x - y, y);
		
	}
	
	public int myDiv(int x, int y)
	{
		// put your code here
		if (x < y) 
			return 0;
		else 
			return 1 + myDiv (x - y, y);
		
	}
	public int testcount () {
//		for (int i = 0; i < n;  i++) 
//			stmt; 
		
		int n = 400000;
		int count = 0;    
		int i;
		
		
		i = 0; count++;
		count++;
		while (i < n) { 
			i++; count++;
			count++;
			count++;
		}
		
		return count;


		
//		i = 0; count++;
//		count++;
//		while (i < 4) {
//			count++;
//			if ((i % 2) == 0) {
//				i = 0; count++;
//				count++;
//				while (i < 1000) {
//					count++;	 	// stmt
//					i++;  	count++; 	// incr part
//					count++;    // while loop part
//				}
//			}
//			i++; count++;
//			count++;
//	
//		}
//		count++;

		
//		for (int i = 0; i < 4; i++) 
//		if ((i % 2) == 0) 
//		for (int j = 0; j < 1000;  j++) 
//		SomeStmt; 
		
//		SomeStmt;
		
	}
	
	public static void main (String[] args) {
		MathStuff x = new MathStuff();
//		System.out.println (x.myDiv(5,2));
//		System.out.println (x.myMod(5,2));
		
		Long t = System.currentTimeMillis();
		System.out.println (x.testcount());
		System.out.println ("Time:" + (System.currentTimeMillis() - t));


		
		
		
		
	}
}
