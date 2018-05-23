package week7;

import java.text.NumberFormat;

/**
 * @author Nandigam
 */
public class Book {

    private String title;
    private String authors; // comma-separated list of authors
    private String publisher;
    private int year;
    private double price;
    private String isbn;

    public Book(String title, String authors, String publisher, int year, double price, String isbn) {
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.year = year;
        this.price = price;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthors() {
        return authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
    	return getTitle() + "; Price: " + NumberFormat.getCurrencyInstance().format(price);
    }
}
