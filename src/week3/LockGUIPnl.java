package week3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

public class LockGUIPnl extends JPanel {

	private Lock lock;
	private String s;

	private JLabel messageLb;

	private JButton[] buttons;
	private ArrayList<JButton> buttonss;

	private JButton button0;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton button9;

	private JButton enter;
	private JButton reset;

	public LockGUIPnl () {
		s = "";

		messageLb = new JLabel("Not Open!");

		buttons = new JButton[10];

		buttonss = new ArrayList<JButton>();

		lock = new Lock("345");

		ButtonListener listener = new ButtonListener();

//		for (int i = 0; i < 10; i++) {
//			buttons[i] = new JButton("" + i);
//			buttons[i].addActionListener(listener);
//			add (buttons[i]);
//		}
//		
		for (int i = 0; i < 10; i++) {
			JButton temp = new JButton(new Integer(i).toString());
			buttonss.add(temp);
			temp.addActionListener(listener);
			add(temp);
		}
		//		button0 = new JButton("0");
		//		button1 = new JButton("1");
		//		button2 = new JButton("2");
		//		button3 = new JButton("3");
		//		button4 = new JButton("4");
		//		button5 = new JButton("5");
		//		button6 = new JButton("6");
		//		button7 = new JButton("7");
		//		button8 = new JButton("8");
		//		button9 = new JButton("9");

		enter = new JButton("Enter");
		reset = new JButton("Clear");

		//		button0.addActionListener(listener);
		//		button1.addActionListener(listener);
		//		button2.addActionListener(listener);
		//		button3.addActionListener(listener);
		//		button4.addActionListener(listener);
		//		button5.addActionListener(listener);
		//		button6.addActionListener(listener);
		//		button7.addActionListener(listener);
		//		button8.addActionListener(listener);
		//		button9.addActionListener(listener);

		enter.addActionListener(listener);
		reset.addActionListener(listener);

		//		add (button0);
		//		add (button1);
		//		add (button2);
		//		add (button3);
		//		add (button4);
		//		add (button5);
		//		add (button6);
		//		add (button7);
		//		add (button8);
		//		add (button9);

		add (enter);
		add (reset);

		add (messageLb);


	}

	private class ButtonListener implements ActionListener
	{
		//--------------------------------------------------------------
		//  Determines which button was pressed and sets the label
		//  text accordingly.
		//--------------------------------------------------------------
		public void actionPerformed (ActionEvent event)
		{

//			for (int i = 0; i < 10; i++)
//				if (event.getSource() == buttons[i])
//					s += i;
//			
			for (JButton temp : buttonss)
				if (event.getSource() == temp)
					s += buttonss.indexOf(temp);
			
//			if (event.getSource() == button0)
//				s = s + "0";  
//			if (event.getSource() == button1)
//				s = s + "1";  
//			if (event.getSource() == button2)
//				s = s + "2";  
//			if (event.getSource() == button3)
//				s = s + "3";  
//			if (event.getSource() == button4)
//				s = s + "4";  
//			if (event.getSource() == button5)
//				s = s + "5";  
//			if (event.getSource() == button6)
//				s = s + "6";  
//			if (event.getSource() == button7)
//				s = s + "7";  
//			if (event.getSource() == button8)
//				s = s + "8";  
//			if (event.getSource() == button9)
//				s = s + "9";  

			if (event.getSource() == enter) {
				lock.enterCode(s);

				if (lock.isUnlock())
					messageLb.setText("Open");
				else
					messageLb.setText("Not Open!");

				lock.reset();
				s = "";
			}

			if (event.getSource() == reset) {
				lock.reset();
				messageLb.setText("Not Open!");

				s = "";
			}
		}
	}
}
