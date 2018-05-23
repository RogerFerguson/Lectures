package week6;

import java.io.*;
import java.util.*;

public abstract class Auto implements Serializable {
	protected GregorianCalendar bought;
	protected double cost;
	protected String name;
	
	public Auto() {
	}
	
	public Auto(GregorianCalendar bought, double cost, String name) {
		super();
		this.bought = bought;
		this.cost = cost;
		this.name = name;
	}
	
	public GregorianCalendar getBought() {
		return bought;
	}
	public void setBought(GregorianCalendar opened) {
		this.bought = opened;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
