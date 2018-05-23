package week2Game2;

import javax.swing.*;

public class SuperTicTacToe {

	public static void main (String[] args)
	{	
		JFrame frame = new JFrame ("Super Tic Tac Toe!");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		SuperTicTacToePanel panel = new SuperTicTacToePanel();
		frame.getContentPane().add(panel);
		frame.setSize(600, 400);
		frame.setVisible(true);
	}
}

