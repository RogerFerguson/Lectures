package week12;

import java.util.Arrays;

public class Qarray {

    private int [] q;
    private int front;
    private int back;
    private int size;
    
	public Qarray() {
	 q = new int[5];	
	 front = 0; back = 0;
	 size = 0;
	}

	public int deQ() {
           int temp = q[front = (front + 1) % q.length];
           size--;
           return temp;
			}

	public void enQ (int data) {
         q[back = (back + 1) % q.length] = data;
         size++;
	}

	@Override
	public String toString() {
		return "Qarray{" +
				"q=" + Arrays.toString(q) +
				", front=" + front +
				", back=" + back +
				", size=" + size +
				'}';
	}

	public static void main (String[] args) {
		Qarray q = new Qarray();
		q.enQ(10);
		q.enQ(20);
		q.enQ(30);

		System.out.println(q.deQ());
		System.out.println(q.deQ());
		System.out.println(q.deQ());
		
		q.enQ(40);
		q.enQ(50);  // full?
		q.enQ(60);
		q.enQ(70);
		q.enQ(80);  // full?

		System.out.println(q);

	}

}


