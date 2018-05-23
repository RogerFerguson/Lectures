package week2;

/**
 * Write a description of class DriverLocik here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import javax.swing.*;

public class DriverLock
{

    public static void main (String[] args) {
        Lock myLock1 = new Lock ("345");
        Lock myLock2 = new Lock ();
        
        Lock.setMasterCode("999");
        
        String s = JOptionPane.showInputDialog ("Enter String");
         
         myLock1.enterCode(s);
         myLock2.enterCode(s);

         
         if (myLock1.isUnlock()) 
             System.out.println ("OPEN Lock 1!");
         else
             System.out.println ("Lock 1 is Locked!!!");
         
         
         if (myLock2.isUnlock()) 
             System.out.println ("OPEN Lock 2!");
         else
             System.out.println ("Lock 2 is Locked!!!");
             
         }
             
        
    }

