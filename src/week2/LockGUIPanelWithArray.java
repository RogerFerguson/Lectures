//********************************************************************
//  FahrenheitPanel.java       Author: Lewis/Loftus
//
//  Demonstrates the use of text fields.
//********************************************************************

package week2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LockGUIPanelWithArray extends JPanel
{
	private JLabel label;

	private JButton[] buttons;

	private JButton clrButton;
	private JButton entButton;

	private Lock myLock;
	private String userInput;

	//JButton button;

	//-----------------------------------------------------------------
	//  Constructor: Sets up the main GUI components.
	//-----------------------------------------------------------------
	public LockGUIPanelWithArray()
	{

		buttons = new JButton[10];

		myLock = new Lock("12");
		userInput = "";

		label = new JLabel ("Locked!!!");
		entButton = new JButton("Enter");
		clrButton = new JButton("Reset");

		ButtonListener butListener = new ButtonListener();

		for (int i = 0; i < 10; i++) {
			buttons[i] = new JButton(""+i);
			buttons[i].addActionListener(butListener);
			add (buttons[i]);
		}
		clrButton.addActionListener(butListener);
		entButton.addActionListener(butListener);

		add (clrButton);
		add (entButton);
		add (label);

		setPreferredSize (new Dimension(400,300));
		setBackground (Color.yellow);
	}

	//*****************************************************************
	//  Represents an action listener for the temperature input field.
	//*****************************************************************
	private class ButtonListener implements ActionListener
	{
		//--------------------------------------------------------------
		//  Performs the conversion when the enter key is pressed in
		//  the text field.
		//--------------------------------------------------------------
		public void actionPerformed (ActionEvent event)
		{

			for (int i = 0; i < 10; i++) 
				if (buttons[i] == event.getSource()) 
					userInput += i;

			if (clrButton == event.getSource()) {
				myLock.reset();
				label.setText("Locked!!!");
			}

			if (entButton == event.getSource()) {
				myLock.enterCode(userInput);
				if (myLock.isUnlock()) 
					label.setText("Unlocked!!!!");
				else
					label.setText("Locked!!!");
				userInput = "";


			}
		}
	}
}
