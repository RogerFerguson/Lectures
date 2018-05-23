package week5a;

public class SimpleTryExample {

	public static void main(String[] args) {
		int n = 0;   // user input
		int i;

		try {
			i = 5 / (n + 1);
			System.out.println("I am here");
			System.out.println("I am here");
			System.out.println("I am here");
			System.out.println("I am here");
			i = 5 / n;
			System.out.println("I am here");
			System.out.println("I am here");
			i = 5 / n-1;
			System.out.println("I am here");
		}

		catch (ArithmeticException e)
		{

			// Unknown what to do here. 
		}

catch (IllegalArgumentException e) {
			// Unknown what to do here. 
		}

				System.out.println("Hi");
	}
}
