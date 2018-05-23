package week7;

import javax.swing.table.*;
import java.util.*;
import java.io.*;

/**
 * @author Nandigam
 */
public class BookModel extends AbstractTableModel {

    private ArrayList<Book> books;
    
    private String[] columnNames = {"Title", "Authors", "Publisher", "Year",
        "Price", "ISBN"};

    public BookModel() {
        books = new ArrayList<Book>();
    }

    public int getRowCount() {
        return books.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        Object val = null;
        switch (col) {
            case 0:
                val = books.get(row).getTitle();
                break;

            case 1:
                val = books.get(row).getAuthors();
                break;

            case 2:
                val = books.get(row).getPublisher();
                break;

            case 3:
                val = books.get(row).getYear();
                break;

            case 4:
                val = String.format("%5.2f", books.get(row).getPrice());
                break;

            case 5:
                val = books.get(row).getIsbn();
                break;
        }
        return val;
    }

    public Book get(int index) {
        return books.get(index);
    }

    public int indexOf(Book b) {
        return books.indexOf(b);
    }
    
    public void add(Book b) {
        if (b != null) {
            books.add(b);
            fireTableRowsInserted(books.size() - 1, books.size() - 1);
        }
    }

    public void add(int index, Book b) {
        if (b != null) {
            books.add(index, b);
            fireTableRowsInserted(index, index);
        }
    }

    public void remove(int index) {
        books.remove(index);
        fireTableRowsDeleted(index, index);
        return;
    }

    public void remove(Book b) {
        remove(indexOf(b));
    }

    public void clear() {
        if (books.size() > 0) {
            int size = books.size();
            books.clear();
            this.fireTableRowsDeleted(0, size - 1);
        }
    }

    public void sortByTitle() {
        if (books.size() > 1) {
            Collections.sort(books, new BookTitleComparator());
            this.fireTableRowsUpdated(0, books.size() - 1);
        }
    }

    public void sortByPrice() {
        if (books.size() > 1) {
            Collections.sort(books, new BookPriceComparator());
            this.fireTableRowsUpdated(0, books.size() - 1);
        }
    }

    public boolean saveAsXML(String filename) {
        if (filename.equals("")) {
            return false;
        }

        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
            
            StringBuilder sb = new StringBuilder();
            sb.append("<?xml version=\"1.0\"?>\n");
            sb.append("<books>\n");
            for (int i = 0; i < books.size(); i++) {
                sb.append("<book>\n");
                sb.append("<title>" + books.get(i).getTitle() + "</title>\n");
                sb.append("<authors>" + books.get(i).getAuthors() + "</authors>\n");
                sb.append("<publisher>" + books.get(i).getPublisher() + "</publisher>\n");
                sb.append("<year>" + books.get(i).getYear() + "</year>\n");
                sb.append("<price>" + books.get(i).getPrice() + "</price>\n");
                sb.append("<isbn>" + books.get(i).getIsbn() + "</isbn>\n");
                sb.append("</book>\n");
            }
            sb.append("</books>\n");
            
            out.print(sb.toString());
            out.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

}
