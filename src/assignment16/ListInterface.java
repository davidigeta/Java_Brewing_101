package assignment16;

/**
 * A generic interface for a list
 * 
 * @author William McDaniel Albritton
 */
public interface ListInterface<T> {

	/**
	 * Adds an item (of any class) to the list
	 * 
	 * @param item
	 *            is the object that is added to the list
	 */
	public void add(T item);

	/**
	 * Gets an item (address to an item) from the list.
	 * 
	 * @param position
	 *            The position of an item in the list.
	 * @returns the address to the requested item
	 * @exception ItemException
	 *                if an item does not exist at that position
	 */
	public T get(Integer position) throws ListException;

	/**
	 * Removes an item from a list.
	 * 
	 * @param position
	 *            The position of an item in the list.
	 * @exception ItemException
	 *                if an item does not exist at that position
	 */
	public void remove(Integer position) throws ListException;

	/**
	 * This Is An "Accessor" Method - Used To Get A Data Field.
	 * 
	 * @return the size of the list
	 */
	public Integer getSize();

}// end of interface

// *************************************************************************

/**
 * Used for all List exceptions
 */
class ListException extends RuntimeException {
	/**
	 * @param message
	 *            describes the exact cause of the error.
	 */
	public ListException(String message) {
		super(message);
	}// end of constructor
}// end of class

// *************************************************************************
