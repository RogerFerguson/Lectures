package week10;


public class Nodea<E> {
		private E data;
		private Nodea<E> next;

		public Nodea(E data, Nodea next) {
			super();
			this.data = data;
			this.next = next;
		}
		
		public Nodea () {
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
