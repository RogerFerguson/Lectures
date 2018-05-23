package week1;

public class DriverStud {

	public static void main (String[] args) {
		Stud d = new Stud();

		Stud d2;
		
		d2 = new Stud();				// without the new a null pointer would occur. 
		d2.setName("Roger");
		
//		System.out.println (d2.name);     // to demonstrate private and public

	}
}
