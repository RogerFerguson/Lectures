package week4;

import javax.swing.JFrame;

public class Driver {

	public static void main (String[] args) {

		Car c = new Car();
		Car c1 = new Car();
		SportsCar s = new SportsCar();
		Object o;


	   	 c.setHorsePower(40);
	   	 s.setHorsePower(200);


	   	 c = s;
	   	 c.setHorsePower(120);


	    c = s;
// s = c;
	    o = c;
	    o = s;
	    
	    JFrame frame = new JFrame();
	    
	}
}
