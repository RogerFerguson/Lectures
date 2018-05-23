package week1;

public class ReferencesAndArraysPractice {
	public static void practiceArrayProblem() {
		SimpleCLass[] arrayA = { new SimpleCLass(0), new SimpleCLass(10), new SimpleCLass(20), new SimpleCLass(30) };
		SimpleCLass[] arrayB = new SimpleCLass[arrayA.length];
		SimpleCLass[] arrayC = new SimpleCLass[arrayB.length];
		System.out.println("Line 1: " + arrayA[1] + " " + arrayB[1] + " " + arrayC[1]);
		
		// ****** S T O P  N O W ***********
		
		arrayB = arrayA;
		for (int x = 0; x < arrayB.length; x++) {
			arrayC[x] = new SimpleCLass(arrayB[x].getValue());
		}
		System.out.println("Line 2: " + arrayA[1] + " " + arrayB[1] + " " + arrayC[1]);
		
		// ****** S T O P  N O W ***********
		
		arrayA[1].incr();
		arrayB[1].incr();
		arrayC[1].incr();
		System.out.println("Line 3: " + arrayA[1] + " " + arrayB[1] + " " + arrayC[1]);
		System.out.println("Line 4: " + arrayA[2] + " " + arrayB[2] + " " + arrayC[2]);
		
		// ****** S T O P  N O W ***********
			
		arrayA[3] = new SimpleCLass(100);
		arrayB[3] = new SimpleCLass(200);
		arrayC[3] = new SimpleCLass(300);
		arrayA[3].incr();
		arrayB[3].incr();
		arrayC[3].incr();
		System.out.println("Line 5: " + arrayA[3] + " " + arrayB[3] + " "+ arrayC[3]);
	}
	
	public static void main(String[] args) {
		practiceArrayProblem();
	}
}
