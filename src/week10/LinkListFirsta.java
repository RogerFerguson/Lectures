package week10;

public class LinkListFirsta<E> {
	private Nodea<E> top; 
	private Nodea<E> tail;

	public LinkListFirsta() {
		top = null;
		tail = null;
	}

	public void addAtTop (E s) {
		Nodea<E> temp;
		temp = new Nodea<E>(s, top);
		//		temp.setData(s);
		//		temp.setNext(top);
		if (top == null)
			tail = temp;

		top = temp;
	}

	public void display () {
		Nodea<E> temp = top;
		while (temp != null) {
			System.out.println (temp.getData());
			temp = temp.getNext();
		}
	}

	public void addAtEnd(E s) {
		Nodea<E> temp = new Nodea<E> (s, null);

		if (top == null) 
			top = tail = temp;
		else {
			tail.setNext(temp);
			tail = temp;
		}

	}



	public boolean delete (E s) {
		
		if (top == null)
			return false;
		
		if (top == tail && top.getData().equals(s)) {
			top = tail = null;
			return true;
		}
			
		if (top == tail && !top.getData().equals(s)) 
			return false;
		
		if (top.getData().equals(s)) {
			top = top.getNext();
			return true;
		}
		
		Nodea<E> temp = top;
		while (temp.getNext() != null) {
			if (temp.getNext().getData().equals(s))
				if (temp.getNext() == tail) {
					tail = temp;
					temp.setNext(null);
					return true;
				}
				else {
					temp.setNext(temp.getNext().getNext());
					return true;
				}				
			temp = temp.getNext();	
		}
		
	return false;
	}
	
	public Nodea<E> find (String s) {
		Nodea<E> temp = top;
		while (temp != null) {
			if (temp.getData().equals(s))
				return temp;
		}
		return null;
	}
	
	public void delete (Nodea<E> curr) {
		
		
	}
	
	public void delete (int x) {
		
		
	}

    public Nodea<E> getTop() {
        return top;
    }

    public void setTop(Nodea<E> top) {
        this.top = top;
    }

    public static void main (String[] args){
		LinkListFirsta<String> list = new LinkListFirsta<String>();
		LinkListFirsta<NewNodeProject4> listClb = new LinkListFirsta<NewNodeProject4>();

		list.addAtTop("pizza");
		list.addAtTop("donuts");
		list.addAtTop("chocolate");

		listClb.addAtTop(new NewNodeProject4(2,list.getTop()));
		//		list.display();

		list.addAtEnd("endCheese");
		//		list.display();

		System.out.println (list.delete ("pizza"));
		list.display();

		Nodea<String> curr = list.find("pizza");
		list.delete (curr);
		
	}
}

