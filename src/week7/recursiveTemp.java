package week7;

public class recursiveTemp {
	public int mul (int x, int y) {
		if ((y < 0) && (x < 0))
			return mul(-x, -y);
		else 
			if (y < 0) 
				return -mul (x, -y);
			else
				if (x < 0)
					return -mul (-x, y);
				else
					if (y == 0)
						return 0;
					else
						return mul(x,y-1) + x;
	}
	
	
	
	public boolean stuff (String x) {

		if (x.length() == 0 || x.length() == 1)
			return true;
        return x.charAt(0) == x.charAt(x.length() - 1) &&
                stuff(x.substring(1, x.length() - 1));
		
		
	}
	
	
	public static void main(String[] args) {
		recursiveTemp r = new recursiveTemp();

				System.out.println(" pos pos " + r.mul(2,3));
		//		System.out.println(" neg neg " + r.mul(-2,-3));	
		//		System.out.println(" pos neg " + r.mul(2,-3));
		//		System.out.println(" neg pos " + r.mul(-2,3));
		//		System.out.println (r.countit(100));
		
	//	System.out.println (r.palindrome("racecar"));
	//	System.out.println (r.palindrome("raar"));
		
	} 
} 