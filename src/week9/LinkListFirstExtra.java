package week9;

public class LinkListFirstExtra {
	

	//	
	//	
	//	public void addfirst (E data) {
	//		if (top == null) 
	//			tail = top = new Node (data, top);
	//		else {
	//			top = new Node (data, top);
	//		}
	////		Node<E> temp = new Node<E>();
	////		temp.setData(data);
	////		temp.setNext(top);
	////		top = temp;
	////
	////		//top = new Node (data, top);
	//
	//		
	//	}
	//
	//	public void display() {
	//		//				System.out.println (top.getData());
	//		//				System.out.println (top.getNext().getData());
	//		//				System.out.println (top.getNext().getNext().getData());
	//		// System.out.println (top.getNext().getNext().getNext().getData());
	//
	//		Node<E> temp = top;
	//		while (temp != null) {
	//			System.out.println (temp.getData());
	//			temp = temp.getNext();
	//
	//		}
	//	}
	//
//		public int count() {
//			int count = 0;
//	
//			Node temp = top;
//			while (temp != null) {
//				count++;
//				temp = temp.getNext();
//			}
//			return count;
//		}
	//
	//	public void addAtEnd (E data) {
	//		if (top == null)
	//			tail = top = new Node <E> (data, top);
	//		else {
	//			tail.setNext(new Node<E>(data, null));
	//			tail = tail.getNext();
	//			
	////			Node <E>temp = top;
	////			while (temp.getNext() != null) {
	////				temp = temp.getNext();
	////			}
	////
	////			temp.setNext(new Node (data, null));
	//		}
	//	} 
	//
	
//		public boolean delete (int index) {
//		
//			if (top == null)
//				return false;
//			
//			if (index > count() || index < 0) 
//				return false;
//	
//			Node temp = top;
//			for (int i = 0; i < index -1; i++)
//				temp = temp.getNext();
//			
//			temp.setNext(temp.getNext().getNext());
//			return true;
//			
//		
//		}
		
		
//		public boolean delete (String data) {
//			if (top == null)
//				return false;
//	
//			if (top.getData().equals(data)) {
//				top = top.getNext();
//				return true;
//			}
//	
//			Node temp = top;
//			while (temp != null) {
//				if (temp.getNext().getData().equals(data)) {
//					temp.setNext(temp.getNext().getNext());
//					return true;
//				}
//				temp = temp.getNext();
//			}
//	
//	
//			return false;
//		}
	//
	//	public void deleteAll(String data) {
	//		while (delete (data));
	//	}


//	public static void main (String[] args){
//		LinkListFirst<String> list = new LinkListFirst<String>();
//		LinkListFirst<Integer> list2 = new LinkListFirst<Integer>();



		//		list.addAtEnd("pizza2");
		//		list.addfirst("pizza2");
		//		list.addfirst("pizza2");
		//		list.addfirst("pizza2");
		//		list.addfirst("pizza2");
		//
		//		list.display();
		//
		//		list.delete("pizza1");
		//		list.display();
		//
		//	list.deleteAll("pizza2");
		//		list.display();


		//		list.addAtEnd("pizza11");

		//		list.addfirst("pizza3");
		//		list.addfirst("pizza4");
		//		list.addfirst("pizza5");
		//		list.addfirst("pizza6");
		//		list.addfirst("pizza7");
		//		list.addfirst("pizza8");
		//		list.addAtEnd("pizza9");

		//	list.display();

	//}




}
