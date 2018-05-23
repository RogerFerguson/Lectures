package week2Game2;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuperTicTacToePanel extends JPanel {
	private JButton[][] board;
	private Cell[][] iBoard;
	private JLabel xWon;
	private JLabel oWon;
	private JButton quitButton;
	private JButton up, down, left, right;

	private SuperTicTacToeGame game;

	public SuperTicTacToePanel() {

		game = new SuperTicTacToeGame();

		JPanel bottom = new JPanel();
		JPanel center = new JPanel();

		// create game, listeners
		ButtonListener listener = new ButtonListener();

		// create Undos and quit buttons.
		quitButton = new JButton("Quit");
		quitButton.addActionListener(listener);


		// create the board 
		center.setLayout(new GridLayout(7,7,3,2));
		board = new JButton[7][7];

		for (int row = 0; row < 7; row++) 
			for (int col = 0; col < 7; col++) {
				board[row][col] = new JButton ("");
				board[row][col].addActionListener(listener);
				center.add(board[row][col]);
			}

		displayBoard();

		bottom.setLayout (new GridLayout(3,2));
		JLabel labxWins = new JLabel ("X Wins: ");
		JLabel laboWins = new JLabel ("O Wins: ");
		xWon = new JLabel ("0");
		oWon = new JLabel ("0");

		bottom.add(labxWins);
		bottom.add(xWon);
		bottom.add(laboWins);
		bottom.add(oWon);
		bottom.add(quitButton);

		// add all to contentPane

		add (new JLabel("!!!!!!  Super TicTacToe  !!!!"), BorderLayout.NORTH);
		add (center, BorderLayout.CENTER);
		add (bottom, BorderLayout.SOUTH);

	}


	private void displayBoard() {
		
		
		iBoard = game.getBoard ();

		for (int r = 0; r < 7; r++) 
			for (int c = 0; c < 7; c++) {

				if (iBoard[r][c] == Cell.O)
					//System.out.println (" " + r + " " + c + " O");
					board[r][c].setText("O");

				if (iBoard[r][c] == Cell.X)
					// System.out.println (" " + r + " " + c + " X");
					board[r][c].setText("X");
			}

	}

	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (quitButton == e.getSource())
				System.exit(0);


			if (e.getSource() == left)
				
			for (int r = 0; r < 7; r++) 
				for (int c = 0; c < 7; c++) 

					if (board[r][c] == e.getSource()) 
						game.select (r,c);

			displayBoard();	

			if (game.isWinner() == GameStatus.X_WON) {
				JOptionPane.showMessageDialog(null, "X Won!");
				game.reset();
				displayBoard();
			}


		}
	}
}
