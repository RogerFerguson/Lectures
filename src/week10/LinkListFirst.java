package week10;
public class LinkListFirst  {
	private Node top;
	private Node tail;

	public LinkListFirst() {
		top = null;
		tail = null;
	}

	public void addAtTop (String s) {

		// the list does not exist
		if (top == null)
			tail = top = new Node (s, null);
			// the list exist
		else {
			top = new Node (s, top);
		}


		// this works with no tail
		//top = new Node(s, top);

		// or the long approach.
//				temp.setData(s);
//				temp.setNext(top);
//				top = temp;

		// This code does not work
		//		top = new Node();
		//		top.setData(s);
		//		top.setNext(null);

	}
	public void display () {

		Node temp = top;
		while (temp != null) {
			System.out.println (temp.getData());
			temp = temp.getNext();

		}

		//		System.out.println (top.getData());
		//		System.out.println (top.getNext().getData());
		//		System.out.println (top.getNext().getNext().getData());

	}

	public void append (String s) {

		// Case 0:  The list does not exist.
		if (top == null)
			addAtTop(s);

			// Case 1: at Least one item in list
		else {

			// code is not needed if using a tail
//			Node temp = top;
//			while (temp.getNext() != null)
//				temp = temp.getNext();

			// place at the bottom of the list
			tail.setNext(new Node (s, null));
			tail = tail.getNext();
		}
}

	public boolean remove (String s) {
		// no list
		if (top == null)
		    return false;

		// 1 Item and s is found
        if (top.getData().equals(s) && top == tail) {
            top = tail = null;
            return true;
        }

        // 1 ITem and s is not found
        if (!top.getData().equals(s) && top == tail)
            return false;

        // multi-itmes and s is on top
        if (top.getData().equals(s) && top != tail) {
            top = top.getNext();
            return true;
        }

            // At this position, the list exist with >= 1 node
        Node temp = top;
        while (temp.getNext() != null) {
            if (temp.getNext().getData().equals(s)) {
                // found at the tail position
                if (temp.getNext() == tail)
                    tail = temp;
                temp.setNext(temp.getNext().getNext());
                return true;
            }
            else
                temp = temp.getNext();
        }

        return false;
    }

	public void removeAll(String s) {



	}

	public static void main (String[] args){
		LinkListFirst list = new LinkListFirst();

		list.append("1");
		list.append("2");
		list.append("3");
		list.append("4");
		list.append("5");
		list.addAtTop("2nd");
		list.addAtTop("1st");

        list.remove("1");
        list.remove("3");
        list.remove("1st");
        list.remove("5");

		//list.insertAfter(4, "sdf");

		//		list.remove("donuts4");
		//		list.removeAll ("pizza3");

		list.display();

	}
}


/*
 // no list
        if (top == null)
            return false;

        // 1 item in the list and target found there
        if ((top == tail))
            if (top.getData().equals(s)) {
                top = tail = null;
                return true;
            }

        if (top != tail && top.getData().equals(s)) {
            top = top.getNext();
            return true;
        }

        // in the middle
        Node temp = top;
        while (temp.getNext() != null)
            if (temp.getNext().getData().equals(s)) {
                temp.setNext(temp.getNext().getNext());

                if (temp.getNext() == tail)
                    tail = temp;
            }
            else
                temp = temp.getNext();

        // at the tail
 */

/*
// This method needs to be changed to handle the tail pointer
	public boolean insertAfter (int pos, String s) {
		return false;

 */