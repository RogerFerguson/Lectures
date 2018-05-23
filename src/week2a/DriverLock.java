package week2a;

import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * Write a description of class DriverLocik here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class DriverLock
{
	public static void main (String[] args) {
		Lock t1 = new Lock();
		Lock t2 = new Lock ("");
		Lock t3 = new Lock (t2);

//		if (t1.equals("123"))
//			System.out.println ("t1 equals t2");
//
//		if (Lock.equals(t2, t3)) 
//			System.out.println ("t1 equals t2");

		Lock.setMasterCode("999");
		
		t1.enterCode("123");
		if (t1.isUnlock() == OpenStatus.OpenWithNormalCode)
			System.out.println ("OPEN!!!!");
		else
			System.out.println ("Still Closed!");

		
		t2.enterCode("999");
		if (t2.isUnlock() == OpenStatus.Locked)
			System.out.println ("OPEN!!!!");
		else
			System.out.println ("Still Closed!");


		//        Lock myLock1;
		//        myLock1 = new Lock("345");
		//        Lock myLock2 = new Lock();  
		//        
		//        String s = JOptionPane.showInputDialog ("Enter String");
		//         
		//         myLock1.enterCode(s);
		//         myLock2.enterCode(s);
		//         
		//         if (myLock1.equals(myLock2)) 
		//        	 System.out.println ("mylock1 equals mylock2");
		//         
		//         if (Lock.equals(myLock1, myLock2))
		//        	 System.out.println ("mylock1 equals mylock2");
		//
		//         
		//         
		//         if (myLock1.isUnlock()) 
		//             System.out.println ("OPEN Lock 1!");
		//         else
		//             System.out.println ("Lock 1 is Locked!!!");
		//         
		//         if (myLock2.isUnlock()) 
		//             System.out.println ("OPEN Lock 2!");
		//         else
		//             System.out.println ("Lock 2 is Locked!!!");
	}        
}

