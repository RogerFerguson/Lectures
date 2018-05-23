package NONGUITicTacToe;

import java.util.Random;

public class TicTacToeGame2 {
	private char[][] board;
	private int rows;
	private int cols;
	private Random n;
	
	public TicTacToeGame2() {
		board = new char[3][3];
		n = new Random ();
	}
	
	// Set the game to empty
	public void setEmpty() {
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				board[r][c] = ' ';
			}
		}
	}
	
	
	// Display game
	public char[][] getDisplay() {
		return board;
	}
	
	public void xMove(int row, int col) {
		
		if (board[row][col] == ' ')
			board[row][col] = 'X';   // User places an "X"					
	}
	
	public void oMove (){
		boolean found = false;
		int row = 0,  col = 0;
		while (!found) {
			row = n.nextInt(3);
			col = n.nextInt(3);
			if (board[row][col] == ' ')
				found = true;
			
		}
		board[row][col] = 'O';
	}
	
	public String isWinner() {
		int row, col;
		String winner = null;
		
		for (row = 0;row < 3;row++) 
			if	((board[row][0] == 'O') &&
					(board[row][1] == 'O') &&
					(board[row][2] == 'O')) 
				winner = "0";
		
		for (row = 0;row < 3;row++) 
			if	((board[row][0] == 'X') &&
					(board[row][1] == 'X') &&
					(board[row][2] == 'X')) 
				winner = "X";		
		
		for (col = 0;col < 3;col++) 
			if	((board[0][col] == 'O') &&
					(board[1][col] == 'O') &&
					(board[2][col] == 'O')) 
				winner = "0";		
		
		for (col = 0;col < 3;col++) 
			if	((board[0][col] == 'X') &&
					(board[1][col] == 'X') &&
					(board[2][col] == 'X')) 
				winner = "X";
		
		if (winner == null) {
			boolean cats = true;
			for (row = 0;row < 3;row++) 
				for (col = 0;col < 3;col++) 
					if (board[row][col] == ' ')
						cats = false;
			
			if (cats)
				winner =  "Cats";
		}
		
		if (winner == null) 
			return "";
		else
			return winner;
	}
}




