package week2a;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

import javax.swing.*;


public class DialogChange extends JDialog implements ActionListener {

	private JTextField txtName;
	private JTextField txtGPA;

	private JButton okButton;
	private JButton cancelButton;
	private int closeStatus;

	public static final int OK = 0;
	public static final int CANCEL = 1;

	private Student student;  

	/*********************************************************
		 Instantiate a Custom Dialog as 'modal' and wait for the
		 user to provide data and click on a button.

		 @param parent reference to the JFrame application
		 @param m an instantiated object to be filled with data
	 *********************************************************/

	public DialogChange(JFrame parent, Student s) {
		// call parent and create a 'modal' dialog
		super(parent, true);

		setTitle("Change a Student");
		closeStatus = CANCEL;
		setSize(400,200);

		student = s; 
		// prevent user from closing window
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		// instantiate and display text fields

		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(3,2));

		textPanel.add(new JLabel("Name:"));
		txtName = new JTextField(s.getName(),10);
		textPanel.add(txtName);

		textPanel.add(new JLabel("gpa: "));
		txtGPA = new JTextField("" + s.getOverAllGPA(),10);
		textPanel.add(txtGPA);

		// Instantiate and display two buttons
		okButton = new JButton("OK");
		cancelButton = new JButton("Cancel");
		JPanel buttonPanel = new JPanel();
	
		buttonPanel.add(textPanel);
		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);

		getContentPane().add(buttonPanel);
		okButton.addActionListener(this);
		cancelButton.addActionListener(this);

		setSize(300,300);
		setVisible (true);	
	}

	/**************************************************************
		 Respond to either button clicks
		 @param e the action event that was just fired
	 **************************************************************/
	public void actionPerformed(ActionEvent e) {

		JButton button = (JButton) e.getSource();

		// if OK clicked the fill the object
		if (button == okButton) {
			// save the information in the object
			closeStatus = OK;

			double tempGPA = Double.parseDouble(txtGPA.getText());

			student.setOverAllGPA(tempGPA);
			student.setName(txtName.getText());

		}

		// make the dialog disappear
		dispose();
	}

	/**************************************************************
		 Return a String to let the caller know which button
		 was clicked

		 @return an int representing the option OK or CANCEL
	 **************************************************************/
	public int getCloseStatus(){
		return closeStatus;
	}

}



