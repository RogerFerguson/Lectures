package week4;

public abstract class Triangle extends Shape {

	private double base, height;

	@Override
	public double getArea() {
		
		return .5 * base * height;
	}
	

	
}
