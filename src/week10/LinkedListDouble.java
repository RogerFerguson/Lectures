package week10;

public class LinkedListDouble {
	private DNode top; 

	public LinkedListDouble() {
		top = null;

	}

	public void insertBefore (DNode curr, String s) {
		// at the top of the list
		if (curr == top) {
			top = new DNode(s, top, null);
			top.getNext().setPrev(top);
		}

		// case in the middle
		else {
			curr.setPrev(new DNode(s, curr, curr.getPrev()));
			curr.getPrev().getPrev().setNext(curr.getPrev());
		}



	}

	public void insertAfter (DNode curr, String s) {
		if (top == null)
			top = new DNode (s, null, null);
		else if (curr == null) 
			throw new IllegalArgumentException();
		else
		{
			DNode temp = new DNode (s, curr.getNext(), curr);
			curr.getNext().setPrev(temp);
			curr.setNext(temp);
			
			
			
		}
		
	}




	

	public boolean Delete (DNode curr) {
		
		if (top == null)
			return false;
		
		if (curr == null)
			throw new IllegalArgumentException();

		if (top == curr) {
		    top = top.getNext();
		    top.setPrev(null);
		    return true;
		}
		
		curr.getNext().setPrev(curr.getPrev());
		curr.getPrev().setNext(curr.getNext());
		
		return true;
	}
	
	
	
	public void addAtTop (String s) {
		if (top == null) 
			top = new DNode (s, null, null);
		else {
			top = new DNode (s, top, null);
			top.getNext().setPrev(top);
		}

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
		DNode temp = top;

		while (temp.getNext() != null)
			temp = temp.getNext();

		temp.setNext(new DNode(s, null, temp));

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
		LinkedListDouble list = new LinkedListDouble();

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
