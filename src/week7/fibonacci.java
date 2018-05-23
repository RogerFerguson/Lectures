package week7;

public class fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		fibonacci f = new fibonacci();

		//		System.out.println ("Non = Rec " + f.nonFib(55));
		//		System.out.println ("Rec =" + f.fib(55));	

		    int i = 10721;
			int temp = i * i;
			int temp1 = f.mult(i,i);
			if (temp != temp1)
				System.out.println("Fail");
			
			temp = -i * i;
			temp1 = f.mult(-i,i);
			if (temp != temp1)
				System.out.println("Fail");
			
			temp = i * -i;
			temp1 = f.mult(i,-i);
			if (temp != temp1)
				System.out.println("Fail");
		
		System.out.println("Pass");
	}


	private long fib(int n) {
		if (n < 3)
			return 1;
		else
			return fib(n - 1) + fib (n - 2);
	}

	private long nonFib(int n) {
		long first = -1;
		long second = 1;

		for (int i = 0; i <= n; i++) {
			long sum = second + first;
			first = second;
			second = sum;
		}
		return second;
	}

	
	
	public int mult (int x, int y) {
		if (x == 0 || y == 0) 
			return 0;
		else if (y > 0)
			return x + mult(x, y-1);
		else
			return -x + mult (x, y +1);
	}

}










