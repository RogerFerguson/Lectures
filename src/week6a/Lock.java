package week6a;

/**
 * Write a description of class Lock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lock
{
    /** what the user enters */
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
    
    public Lock (String pActualCode) {
//    	for (int i = 0; i < pActualCode.length(); i++)
//    		if (!(pActualCode.charAt(i) >= '0' 
//				    	&& pActualCode.charAt(i) <= '9'))
//    			throw (new IllegalArgumentException());

    	if (!pActualCode.matches("[0-9]*"))
    		throw (new IllegalArgumentException());

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
        return correctCode.equals(l.correctCode);
    	
    }
    
    public boolean equals (Object l) {
        return correctCode.equals(((Lock) l).correctCode);
    	
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

    

