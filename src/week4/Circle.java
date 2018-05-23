package week4;


public class Circle extends Shape
{
	protected int radius;

	public Circle(int pRadius)
	{
		radius = pRadius;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}

	public double getArea() {
		return 3.14159 * radius * radius;
	}


	
}

