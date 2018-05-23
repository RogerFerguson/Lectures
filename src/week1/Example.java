package week1;

public class Example {
	public static void doIt(SimpleCLass c1, SimpleCLass c2) {
		c1 = new SimpleCLass(6);
		//		
		c1.incr();
		c2.incr();
		c1.incr();
		c2.incr();
	}

	public static void main(String[] args) {
		SimpleCLass c1 = new SimpleCLass(3);	
		SimpleCLass c2 = new SimpleCLass(4);	
		c1 = c2;
		doIt(c1, c2);
		System.out.println("Line 1: " + c1 + " " + c2);		
		//		c1 = new SimpleCLass(3);
		//		c2 = new SimpleCLass(5);
		//		doIt(c2, c1);
		//		System.out.println("Line 2: " + c1 + " " + c2);
		//		doIt(c1, c1);
		//		System.out.println("Line 3: " + c1 + " " + c2);
		//		doIt(c2, c2);
		//		System.out.println("Line 4: " + c1 + " " + c2);
	}

	//	   Output: 	Line 1: ___________________
	//
	//			Line 2: ___________________
	//
	//			Line 3: ___________________
	//
	//			Line 4: ___________________

	/*
	 * 
	 * 
	 *
	Line 1:  6
    Line 2: 5 5 
	 * 
	 */

}
