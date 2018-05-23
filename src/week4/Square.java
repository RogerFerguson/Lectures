package week4;

public class Square extends Shape
{
	protected int length;
	public Square(int pLength)
	{
		length = pLength;
	}
	
	
	public double getArea()
	{
		return length * length;
	}
	
	public static void main (String[] args) {
		
		Square sq = new Square(20);
		Shape sh = sq;
	}
}

