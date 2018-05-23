package week2;

/******************************************************************
 * Write a description of class Lock here. The class lock is 
 * a class that demos a typical lock.
 * 
 * @author (I am who I am) 
 * @version (I do not like to write comments!!!)
 ******************************************************************/
public class Lock
{
    /** what the user enters I hate writing comments */
    private String userEnteredCode;

    /** what the correct code will be */
    private String correctCode;
    
    private static String masterCode;
    
    public static String getMasterCode() {    	
    	return masterCode;
	}

	public static void setMasterCode(String masterCode) {
		Lock.masterCode = masterCode;
	}

	public Lock () {
        correctCode = "123";
        masterCode = "000";
        userEnteredCode = "";
    }
    
	/*********************************************************************
	 * This constructor accepts a parameter and that parameter is used 
	 * for the correctCode.  I still do not like to write commennts.
	 * 
	 * @param pActualCode The correct code for the lock to open!
	 */
	
	
    public Lock (String pActualCode) {
        correctCode = pActualCode;
        masterCode = "000";
        userEnteredCode = "";
    }  
    
    public Lock (String pActualCode, String ms) {
		Lock.masterCode = ms;
        correctCode = pActualCode;
        userEnteredCode = "";
    }  
    
    public boolean equals (Lock l) {
    	// this is a comment. 
        return correctCode.equals(l.correctCode);
    	
    }

    public void enterCode (String pCode) {
        userEnteredCode = pCode;
    }

    public boolean isUnlock() {
        return (correctCode.equals(userEnteredCode)) ||
                (masterCode.equals(userEnteredCode));
    }

    public boolean reset () {
        userEnteredCode = "";
        return true;

    }

        
        
}

    

