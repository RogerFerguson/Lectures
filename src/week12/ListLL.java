package week12;

public class ListLL {

	protected SNode front;  		// The first node in the list
	protected SNode tail;  	// The last node in the list

	public ListLL () {
		front = null;
		tail = null;
	}


	public boolean addInorder(String item) {	
		//  Your code here
		return true;
		
		}

	
	public void enQ (String s) {
		
		if (front == null) {   // no list 
			front = new SNode();
			front.setData(s);
			front.setNext(null);
			tail = front;
			return;
		}
		
		SNode temp = new SNode();
		temp = new SNode();
		temp.setData(s);
		temp.setNext(null);
		
		tail.setNext(temp);
		tail = temp;
	}
	
	public String deQ () {
		if (front == null)	// case where no list 
			return null;
		
		String temp = front.getData();

		if (front == tail) {	// case with one item in list
			tail = null;
			front = null;
			return temp;
		}
		
		// assume mult item. 
		front = front.getNext();
		return temp;
	}
	
	public void display () {
		SNode temp = front;
		System.out.println ("------ do not use tail -----");
		while (temp != null ) { // tail.getNext()) {
			System.out.println (temp.getData());
			temp = temp.getNext();
		}
	}


	public void displayUseTail () {
		SNode temp = front;
		System.out.println ("------ do use tail -----");

		while (temp != tail.getNext()) {
			System.out.println (temp.getData());
			temp = temp.getNext();
		}
	}

	public static void main (String[] args) {
		ListLL list = new ListLL();

		list.enQ (new String ("job1"));
		list.enQ (new String ("job1"));

		list.enQ ("job3");

		list.display ();	 
		list.displayUseTail();
		
		System.out.println ("DeQ->" + list.deQ());
		System.out.println ("DeQ->" + list.deQ());

		list.enQ ("job4");
		System.out.println ("DeQ->" + list.deQ());
		
		list.display ();	 

		
	}
}
