package week2a;

import java.util.ArrayList;
//
// This example shows constructors, set/gets, equals, compareTo methods.
public class Student {
	private String name;
	private double overAllGPA;
	
	public Student(String name, double overAllGPA) {
		super();
		this.name = name;
		this.overAllGPA = overAllGPA;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getOverAllGPA() {
		return overAllGPA;
	}
	public void setOverAllGPA(double overAllGPA) {
		this.overAllGPA = overAllGPA;
	}
	
		
}
