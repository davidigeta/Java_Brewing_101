package assignment11;

//An interface used to compare two objects.
   import java.lang.Comparable; 

/**
 * 5 sorting methods
 * @author William McDaniel Albritton
 */
    public class Sorting {
    
    /*Set this to "false" to turn off display*/
      public static Boolean display = true;
    
   /**main method starts the program
    * @param args must be Integers only */ 
       public static void main(String args[]) {
      // selectionSort
         Integer[] array = Sorting.arrayCopy(args);
         System.out.println("selectionSort");
         Sorting.print(array);
         Sorting.selectionSort(array);
         System.out.println();
      
      // bubbleSort
         array = arrayCopy(args);
         System.out.println("bubbleSort");
         Sorting.print(array);
         Sorting.bubbleSort(array);
         System.out.println();
      
      // insertionSort
         array = arrayCopy(args);
         System.out.println("insertionSort");
         Sorting.print(array);
         Sorting.insertionSort(array);
         System.out.println();
      
      // mergeSort
         array = arrayCopy(args);
         System.out.println("mergeSort");
         Sorting.print(array);
         Sorting.mergeSort(array);
         System.out.println();
      
      // quickSort
         array = arrayCopy(args);
         System.out.println("quickSort");
         Sorting.quickSort(array);
         Sorting.print(array);
         System.out.println();
      }//end of main
   
   /**selection sort
   * @param array is an array of Comparable objects
   */
       public static void selectionSort(Comparable[] array) {
         Sorting.selectionSort(array, 0, array.length-1);
      }
   
   /**selection sort
   * @param array is an array of Comparable objects
   * @param start is the first element in the array  	
   * @param end is the last element in the array */
       public static void selectionSort(Comparable[] array, int start, int end) {
      // loop from first element to 2nd to last element
         for (int i = start; i < end; i++) {
         // find index of smallest element
            int smallest = findSmallest(array, i, end);
         // swap smallest with current position in array
            Comparable temp = array[smallest];
            array[smallest] = array[i];
            array[i] = temp;
         //print the array to show each step
            if(Sorting.display){  
               Sorting.print(array, start, end);
            }
         }
      }
   
   /**find index of smallest item
   * @param array is an array of Comparable objects 
   * @param start is the first element
   * @param end is the last element in the array
   * @return the index of the smallest element*/ 
       private static int findSmallest(Comparable[] array, int start, int end) {
         int smallest = start; // the index of the smallest element
      // loop from current position to end of array
         for (int i = start; i <= end; i++) {
         // if find a smaller element, then save the index
            if (array[i].compareTo(array[smallest]) < 0) {
               smallest = i;
            }
         }
      //details on smallest index
         if(Sorting.display){  
            System.out.println("start index = " + start);
            System.out.println("smallest index = " + smallest);
            System.out.println("swap " + array[start] + " with " + array[smallest]);
         }
         return smallest;
      }
   
   /**bubble sort
   * @param array is an array of Comparable objects
   */
       public static void bubbleSort(Comparable[] array) {
         Sorting.bubbleSort(array, 0, array.length-1);
      }
   
   /**bubble sort
   * @param array is an array of Comparable objects
   * @param start is the first element in the array  	
   * @param end is the last element in the array */
       public static void bubbleSort(Comparable[] array, int start, int end) {
      //flag to see if an item was swapped or not
         boolean swap = false;
        // loop size - 1 times   
         for (int i = start + 1; i <= end; i++) {
            swap = false;
         	//loop from beginning of array to (last element - i)
            for (int j = 0; j <= end - i; j++) {
            // swap if 1st item greater than 2nd item
               if (array[j].compareTo(array[j + 1]) > 0) {
               // swap
                  Comparable temp = array[j];
                  array[j] = array[j + 1];
                  array[j + 1] = temp;
                  swap = true;
               //display each swap
                  if(Sorting.display){  
                     Sorting.print(array, j, j+1);
                  }
               }
            }
            //display each step of algorithm
            if(Sorting.display){  
               Sorting.print(array, start, end);
            }
            //if no swap, array is in order
         	//so break out of loop early
            if (!swap) {
               break;
            }
         }
      }
   
   /**insertion sort
   * @param array is an array of Comparable objects
   */
       public static void insertionSort(Comparable[] array) {
         Sorting.insertionSort(array, 0, array.length-1);
      }
   
   /**insertion sort
   * @param array is an array of Comparable objects
   * @param start is the first element in the array  	
   * @param end is the last element in the array */
       public static void insertionSort(Comparable[] array, int start, int end) {
      // loop from 2nd item to end of array
         for (int i = start + 1; i <= end; i++) {
         // store the item being inserted
            Comparable temp = array[i];
         //display inserted item
            if(Sorting.display){ 
               System.out.println("inserted item = " + temp); 
            }
            int j = i;
         // loop through sorted part of array
            while ((j > 0) && (temp.compareTo(array[j - 1]) < 0)) {
            // shift elements to the right
               array[j] = array[j - 1];
              //display each shift
               if(Sorting.display){ 
                  Sorting.print(array, j-1, j);
               }
               j--;   
            }
         // insert next item into sorted part
            array[j] = temp;
         //display each step of algorithm
            if(Sorting.display){  
               Sorting.print(array, start, end);
            }
         }
      }
   
   /**merge sort
   * @param array is an array of Comparable objects
   */
       public static void mergeSort(Comparable[] array) {
      //overloading: two methods with same name, but different parameter type and/or count
      //calls mergeSort method with 3 parameters
         Sorting.mergeSort(array, 0, array.length-1);
      }
   
   /**merge sort
   * @param array is an array of Comparable objects 	
   * @param start is the first element in the array  	
   * @param end is the last element in the array */ 	
       public static void mergeSort(Comparable[] array, int start, int end) {
      // if start index is less than end index
         if (start < end) {
            int half = (start + end) / 2;
         //show array split  
            if(Sorting.display){  
               System.out.println("SPLIT: start=" + start + ", half=" + half + ", end=" + end);  
            }
         // sort left & right half of array
            Sorting.mergeSort(array, start, half);
            Sorting.mergeSort(array, half + 1, end);
         // merge left & right half of array
            Sorting.merge(array, start, half, end);		
         }
      }
   
   /**merge: merges the two arrays back together
   * @param array is an array of Comparable objects 	
   * @param start is the first element in the array  	
   * @param half is the middle element in the array  		
   * @param end is the last element in the array */ 	
       private static void merge(Comparable[] array, int start, int half, int end) {
      //display 2 arrays before merge
         if(Sorting.display){  
            Sorting.print(array, start, half);
            Sorting.print(array, half+1, end); 
         }
      // temporary array
         Comparable[] temp = new Comparable[array.length];
      // index for 2 subarrays
         int start1 = start;
         int end1 = half;
         int start2 = half + 1;
         int end2 = end;
         int i = start1;
       //loop & copy to temp array, so that elements are sorted
         while ((start1 <= end1) && (start2 <= end2)) {
            if (array[start1].compareTo(array[start2]) < 0) {
               temp[i] = array[start1];
               //increment i & start1
               i = i + 1;
               start1 = start1 + 1;
            } 
            else {
               temp[i] = array[start2];
               //increment i & start2
               i = i + 1;
               start2 = start2 + 1;
            }
         }
      // loop through either the first or second subarray & copy to temp array
         while (start1 <= end1) {
            temp[i] = array[start1];
         //increment i & start1
            i = i + 1;
            start1 = start1 + 1;
         }
         while (start2 <= end2) {
            temp[i] = array[start2];
         //increment i & start2
            i = i + 1;
            start2 = start2 + 1;
         }
      // copy back to actual array
         i = start;
         while (i <= end) {
            array[i] = temp[i];
            i=i+1;
         }
      //result after merge
         if(Sorting.display){  
            Sorting.print(array, start, end);   
         }
      }
   
   /**quick sort
   * @param array is an array of Comparable objects 	
   */    
       public static void quickSort(Comparable[] array) {
      //overloading: two methods with same name, but different parameter type and/or count
      //calls quickSort method with 3 parameters 
         Sorting.quickSort(array, 0, array.length-1);
      }
   
   /**quick sort
   * @param array is an array of Comparable objects 	
   * @param start is the first element in the array  	
   * @param end is the last element in the array */    
       public static void quickSort(Comparable[] array, int start, int end) {
         if (start < end) {
         // split the table into two parts
            int pivot = Sorting.partition(array, start, end);
         // sort the two parts
            Sorting.quickSort(array, start, pivot - 1);
            Sorting.quickSort(array, pivot + 1, end);
         }
      }
   
   /**partitions the array into two parts: smaller or greater/equal part
   * @param array is an array of Comparable objects 	
   * @param start is the first element in the array  	
   * @param end is the last element in the array 
   * @return the index of the partition element */     
       private static int partition(Comparable[] array, int start, int end) {
       //display array before partition
         if(Sorting.display){  
            Sorting.print(array, start, end);
         }
      // get pivot item (1st item)
         Comparable pivot = array[start];
      //display pivot
         if(Sorting.display){  
            System.out.println("pivot=" + pivot);   
         }
      // index of end element in smaller part
         int split = start;
      // loop from 2nd element to end of array
         for (int i = start + 1; i <= end; i++) {
         // put element in smaller or greater/equal part
            if (pivot.compareTo(array[i]) > 0) {
            //increase size of smaller part
               split = split + 1;
            //swap, so item is in smaller part
               Comparable temp = array[i];
               array[i] = array[split];
               array[split] = temp;
            	//display swapped numbers
               if(Sorting.display){  
                  System.out.println("swap " + array[split] + " and " + array[i]);
               }
            }
         }
      // swap pivot with last element in smaller part
      // so pivot is between the two parts
         Comparable temp = array[start];
         array[start] = array[split];
         array[split] = temp;
      //display swapped numbers
         if(Sorting.display){  
            System.out.println("swap " + array[split] + " and " + array[start]);   
            Sorting.print(array, start, end);
         }
         return split;
      }
   
   /**prints out an array from start index to ending index
   * @param array is an array of Comparable objects 	
   */
       public static void print(Comparable[] array){
      //overloading: two methods with same name, but different parameter type and/or count
      //calls print method with 3 parameters 
         Sorting.print(array, 0, array.length-1);
      }
   
   /**prints out an array from start index to ending index
   * @param array is an array of Comparable objects 	
   * @param start is the first element in the array  	
   * @param end is the last element in the array  */ 	
       public static void print(Comparable[] array, int start, int end) {
         for (int i = 0; i < array.length; i++) {
            if(i>=start && i<=end){
               System.out.print(array[i] + ", ");
            }
            else{
            //display blanks for proper placement of elements
               System.out.print("   ");
            }
         }
         System.out.println();
      }
   
   /**copies & converts an array of Strings to an array of Integers
   * @param array is an array of Strings 	
   * @return an array of Integers  */
       public static Integer[] arrayCopy(String[] array) {
         Integer[] array2 = new Integer[array.length];
         for (int i = 0; i < array.length; i++) {
            array2[i] = Integer.parseInt(array[i]);
         }
         return array2;
      }//end of method
   
   }//end of class
	