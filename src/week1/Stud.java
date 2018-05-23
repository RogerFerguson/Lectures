package week1;

public class Stud {

	private String name;
	private double gpa;
	
	public Stud() {			// default constructor
	}

	public Stud(String name, double gpa) { // overloaded constructor
		super();
		this.name = name;
		this.gpa = gpa;
	}
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	
}
