package myutil;

public class MyStack<E> {

	private Node<E> first;
	private int size;

	public MyStack() {

		first = null;

	}

	public void push(E data) {

		Node<E> newNode = new Node<E>(data, first);
		first = newNode;
		size++;

	}

	public E pop() {
		
		if (isEmpty()) {
			
			throw new RuntimeException("Det finns inget att poppa");
		}

		E temporary_data = first.getData();

		first = first.getNext();
		
		size--;

		return temporary_data;

	}
	
	public boolean isEmpty() {
		
		if(first != null){
			
			return false;
			
		} else {
			
			return true; 
			
		}
		
	}
	
	public int size() {
		
		return size;
		
	}

}
