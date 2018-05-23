package NONGUITicTacToe;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.*;

public class TicTacToePanel extends JPanel {
	private JButton[][] game;
	private int currentRow = 0 , currentCol = 0;
	private Random n = new Random();
	
	private DirectionListener dl;

	
	public TicTacToePanel() {
		
		setLayout(new GridLayout(3,3));
		
		dl = new DirectionListener();
		ButtonListener listener = new ButtonListener();
		
		game = new JButton[3][3];
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				game[row][col] = new JButton("");
				game[row][col].addActionListener(listener);
				game[row][col].addKeyListener(dl);
				add(game[row][col]);
			} 
		}
	}
	
	
	private class ButtonListener implements ActionListener {
		
		int row = 0 , col = 0;
		
		public void actionPerformed(ActionEvent e) {
			JComponent comp = (JComponent) e.getSource();

	
			
			xMove(comp);
		
			if (isWinner().equals("X"))
				JOptionPane.showMessageDialog(null,"The X's have it; X wins the game!");
			
			if (isWinner().equals(""))
				// dl.oMove();          // this solves the keyPress problem... A requirement. 
				oMove();
			
			if (isWinner().equals("O"))
				JOptionPane.showMessageDialog(null,"The 0's have it; 0 wins the game!");
			
			if (isWinner().equals("Cats"))
				JOptionPane.showMessageDialog(null,"It is a Cats game!");
			
			
		}
		
		private void xMove(JComponent comp){
			for (row = 0; row < 3; row++) 
				for ( col = 0; col < 3; col++) 
					if (comp == game[row][col]) 
						
						if ((!game[row][col].getText().equals("O") && 
								!game[row][col].getText().equals("X"))) {
							
							game[row][col].setText("X");   // User places an "X"
							currentRow = row;
							currentCol = col;
						}
		}
		
		private void oMove() {
			boolean found = false;
			int row = 0,  col = 0;
			while (!found) {
				 row = n.nextInt(3);
				 col = n.nextInt(3);
				if ((!game[row][col].getText().equals("X")) && 
						(!game[row][col].getText().equals("O")))
					found = true;
				
			}
			game[row][col].setText("O");
		}
		
		private String isWinner() {
			int row, col;
			String winner = null;
			
			for (row = 0;row < 3;row++) 
				if	((game[row][0].getText().equals("O")) &&
						(game[row][1].getText().equals("O")) &&
						(game[row][2].getText().equals("O"))) 
					winner = "O";
			
			for (row = 0;row < 3;row++) 
				if	((game[row][0].getText().equals("X")) &&
						(game[row][1].getText().equals("X")) &&
						(game[row][2].getText().equals("X"))) 
					winner = "X";		
			
			for (col = 0;col < 3;col++) 
				if	((game[0][col].getText().equals("O")) &&
						(game[1][col].getText().equals("O")) &&
						(game[2][col].getText().equals("O"))) 
					winner = "O";		
			
			for (col = 0;col < 3;col++) 
				if	((game[0][col].getText().equals("X")) &&
						(game[1][col].getText().equals("X")) &&
						(game[2][col].getText().equals("X"))) 
					winner = "X";
			
			if (winner == null) {
				boolean cats = true;
				for (row = 0;row < 3;row++) 
					for (col = 0;col < 3;col++) 
						if ((!game[row][col].getText().equals("X")) && 
								(!game[row][col].getText().equals("O")))
							cats = false;
				
				if (cats)
					winner =  "Cats";
			}
			
			return "";
		}
	}
	
	
	
	
	
	private class DirectionListener implements KeyListener {
		
		public void keyTyped(KeyEvent arg0) {
			// System.out.println("here1" + arg0.getKeyCode());
			
		}
		
		public void keyPressed (KeyEvent event)
		{
			switch (event.getKeyCode())
			{
				case KeyEvent.VK_UP:
					currentRow = (currentRow - 1);
					if (currentRow == -1)
						currentRow = 2;
					
					game[currentRow][currentCol].requestFocus();
					break;
				case KeyEvent.VK_DOWN:
					currentRow = (currentRow + 1);
					if (currentRow == 3)
						currentRow = 0;
					
					game[currentRow][currentCol].requestFocus();
					break;
				case KeyEvent.VK_LEFT:
					System.out.println ("asdasdsad");
					break;
				case KeyEvent.VK_RIGHT:
					
					break;
				case KeyEvent.VK_ENTER:
					if ((!game[currentRow][currentCol].getText().equals("O") && 
							!game[currentRow][currentCol].getText().equals("X"))) {
						
						game[currentRow][currentCol].setText("X");   // User places an "X"
						oMove();
						// more code needed here. 
						
					}
					break;
			}

			repaint();
		}


		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		private void oMove() {
			boolean found = false;
			int row = 0,  col = 0;
			while (!found) {
				 row = n.nextInt(3);
				 col = n.nextInt(3);
				if ((!game[row][col].getText().equals("X")) && 
						(!game[row][col].getText().equals("O")))
					found = true;
				
			}
			game[row][col].setText("O");
		}
	}
	
	
}