package week10;

public class LinkedListDouble2 {
	private DNode top; 

	public LinkedListDouble2() {
		top = null;
	}

	public void insertBefore (DNode curr, String s) {
				
	}

	public void insertAfter (DNode curr, String s) {
	
	}

	public boolean Delete (DNode curr) {
		
		return true;
	}
		
	public void addAtTop (String s) {
	
	}


	public void displayBackwards () {

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
		if (top == null)
			return false;

		if (top.getData().equals(s)) {
			top = top.getNext();
			if (top != null)
				top.setPrev(null);
			return true;
		}

		DNode temp = top;
		while (temp != null) {
			if (temp.getData().equals(s)) {
				temp.getPrev().setNext(temp.getNext());
				if (temp.getNext() != null)
					temp.getNext().setPrev(temp.getPrev());
				return true;
			}
			temp = temp.getNext();
		}

		return false;
	}

	public static void main (String[] args){
		LinkedListDouble2 list = new LinkedListDouble2();

		list.addAtTop("pizza");
		list.addAtTop("donuts");
		list.addAtTop("chocolate");

		//		list.display();

		list.addAtEnd("endCheese");
		//list.display();

		System.out.println (list.delete ("endasdfasdfCheese"));
		list.displayBackwards();

	}
}
