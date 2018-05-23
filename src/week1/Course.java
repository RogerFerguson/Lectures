package week1;

public class Course {

	private String name;
	private double gpa;

	public Course(String pName) {
		name = pName;
	}
	public Course(String name, double gpa) {
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


	public boolean equals (Course c) {			// example of an equals method did in class
        return c.getName().equalsIgnoreCase(name);
	}
	
	
	public int compareTo (Course c) {		// example of a compareTo method, 
		if (c.getName().compareTo(name) == 1)	// not worth much. Just an example. 
			return 1;
		else if (c.getName().compareTo(name) == -1)
			return -1;
		else
			return 0;
		
	}



}


