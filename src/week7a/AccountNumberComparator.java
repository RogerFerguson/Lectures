package week7a;
import java.util.*;

/**
 * @author Nandigam
 */
public class AccountNumberComparator implements Comparator<Account> {
	
	ArrayList<Class> i = new ArrayList<Class>();
	
    public int compare(Account act1, Account act2) {
        return act1.getNumber() - act2.getNumber();
    }
    
}
