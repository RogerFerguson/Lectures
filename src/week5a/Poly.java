package week5a;

import java.io.IOException;


public class Poly {
	
	private double a,b,c; 
	
	public Poly(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	/**
	 * 
	 * @return
	 * @throws NegSqrtException One Sentence
	 */
	
	public double getQuadNegSolution() throws NegSqrtException  
	{
		if  (b * b < 4 * a * c) 
			throw (new NegSqrtException ("Negative sqrt"));
		
		if (a == 0) 
			throw (new ArithmeticException ());
		
		return (-b - Math.sqrt(b * b + 4 * a * c) / (2 * a));
	}
	
	/**
	 * 
	 * @return
	 * @throws PosSqrtException  One Sentence
	 */
	public double getQuadPosSolution()  
	{
		if  (b * b < 4 * a * c)
			throw (new PosSqrtException ("Postive sqrt"));
		
		if (a == 0) 
			throw (new ArithmeticException ());
			
		return (-b + Math.sqrt(b * b + 4 * a * c) / (2 * a));
	}
	
}


