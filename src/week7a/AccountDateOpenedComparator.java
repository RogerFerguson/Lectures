package week7a;
import java.util.Comparator;


public class AccountDateOpenedComparator implements Comparator<Account> {

    public int compare(Account act1, Account act2) {
        return act1.getDateOpened().compareTo(act2.getDateOpened());
    }
    
}
