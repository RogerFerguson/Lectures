package week6;

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
	
	
		public double power (int x, int y) {
			if (y < 0) 
				return 1.0/power(x,-y);
			else
				if ((x == 0) && (y== 0)) 
					return 0;  // problem
				else
					if (y == 0)
						return 1.0;
					else
						return power(x,y-1) * x;
		}
	
//	public double power (int x, int y) {
//		if (y < 0) 
//			return power(x, y+1)/x;
//		else
//			if ((x == 0) && (y== 0)) 
//				return 0;  // problem
//			else
//				if (y == 0)
//					return 1.0;
//				else
//					return power(x,y-1) * x;
//	}
	
	public boolean stuff (String x) {
		System.out.println (x);
		if (x.length() == 0 || x.length() == 1)
			return true;
        return x.charAt(0) == x.charAt(x.length() - 1) &&
                stuff(x.substring(1, x.length() - 1));
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public int Snippet1(int y){
		int i, j, n = y, x = 0;
		
		i = 0;  x++;
		while (i < n) {  x++;
		x++;
		j = 0; x++;
		while (j < n) { x++;
		x++;
		x++;
		j+=2; x++;
		}
		x++;  // Can you explain why is this here?
		i++; x++;
		}
		x++; // Can you explain why is this here?
		return x;
		
	}
	
	public int Snippet2(int y){
		int i, j, n = y, x = 0;
		
		i = 0;  x++;
		while (i < 4000 * n) {  x++;
		x++;
		if ((i % 2) == 0) {
			x++;
		}
		i++; x++;
		}
		x++;  // Can you explain why is this here?
	

		return x;
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		recursiveTemp r = new recursiveTemp();
//		System.out.println(" Power " + r.power (2,2));
//		System.out.println(" Power " + r.power (10,4));
//		System.out.println(" Power " + r.power (-10,-4));
//		System.out.println(" Power " + r.power (-10,3));
		//		
		//		System.out.println(" pos pos " + r.mul(2,3));
		//		System.out.println(" neg neg " + r.mul(-2,-3));	
		//		System.out.println(" pos neg " + r.mul(2,-3));
		//		System.out.println(" neg pos " + r.mul(-2,3));
		//		System.out.println (r.countit(100));
		
		System.out.println (r.stuff("racecar"));
		System.out.println (r.stuff("raar"));
		System.out.println (r.stuff("firetrucf"));

//		System.out.println (r.Snippet2(10));
//		System.out.println (r.Snippet1(10));
	} 
} 