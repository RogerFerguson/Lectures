package week9;

public class LinkListTail<E> {
//	private Node<E> top;
//	private Node<E> tail;
//
//	public LinkListTail() {
//		top = null;
//		tail = null;
//	}
//
//	public void addfirst (E data) {
//		if (top == null)
//			tail = top = new Node<E>(data, top);
//		else
//			top = new Node<E>(data, top);
//	}
//
//	public void addToEnd (E data) {
//		if (top == null) 
//			tail = top = new Node<E>(data, top);
//		else {
//			tail.setNext(new Node<E>(data, null));
//			tail = tail.getNext();
//		}
//
//	}
//
//
//
//	public void display() {
//		Node<E> temp = top;
//		int lineNumber = 0;
//
//		while (temp != null) {
//			System.out.println (lineNumber++ + ": " + temp.getData());
//			temp = temp.getNext();
//		}
//	}
//
//	public int count() {
//
//		return 0;
//	}
//
//	public boolean delete (String data) {
//
//		if (top == null) 
//			return false;
//
//		if (top.getData().equals(data) && top == tail) {
//			top = tail = null;
//			return true;
//		}
//
//		if (top.getData().equals(data)) {
//			top = top.getNext();
//			return true;
//		}
//
//		Node<E> temp = top;
//		while (temp.getNext() != null) {
//
//			if (temp.getNext().getData().equals(data)) {
//				temp.setNext(temp.getNext().getNext());
//				if (temp.getNext() == null)
//					tail = temp;
//				return true;
//			}
//
//			temp = temp.getNext();
//
//		}
//
//		return false;
//	}
//
//	public static void main (String[] args){
//		LinkListTail<String> list = new LinkListTail<String>();
//
//		list.addfirst("pizza1");
//		list.addfirst("pizza2");
//		list.addfirst("pizza3");
//		list.addToEnd("pizza4");	
//
//		list.delete ("pizza2");
//		list.display();
//	}


}
