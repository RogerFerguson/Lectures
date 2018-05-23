package week2Game2;

import java.awt.*;
import java.util.ArrayList;

public class SuperTicTacToeGame {
	private Cell[][] board;
	private GameStatus status;
	private Cell turn;

	public SuperTicTacToeGame() {
		board = new Cell[7][7];
		reset ();
		turn = Cell.X;
	}

	public Cell[][] getBoard() {
		return board;
	}


	public void select(int row, int col) {
		if (turn == Cell.X)
			board[row][col] = Cell.X;
		else 
			board[row][col] = Cell.O;
		
		if (turn == Cell.X) 
			turn = Cell.O;
		else
			turn = Cell.X;
	}


	public GameStatus isWinner() {


		for (int r =0; r < 7; r++)
			for (int c = 0; c < 5; c++)
				if (board[r][c] == Cell.X && board[r][c+1] == Cell.X &&
					board[r][c+2] == Cell.X)
						return GameStatus.X_WON;

		return GameStatus.IN_PROGRESS;

	}



	public GameStatus getGameStatus() {
		return status;
	}

	public void reset() {
		for (int r = 0; r < 7; r++)
			for (int c = 0; c < 7; c++)
				board[r][c] = Cell.EMPTY;


	}

}


