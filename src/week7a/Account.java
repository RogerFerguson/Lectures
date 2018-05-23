package week7a;
import java.io.Serializable;


public abstract class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int number;
	private String owner;
	private java.util.GregorianCalendar dateOpened;
	private double balance;
	
	public Account(int number, String owner, java.util.GregorianCalendar dateOpened, double balance) {
		this.number = number;
		this.owner = owner;
		this.dateOpened = dateOpened;
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getNumber() {
		return number;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public java.util.GregorianCalendar getDateOpened() {
		return dateOpened;
	}
	
	public boolean equals(Object other) {
		if (other instanceof Account) {
			Account act = (Account) other;
			return this.number == act.number && this.owner.equals(act.owner)
					&& this.dateOpened.equals(act.dateOpened)
					&& this.balance == act.balance;
		}
		
		return false;
	}
	
	public String toString() {
		return number + " " + owner + " " + dateOpened + " " + balance;
	}

}
