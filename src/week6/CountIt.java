package week6;


public class CountIt {
	
	public long SnippetBigN(long n) {
		long i, j, x = 0;
		
		// for (i = 0; i < n; i+= 1) {
		//	   stmt;
		//	   stmt;
		//	   stmt;
		// 	   stmt;
		// }
		
		
		i = 0; x++;
		while (i < n) {
			x++;    // i < n
			x++;	// stmt
			x++;	// stmt
			x++;	// stmt
			x++;	// stmt

			i+= 1;  x++;  // i++;
		}
		x++; 
		return x;

	}
	
	public long SnippetNestedLoop(long n) {

		// 3n2 + 5n + 2
		// for (i = 0; i < n; i++) {
		//    stmt
		//    for (j = 0; j < n; j++)
		//		 stmt;
		//    stmt;
		//    }
		long i, j, x = 0;

		i = 0;  x++;
		while (i < n) {  x++;    // i < n
			x++;    // s
			j = 0; 	x++;      // j = 0;
			while (j < n) { x++;   // j < n
				x++;   // s

				j++; x++;   // j++;
			}
			x++; // Can you explain why is this here? Ans: 

			x++;    // stmt
			i++;
			x++;  // i++;
		}
		x++; // Can you explain why is this here? Ans: i < n
		return x;

	}

	

	public long SnippetLog(long n) {
		long i, j, x = 0;

		// 3Log(n) + 2

		i = 1;
		x++;
		while (i < n) {	x++;
		x++;  // s
		x++;  // s
		x++;  // s
		x++;  // s
		x++;  // s
		x++;  // s
		x++;  // s
		x++;  // s
		x++;  // s

		
		i = i * 10; 	x++;
		}
		x++; // Can you explain why is this here?

		return x;
	}

	// other generic examples

	public long SnippetOtherExample(long n) {
		long i, j, x = 0;

		// for (i = 0; i < n; i++) {
		//  	if (i > 10)
		//			stmt;
		//		stmt;
		//  }
		// 	
		
		i = 0;  	x++;
		while (i < n) {
			x++;    // i < n
			x++;	// i > 10;
			if (i > 10)
				x++;
			x++;    // stmt;
			i++;    x++;
		}
		x++; 
		return x;

	}


	
	public static void main(String[] args) {
		CountIt r = new CountIt();
   //System.out.println(r.SnippetNestedLoop(100));

		Long t = System.currentTimeMillis();
		System.out.println(r.SnippetNestedLoop(10));
		System.out.println ("Time:" + (System.currentTimeMillis() - t));


	}
}