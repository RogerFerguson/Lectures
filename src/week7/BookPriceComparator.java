package week7;
import java.util.*;

/**
 * @author Nandigam
 */
public class BookPriceComparator implements Comparator<Book> {

    public int compare(Book b1, Book b2) {
    	Double price1 = b1.getPrice();
    	Double price2 = b2.getPrice();
        return price1.compareTo(price2);
    }
    
}
