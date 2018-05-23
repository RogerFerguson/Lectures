package week7;

public class MathStuff {

	
	public int myDiv(int x, int y)
	{
		if (x < y) 
			return 0;
		else 
			return 1 + myDiv (x - y, y);	
	}

	
	public static void main (String[] args) {
		MathStuff x = new MathStuff();
		System.out.println (x.myDiv(5,2));
		
		
		
		
	}
}
