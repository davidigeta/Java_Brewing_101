package assignment19;

/**
 * A Queue interface roughly based on Java API's Queue interface
 * 
 * @author William McDaniel Albritton
 */
public interface QueueInterface<T> {

	/**
	 * Tests if the Queue is empty
	 * 
	 * @return true/false if empty/not empty
	 */
	public boolean empty();

	/**
	 * Adds an element to the end of the Queue
	 * 
	 * @param element
	 *            is added to the end of the Queue
	 * @return true if it was possible to add the element to Queue, else false
	 */
	public boolean offer(T element);

	/**
	 * Retrieves and removes the from the front of Queue, or null if Queue is
	 * empty
	 * 
	 * @return the front of Queue, or null if Queue is empty
	 */
	public T poll();

	/**
	 * Retrieves, but does not remove, from the front of Queue, or null if Queue
	 * is empty
	 * 
	 * @return the front of Queue, or null if Queue is empty
	 */
	public T peek();

}// end interface
