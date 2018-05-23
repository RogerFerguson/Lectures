//package week9;
//
//public class LinkListLab {
//	private Node top; 
//	
//	public LinkListLab() {
//		top = null;
//	}
//	
//	/****************************************************************
//	 * 
//	 * Determines the size, that is, the number of elements in the list
//	 *
//	 * @return  the size of the list
//	 * 
//	 ****************************************************************/
//	public int getLen() {
//		Node temp = top;
//		int size = 0;
//		while (temp != null) {
//			temp = temp.getNext();
//			size++;
//		}
//		return size;
//	}
//	
//	/****************************************************************
//	 * 
//	 * Inserts a node before a specific index.  When the list is empty
//	 * that is, top = null, then the index must be 0. After the first
//	 * element is added, index must be:  0 <= index < size of list  
//	 * 
//	 * @param index a specific index into the list.
//	 * 
//	 * 
//	 ****************************************************************/
//	
//	public void insertBefore (int index, String data) {	
//		// place your code here
//	}
//	
//	/****************************************************************
//	 * 
//	 * Inserts a node after a specific index.  When the list is empty
//	 * that is, top = null, then the index must be 0. After the first
//	 * element is added, index must be:  0 <= index < size of list  
//	 * 
//	 * @param index a specific index into the list.
//	 * 
//	 * 
//	 ****************************************************************/
//	
//	public void insertAfter (int index, String data) {	
//		// place your code here
//	}
//
//	/****************************************************************
//	 * 
//	 * Removes the top element of the list
//	 * 
//	 * @return returns the element that was removed.
//	 * 
//	 * @throws RuntimeStringxception if top == null, that is,
//	 * 			 there is no list.
//	 * 
//	 ****************************************************************/
//	
//	public String removeTop () {
//		
//		// case 0; no list
//		if (top == null)
//			return null;
//		
//		// case 1: one Item in the list only
//		if (top.getNext() == null) {
//			Node temp = top;
//			top = null;
//			return temp.getData();
//		}
//		
//		// case 2: more than 1 item remove top.
//		Node temp = top;
//		top = top.getNext();
//		top.setPrev(null);
//		return temp.getData();
//	}
//	
//	
//	/****************************************************************
//	 * 
//	 * This Method removes a node at the specific index position.  The
//	 * first node is index 0.
//	 * 
//	 * @param index the position in the linked list that is to be 
//	 * 			removed.  The first position is zero.  
//	 * 
//	 * @throws IllegalArgumentStringxception if index < 0 or 
//	 * 			index >= size of the list
//	 * 
//	 ****************************************************************/
//	public boolean delAt(int index) {
//		return false;
//	}
//	
//// A simple testing program.  Not complete but a good start.
//	
//	public static void main (String[] args){
//		LinkListLab list = new LinkListLab();
//		
//		list.display();
//		System.out.println ("Current length = " + list.getLen());
//		
//		list.insertBefore(0, "apple");
//		list.insertBefore(0, "pear");
//		list.insertBefore(1, "peach");
//		list.insertBefore(1, "cherry");
//		list.insertBefore(3, "donut");
//		list.insertAfter(0, "apple");
//		list.insertAfter(0, "pear");
//		list.insertAfter(1, "peach");
//		list.insertAfter(1, "cherry");
//		list.insertAfter(3, "donut");
//		list.display();
//
//		list.removeTop();
//		list.delAt(4);
//		list.delAt(2);
//		list.delAt(0);
//		list.removeTop();
//		list.removeTop();
//			
//		list.display();
//	}
//
//	public void display() {
//		Node temp = top;
//
//		System.out.println ("___________ List ________________________");
//		while (temp != null) {
//			System.out.println (temp.getData());
//			temp = temp.getNext();
//		}
//	}
//}
//
//
//
//
//
//
//
