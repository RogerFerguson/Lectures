package package1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*****************************************************************
 * 
 * Class that maintains the rent game dialog. Displays a new
 * JFrame when trying to rent a new Game
 * 
 *****************************************************************/
public class DialogRentGame extends JDialog implements ActionListener{
	
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
	
	/** text field for platform title */
	private JTextField platformTxt;
	
	/** JLabel for title */
	private JLabel titleLabel;
	
	/** JLabel for renter */
	private JLabel renterLabel;
	
	/** JLabel for date rented on */
	private JLabel rentedOnLabel;
	
	/** JLabel for due back title */
	private JLabel dueBackLabel;
	
	/** JLabel for platform title */
	private JLabel platformLabel;
	
	/** OK button for selection */
	private JButton okButton;
	
	/** cancel button */
	private JButton cancelButton;
	
	/** boolean for close status */
	private static boolean closeStatus;
	
	/** Maintains Game object */
	private DVD unit; 
	
	/** Holds the date format */
	private SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	
	/*****************************************************************
	 * 
	 * Maintains the dialog rent game functions
	 * 
	 * @param - parent - parent JFrame which is up
	 * @param - g - Game object given
	 *****************************************************************/
	public DialogRentGame(JFrame parent, DVD g) {	
		unit = g; 
		Date date = Calendar.getInstance().getTime();
		closeStatus = false;
		
		//creating labels and text fields
		renterLabel = new JLabel("Your Name:");
		renterTxt = new JTextField("Steve Smith");
		titleLabel = new JLabel("Title of Game:");
		titleTxt = new JTextField("Shovel Knight");
		rentedOnLabel = new JLabel("Rented on Date:");
		rentedOnTxt = new JTextField(df.format(date));
		dueBackLabel = new JLabel("Due Back:");
		dueBackTxt = new JTextField("07/23/2014");
		platformLabel = new JLabel("Game Platform:");
		platformTxt = new JTextField("Wii U");
				
		//creating new buttons
		okButton = new JButton("Ok");
		okButton.addActionListener(this);
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		
		//adding labels and buttons
		JPanel masterPanel = new JPanel(new GridLayout(2,1));
		JPanel details = new JPanel(new GridLayout(5,2));
		JPanel butPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		details.add(renterLabel);
		details.add(renterTxt);
		details.add(titleLabel);
		details.add(titleTxt);
		details.add(rentedOnLabel);
		details.add(rentedOnTxt);
		details.add(dueBackLabel);
		details.add(dueBackTxt);
		details.add(platformLabel);
		details.add(platformTxt);
		
		butPanel.add(okButton);
		butPanel.add(cancelButton);
		
		masterPanel.add(details);
		masterPanel.add(butPanel);
		
		//frame.setJMenuBar(menus);
		frame = new JFrame("Rent Game");
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
