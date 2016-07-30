package assignment12;

import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

/**
 * File reader with sorting.
 *
 * @author Igeta, David
 * @assignment ICS 211, Assignment #12
 * @date 2/24/2015
 */
 public class IgetaDavid12 {
   /**
    * main() method begins program
    *
    * @param args is user input
    */
   public static void main(String[] args) {
      //checks if user entered in two args
      if(args.length != 1) {
         JOptionPane.showMessageDialog(null, "Please enter a file input in command line.");
         //terminates program
         System.exit(0);
      }
      else {
         //creates an array of file contents
         String[] sFileContents = IgetaDavid12.createArray(args[0]);
         
         //sorts and prints the array created in sFilecontents() method
         IgetaDavid12.sortPrintArray(sFileContents, args[0]);
      }
   }//end main() method
   
   /**
    * creates an array of file contents
    *
    * @param sFileName is user input
    * @returns a String array
    */  
   public static String[] createArray(String sFileName) {
      //size of array set to 10000
      final Integer SIZE = new Integer(10000);
      //create a string array to store file contents
      String[] sArray = new String[SIZE];
      //counter for loops
      Integer i = new Integer(0);
      //scanner object which reads each line from file
      Scanner fileReader = null;
      
      try {
         File myFile = new File(sFileName);
         //links scanner object to file.
         fileReader = new Scanner(myFile);
         
         //fileReader reads each line from file.
         while(fileReader.hasNextLine()) {
            //sArray[i] stores each word that is read.
            sArray[i] = fileReader.next();
            i++;
         }
      }//end try statement
      catch (FileNotFoundException fnf) {
         JOptionPane.showMessageDialog(null, "ERROR: File not found for " + sFileName);
      }
      catch (SecurityException se) {
         JOptionPane.showMessageDialog(null, "ERROR: You do not have authorization to access this file.");
      }
      catch (NullPointerException npe) {
         JOptionPane.showMessageDialog(null, "ERROR: The file destination does not exist.");
      }
      catch (ArrayIndexOutOfBoundsException out) {
         JOptionPane.showMessageDialog(null, "ERROR: Unable to display all file elements.");
      }
      catch (InputMismatchException ime) {
         JOptionPane.showMessageDialog(null, "ERROR: Unable to read file content.");
      }
      catch (NoSuchElementException nse) {
         System.out.print("");
      }
      catch (IllegalStateException ise) {
         JOptionPane.showMessageDialog(null, "ERROR: Program terminated.");
      }  
      return sArray;
   }//end createArray() method
   
   /**
    * sorts and prints the array created in sFilecontents() method
    *
    * @param sMyArray is array with file contents
    * @param sFileName is user input
    */    
   public static void sortPrintArray(String[] sMyArray, String sFileName) {
      //declare counter for loops
      Integer i = new Integer(0);
      
      //counts the number of elements in array minus null elements
      for(i = 0; sMyArray[i] != null; i++) {
      }
      //to prevent automatic output of Sorting.java program
      Sorting.display = false;
      //parameters arrayName, start, end
      Sorting.mergeSort(sMyArray, 0, i-1);
      System.out.println("ASCII listing of words in file: " + sFileName);
      //prints elements of sMyArray. 
      for(i = 0; sMyArray[i] != null; i++) {
         System.out.println("index = " + i + ", element = " + sMyArray[i]); 
      }
   }//end sortPrintArray() method
 }//end class IgetaDavid12