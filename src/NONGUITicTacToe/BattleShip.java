package NONGUITicTacToe;

import javax.swing.*;

public class BattleShip {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame ("Voting Simulation:");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menus = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		
		JMenuItem reset = new JMenuItem("Reset");
		JMenuItem exit = new JMenuItem("Exit");
		fileMenu.add(reset);
		fileMenu.add(exit);
		
		menus.add(fileMenu);
		frame.setJMenuBar(menus);
		
		BattleShipPanel panel = new BattleShipPanel(frame, reset, exit);
		
		frame.add(panel);
		
		//      frame.pack();
		frame.setSize(1200,600);
		frame.setVisible(true);
		
	}
	
}
