package week2Game;


import javax.swing.*;

public class MineSweeper {
	public static void main (String[] args)
	{
		JFrame frame = new JFrame ("Mine Sweeper!");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		MineSweeperPanel panel = new MineSweeperPanel();
		frame.getContentPane().add(panel);
		frame.setSize(400, 400);
		frame.setVisible(true);
	}


}

