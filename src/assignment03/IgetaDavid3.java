package assignment03;

/**
* File input reading using command line arguments.
*
* @author Igeta, David
* @assignment ICS 211, Assignment #3
* @date 1/23/2015
*/
import java.util.*;
import java.io.*;

public class IgetaDavid3 {
   /**
    * main method() for the IgetaDavid3 class.
    *
    * @param args is a string where args[0] is the file name the user wants to be read.
    */
   public static void main(String[] args) {
      String sFileName = "";
      //checks if arguments are present.
      if(args.length != 0) {
         sFileName = args[0];
         /**
          * stores integers into arrayElements.
          * 
          * @param args[0] is a string user entered in command line.
          */
         Integer [] arrayElements = IgetaDavid3.createIntArray(args[0]);
         /**
          * prints the array to the screen. 
          *
          * @param arrayElements array to hold file content's integers.
          * @param args[0] is a string user entered in command line.
          */
         IgetaDavid3.printIntArray(arrayElements, args[0]); 
      } 
      //prints statement if user does not enter an arguement.
      else {
         System.out.println("Please enter a file name.");
      } 
   }//ends main method.
   /**
    * creates an integer array of numbers read from sFileName, returns array iArray.
    *
    * @param sFileName is the name of the file the user inputted args[0].
    * @param return the array iArray.
    */
   public static Integer[] createIntArray(String sFileName) {
      final int SIZE = 10000; //size of iArray.
      Integer [] iArray = new Integer [SIZE];
      Integer i = new Integer(0);//counter for loop.
      //ArrayList iArray = new ArrayList();
      Scanner fileReader = null; //reads the file's contents.
      Scanner intReader = null;//retrieves only the integer elements from file.
      Integer iElement = new Integer(0); //iArray element
      String sLine = ""; //stores each line from file from 'filereader' scanner.

         try {	
            File myFile = new File(sFileName);
            //links scanner object to file.
            fileReader = new Scanner(myFile); 

               //fileReader reads each line from file.
               while(fileReader.hasNextLine()) {
                  //sLine stores one word each line that is read.
                  sLine = fileReader.next();
                  intReader = new Scanner(sLine);
                  
                  //grabs the integers from filereader and assigns it to iElement.
                  while(intReader.hasNextInt()) {
                     iElement = intReader.nextInt();
                     iArray[i] = iElement;
                     i++;
                  }//end intReader while loop                       
               }//end fileReader while loop
               System.out.println("Number of integers found in file " + "\"" + sFileName + "\" = " + i); 
         }//end try 
         catch (FileNotFoundException fnf) {
            System.out.print("Error: File not found for " + sFileName);
         }
         catch (SecurityException se) {
            System.out.print("Error: You do not have authorization to access this file.");
         }
         catch (NullPointerException npe) {
            System.out.print("Error: The file destination does not exist.");
         }
         catch (ArrayIndexOutOfBoundsException out) {
            System.out.print("Error: Unable to display all file elements.\n");
         }
         catch (InputMismatchException ime) {
            System.out.print("Error: Invalid valid.");
         }
         catch (NoSuchElementException nse) {
            System.out.print("");
         }
         catch (IllegalStateException ise) {
            System.out.print("Error: Program terminated.");
         }  
      return iArray;            
   }//end public createIntArray
   /**
    * prints myArray to screen using sFileName. no return value.
    * 
    * @param myArray prints array genererated from file's contents.
    * @param sFileName is a string of the file's name.
    */
   public static void printIntArray(Integer[] myArray, String sFileName) {
      Integer i = new Integer(0); //counter for loop.
      Integer arrayLen = myArray.length; //length of array.
      
      try {
         //prints elements of myArray. 
         for(i = 0; myArray[i] != null; i++) {
            System.out.println("index = " + i + ", element = " + myArray[i]); 
         }
      }
      //throws in case the number of integers read in a file > the array size.
      catch(ArrayIndexOutOfBoundsException aout) {
         System.out.println("Error: Unable to display all file elements.");
      }   
   }//end public printIntArray  
}//ends public class IgetaDavid3    
