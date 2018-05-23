package week12;


public class Q <E> {

	private Node<E> front;
	private Node<E> back;

	public Q() {
		front = null;
		back = null;
	}

	public E deQ() {

		if (front == null)
			throw new RuntimeException();
		
		E temp = front.getData();
		front = front.getNext();
		return temp;
	}

	public void enQ (E data) {

		// no list... 
		if (front == null) {
			front = back  = new Node<E>(data, null);
			return;
		}
		
		// list exist, adding at the end.
		back.setNext(new Node<E>(data, null));
		back = back.getNext();

	}

	public int size () {
		return 0;
	}

}
