package NONGUITicTacToe;

import javax.swing.*;

public class TicTacToe2 {
	public static void main (String[] args)
	{
		JFrame frame = new JFrame ("Tic Tac Toe Game");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new TicTacToePanel2();
		frame.add(panel);
		
		frame.setSize(400,400);
		frame.setVisible(true);
	}
}

