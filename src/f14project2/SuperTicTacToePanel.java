package f14project2;

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
	private int size;
	private JButton quitButton;
	private JButton undoButton;

	private ImageIcon xIcon;
	private ImageIcon oIcon;
	private ImageIcon emptyIcon;

	private SuperTicTacToeGame game;

	public SuperTicTacToePanel(int size, String starts) {

		this.size = size;

		xIcon = new ImageIcon ("src/F12Project2/x.jpg");
		oIcon = new ImageIcon ("src/F12Project2/o.jpg");
		emptyIcon = new ImageIcon ("src/F12Project2/empty.jpg");

		JPanel bottom = new JPanel();
		JPanel center = new JPanel();

		// create game, listeners
		ButtonListener listener = new ButtonListener();

		if (starts.equalsIgnoreCase("o"))
			game = new SuperTicTacToeGame(size, Cell.O);
		else
			game = new SuperTicTacToeGame(size, Cell.X);


		// create Undop and quit buttons.
		quitButton = new JButton("Quit");
		quitButton.addActionListener(listener);
		undoButton = new JButton("Undo");
		undoButton.addActionListener(listener);
		
		// create the board 
		center.setLayout(new GridLayout(size,size,3,2));
		Dimension temp = new Dimension(60,60);
		board = new JButton[size][size];

		for (int row = 0; row < size; row++) 
			for (int col = 0; col < size; col++) {

				Border thickBorder = new LineBorder(Color.blue, 2);

				board[row][col] = new JButton ("", emptyIcon);
				board[row][col].setPreferredSize(temp);
				board[row][col].setBorder(thickBorder);

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
		bottom.add(undoButton);

		// add all to contentPane

		add (new JLabel("!!!!!!  Super TicTacToe  !!!!"), BorderLayout.NORTH);
		add (center, BorderLayout.CENTER);
		add (bottom, BorderLayout.SOUTH);

	}


	private void displayBoard() {
        System.out.println(GameStatus.O_WON);
		iBoard = game.getBoard ();

		for (int r = 0; r < size; r++) 
			for (int c = 0; c < size; c++) {

				board[r][c].setIcon(emptyIcon);
				if (iBoard[r][c] == Cell.O)
					board[r][c].setIcon(oIcon);

				if (iBoard[r][c] == Cell.X)
					board[r][c].setIcon(xIcon);
			}

	}

	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (quitButton == e.getSource())
				System.exit(0);
			

			if (undoButton == e.getSource()) {
				game.undo();
			}
				
			for (int r = 0; r < size; r++) 
				for (int c = 0; c < size; c++) 
					if (board[r][c] == e.getSource() && game.getOK(r,c))
						game.select (r,c);


			displayBoard();
			
			if (game.getGameStatus() == GameStatus.O_WON) {
				JOptionPane.showMessageDialog(null, "O won and X lost!\n The game will reset");
				game.reset();
				displayBoard();
				oWon.setText(""+(Integer.parseInt(oWon.getText()) + 1));
			}

			if (game.getGameStatus() == GameStatus.X_WON) {
				JOptionPane.showMessageDialog(null, "X won and O lost!\n The game will reset");
				game.reset();
				displayBoard();
				xWon.setText(""+(Integer.parseInt(xWon.getText()) + 1));
			}
			
			if (game.getGameStatus() == GameStatus.CATS) {
				JOptionPane.showMessageDialog(null, "Cats game!\n The game will reset");
				game.reset();
				displayBoard();
			}
			
		}
	}
}
