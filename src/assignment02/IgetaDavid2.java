package assignment02;

/**
* Arrays, Loops, and Modulus practice.
*
* @author Igeta, David
* @assignment ICS 211, Assignment #2
* @date 1/20/2015
*/
public class IgetaDavid2 {
   /**
    *
    *@param main argument to execute code.
    */
   public static void main(String[] args) {
      
      final int SIZE = 200; // size of array.
      int[] iArray = new int[SIZE]; // instantiates an array of 200 integers.
      int i = 0; // counter for loops.
      int iElement = 0; //elements of iArray.
      
      //loop to initialize elements of iArray.
      for(i = 0; i < SIZE; i++) {
         //uses modulus to find get positive even indexes.
         if(i % 2 == 0) { 
            iArray[i] = iElement + 5;
            iElement += 5;
         } 
         //odd indexes are negative.  
         else { 
            iArray[i] = (iElement + 5) * -1;    
            iElement = iArray[i] * -1;  
         }     
      }
      //loop to print iArray.
      for(i = 0; i < SIZE; i++) {
         //prints all indexes and elements of iArray on each line.
         System.out.println("index = " + i + ", element = " + iArray[i]);
      }
   }//end main method.
}//end public class.
