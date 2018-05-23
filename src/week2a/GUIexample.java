package week2a;

import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class GUIexample extends JFrame implements ActionListener {
	
	private JMenuBar menus;
	
	private JMenu fileMenu;
	
	// fileMenu
	private JMenuItem exitItem;
	private JMenuItem dialogItem;

	//private 
	public GUIexample () {	
		fileMenu = new JMenu("File");
		exitItem = new JMenuItem("Exit");
		dialogItem = new JMenuItem("Student change");
		
		fileMenu.add(exitItem);
		fileMenu.add(dialogItem);
		
		exitItem.addActionListener(this);
		dialogItem.addActionListener(this);
		
		menus = new JMenuBar();
		
		menus.add(fileMenu); 
		setJMenuBar(menus);
				
		setVisible(true);
		setSize(600,400);
	}
	
	public static void main (String[] args) {
		new GUIexample();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (exitItem == e.getSource()) {
			System.exit(0);
		}
		
		if (dialogItem == e.getSource()) {
			Student s = new Student("Roger", 2.0);
			DialogChange x = new DialogChange(this, s);
			if (x.getCloseStatus() == DialogChange.OK) {
				System.out.println ("Name: " + s.getName() +
						" GPA: " + s.getOverAllGPA());
			}
				
		}
	}
}


