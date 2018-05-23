package week9;


public class LinkListFirst<E> {
	private Node<E> top; 
	
	public boolean remove (String data) {
		
		if (top == null)       // no list
			return false;
		
		if (top.getData().equals(data)) {    // found at top position
			top = top.getNext();
			return true;
		}
		
		Node temp = top;
		while (temp != null)
			if (temp.getNext().getData().equals(data)) {
				temp.setNext(temp.getNext().getNext());
				return true;
			}
		
		return false;
	}
	
	public void addfirst (String data) {
		
		
		
	}
	
	public void display() {
		Node temp = top;
		
//		System.out.println (temp.getData());
//		temp = temp.getNext();
//		System.out.println (temp.getData());	
		
		while (temp != null) {
			System.out.println (temp.getData());
			temp = temp.getNext();
		}
	}
	
	public static void main (String[] args){
		LinkListFirst<String> list = new LinkListFirst<String>();
		

		list.addfirst("pizza1");
		list.addfirst("pizza2");
		list.addfirst("pizza3");
		list.addfirst("pizza4");
		list.addfirst("pizza5");
		list.addfirst("pizza6");
		list.addfirst("pizza7");
		list.addfirst("pizza8");
		
		list.display();
	}
	
}