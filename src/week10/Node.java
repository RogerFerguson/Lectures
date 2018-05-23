package week10;

public class Node<E>  {
		private E data;
		private Node next;
		
		public Node(E s, Node next) {
			super();
			this.data = s;
			this.next = next;
		}
		
		public Node() {	
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
