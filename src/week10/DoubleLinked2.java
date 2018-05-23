package week10;

public class DoubleLinked2
{
	private DNode top; 

	public DoubleLinked2() {
		top = null;

	}

	public void insertBefore (DNode curr, String s) {
		
		// no list
		if (top == null && curr == null) {
			top = new DNode (s, null, null);
			return;
		}

		// curr == top
		if (curr == top) {
			top  = new DNode (s, top, null);
			top.getNext().setPrev(top);
			return;
		}

		// 
		if (curr != null) {
			curr.setPrev(new DNode (s, curr, curr.getPrev()));
			curr.getPrev().getPrev().setNext(curr.getPrev());
			return;
		}

      throw new IllegalArgumentException();
      



	}

	public void insertAfter (DNode curr, String s) {

	}

	public boolean Delete (DNode curr) {
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