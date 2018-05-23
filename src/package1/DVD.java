package package1;

import java.io.Serializable;
import java.util.GregorianCalendar;

/*****************************************************************
 * 
 * Maintains the DVD class and initiates new DVDs
 * 
 *****************************************************************/
public class DVD implements Serializable{
	private static final long serialVersionUID = 1L;

	/** The date the DVD was rented */
	protected GregorianCalendar bought;

	/** The date the DVD is due back */
	protected GregorianCalendar dueBack;

	/** The title of the DVD */
	protected String title;

	/** The name of the person who is renting the DVD */
	protected String nameOfRenter; 

	/*****************************************************************
	 * 
	 * A constructor that initiates a new DVD
	 * 
	 *****************************************************************/
	public DVD(){
		super();
		this.nameOfRenter = nameOfRenter;
		this.title = title;
		this.bought = bought;
		this.dueBack = dueBack;
	}
	
	/*****************************************************************
	 * 
	 * Returns the title for the DVD
	 * 
	 * @return - string of the title
	 *****************************************************************/
	public String getTitle(){
		return title;
	}
	
	/*****************************************************************
	 * 
	 * Returns the name of the renter for the DVD
	 * 
	 * @return - string of the name of the renter
	 *****************************************************************/
	public String getRenter(){
		return nameOfRenter;
	}
	
	/*****************************************************************
	 * 
	 * Returns the date that it was rented
	 * 
	 * @return - GregorianCalender of date
	 *****************************************************************/
	public GregorianCalendar getBought(){
		return bought;
	}
	
	/*****************************************************************
	 * 
	 * Returns the date that it is due
	 * 
	 * @return - GregorianCalender of date
	 *****************************************************************/
	public GregorianCalendar getDueBack(){
		return dueBack;
	}
	
	/*****************************************************************
	 * 
	 * Sets the cost for the DVD
	 * 
	 *****************************************************************/
	public void setCost(){

	}
}
