package week5a;
//********************************************************************
//  Zero.java       Author: Lewis/Loftus
//
//  Demonstrates an uncaught exception.
//********************************************************************

public class Zero
{
	//-----------------------------------------------------------------
	//  Deliberately divides by zero to produce an exception.
	//-----------------------------------------------------------------
	public static void main (String[] args)
	{
		int numerator = 10;
		int denominator = 0;

		try {
			System.out.println ("1");
			System.out.println (numerator / denominator);
			System.out.println ("2");
			System.out.println ("2");
			System.out.println ("2");
			System.out.println ("2");
			System.out.println ("2");
			System.out.println ("2");


		}
		catch (Exception ex) {
			System.out.println ("Hi");		}
		System.out.println ("This text will not be printed.");
	}
}
