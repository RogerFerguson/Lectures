package week10;

public class LinkedListFirstb<E> {
	private Nodeb<E> top; 
	private Nodeb<E> tail;

	public LinkedListFirstb() {
		top = null;
		tail = null;
	}

	public void addAtTop (E s) {
		Nodeb<E> temp;
		temp = new Nodeb<E>(s, top);
		if (top == null)
			tail = temp;

		top = temp;
	}

	public void display () {
		Nodeb<E> temp = top;
		while (temp != null) {
			System.out.println (temp.data);
			temp = temp.next;
		}
	}

	public void addAtEnd(E s) {
		Nodeb<E> temp = new Nodeb<E> (s, null);

		if (top == null) 
			top = tail = temp;
		else {
			tail.next = temp;
			tail = temp;
		}

	}

	public static void main (String[] args){
		LinkedListFirstb<String> list = new LinkedListFirstb<String>();

		list.addAtTop("pizza");
		list.addAtTop("donuts");
		list.addAtTop("chocolate");

		//		list.display();

		list.addAtEnd("endCheese");
		//		list.display();

		list.display();

	}
}
