package f14project2;

import javax.swing.*;

public class SuperTicTacToe {

	private static int size;
	private static int timeLimit;

	public static void main (String[] args)
	{	

		try {
			JFrame frame = new JFrame ("Super Tic Tac Toe!");
			frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

			String strSize = JOptionPane.showInputDialog("Please enter size of the board (3):");
			int size = (strSize == null || strSize.equals("")) ? 3 : Integer.parseInt(strSize); 

			if (size < 3 || size > 9) {
				JOptionPane.showMessageDialog(null, "Size must be greater than 2 and Less than 10");
				System.exit(1);
			}

			String strStarts = JOptionPane.showInputDialog("Which player starts first: X or O (default: X)");

			if (!strStarts.equalsIgnoreCase("o"))
				strStarts = "x";

			SuperTicTacToePanel panel = new SuperTicTacToePanel(size, strStarts);
			frame.getContentPane().add(panel);

			frame.setSize(size*80, 300 + size * 50);
			frame.setVisible(true);
		}

		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "The program has unexpectedly quit!");
		
		// 
		
		}
	}


}

