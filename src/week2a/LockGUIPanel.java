package week2a;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class LockGUIPanel extends JPanel {
	private Lock lock1;
	
	private JLabel outLabel;	
	private String s;
	
	private JButton b0;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JButton b6;
	private JButton b7;
	private JButton b8;
	private JButton b9;
	
	public LockGUIPanel() {
		s = "";

		lock1 = new Lock("123");
		
		b0 = new JButton ("0");
		b1 = new JButton ("1");
		b2 = new JButton ("2");
		b3 = new JButton ("3");
		b4 = new JButton ("4");
		b5 = new JButton ("5");
		b6 = new JButton ("6");
		b7 = new JButton ("7");
		b8 = new JButton ("8");
		b9 = new JButton ("9");
		
		
		outLabel = new JLabel("Locked!!!!");
		ButtonListener Listener = new ButtonListener();
		
		b0.addActionListener(Listener);
		b1.addActionListener(Listener);
		b2.addActionListener(Listener);
		b3.addActionListener(Listener);
		b4.addActionListener(Listener);
		b5.addActionListener(Listener);
		b6.addActionListener(Listener);
		b7.addActionListener(Listener);
		b8.addActionListener(Listener);
		b9.addActionListener(Listener);
		
		add (outLabel);
		
		add (b0);
		add (b1);
		add (b2);
		add (b3);
		add (b4);
		add (b5);
		add (b6);
		add (b7);
		add (b8);
		add (b9);
		
		
	}
	
	private class ButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
		    
			if (arg0.getSource() == b0)
				s += "0";
			if (arg0.getSource() == b1)
				s += "1";
			if (arg0.getSource() == b2)
				s += "2";
			if (arg0.getSource() == b3)
				s += "3";
			if (arg0.getSource() == b4)
				s += "4";
			if (arg0.getSource() == b5)
				s += "5";
			if (arg0.getSource() == b6)
				s += "6";
			if (arg0.getSource() == b7)
				s += "7";
			if (arg0.getSource() == b8)
				s += "8";
			if (arg0.getSource() == b9)
				s += "9";
			

			
			lock1.enterCode(s);
			if (lock1.isUnlock() == OpenStatus.OpenWithNormalCode)
				outLabel.setText("Open");
			
			
			
		}
		
	}
	
	

}
