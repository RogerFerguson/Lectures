package week12;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class StackBK<E> {

	final static int STACKSIZE = 100;
	E[] stack;
	int top;
	
	public StackBK () {
		top = 0;
//		stack = new E[STACKSIZE];
	}
	
	public void push (E data) {	
		stack[top++] = data;
	}

	public E pop () {
		return stack[--top];
	}
	
	public boolean empty () {
		
		return top == 0;
	}

	
	public int peek () {
		return 0; //stack[top];
	}

	public static void main (String[] args) {
		StackBK s1 = new StackBK();
		s1.push(5);
		s1.push(7);
		System.out.println (s1.pop());
		System.out.println (s1.pop());
		
	}
}





