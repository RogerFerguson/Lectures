package week9;


public class Nodea<E> {
		public E data;
		public Nodea next;
		
		public Nodea(E data, Nodea next) {
			super();
			this.data = data;
			this.next = next;
		}

		public Nodea() {
			super();
		}

		public E getData() {
			return data;
		}
		
		public void setData(E data) {
			this.data = data;
		}
		public Nodea getNext() {
			return next;
		}
		public void setNext(Nodea next) {
			this.next = next;
		}
}
