package week9;

import java.util.List;

public class MyLinkedList <E> {
	private Node<E> top; 
	private Node<E> tail;

	// Needs to be fixed, tail problems
	public void addEnd(E string) {
		// case 0; no list
		if (top == null) 
			top = new Node (string, null);

		else {
			// case 1, multi items in the list
			Node<E> temp = top;
			while (temp.getNext() != null) 
				temp = temp.getNext();

			Node<E> temp2 = new Node(string, null);
			temp.setNext(temp2);
		}
	}

	// Needs to be fixed, tail problems
	public void addFirst(E string) {

		// not list
		if (top  == null) 
			top = tail = new Node<E> (string, top);
		else
			// one item in the list
			if (top == tail) {
				top = new Node<E> (string, top);
			}
	}


	// Needs to be fixed, tail problems
	private boolean remove(E string) {
		Node<E> temp;

		// case 0, no list
		if (top == null)
			return false;

		// case 1, found at the top position
		if (top.getData().equals(string)) {
			top = top.getNext();
			return true;
		}

		temp = top;
		while (temp != null) {
			if (temp.getData().equals(string)) {
				temp.setNext(temp.getNext().getNext());
				return true;
			}
			temp = temp.getNext();
		}

		return false;
	}


	public MyLinkedList() {
		top = null;
		tail = null;
	}

	public static void main (String[] args){
		MyLinkedList<String> list = new MyLinkedList<String>();

		list.addEnd("1");
		list.addEnd("2");
		list.addEnd("3");

		list.remove("2");
		list.remove("1");
		list.remove("8");
		//		list.remove("3");

		list.display();
	}


	public void display() {
		Node temp = top;
		System.out.println ("___________________________________");
		//						System.out.println (temp.getData());	
		//						temp = temp.getNext();
		//						System.out.println (temp.getData());	
		//						temp = temp.getNext();
		//						System.out.println (temp.getData());	
		//						temp = temp.getNext();
		//						System.out.println (temp.getData());	

		while (temp != null) {
			System.out.println (temp.getData());
			temp = temp.getNext();
		}
	}
}
