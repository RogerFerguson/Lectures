package week9;
public class TNode {
		private String data;
		private TNode left;
		private TNode right;

		public TNode(String data, TNode next, TNode prev) {
			super();
			this.data = data;
			this.left = next;
			this.right = prev;
		}

		public TNode() {
			super();
		}

		public String getData() {
			return data;
		}
		
		public void setData(String data) {
			this.data = data;
		}
		public TNode getNext() {
			return left;
		}
		public void setNext(TNode next) {
			this.left = next;
		}

		public TNode getPrev() {
			return right;
		}

		public void setPrev(TNode prev) {
			this.right = prev;
		}
		
		
}
