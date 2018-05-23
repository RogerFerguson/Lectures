package week8;


import java.util.Comparator;

public class SortByFirstName implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getFirstName().compareTo(o2.getFirstName());
	}
	
}
