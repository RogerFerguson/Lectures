package week6a;

import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class GUIexample extends JFrame implements ActionListener {
	
	private JMenuBar menus;
	
	private JMenu fileMenu;
	private JMenu autoMenu;
	
	// fileMenu
	private JMenuItem openSerItem;
	private JMenuItem exitItem;
	private JMenuItem saveSerItem;
	private JMenuItem openTextItem;
	private JMenuItem saveTextItem;
	
	// auto Menu
	private JMenuItem addSItem;
	private JMenuItem addEItem;
	private JMenuItem removeItem;
	
	private JTable jTableArea;
	private autoEngine dTableModel;
    private JScrollPane scrollPane;
	
	//private 
	public GUIexample () {	
		fileMenu = new JMenu("File");
		openSerItem = new JMenuItem("Open Serial");
		saveSerItem = new JMenuItem("Save Serial");
		exitItem = new JMenuItem("Exit");
		openTextItem = new JMenuItem("Open Text");
		saveTextItem = new JMenuItem("Save Text");
		
		fileMenu.add(openSerItem);
		fileMenu.add(saveSerItem);
		
		fileMenu.add(exitItem);

		fileMenu.add(openTextItem);
		fileMenu.add(saveTextItem);
		
		openSerItem.addActionListener(this);
		exitItem.addActionListener(this);
		saveSerItem.addActionListener(this);
		openTextItem.addActionListener(this);
		saveTextItem.addActionListener(this);
		
		autoMenu = new JMenu ("Auto");
		
		addSItem = new JMenuItem("Add Sport Car");
		addEItem = new JMenuItem("Add Electric Car");
		
		removeItem = new JMenuItem("Remove");
		autoMenu.add(addSItem);
		autoMenu.add(addEItem);
		autoMenu.add(removeItem);
		
		addSItem.addActionListener(this);
		addEItem.addActionListener(this);
		removeItem.addActionListener(this);
		
		menus = new JMenuBar();
		
		menus.add(fileMenu); 
		menus.add(autoMenu);

		setJMenuBar(menus);
		
		dTableModel = new autoEngine();
		jTableArea = new JTable(dTableModel);
		scrollPane = new JScrollPane(jTableArea);
		add (scrollPane);
				
		setVisible(true);
		setSize(600,400);
	}
	
	public static void main (String[] args) {
		new GUIexample();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (openSerItem == e.getSource()) {
			dTableModel.loadDatabase("/Users/fergusor/testDB");
		}
		
		if (openTextItem == e.getSource()) {
			dTableModel.loadFromText("/Users/fergusor/testDBtext");
		}
		
		if (exitItem == e.getSource()) {
			System.exit(0);
		}
		
		if (saveSerItem == e.getSource()) {
			dTableModel.saveDatabase("/Users/fergusor/testDB");
		}
		
		if (saveTextItem == e.getSource()) {
			dTableModel.saveAsText("/Users/fergusor/testDBtext");
		}
		
		if (addSItem == e.getSource()) {
			SportsCar s = new SportsCar();
			DialogSportsAdd x = new DialogSportsAdd(this, s);
			if (x.getCloseStatus() == DialogSportsAdd.OK) {
				dTableModel.addAuto(s);
			}
				
		}
		
		if (addEItem == e.getSource()) {
						
		}
		
		if (removeItem == e.getSource()) {
			int index = jTableArea.getSelectedRow();
			//System.out.println (index);
			if (index == -1)
				JOptionPane.showMessageDialog(this,"NO");
			else
				dTableModel.removeAuto(index);

		}
	}
}


