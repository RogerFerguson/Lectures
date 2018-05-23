package week6a;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

import javax.swing.*;


public class DialogSportsAdd  extends JDialog implements ActionListener {
	
	private JTextField name;
	private JTextField turboCharged;
	private JTextField txtDate;
	private JTextField cost;
	
	private JButton okButton;
	private JButton cancelButton;
	private int closeStatus;
	
	public static final int OK = 0;
	public static final int CANCEL = 1;
	
	private SportsCar sCar;  
	
	/*********************************************************
		 Instantiate a Custom Dialog as 'modal' and wait for the
		 user to provide data and click on a button.
		 
		 @param parent reference to the JFrame application
		 @param m an instantiated object to be filled with data
	 *********************************************************/
	
	public DialogSportsAdd(JFrame parent, SportsCar s) {
		// call parent and create a 'modal' dialog
		super(parent, true);
		
		setTitle("Add Sports Car");
		closeStatus = CANCEL;
		setSize(400,200);
		
		sCar = s; 
		// prevent user from closing window
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		// instantiate and display text fields
		
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(6,2));
		
		textPanel.add(new JLabel("Name:"));
		name = new JTextField("X100 GT",30);
		textPanel.add(name);
		
		textPanel.add(new JLabel("TurboCharged:"));
		turboCharged = new JTextField("Yes",30);
		textPanel.add(turboCharged);
		
		textPanel.add(new JLabel("Cost of the Sports Car: "));
		cost = new JTextField("50000",30);
		textPanel.add(cost);
		
		
		textPanel.add(new JLabel("Bought on: "));
		txtDate = new JTextField(15);
		txtDate.setText("2/27/2013");
		textPanel.add(txtDate);
		getContentPane().add(textPanel, BorderLayout.CENTER);
		
		// Instantiate and display two buttons
		okButton = new JButton("OK");
		cancelButton = new JButton("Cancel");
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(okButton);
		buttonPanel.add(cancelButton);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
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
			
			SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			Date d;
			try {
				d = df.parse(txtDate.getText());
				
				GregorianCalendar opened = new GregorianCalendar();
				opened.setTime(d);
				
				int costAmt = Integer.parseInt(cost.getText());
				
			    if (turboCharged.getText().equalsIgnoreCase("yes"))
			    	sCar.setTurboCharged(true);
			    else
			    	sCar.setTurboCharged(false);
				
				sCar.setCost(costAmt);
				sCar.setBought(opened);
				sCar.setName(name.getText());
				
			} catch (ParseException e1) {
				System.out.println ("Herer");
				e1.printStackTrace();
			}
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



