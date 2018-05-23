package week5a;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class MSimpleException {
	
	public static void main(String[] args) {
		MSimpleException example = new MSimpleException();
		
		ArrayList l = new ArrayList(-10);
		// more code goes here.,,,
		
		
		
		
		
		
		
		
		
		
		
		
		
		try {
				example.Word();
			System.out.println ("You just lost your document thank you for using word!!");
		}
		catch (Throwable e) {
			JOptionPane.showMessageDialog(null, 
					"Word has unexpectly quit, sorry");
			/// load of an email send the e....
			System.exit(1);
		}
	}
	public void Word ()	{  // throws IndexOutOfBoundsException

		// 
//		try {
//		ArrayList l = new ArrayList(-10);
//		System.out.println ("Pizza1");
//		}
//		catch (ArithmeticException e) {
//			System.out.println ("Pizza1.5");
//		}
//		
//		catch (Exception e) {
//			System.out.println ("Pizza1.7");
//		}
	}

}
