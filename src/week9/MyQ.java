package week9;

public class MyQ {
	
	private int[] Q;
	private int front = 0;
	private int back = 0;
	private final int SIZE = 100;
	private int count = 0;
	
	public MyQ () {
		Q = new int[SIZE];	
	}
	
	public void enQ (int item){
		Q[back] = item;
		back = (back + 1) % SIZE;
		count++;
	}
	
	public int deQ() {
		int data = Q[front];
		front = (front + 1) % SIZE;
		return data;
	}
	
	
}
