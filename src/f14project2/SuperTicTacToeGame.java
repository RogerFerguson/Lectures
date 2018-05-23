package f14project2;

import java.awt.*;
import java.util.ArrayList;

public class SuperTicTacToeGame {
	private Cell[][] board;
	private GameStatus status;
	private int size;
	private Cell turn;
	private Cell firstTime;
	
	private ArrayList<Point> backup = new ArrayList<Point>();

	
	
	
	public SuperTicTacToeGame(int size, Cell starts) {
		status = GameStatus.IN_PROGRESS;
		this.size = size;
		board = new Cell[size][size];
		turn = starts;
		firstTime = starts;
		reset();
	}

	public Cell[][] getBoard() {
		return board;
	}
	
	public boolean undo () {
		if (backup.isEmpty())
			return false;
		
		Point p = backup.remove(backup.size() - 1);
		board[p.y][p.x] = Cell.EMPTY;
		
		if (turn == Cell.O)
			turn = Cell.X;
		else
			turn = Cell.O;
		
		return true;
	}

	public void select(int row, int col) {
		if (board[row][col] != Cell.EMPTY)
			return;
		
		board[row][col] = turn;
		backup.add (new Point(col, row));

		if (turn == Cell.O)
			turn = Cell.X;
		else
			turn = Cell.O;
		status = isWinner();
	}

	private GameStatus isWinner() {

		for (int r = 0; r < size; r++)     
			for (int c = 0; c < size; c++) {
				if (isThreeInRow(r,c, Cell.X))
					return GameStatus.X_WON;
				if (isThreeInRow(r,c, Cell.O))
					return GameStatus.O_WON;
				if (isThreeInCol(r,c, Cell.X))
					return GameStatus.X_WON;
				if (isThreeInCol(r,c, Cell.O))
					return GameStatus.O_WON;
			}

		for (int r = 0; r < size; r++)     
			for (int c = 0; c < size; c++) 
				if (board[r][c] == Cell.EMPTY)
					return GameStatus.IN_PROGRESS;

		return GameStatus.CATS;
	}

	private boolean isThreeInRow (int row, int col, Cell type) {
		if (col + 2 < size)
            return board[row][col] == type && board[row][col + 1] == type && board[row][col + 2] == type;

		return false;
	}

	private boolean isThreeInCol (int row, int col, Cell type) {
		if (row + 2 < size)
            return board[row][col] == type && board[row + 1][col] == type && board[row + 2][col] == type;

		return false;}

	public GameStatus getGameStatus() {
		return status;
	}

	public void reset() {
		for (int r = 0; r < size; r++) 
			for (int c = 0; c < size; c++) 
				board[r][c] = Cell.EMPTY;
		
		turn = firstTime;
	}

	public boolean getOK(int r, int c) {
        return board[r][c] == Cell.EMPTY;
	}
}


