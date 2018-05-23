package week6;

public class fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		fibonacci f = new fibonacci();

		//	    System.out.println (f.stuff(3,3));

		Long t = System.currentTimeMillis();

		//System.out.print(f.fact());
		//System.out.println (" Time:" + (System.currentTimeMillis() - t));

				t = System.currentTimeMillis();
				System.out.println ("Non = Rec " + f.nonFib(58));
				System.out.println ("Time:" + (System.currentTimeMillis() - t));
				
				t = System.currentTimeMillis();
				System.out.println ("Rec =" + f.fib(58));			
				System.out.println ("Time:" + (System.currentTimeMillis() - t));		
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

	public int fact (int x) {
		if (x == 0)
			return 1;
		else
			return x * fact(x-1);
	}

}










