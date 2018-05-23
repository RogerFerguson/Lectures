package package1;

import java.util.GregorianCalendar;

/*****************************************************************
 * 
 * Maintains the game rental portion of the red box program
 * 
 *****************************************************************/
public class Game extends DVD{
	
	/** The date the DVD was rented */
	protected GregorianCalendar bought;

	/** The date the DVD is due back */
	protected GregorianCalendar dueBack;

	/** The title of the DVD */
	protected String title;

	/** The name of the person who is renting the DVD */
	protected String nameOfRenter; 
	
	/** Represents the type of player */
    private String player;   // Xbox 360, PS3, Xbox720.
    
    /*****************************************************************
	 * 
	 * A constructor initiates a new game to be rented
	 * 
	 *****************************************************************/
    public Game(){
    	super();
		this.nameOfRenter = nameOfRenter;
		this.title = title;
		this.bought = bought;
		this.dueBack = dueBack;
		this.player = player;
    }
    
    /*****************************************************************
	 * 
	 * Returns the title for the Game
	 * 
	 * @return - string of the title
	 *****************************************************************/
	public String getTitle(){
		return title;
	}
	
	/*****************************************************************
	 * 
	 * Returns the name of the renter for the Game
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
	 * Returns the platform that the game is played on
	 * 
	 * @return - String of platform
	 *****************************************************************/
	public String getPlatform(){
		return player;
	}
	
	/*****************************************************************
	 * 
	 * Sets the cost for the DVD
	 * 
	 *****************************************************************/
	public void setCost(){

	}
	
}
