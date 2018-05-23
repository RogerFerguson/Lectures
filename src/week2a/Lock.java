package week2a;

/**********************************************************************
 * Write a description of class Lock here. 
 * 
 * @author Ferguson
 * @version 1.0
 ********************************************************************/
public class Lock
{
	/** What the user enters */
	private String userEnteredCode;

	/** Whatever I write will appear in eclipse later on. */
	private String correctCode;
	
	private static String masterCode;
	
	
	public static String getMasterCode() {
		return masterCode;
	}

	public static void setMasterCode(String masterCode) {
		Lock.masterCode = masterCode;
	}

	/*****************************************************************
	 * 
	 * This is a constructor that is used to create a default 
	 * constructor
	 * 
	 ****************************************************************/
	public Lock () {
		this.correctCode = "123";
	}

	public Lock (String correctCode) {
		if (correctCode.length() == 0)
			throw new IllegalArgumentException();
		
		this.correctCode = correctCode;
	} 

	public Lock (Lock other) {
		this.correctCode = other.correctCode;
		this.userEnteredCode = other.userEnteredCode;	
	}
	
	
	public boolean equals (Lock lock) {
        return this.correctCode.equals(lock.correctCode);
	}
	
	
	public boolean equals (Object lock) {
		Lock other = (Lock) lock;
        return this.correctCode.equals(other.correctCode);
	}
	
	
	public static boolean equals (Lock l1, Lock l2) {
		//

        return l1.correctCode.equals(l2.correctCode);
	}
		
		
	public void enterCode (String pCode) {
		this.userEnteredCode = pCode;
	}
	
//	public boolean isUnlock() {
//		if ((correctCode.equals (userEnteredCode))  || 
//		   (userEnteredCode.equals(masterCode)) )
//				return true;
//		else
//			return false;
//	}
	
	public OpenStatus isUnlock() {
		if (correctCode.equals (userEnteredCode))  
				return OpenStatus.OpenWithNormalCode;
		
		if (userEnteredCode.equals(masterCode))
				return OpenStatus.OpenWithMasterCode;
		else
			return OpenStatus.Locked;
	}
}



