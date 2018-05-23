package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ExampleExceptions {
	public void method1 () 
	{		
		ArrayList l;

		try { 
			l = new ArrayList(-10);
			System.out.println ("here 1");
		}

		catch (NumberFormatException e) {
			System.out.println ("here 2");

		}

		catch (IllegalArgumentException e) {
			System.out.println ("here 3");
			throw (new IndexOutOfBoundsException());
		}

		finally {
			System.out.println ("here 4");
			//		throw (new IllegalArgumentException());
		}

		System.out.println ("here 5");
	}

	public static void main(String[] args)       {
		ExampleExceptions example = new ExampleExceptions();

		try {
			example.method1();
			System.out.println ("A");
		}

		catch (IllegalArgumentException e) {
			System.out.println ("here B");
			//throw e;
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println ("here C");
		}
		finally {
			System.out.println ("here D");
		}

		System.out.println ("here E");

	}


	//	public void method2 () //throws IOException              
	//	{
	//		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
	//		System.out.println ("How much do you weight?");
	//		String inputit="";
	//
	//		try {
	//			inputit = in.readLine();
	//		} catch (IOException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//
	//		int weight = Integer.parseInt(inputit);

	/*
		try {
				inputit = in.readLine();
			} catch (IOException e) {
				inputit = "1";
				e.printStackTrace();
			}

			int weight = Integer.parseInt(inputit);
	 */

	//}

}



