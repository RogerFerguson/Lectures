//********************************************************************
//  Fahrenheit.java       Author: Lewis/Loftus
//
//  Demonstrates the use of text fields.
//********************************************************************

package week3;

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

     //   LockGUIPanel panel = new LockGUIPanel();
      //  LockGUIPanelWithArray panel = new LockGUIPanelWithArray();
    
        LockGUIPnl panel = new LockGUIPnl ();
        
        
        frame.getContentPane().add(panel);
        //frame.pack();
        frame.setSize(400,400);
        frame.setVisible(true);
    }
}
