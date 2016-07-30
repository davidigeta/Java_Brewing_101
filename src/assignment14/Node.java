package assignment14;

/**
 * A generic Node class that Stores a reference to Data and the next Node
 * 
 * @author William McDaniel Albritton
 */
public class Node<T> {

	// data fields (reference variables)
	// data stores an object of any class
	private T data;
	// next points to the next node
	private Node<T> next;

	/**
	 * Constructor - Used To Create EAch Object & Initialize DAta Fields.
	 * 
	 * @param data2
	 *            initializes the data reference variable.
	 * @param next2
	 *            initializes the next reference variable..
	 */
	public Node(T data2, Node<T> next2) {
		data = data2;
		next = next2;
	}

	/**
	 * Used to Display The Data Stored In EAch Node.
	 * 
	 * @return a String for the data
	 */
	public String toString() {
		return data.toString();
	}

	/**
	 * This Is An "Accessor" Method - Used To Get A Data Field.
	 * 
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * This Is An "Accessor" Method - Used To Get A Data Field.
	 * 
	 * @return the address to the next node
	 */
	public Node<T> getNext() {
		return next;
	}

	/**
	 * This Is A "Mutator" Method - Used To Set A Data Field.
	 * 
	 * @param data2
	 *            is a pointer to an object.
	 */
	public void setData(T data2) {
		data = data2;
	}

	/**
	 * This Is A "Mutator" Method - Used To Set A Data Field.
	 * 
	 * @param next2
	 *            is a pointer to the next node.
	 */
	public void setNext(Node<T> next2) {
		next = next2;
	}

	/**
	 * Driver code to test class
	 * 
	 * @param arguments
	 *            Commandline arguments not used
	 */
	public static void main(String[] arguments) {

		// create variables that can point to objects of class Node
		System.out.println("Class Node<String>:");
		Node<String> head, tail;

		// give each variable the address to an object
		String fruit1 = new String("apple");
		String fruit2 = new String("banana");
		head = new Node<String>(fruit1, null);
		tail = new Node<String>(fruit2, null);
		// link the nodes together
		head.setNext(tail);

		// print linked nodes
		Node<String> pointer = head;
		String fruitX = pointer.getData();
		System.out.println("head = " + fruitX);
		pointer = pointer.getNext();
		fruitX = pointer.getData();
		System.out.println("tail = " + fruitX);
		System.out.println();

		// How are these nodes linked together?
		Node<String> node1 = new Node<String>("apple", null);
		Node<String> node2 = new Node<String>("banana", null);
		Node<String> node3 = new Node<String>("carrot", null);
		Node<String> node4 = new Node<String>("doughnut", null);
		Node<String> node5 = new Node<String>("eggplant", null);
		node1.setNext(node5);
		node2.setNext(node4);
		node3.setNext(node2);
		node4.setNext(null);
		node5.setNext(node3);

		// Print out the linked nodes with a loop
		System.out.println("Linked nodes 1-5: ");
		for (Node<String> i = node1; i != null; i = i.getNext()) {
			System.out.println(i.toString());
		}

	}// end of main

} // end of class

/*PROGRAM OUTPUT:
Class Node<String>:
head = apple
tail = banana

Linked nodes 1-5: 
apple
eggplant
carrot
banana
doughnut
*/