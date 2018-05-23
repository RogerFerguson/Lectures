package week12;

public class SNode {
		public String data;
		public SNode next;
		
		public SNode(String data, SNode next) {
			super();
			this.data = data;
			this.next = next;
		}

		public SNode() {
			super();
		}

		public String getData() {
			return data;
		}
		
		public void setData(String data2) {
			this.data = data2;
		}
		
		public SNode getNext() {
			return next;
		}
		public void setNext(SNode next) {
			this.next = next;
		}
}
