package week13;

public class ListDL {

	protected DNode top;  		// The first node in the list
	protected DNode tail;

	public ListDL () {
		top = null;
		tail = null;
	}


	public void enQ (String s) {
		if (top == null) 
			tail = top = new DNode (s,null, null);
//			tail = top;
		
		else {
			DNode temp = new DNode(s,null,tail);
			tail.setNext(temp);
			tail = temp;
		}

	}

	public String deQ () {
		
		return null;
	}

	public boolean isEmpty() {
		return (top == null);
//		
//		if (top == null)
//			return true;
//		else
//			return false;
	}

	public void push (String s) {

	}

	public String pop () throws Iwilltakecareofthislater {
		if (top == null)
			throw new Iwilltakecareofthislater();
		else 
			if (top == tail) {
				String temp = top.getData();
				tail = null;
				top = null;
				return temp;
			}
			else {
				String temp = top.getData();
				top = top.getNext();
				top.setPrev(null);
				return temp;
				
			}
			
	}


	public void display () {

		DNode temp = top;
		System.out.println ("------ forward -----");
		while (temp != null ) { 
			System.out.println (temp.getData());
			temp = temp.getNext();
		}

		
		
		
		
		
		
		
		
		
		
		
		System.out.println ("------ backwards -----");
		DNode prev = tail;
		while (prev != null ) { 
			System.out.println (prev.getData());
			prev = prev.getPrev();
		}


	}



	public static void main (String[] args) {
		ListDL list = new ListDL();

		list.enQ (new String ("job1"));
		list.enQ (new String ("job1"));
		list.enQ ("job3");

	//	list.pop();
		
		list.display ();	 

		System.out.println ("DeQ->" + list.deQ());
		System.out.println ("DeQ->" + list.deQ());

		list.enQ ("job4");
		System.out.println ("DeQ->" + list.deQ());

		list.display ();	 


	}
}
