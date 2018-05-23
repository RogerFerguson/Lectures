//********************************************************************
//  Fahrenheit.java       Author: Lewis/Loftus
//
//  Demonstrates the use of text fields.
//********************************************************************

package week2a;

import javax.swing.JFrame;

public class LockGUI
{
    //-----------------------------------------------------------------
    //  Creates and displays the temperature converter GUI.
    //-----------------------------------------------------------------
    public static void main (String[] args)
    {
        JFrame frame = new JFrame ("Lock example");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        LockGUIPanel1 panel = new LockGUIPanel1();        
        frame.getContentPane().add(panel);
        frame.setSize (400,400);
        frame.setVisible(true);
    }
}
