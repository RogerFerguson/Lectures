package week11;

public class fun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
 
		float s1 = 0, s2= 0;
		int n = 300000000;
		for (int i = 0; i < n; i++) {
			s1 +=  i;
			s2 += (n - 1 - i);
		}
		
		System.out.println ("s1 = " + s1 + "  s2 = " + s2);
			
		}
	}


