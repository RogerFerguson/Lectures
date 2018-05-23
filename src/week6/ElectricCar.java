package week6;

import java.util.GregorianCalendar;

public class ElectricCar extends Auto {
	
	private int voltage;

	public ElectricCar() {
		super();
	}

	public ElectricCar(GregorianCalendar bought, double cost, String owner, int voltage) {
		super(bought, cost, owner);
		this.voltage = voltage;
	}

	public int getVoltage() {
		return voltage;
	}

	public void setVoltage(int voltage) {
		this.voltage = voltage;
	}
	
	
	

}
