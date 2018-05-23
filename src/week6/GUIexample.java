package week6;

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

	private JTextArea area;
	private JList jListArea;

	private AutoModel dListModel;

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

		//	jListArea = new JList();

		dListModel = new AutoModel();
		jListArea = new JList(dListModel);

		add(jListArea);

		setVisible(true);
		setSize(600,400);
	}

	public static void main (String[] args) {
		new GUIexample();
	}

	public void actionPerformed(ActionEvent e) {

		if (openSerItem == e.getSource()) {
			dListModel.loadDatabase("/Users/fergusor/testDB");
		}

		if (openTextItem == e.getSource()) {
			dListModel.loadFromText("/Users/fergusor/testDBtext");
		}

		if (exitItem == e.getSource()) {
			System.exit(0);
		}

		if (saveSerItem == e.getSource()) {
			dListModel.saveDatabase("/Users/fergusor/testDB");
		}

		if (saveTextItem == e.getSource()) {
			dListModel.saveAsText("/Users/fergusor/testDBtext");
		}

		if (addSItem == e.getSource()) {
			SportsCar s = new SportsCar();
			DialogSportsAdd x = new DialogSportsAdd(this, s);
			if (x.getCloseStatus() == DialogSportsAdd.OK)
				dListModel.addAuto(s);
			//dListModel.addElement(s.getOwner().getName() + s.getBalance());
		}

		if (addEItem == e.getSource()) {

		}

		if (removeItem == e.getSource()) {
			int index = jListArea.getSelectedIndex();
			//System.out.println (index);
			if (index == -1)
				JOptionPane.showMessageDialog(this,"NO");
			else
				dListModel.removeAuto(index);

		}
	}
}


