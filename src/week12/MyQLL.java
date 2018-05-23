package week12;

public class MyQLL<E> {
	Node<E> front;
	Node<E> back;

	public MyQLL () {
		front = null;	
	}

	public void enQ (E item){
		if (front == null) {
			front = new Node<E>(item, front); 
		}
		else {

			Node<E> temp;

			temp = front;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}

			Node<E> last = new Node<E>(item, null);
			temp.setNext(last);
		}


	}
	public E deQ() {
		if (front == null)
			throw new RuntimeException();
		
		E temp = front.getData();
		front = front.getNext();
		return temp;

	}

	public static void main (String[] args) {
		MyQLL<Integer> q = new MyQLL<Integer>();
		q.enQ(10);
		q.enQ(20);
		q.enQ(30);

		System.out.println(q.deQ());
		System.out.println(q.deQ());
		System.out.println(q.deQ());

		q.enQ(40);
		q.enQ(50);  // full?
		q.enQ(60);
		q.enQ(70);
		q.enQ(80);  // full?

		System.out.println(q);

	}

}
