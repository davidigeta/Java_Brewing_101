package assignment13;

import java.util.EmptyStackException;

/**
* A generic Stack class implemented with an array
* @author William McDaniel Albritton
*/			
    public class ArrayStack<T> implements StackInterface<T> {
    
   // data fields
   // size of array (size can increase if needed)
      private Integer size = new Integer(5); 
   // top of the stack is the last element in the array 
      private Integer top = new Integer(-1);
   // When using a generic container class with arrays,
   // we must cast when we instantiate an array.	
      private T array[ ] = (T[ ]) new Object[size];		
   
   /**Constructor*/
       public ArrayStack(){
       //We don't need any code in constructor,
       //as we already initialized the data fields.
      }
   
   /**Tests if the stack is empty
    * @return true/false if empty/not empty */
       public boolean empty(){
         return top == -1;
      }
   
   /**Looks at the object at the top of the stack 
   * without removing it from the stack.
   * @return an address to the top item on the stack 
   * @exception EmptyStackException if the stack is empty*/
       public T peek() throws EmptyStackException{
      //check to see if empty		 
         if(this.empty()){
            throw new EmptyStackException();
         }
      //return pointer to top element in array
      //but do NOT take it off the stack!			
         return array[top];
      }
       
   /**Removes the object at the top of stack 
   * and returns the address of this object
   * @return an addressed to the top item on the stack 
   * @exception EmptyStackException if the stack is empty*/
       public T pop() throws EmptyStackException{
      //check to see if stack is empty		 
         if(this.empty()){
            throw new EmptyStackException();
         }
      //return pointer (address) to top element in array
      //and take it off the stack				
         return array[top--];	
      	//This is the same code as:
      	//int temp = top;
      	//top = top - 1;
      	//return array[temp];
      } 
   
   /**Pushes an item onto the top of this stack 
   * @param item the item that is pushed on the stack */
       public void push(T item){
       //check to see if the stack is full
         if(top + 1 == size){
         //make the array twice as big!
            Integer size2 = size * 2;
         // When using a generic container class with arrays,
         // we must cast when we instantiate an array.				
            T array2[] = (T[]) new Object[size2];
         //copy elements into new array   
            System.arraycopy(array, 0, array2, 0, size);
         //reassign the array & size
            size = size2;
            array = array2;
         }
         array[++top] = item;	
      	//This is the same code as:
      	//top = top + 1;
      	//array[top] = item;
      } 	 
   }//end class

/*
PROGRAM OUTPUT:
    true
    push on stack
    1
    2
    3
    4
    5
    6
    7
    8
    9
    10
    11
    12
    13
    14
    15
    16
    17
    18
    19
    20
    21
    22
    23
    24
    25
    26
    27
    28
    29
    30
    31
    32
    33
    34
    35
    36
    37
    38
    39
    40
    41
    42
    43
    44
    45
    46
    47
    48
    49
    50
    51
    52
    53
    54
    55
    56
    57
    58
    59
    60
    61
    62
    63
    64
    65
    66
    67
    68
    69
    70
    71
    72
    73
    74
    75
    76
    77
    78
    79
    80
    81
    82
    83
    84
    85
    86
    87
    88
    89
    90
    91
    92
    93
    94
    95
    96
    97
    98
    99
    100
    false
    pop off stack
    100
    99
    98
    97
    96
    95
    94
    93
    92
    91
    90
    89
    88
    87
    86
    85
    84
    83
    82
    81
    80
    79
    78
    77
    76
    75
    74
    73
    72
    71
    70
    69
    68
    67
    66
    65
    64
    63
    62
    61
    60
    59
    58
    57
    56
    55
    54
    53
    52
    51
    50
    49
    48
    47
    46
    45
    44
    43
    42
    41
    40
    39
    38
    37
    36
    35
    34
    33
    32
    31
    30
    29
    28
    27
    26
    25
    24
    23
    22
    21
    20
    19
    18
    17
    16
    15
    14
    13
    12
    11
    10
    9
    8
    7
    6
    5
    4
    3
    2
    1
    java.util.EmptyStackException
    java.util.EmptyStackException
    Top of stack is: D
    Pop off element: D
    Pop off element: C
    Pop off element: B
    Top of stack is: F

    Top of stack is: Z, X Y
    Pop off elements: Z, X Y; C, A B; 
*/