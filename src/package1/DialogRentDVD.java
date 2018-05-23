package package1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*********************************************************************
 * CIS 163 Project 4 - RedBox Program - Simulates a red box like 
 * rental program
 * By: Mark Van Baren
 * Professor: Dr. Ferguson
 * due 7/30/14
 *********************************************************************/
public class DialogRentDVD extends JDialog implements ActionListener{
	
	/** The frame in witch the GUI works */
	private JFrame frame;
	
	/** text field for the title */
	private JTextField titleTxt;
	
	/** text field for the renter */
	private JTextField renterTxt;
	
	/** text field for the date rented on */
	private JTextField rentedOnTxt;
	
	/** text field for the due back title */
	private JTextField dueBackTxt;
	
	/** JLabel for title */
	private JLabel titleLabel;
	
	/** JLabel for renter */
	private JLabel renterLabel;
	
	/** JLabel for date rented on */
	private JLabel rentedOnLabel;
	
	/** JLabel for due back title */
	private JLabel dueBackLabel;
	
	/** OK button for selection */
	private JButton okButton;
	
	/** Cancel button */
	private JButton cancelButton;
	
	/** Boolean for close status */
	private static boolean closeStatus;
	
	/** Maintains DVD object */
	private DVD unit; 

	/** Holds the date format */
	private SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	
	/*****************************************************************
	 * 
	 * Maintains the dialog rent dvd functions
	 * 
	 * @param - parent - parent JFrame which is up
	 * @param - d - DVD object given
	 *****************************************************************/
	public DialogRentDVD(JFrame parent, DVD d) {	
		unit = d; 
		Date date = Calendar.getInstance().getTime();
		
		//creating labels and text fields
		renterLabel = new JLabel("Your Name:");
		renterTxt = new JTextField("Steve Smith");
		titleLabel = new JLabel("Title of DVD:");
		titleTxt = new JTextField("Forest Gump");
		rentedOnLabel = new JLabel("Rented on Date:");
		rentedOnTxt = new JTextField(df.format(date));
		dueBackLabel = new JLabel("Due Back:");
		dueBackTxt = new JTextField("07/23/2014");
		
		//creating new buttons
		okButton = new JButton("Ok");
		okButton.addActionListener(this);
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		
		//adding labels and buttons
		JPanel masterPanel = new JPanel(new GridLayout(2,1));
		JPanel details = new JPanel(new GridLayout(4,2));
		JPanel butPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		details.add(renterLabel);
		details.add(renterTxt);
		details.add(titleLabel);
		details.add(titleTxt);
		details.add(rentedOnLabel);
		details.add(rentedOnTxt);
		details.add(dueBackLabel);
		details.add(dueBackTxt);
		
		butPanel.add(okButton);
		butPanel.add(cancelButton);
		
		masterPanel.add(details);
		masterPanel.add(butPanel);
		
		//frame.setJMenuBar(menus);
		frame = new JFrame("Rent DVD");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().add(masterPanel);
		frame.pack();
		frame.setSize(new Dimension (400,300));
		frame.setMinimumSize(new Dimension(400,300));
		frame.setMaximumSize(new Dimension(400,300));
		frame.setVisible(true);
	}
	
	/*****************************************************************
	 * 
	 * This method handles event-handling code for the GUI
	 * 
	 * @param e - Holds the action event parameter
	 *****************************************************************/
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == okButton){
			closeStatus = true;
	        frame.dispose();
        }
		if(e.getSource() == cancelButton){
            frame.dispose();
        }
	}
	
	/*****************************************************************
	 * 
	 * This method retrieves the close status
	 * 
	 * @return - returns the boolean close status
	 *****************************************************************/
	public static boolean getCloseStatus(){
		return closeStatus;
	}
	
}
