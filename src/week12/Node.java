package week12;


public class Node<E> {
		public E data;
		public Node next;
		
		public Node(E data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}

		public Node() {
			super();
		}

		public E getData() {
			return data;
		}
		
		public void setData(E data) {
			this.data = data;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
}
