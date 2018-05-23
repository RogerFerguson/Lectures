package package1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIRentalStore extends JFrame implements ActionListener {

    private JMenuBar menus;

    private JMenu fileMenu;
    private JMenu actionMenu;

    // fileMenu
    private JMenuItem openSerItem;
    private JMenuItem exitItem;
    private JMenuItem saveSerItem;
    private JMenuItem openTextItem;
    private JMenuItem saveTextItem;

    // auto Menu
    private JMenuItem rentDvdItem;
    private JMenuItem rentGameItem;
    private JMenuItem returnItem;
    private JMenuItem searchItem;
    boolean filter;


    private JList jListArea;

    private ListEngine dList;

    //private
    public GUIRentalStore() {
        fileMenu = new JMenu("File");
        openSerItem = new JMenuItem("Open Serial...");
        saveSerItem = new JMenuItem("Save Serial...");
        exitItem = new JMenuItem("Exit!");
        openTextItem = new JMenuItem("Open Text...");
        saveTextItem = new JMenuItem("Save Text...");

        fileMenu.add(openSerItem);
        fileMenu.add(saveSerItem);
        fileMenu.addSeparator();
        fileMenu.add(openTextItem);
        fileMenu.add(saveTextItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        openSerItem.addActionListener(this);
        exitItem.addActionListener(this);
        saveSerItem.addActionListener(this);
        openTextItem.addActionListener(this);
        saveTextItem.addActionListener(this);

        actionMenu = new JMenu("Action");

        rentDvdItem = new JMenuItem("Rent DVD");
        rentGameItem = new JMenuItem("Rent Game");
        returnItem = new JMenuItem("Return");
        searchItem = new JMenuItem("Turn on filter");

        actionMenu.add(rentDvdItem);
        actionMenu.add(rentGameItem);
        actionMenu.addSeparator();
        actionMenu.add(returnItem);
        actionMenu.addSeparator();
        actionMenu.add(searchItem);

        rentDvdItem.addActionListener(this);
        rentGameItem.addActionListener(this);
        returnItem.addActionListener(this);
        searchItem.addActionListener(this);
        filter = false;

        menus = new JMenuBar();

        menus.add(fileMenu);
        menus.add(actionMenu);

        setJMenuBar(menus);

    //    jListArea = new JList();

        dList = new ListEngine();
        jListArea = new JList(dList);

        add(jListArea);

        setVisible(true);
        setSize(800, 400);
    }

    public static void main(String[] args) {
        new GUIRentalStore();
    }

    public void actionPerformed(ActionEvent e) {

        JComponent comp = (JComponent) e.getSource();

        if (exitItem == comp)
            System.exit(0);

//        if (openSerItem == comp || openTextItem == comp) {
//            JFileChooser chooser = new JFileChooser();
//            int status = chooser.showOpenDialog(null);
//            if (status == JFileChooser.APPROVE_OPTION) {
//                String filename = chooser.getSelectedFile().getAbsolutePath();
//                if (openSerItem == comp)
//                    dList.loadDatabase(filename);
//                if (openTextItem == e.getSource())
//                    dList.loadFromText(filename);
//            }
//        }
//
//        if (saveSerItem == comp || saveTextItem == comp) {
//            JFileChooser chooser = new JFileChooser();
//            int status = chooser.showSaveDialog(null);
//            if (status == JFileChooser.APPROVE_OPTION) {
//                String filename = chooser.getSelectedFile().getAbsolutePath();
//                if (saveSerItem == e.getSource())
//                    dList.saveDatabase(filename);
//                if (saveTextItem == e.getSource())
//                    dList.saveAsText(filename);
//            }
//        }
        
        if (rentDvdItem == comp) {
            DVD dvd = new DVD();
            DialogRentDVD x = new DialogRentDVD(this, dvd);
            //if (x.closeOK())
                dList.add(dvd);
        }


        if (rentGameItem == comp) {
            Game game = new Game();
            DialogRentGame x = new DialogRentGame(this, game);
           // if (x.closeOK())
                dList.add(game);
        }

        // Note: the add and remove methods now have issues.
        if (comp == searchItem) {
//            if (filter) {
//                dList.filterOff();
//                filter = false;
//                searchItem.setText("Turn on filter");
//
//            } else {
//                String s;
//                //DialogRentGame x = new DialogSearch(this, s);
//                s = "a";
//                dList.filter(s);
//                searchItem.setText("Turn off filter: " + s);
//                filter = true;
//            }
        }

        if (returnItem == e.getSource()) {
            int index = jListArea.getSelectedIndex();
            if (index != -1) {
//                DVD unit; //= dList.remove(index);
//                JOptionPane.showMessageDialog(null, "Thanks " + unit.getRenter() +
//                        "\n for returning " + unit.getTitle() + ", you owe: " +
//                        " dollars");


            }
        }
    }
}


