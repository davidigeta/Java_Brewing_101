package assignment13;

import java.util.EmptyStackException;

/**
* A generic Stack interface roughly based on Java API's class Stack
* @author William McDaniel Albritton
*/		
    public interface StackInterface<T>{
   
   /**Tests if the stack is empty
    * @return true/false if empty/not empty */
       public boolean empty();
   
   /**Looks at the object at the top of the stack 
   * without removing it from the stack.
   * @return the address to the top item on the stack 
   * @exception EmptyStackException if the stack is empty*/
       public T peek() throws EmptyStackException;
       
   /**Removes the object at the top of stack 
   * and returns the address of this object
   * @return the address to the top item on the stack 
   * @exception EmptyStackException if the stack is empty*/
       public T pop() throws EmptyStackException;	 
   
   /**Pushes an item onto the top of this stack 
   * @param item the item that is pushed on the stack */
       public void push(T item);
       
   }//end interface