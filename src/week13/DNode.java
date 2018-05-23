package week13;

public class DNode {

		public String data;
		public DNode next;
		public DNode prev;
		
		public DNode getPrev() {
			return prev;
		}

		public void setPrev(DNode prev) {
			this.prev = prev;
		}
		
		public DNode(String data, DNode next, DNode prev) {
			super();
			this.data = data;
			this.next = next;
			this.prev = prev;
		}

		public DNode(String data, DNode next) {
			super();
			this.data = data;
			this.next = next;
		}

		public DNode() {
			super();
		}

		public DNode(String s) {
			this.data = s;	// TODO Auto-generated constructor stub
		}

		public String getData() {
			return data;
		}
		
		public void setData(String data2) {
			this.data = data2;
		}
		
		public DNode getNext() {
			return next;
		}
		public void setNext(DNode next) {
			this.next = next;
		}
}


