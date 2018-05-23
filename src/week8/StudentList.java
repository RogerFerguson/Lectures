
package week8;

import java.util.*;
//********************************************************************
//  PhoneList.java       Author: Lewis/Loftus
//
//  Driver for testing a sorting algorithm.
//********************************************************************
import java.util.stream.Collectors;

public class StudentList
{
	//-----------------------------------------------------------------
	//  Creates an array of Contact objects, sorts them, then prints
	//  them.
	//-----------------------------------------------------------------
	public static void main (String[] args)
	{
		
		//Student[] friends = new Student[8];

		ArrayList<Student> friends = new ArrayList<Student>();

		friends.add(new Student ("John", "Smith", "610-555-7384"));
		friends.add(new Student ("Sarah", "Barnes", "215-555-3827"));
		friends.add(new Student ("Mark", "Riley", "733-555-2969"));
		friends.add(new Student ("Laura", "Getz", "663-555-3984"));
		friends.add(new Student ("Larry", "Smith", "464-555-3489"));
		friends.add(new Student ("Frank", "Phelps", "322-555-2284"));
		friends.add(new Student ("Mario", "Guzman", "804-555-9066"));
		friends.add(new Student ("Marsha", "Grant", "243-555-2837"));

//		      friends[0] = new Student ("John", "Smith", "610-555-7384");
//		      friends[1] = new Student ("Sarah", "Barnes", "215-555-3827");
//		      friends[2] = new Student ("Mark", "Riley", "733-555-2969");
//		      friends[3] = new Student ("Laura", "Getz", "663-555-3984");
//		      friends[4] = new Student ("Larry", "Smith", "464-555-3489");
//		      friends[5] = new Student ("Frank", "Phelps", "322-555-2284");
//		      friends[6] = new Student ("Mario", "Guzman", "804-555-9066");
//		      friends[7] = new Student ("Marsha", "Grant", "243-555-2837");

		Collections.sort(friends);
		
		Collections.sort(friends, new SortByFirstName());
	    Collections.sort(friends, new SortByLastName());
		
		System.out.println("Friends " +friends);
		
	    Collections.sort(friends, new Comparator<Student>() {
			   public int compare (Student o1, Student o2) {
				   return o1.getLastName().compareTo(o2.getLastName());
			   }
		});
	    
	    Collections.sort(friends, (s1,  s2) -> 
	    	s1.getLastName().compareTo(s2.getLastName()));
	    		
	    Collections.sort(friends, ( s1,  s2) -> { 
	    	if (s1.getLastName().compareTo(s2.getLastName()) > 0 ) {
	    		return 1;
	    	}
	    	else if (s1.getLastName().compareTo(s2.getLastName()) < 0 )
	    		return -1;
	    		else 
	    			return 0;});	
		
		System.out.println("Friends " +friends);
		
		ArrayList<Student> list = (ArrayList<Student>) friends.stream().
				filter(arg ->!arg.getLastName().equals("Barnes" )).
				collect(Collectors.toList());
		


		
		System.out.println("List temp" +list);

	}
}

