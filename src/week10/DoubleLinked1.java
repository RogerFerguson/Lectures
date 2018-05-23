package week10;

import java.util.ArrayList;

public class DoubleLinked1 {
	private DNode top; 

	public DoubleLinked1() {
		top = null;

	}

	public void insertBefore (DNode curr, String s) {
//		curr.getPrev().setNext(new DNode(s, curr, curr.getPrev()););
//		curr.setPrev(temp);

	}

	public void insertAfter (DNode curr, String s) {

	}


	public boolean Delete (DNode curr) {
		curr.getPrev().setNext(curr.getNext());
		curr.getNext().setPrev(curr.getPrev());
		return false;
	}

	public void addAtTop (String s) {

	}

	void displayBackwards () {
		DNode temp = top;
		while (temp.getNext() != null)
			temp = temp.getNext();

		while (temp != null) {
			System.out.println (temp.getData());
			temp = temp.getPrev();
		}
	}

	public void addAtEnd(String s) {
	}

	public boolean delete (String s) {
		return false;
	}

	public static void main (String[] args){
		LinkedListDouble list = new LinkedListDouble();

		list.addAtTop("pizza");
		list.addAtTop("donuts");
		list.addAtTop("chocolate");

		//		list.display();

		list.addAtEnd("endCheese");
		//list.display();

		System.out.println (list.delete ("Cheese"));
		list.displayBackwards();

	}
}