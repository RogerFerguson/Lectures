package NONGUITicTacToe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BattleShipPanel extends JPanel {
	
	int SIZE = 7;
	
	BattleShipGame game = new BattleShipGame(SIZE);
	private boolean place_AirCraft = false;
	int orientation = 0;	// 0 -  horizontal,  1 - vertical 
	boolean player = false;  // users starts first;  if false then game is over.  
	
	JLabel ul1 = new JLabel ("User Guesses");
	JLabel ul2 = new JLabel ("User ships here");
	JLabel cl1 = new JLabel ("Computer Guesses");
	JLabel cl2 = new JLabel ("Computer Ships here");
	
	JButton[][] ug1 = new JButton[SIZE][SIZE];
	JButton[][] ug2 = new JButton[SIZE][SIZE];
	JButton[][] cg1 = new JButton[SIZE][SIZE];
	JButton[][] cg2 = new JButton[SIZE][SIZE];
	
	JPanel pu1 = new JPanel();
	JPanel pu2 = new JPanel();
	JPanel pc1 = new JPanel();
	JPanel pc2 = new JPanel();
	
	JPanel pgu1 = new JPanel();
	JPanel pgu2 = new JPanel();
	JPanel pgc1 = new JPanel();
	JPanel pgc2 = new JPanel();
	
	JButton start = new JButton ("Click me to Start the Battle-Ship game");
	JFrame frame;
	JMenuItem reset;
	JMenuItem exit;
	
	public BattleShipPanel(JFrame frame, JMenuItem reset, JMenuItem exit) {
		this.frame = frame;
		this.reset = reset;
		this.exit = exit;
		
		setLayout(new GridLayout(2,2));
		
		pgu1.setLayout(new GridLayout(SIZE,SIZE));
		pgu2.setLayout(new GridLayout(SIZE,SIZE));
		pgc1.setLayout(new GridLayout(SIZE,SIZE));
		pgc2.setLayout(new GridLayout(SIZE,SIZE));
		
		pu1.add(ul1);
		pu2.add(ul2);
		pc1.add(cl1);
		pc2.add(cl2);
		
		ButtonListener bl = new ButtonListener();
		
		for (int i = 0; i < SIZE; i++)
			for (int j = 0; j < SIZE; j++) {
				ug1[i][j] = new JButton(" ");
				ug1[i][j].setBackground(Color.lightGray);
				ug1[i][j].addActionListener(bl);
				pgu1.add(ug1[i][j]);
				
				ug2[i][j] = new JButton(" ");
				ug2[i][j].setBackground(Color.lightGray);
				ug2[i][j].addActionListener(bl);
				pgu2.add(ug2[i][j]);
				
				cg1[i][j] = new JButton(" ");
				cg1[i][j].setBackground(Color.lightGray);
				cg1[i][j].addActionListener(bl);
				pgc1.add(cg1[i][j]);
				
				cg2[i][j] = new JButton(" ");
				cg2[i][j].setBackground(Color.lightGray);
				cg2[i][j].addActionListener(bl);
				pgc2.add(cg2[i][j]);
			}
		
		pu1.add(pgu1);
		pu2.add(pgu2);
		pc1.add(pgc1);
		pc2.add(pgc2);
		
		pc2.add(start);
		start.addActionListener(bl);
		reset.addActionListener(bl);
		exit.addActionListener(bl);
		
		add(pu1);
		add(pu2);
		add(pc1);
		add(pc2);
	}
	
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			JComponent comp = (JComponent) e.getSource();
			
			if (comp == exit)
				System.exit(0);
			
			if (comp == reset ) {
				for (int i = 0; i < SIZE; i++)
					for (int j = 0; j < SIZE; j++) {
						ug1[i][j].setText(" ");
						ug2[i][j].setText(" ");	
						cg1[i][j].setText(" ");
						cg2[i][j].setText(" ");	
					}
				place_AirCraft = false;
				start.setEnabled(true);
				player = false;  // users starts first;  if false then game is over. 
				game.reset(SIZE);
			}
			
			
			if (comp == start) {
				start.setEnabled(false);
				Object[] options = {"Horizonal", "Vertical"};
				orientation = JOptionPane.showOptionDialog(frame,
						"Click where to place an Aircraft Carrier","Ship placement by User",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
						options, options[0]);
				place_AirCraft = true;
			}
			
			if (place_AirCraft) {
				for (int i = 0; i < SIZE; i++) 
					for (int j = 0; j < SIZE; j++) {
						if (ug2[i][j] == comp) {
							boolean valid = game.setUserAirCraftShip(i,j,orientation);
							if (!valid) {
								JOptionPane.showMessageDialog(frame, "Not valid, please try again!");
								return;
							}
							if (orientation == 1)
								for (int k = 0; k < 4; k++)
									ug2[i+k][j].setText("A");
							else
								for (int k = 0; k < 4; k++)
									ug2[i][j+k].setText("A");
							
							place_AirCraft = false;
							JOptionPane.showMessageDialog(frame, "Now the Computer will place its ship.");
							
							Ship ship = game.getComputerAirCraft();
							
							int r = ship.getRow();
							int c = ship.getCol();
							int o = ship.getOrientation();
							System.out.println ("Place r " + r + " c " + c +" o " + o);
							
							if (o == Ship.VERTICAL)
								for (int k = 0; k < 4; k++)
									cg2[r+k][c].setText("A");
							else
								for (int k = 0; k < 4; k++)
									cg2[r][c+k].setText("A");
							
							JOptionPane.showMessageDialog(frame, "Let's play Battle ship!\nThe user starts first. \n" +
							"The user Guesses a cell to see if they have a hit!");
							player = true;
							
						}
						
					}	
			}
			
			if (player) {
				for (int i = 0; i < SIZE; i++) 
					for (int j = 0; j < SIZE; j++) {
						if ((ug1[i][j] == comp) && !(ug1[i][j].getText().equals("X"))) {
							ug1[i][j].setText("X");
							Ship ship;
							if ((ship = game.isComputerHit(i,j)) != null) {
								JOptionPane.showMessageDialog(frame, "You Hit a " + ship.getType() +
								" It is your turn again!");
								if (ship.getSize() == 0) {
									JOptionPane.showMessageDialog(frame, "You SUNK my " + ship.getType());
									String winner;
									if ((winner = game.isWinner()) != null) {
										player = false;
										JOptionPane.showMessageDialog(frame, "The " + winner + " WON!");
									}
								}
							}
							else {
								JOptionPane.showMessageDialog(frame, "You missed!, Computer's turn ");
								computerTurn();
								
							}
							
						}		
			}
		}
	}
	
	private void computerTurn() {
		boolean turn = true;
		do {
			game.createComputerGuess();
			int r = game.getComputerRowGuess();
			int c = game.getComputerColGuess();
			
			cg1[r][c].setText("G");
			JOptionPane.showMessageDialog(frame, "The computer selected, and place an G in the grid");
			cg1[r][c].setText("X");
			Ship ship;
			if ((ship = game.isUserHit(r,c)) != null) {
				JOptionPane.showMessageDialog(frame, "The Computer Hit a ship and it was " + ship.getType() +
				". It is the computer's turn again.");
				if (ship.getSize() == 0) {
					JOptionPane.showMessageDialog(frame, "You SUNK my " + ship.getType());
					String winner;
					if ((winner = game.isWinner()) != null) {
						player = false;
						JOptionPane.showMessageDialog(frame, "The " + winner + " WON!");
						return ;
					}
				}
			}
			else {
				JOptionPane.showMessageDialog(frame, "The Computer missed!, User's turn");
				turn = false;
			}
			
		} while (turn);
	}
}
}






