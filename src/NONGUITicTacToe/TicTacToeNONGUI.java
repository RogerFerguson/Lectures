package NONGUITicTacToe;
import java.util.Scanner;
public class TicTacToeNONGUI {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		TicTacToeGame game = new TicTacToeGame();
		char[][] board = new char[3][3];
		game.setEmpty();
		
		int row, col;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("The following program plays TicTacToe Game\n\n");
		
		board = game.getDisplay();
		displayit(board);
		do {
			System.out.println("It is the user's turn:");
			System.out.println("Please select a row, the top row is zero");
			row = scan.nextInt();
			System.out.println("Please select a col, left col is zero");
			col = scan.nextInt();
			
			if ((col >= 0) && (col < 3) && (row >= 0) && (row < 3))
				game.xMove(row, col);
			
			if (game.isWinner().equals ("X")) {
				System.out.println ("\nThe User won! \n");
				board = game.getDisplay();
				displayit(board);
				break;
			}
			
			board = game.getDisplay();
			displayit(board);
			
			System.out.println ("It is the Computer's turn\nHit ENTER key to continue\n");
			String x = scan.nextLine();
			x = scan.nextLine();
			
			game.oMove();
			board = game.getDisplay();
			displayit(board);
			
			if (game.isWinner().equals ("0")) {
				System.out.println ("\nThe computer won! \n");
				board = game.getDisplay();
				displayit(board);
				break;
			}
			
			if (game.isWinner().equals ("CATS")) {
				System.out.println ("\nCats game! \n");
				board = game.getDisplay();
				displayit(board);
				break;
			}
		} while (row != -1);
	}
	
	
	
	public static void displayit (char[][] board) {
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				if (c != 2) 
					System.out.format ("%3c |", board[r][c]);
				else
					System.out.format ("%3c", board[r][c]);
			}
			if (r != 2)
				System.out.println("\n -------------");
		}
		System.out.println ("\n\n");
	}
}








