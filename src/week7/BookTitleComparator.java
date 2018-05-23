package week7;
import java.util.*;

/**
 * @author Nandigam
 */
public class BookTitleComparator implements Comparator<Book> {

    public int compare(Book b1, Book b2) {
        return b1.getTitle().compareTo(b2.getTitle());
    }
    
}
