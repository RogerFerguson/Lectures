package week7a;
import java.util.*;

/**
 * @author Nandigam
 */
public class AccountOwnerComparator implements Comparator<Account> {

    public int compare(Account act1, Account act2) {
        return act1.getOwner().compareTo(act2.getOwner());
    }
    
}
