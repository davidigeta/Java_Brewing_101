package assignment14;

import java.util.EmptyStackException;
	
/**
* A generic Stack class implemented with linked nodes
* @author William McDaniel Albritton
*/		 	
    public class LinkedStack<T> implements StackInterface<T> {
   
   // data fields
      private Node<T> top = null;
   
   /**Constructor*/
       public LinkedStack() {
         //data fields already initialized 
      } 
   
   /**Tests if the stack is empty
    * @return true/false if empty/not empty */  
       public boolean empty() {
         return top == null;
      }
   
   /**Looks at the object at the top of the stack 
   * without removing it from the stack.
   * @return an addressed to the top item on the stack 
   * @exception EmptyStackException if the stack is empty*/  
       public T peek() throws EmptyStackException {
       //check to see if empty
         if(this.empty()){
            throw new EmptyStackException();
         }
      //return pointer (address) to top element in array
      //but do NOT take it off the stack!			
         return top.getData();
      } 
   
   /**Removes the object at the top of stack 
   * and returns the address of this object
   * @return an addressed to the top item on the stack 
   * @exception EmptyStackException if the stack is empty*/
       public T pop() {
      //check to see if stack is empty		 
         if(this.empty()){
            throw new EmptyStackException();
         }
      //Store a temporary variable 
      //that points to the top of stack.		
         Node<T> node = top;
      //Take the first element off the stack, 
      //by pointing the top to the next node.			
         top = top.getNext();
      //Return pointer (address) to top element in array			
         return node.getData();
      }
   
   /**Pushes an item onto the top of this stack 
   * @param item the item that is pushed on the stack */
       public void push(T item) {
      //top is assigned a Node, 
      //which points to the new item
      //and the previous top Node.       
         top = new Node<T>(item, top);
      }
      
     /**Driver code to test class
   * @param arguments Commandline arguments not used */
       public static void main(String[] arguments) { 
       //use interface in declaration (left of equals)
       //use class to instantiate object (right of equals)
       //syntax: Interface variable = new Class();
      //make Stack of Strings 
         StackInterface<String> stack2 = new LinkedStack<String>();
      //test empty   
         System.out.println("Is the empty stack empty? " + stack2.empty());
       //test push, peek, pop
         System.out.println("push on stack");
         final int MAX = 100;
         for(int i = 1; i <=MAX; i++){
         //convert integer to String
            String number = i + ", ";
            stack2.push(number);
            System.out.print(stack2.peek());
            //output newline every 20 loops
            if(i%20==0){
               System.out.println();
            }
         }
         System.out.println("Is the " + MAX + " item stack empty? " + stack2.empty());
         System.out.println("pop off stack: ");
         for(int i = 1; i <=MAX; i++){
            System.out.print(stack2.pop());
            //output newline every 20 loops
            if(i%20==0){
               System.out.println();
            }
         }		    
         System.out.println();
      //test exceptions
         try{
            stack2.pop();
         }	
             catch(Exception exception){
               System.out.println(exception);
            }
         try{
            stack2.peek();
         }	
             catch(Exception exception){
               System.out.println(exception);
            }      
            
      //example code (from slides)
         StackInterface<String> stack = new LinkedStack<String>();
         String letter = new String("A");
         stack.push(letter);
         letter = new String("B");
         stack.push(letter);
         letter = new String("C");
         stack.push(letter);
         letter = new String("D");
         stack.push(letter);
         letter = stack.pop();
         System.out.println(letter);
         letter = stack.peek();
         System.out.println(letter);
         letter = stack.pop();
         System.out.println(letter);
         letter = stack.pop();
         System.out.println(letter);
         letter = stack.pop();
         System.out.println(letter);		
      }//end main()
      
   }//end class

/*
PROGRAM OUTPUT:
Is the empty stack empty? true
push on stack
1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 
21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 
41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 
61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 
81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 
Is the 100 item stack empty? false
pop off stack: 
100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87, 86, 85, 84, 83, 82, 81, 
80, 79, 78, 77, 76, 75, 74, 73, 72, 71, 70, 69, 68, 67, 66, 65, 64, 63, 62, 61, 
60, 59, 58, 57, 56, 55, 54, 53, 52, 51, 50, 49, 48, 47, 46, 45, 44, 43, 42, 41, 
40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 
20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 

java.util.EmptyStackException
java.util.EmptyStackException
D
C
C
B
A
*/