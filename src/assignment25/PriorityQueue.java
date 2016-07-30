package assignment25;

/**
 * A PriorityQueue class roughly based on Java API's PriorityQueue class
 * @author William McDaniel Albritton
 */
public class PriorityQueue<T extends java.lang.Comparable<T>> implements QueueInterface<T>{
	// data fields
	private Heap<T> heap = new Heap<T>(); 

	/** constructor */
	public PriorityQueue() {
      // data fields already initialized
	}

	/**
	 * Tests if the Queue is empty
	 * @return true/false if empty/not empty
	 */
	public boolean empty() {
		return heap.empty();
	}

	/**
	 * offers an element to the PriorityQueue
	 * @param element is offered to the PriorityQueue
	 * @return true if it was possible to offer the element to PriorityQueue, else false
	 */
	public boolean offer(T element) {
		try {
			heap.add(element);
		} catch (Exception exception) {
			return false;
		}
		return true;
	}

	/**
	 * Retrieves and removes the from the top of PriorityQueue, or null if PriorityQueue is empty
	 * @return the top of PriorityQueue, or null if PriorityQueue is empty
	 */
	public T poll() {
		try {
			return heap.remove();
		} catch (Exception exception) {
			return null;
		}
	}

	/**
	 * Retrieves, but does not remove, from the top of PriorityQueue, or null if PriorityQueue is empty
	 * @return the top of PriorityQueue, or null if PriorityQueue is empty
	 */
	public T peek() {
		try {
			return heap.get();
		} catch (Exception exception) {
			return null;
		}
	}

	/**
	 * Driver code to test class
	 * @param arguments Commandline arguments not used
	 */
	public static void main(String[] arguments) {
		// create Priority Queue of integers
		QueueInterface<Integer> queue = new PriorityQueue<Integer>();
		// test empty
		System.out.println(queue.empty());
		// test offer
		queue.offer(3);
		queue.offer(6);
		queue.offer(7);
		queue.offer(5);
		queue.offer(4);
		queue.offer(8);
		queue.offer(2);
		queue.offer(9);
		queue.offer(1);
		// test peek
		System.out.println(queue.peek());
		// test empty
		System.out.println(queue.empty());
		// test poll
		for (Integer i = 0; i < 4; i++) {
			Integer x = queue.poll();
			System.out.println(x);
		}
	}
}// end interface

/*
    true
    9
    false
    9
    8
    7
    6
*/