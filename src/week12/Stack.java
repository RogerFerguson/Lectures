package week12;

public class Stack {
	private int[] stack;
	private int top;

	public Stack (int size) {
        top = 0;
        stack = new int[size];
	}

	public void push (int data) {
	    stack[top++] = data;
		}

	public int pop () {
        return stack[--top];
	}

	public boolean empty() {
        return top == 0;
	}

	public static void main (String[] args) {

		Stack s1 = new Stack(100);
		s1.push(10);
		s1.push(20);
		s1.push(30);
		System.out.println (s1.pop());
		s1.push(40);
		System.out.println (s1.pop());
	}
}





