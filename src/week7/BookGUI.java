package week7;

import javax.swing.*;




import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * @author Nandigam
 */
// Modified by Dulimarta to remove auto-generated code
public class BookGUI {

    /* All other variables are declared towards the end of this class */
    private BookController controller;
    private JFrame frame;
    
    public BookGUI() {
        initComponents();
        controller = new BookController();
        table.setModel(controller.getModel());
    }

    private void initComponents() {
    	frame = new JFrame();
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("MVC, JTable, and AbstractTableModel");
        
        JPanel panel;
        scrollPane = new JScrollPane();
        table = new JTable();

        scrollPane.setVerticalScrollBarPolicy(
                        ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        table.setToolTipText("");
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked();
            }
        });
        scrollPane.setViewportView(table);

        frame.add(scrollPane, BorderLayout.CENTER);
        
        panel = setupSouthPanel();
        frame.add(panel, BorderLayout.SOUTH);
        
        panel = setupEastPanel();
        frame.add (panel, BorderLayout.EAST);

        frame.pack();
        frame.setLocationRelativeTo(null);
		frame.setVisible(true);
    }

    private JPanel setupEastPanel() {
        JPanel p, q;
        p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        q = new JPanel();
        p.add(Box.createVerticalGlue());
        p.add(q);
        p.add(Box.createVerticalGlue());

        randomButton = new JButton("Add Random Books");
        deleteButton = new JButton("Delete Book");
        sortTitleButton = new JButton("Sort by Title");
        sortPriceButton = new JButton("Sort by Price");
        saveButton = new JButton("Save as XML");

        q.setBorder(BorderFactory.createTitledBorder("Operations"));
        q.setLayout(new GridLayout(0, 1));
        q.add(randomButton);
        q.add(deleteButton);
        q.add(sortTitleButton);
        q.add(sortPriceButton);
        q.add(saveButton);
        
        randomButton.addActionListener(buttonHandler);
        deleteButton.setToolTipText("Select a book to delete it from table");
        deleteButton.addActionListener(buttonHandler);

        sortTitleButton.setToolTipText("Sort books by title");
        sortTitleButton.addActionListener(buttonHandler);

        sortPriceButton.setToolTipText("Sort books by price");
        sortPriceButton.addActionListener(buttonHandler);

        saveButton.addActionListener(buttonHandler);
        return p;
    }
    
    private JPanel setupSouthPanel() {
        String[] labels = { "Title", "Author(s)", "Publisher", "Year", "Price",
                "ISBN" };
        
        JPanel p = new JPanel();
        p.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Book Information"),
                BorderFactory.createEmptyBorder(5,5,5,5)));
        titleTextField = new JTextField(50);
        authorsTextField = new JTextField(50);
        publisherTextField = new JTextField(30);
        yearTextField = new JTextField(4);
        priceTextField = new JTextField(5);
        isbnTextField = new JTextField(25);
        addButton = new JButton("Add Book");
        clearButton = new JButton("Clear Fields");

        addButton.setToolTipText("Adds a book to the table");
        addButton.addActionListener(buttonHandler);

        clearButton.setToolTipText("Clear contents of all text fields");
        clearButton.addActionListener(buttonHandler);


        p.setLayout(new GridBagLayout());
        GridBagConstraints cons = new GridBagConstraints();
        cons.gridx = 0;
        cons.ipadx = 5;
        cons.ipady = 10;
        cons.anchor = GridBagConstraints.EAST;
        for (int k = 0; k < labels.length; k++)
        {
            cons.gridy = k;
            p.add(new JLabel(labels[k]), cons);
        }

        cons.gridx = 1;
        cons.gridy = 0;
        cons.gridwidth = 3;
        cons.anchor = GridBagConstraints.WEST;
        p.add(titleTextField, cons);
        cons.gridy = 1;
        p.add(authorsTextField, cons);
        cons.gridy = 2;
        p.add(publisherTextField, cons);
        cons.gridy = 3;
        p.add(yearTextField, cons);
        cons.gridy = 4;
        p.add(priceTextField, cons);
        cons.gridy = 5;
        p.add(isbnTextField, cons);
        cons.gridwidth = 1;
        cons.gridx = 3;
        cons.gridy = 6;
        cons.anchor = GridBagConstraints.EAST;
        JPanel q = new JPanel();
        p.add(q, cons);
        q.add(addButton);
        q.add(clearButton);
        return p;
    }
    
    private ActionListener buttonHandler = new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent ev) {
            Object which = ev.getSource();
            if (which == addButton)
                addButtonAction();
            else if (which == clearButton)
                clearButtonAction();
            else if (which == deleteButton)
                deleteButtonAction();
            else if (which == sortTitleButton)
                sortTitleButtonAction();
            else if (which == sortPriceButton)
                sortPriceButtonAction();
            else if (which == randomButton)
                controller.addRandomBooks(75);
            else
                saveButtonAction();
        }
    };
    
    private void addButtonAction() {
    	try {
    		String title = titleTextField.getText();
    		String authors = authorsTextField.getText();
    		String publisher = publisherTextField.getText();
    		int year = Integer.parseInt(yearTextField.getText());
    		double price = Double.parseDouble(priceTextField.getText());
    		String isbn = isbnTextField.getText();
    		controller.addBook(title, authors, publisher, year, price, isbn);
    	} catch (Exception ex) {
    		JOptionPane.showMessageDialog(frame, "Add Book Failed.",
                    "Add Book", JOptionPane.ERROR_MESSAGE);
    	}
    }

    private void deleteButtonAction() {
        int index = table.getSelectedRow();
        if (index != -1) {
            controller.deleteBook(index);
        }
    }

    private void clearButtonAction() {
        titleTextField.setText("");
        authorsTextField.setText("");
        publisherTextField.setText("");
        yearTextField.setText("");
        priceTextField.setText("");
        isbnTextField.setText("");
    }

    private void sortTitleButtonAction() {
        controller.sortByTitle();
    }

    private void sortPriceButtonAction() {
        controller.sortByPrice();
    }

    private void saveButtonAction() {
        if (controller.getModel().getRowCount() > 0) {
            /* open the CURRENT directory */
            JFileChooser chooser = new JFileChooser(new File("."));
            chooser.setDialogTitle("Export As XML");
            int status = chooser.showSaveDialog(frame);
            if (status == JFileChooser.APPROVE_OPTION) {
                String filename = chooser.getSelectedFile().getAbsolutePath();
                if (controller.saveAsXML(filename)) {
                    JOptionPane.showMessageDialog(frame,
                            "XML Export Successful..", "Export As XML",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "XML Export Failed.",
                            "Export As XML", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(frame,
                    "No books to save at this time.", "Export As XML",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void tableMouseClicked() {
        int index = table.getSelectedRow();
        if (index != -1) {
            Book b = controller.getModel().get(index);
            titleTextField.setText(b.getTitle());
            authorsTextField.setText(b.getAuthors());
            publisherTextField.setText(b.getPublisher());
            yearTextField.setText(b.getYear() + "");
            priceTextField.setText(String.format("%5.2f", b.getPrice()));
            isbnTextField.setText(b.getIsbn());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BookGUI();
            }
        });
    }

    private JButton randomButton;
    private JButton addButton;
    private JTextField authorsTextField;
    private JButton clearButton;
    private JButton deleteButton;
    private JTextField isbnTextField;
    private JTextField priceTextField;
    private JTextField publisherTextField;
    private JButton saveButton;
    private JScrollPane scrollPane;
    private JButton sortPriceButton;
    private JButton sortTitleButton;
    private JTable table;
    private JTextField titleTextField;
    private JTextField yearTextField;
    
}
