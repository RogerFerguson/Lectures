package week6;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class SportsCar extends Auto {
	
	private static final long serialVersionUID = 1L;
	
	private boolean turboCharged;
	
	public SportsCar() {
		super();
	}

	public SportsCar(GregorianCalendar bought, double cost,
			String owner, boolean turboCharged) {
		super(bought, cost, owner);
		this.turboCharged = turboCharged;
	}

	public boolean isTurboCharged() {
		return turboCharged;
	}

	public void setTurboCharged(boolean turboCharged) {
		this.turboCharged = turboCharged;
	}
	
	
	

}
