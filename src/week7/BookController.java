package week7;
import java.util.Random;

/**
 * @author Nandigam
 */

// Modified by Dulimarta to add random content
public class BookController {
    
    private BookModel model;
    private Random rand;
    
    public BookController() {
        model = new BookModel();
        rand = new Random();
    }
    
    public BookModel getModel() {
        return model;
    }
    
    public void addBook(String title, String authors, String publisher,
            int year, double price, String isbn) {
        Book b = new Book(title, authors, publisher, year, price, isbn);
        model.add(b);
    }
    
    public void deleteBook(int pos) {
        model.remove(model.get(pos));
    }
    
    public void sortByTitle() {
        model.sortByTitle();
    }
    
    public void sortByPrice() {
        model.sortByPrice();
    }
    
    public boolean saveAsXML(String filename) {
        return model.saveAsXML(filename);
    }
    
    public void addRandomBooks(int numBooks) {
        for (int k = 0; k < numBooks; k++) {
            addBook (randomTitle(), randomAuthor(), randomPublisher(),
                    rand.nextInt(30) + 1981,
                    60 + rand.nextDouble()*40,
                    randomISBN());
        }
    }
    
    private String randomTitle() {
        /* randomize number of words in title */
        int numwords = rand.nextInt(4) + 5;
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < numwords; k++) {
            int n = rand.nextInt(WORDS.length);
            sb.append(WORDS[n] + " ");
        }
        return sb.toString();
    }
    
    private String randomPublisher() {
        return PUBLISHERS[rand.nextInt(PUBLISHERS.length)];
    }
    
    private String randomAuthor() {
        int n1, n2;
        n1 = rand.nextInt(FIRSTNAMES.length);
        n2 = rand.nextInt(LASTNAMES.length);
        return FIRSTNAMES[n1] + " " + LASTNAMES[n2];
    }
    
    private String randomISBN() {
        return String.format("1-%03d-%05d-%d", rand.nextInt(1000),
                rand.nextInt(100000), rand.nextInt(10));
    }
    
    /* constant array of strings for randomizer */
    private static final String WORDS[] = { "Java", "Web", "Efficient",
            "Super", "Explore", "Guide", "Quick", "C++", "Network", "Socket",
            "Algorithm", "Days", "Mastering", "in", "by", "Definite",
            "Graphics", "iOS", "Linux", "Programming", "HTML", "Android",
            "Eclipse", "Design", "Analysis", "Operating System", "Database",
            "Development", "Key", "Python", "Introduction", "Problem Solving",
            "Ruby", "OpenGL", "UBuntu"};
    
    private static final String LASTNAMES[] = {"Ferguson", "Dulimarta", 
        "Jobs", "Page", "Dulimarta", "Johnson", "Stark", "Anderson", "Taylor"};
    
    private static final String FIRSTNAMES[] = {"Alice", "Ron", "Dan", "Linda",
        "Eva", "Doug", "Ken", "Rachel", "Beth", "Diane", "Jim", "Bob"
    };
    
    private static final String PUBLISHERS[] = { "Morgan Kaufmann",
            "John Wiley", "Bantam", "Addison Wesley", "Safari", "Pearson Ed", 
            "McGraw-Hill" };
}
