package week9;


public class StackVer2 {

	private int top = 0; 
	private int[] sArray = new int[100];

	public void push (int data) {
		sArray[top++] = data;
	}

	public int pop () {
		return sArray[--top];
	}


	public static void main (String[] args) {

		StackVer2 s1 = new StackVer2();

		s1.push(10);
		s1.push(20);
		System.out.println (s1.pop());

	}
}





