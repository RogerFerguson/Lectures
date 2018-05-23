package week10;

public class Nodeb<E> {
	public E data;
	public Nodeb<E> next;
	
	public Nodeb(E data, Nodeb<E> next) {
		super();
		this.data = data;
		this.next = next;
	}
	
	public Nodeb () {
	}	
}
