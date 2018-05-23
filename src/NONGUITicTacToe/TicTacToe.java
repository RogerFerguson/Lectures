package NONGUITicTacToe;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TicTacToe {
		   public static void main (String[] args)
		   {
		      JFrame frame = new JFrame ("Tic Tac Toe Game");
		      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

		      TicTacToePanel panel = new TicTacToePanel();
		      frame.add(panel);

		      frame.setSize(400,400);
		      frame.setVisible(true);
		   }
		}

