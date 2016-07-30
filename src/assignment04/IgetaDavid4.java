package assignment04;

/**
 * Grocery list rev5 with my edit method to modify the grocery list's contents.
 *
 * @author Igeta, David
 * @assignment ICS 211, Assignment #4
 * @date 1/27/2015
 */
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Implements a Grocery List Version 4: Has code for all methods (final version)
 * 
 * @author William McDaniel Albritton
 */
public class IgetaDavid4 {
   /**
    * The main() Method Starts The Program.
    * 
    * @param commandlineArguments 1st argument is INPUT File, 2nd argument is OUTPUT File
    */
   public static void main(String[] commandlineArguments) {
      // Error Checking For 2 Command Line Arguments..
      if (commandlineArguments.length != 2) {
         System.out.println("Please enter the INPUT file name as "
              + "the 1st commandline argument.");
         System.out.println("Please enter the OUTPUT file name as "
              + "the 2nd commandline argument.");
         System.out.println("Please enter exactly "
              + "two (2) commandline arguments.");
      }// end of if
        // if no commandline argument errors, continue program
      else {
         // Declare and instantiate array of 100 Strings
         final Integer MAX_SIZE = new Integer(100);
         String groceryList[] = new String[MAX_SIZE];
         // Set size of grocery list to zero (0) items
         Integer size = new Integer(0);
         // read grocery items from file & store in array for grocery list
         try {
            size = IgetaDavid4.readFromFile(commandlineArguments[0],
                 groceryList, size);
         } 
         catch (ArrayIndexOutOfBoundsException exception) {
            System.out.print("ERROR: Too many items in input file. ");
            System.out.println("Please limit to " + MAX_SIZE + " items.");
            // Immediately terminates program
            System.exit(1);
         }
      
         // user's choice for Menu
         Integer choice = new Integer(0);
         // choice for ending program
         final Integer QUIT = new Integer(5);
         // if the user does not want to QUIT, keep looping
         while (!choice.equals(QUIT)) {
            // get the user's choice
            choice = IgetaDavid4.displayMenu();
            // add grocery item
            if (choice.equals(1)) {
               size = IgetaDavid4.add(groceryList, size);
            }
            // edit method asks user for item information to be changed
            else if (choice.equals(2)) {
               size = IgetaDavid4.edit(groceryList, size);
            }
             // delete grocery item
            else if (choice.equals(3)) {
               size = IgetaDavid4.delete(groceryList, size);
            }
             // display grocery item
            else if (choice.equals(4)) {
               IgetaDavid4.display(groceryList, size);
            }
             // error message
            else if (!choice.equals(QUIT)) {
               System.out.println("ERROR: Please enter an integer in the range from 1 to 5");
            }
         }// end of "while"
          // write to from grocery list array to OUTPUT file
         IgetaDavid4.writeToFile(commandlineArguments[1], groceryList,
              size);
      }// end of "else"
   }// end of main() method

   /**
    * Displays the menu for the program and returns user's choice
    * 
    * @return the choice of the user (if error, returns 0)
    */
   public static Integer displayMenu() {
      // display menu
      System.out.println();
      System.out.println("\tGROCERY LIST MENU");
      System.out.println("\t Enter 1 to Add");
      System.out.println("\t Enter 2 to Edit");
      System.out.println("\t Enter 3 to Delete");
      System.out.println("\t Enter 4 to Display");
      System.out.println("\t Enter 5 to Quit");
      System.out.print("\tEnter your choice: ");
      // get input from user
      Scanner keyboardInput = new Scanner(System.in);
      Integer choiceOfUser = new Integer(0);
      try {
         // non-integer input will throw InputMismatchException
         choiceOfUser = keyboardInput.nextInt();
      } 
      catch (InputMismatchException exception) {
         // Already have error message in main() method,
         // as choiceOfUser = 0
      }
      System.out.println();
      return choiceOfUser;
   }

   /**
    * Reads grocery items from a file and stores items in an array
    * 
    * @param inputFile is the INPUT File
    * @param array is the Grocery List array
    * @param size is the number of items in Grocery List
    * @return the new size of the grocery list
    * @throws ArrayIndexOutOfBoundsException if array size is less than number of
    *         items in input file
    */
   public static Integer readFromFile(String inputFile, String[] array,
       Integer size) throws ArrayIndexOutOfBoundsException {
      // connect to file (does NOT create new file)
      File file = new File(inputFile);
      Scanner scanFile = null;
      try {
         scanFile = new Scanner(file);
      } 
      catch (FileNotFoundException exception) {
         // Print error message.
         // In order to print double quotes("),
         // the escape sequence for double quotes (\") must be used.
         System.out.print("ERROR: File not found for \"");
         System.out.println(inputFile + "\"");
      }
      // if made connection to file, read from file
      if (scanFile != null) {
         // keeps looping if file has more lines..
         while (scanFile.hasNextLine()) {
            // get a line of text..
            String line = scanFile.nextLine();
            // display a line of text to screen..
            // System.out.println(line);
            // array[0] stores the first row (headings) to table
            array[size] = line;
            // increment size
            ++size;
         }
         // In order to print double quotes("),
         // the escape sequence for double quotes (\") must be used.
         System.out.println("Read from file \"" + inputFile + "\"");
      }// end of "if" for connecting to file
      return size;
   }

   /**
    * Adds a grocery item to an array
    * 
    * @param list is the grocery list
    * @param listSize is the size of the grocery list
    * @return new size of the grocery list
    */
   public static Integer add(String[] list, Integer listSize) {
      try{
         // get item from user
         Scanner keyboard = new Scanner(System.in);
         System.out.print("Enter name of item: ");
         String name = keyboard.nextLine();
         System.out.print("Enter number of items: ");
         String number = keyboard.nextLine();
         // add to the end of the array
         list[listSize] = name + ", " + number;
         // add one to the size (one item to end of list)
      }//end try
      catch(ArrayIndexOutOfBoundsException aout){
         System.out.println("Error: Please delete an entry to make room in your grocery list.");
      }   
      return listSize + 1;
   }
   /**
    * prompts for a row and item to be edited in list and gets listSize, returns integer listSize.
    * 
    * @param list is grocery list array.
    * @param listSize is the size of the list.
    * @return the modified grocery list integer listSize.
    */
   public static Integer edit(String[]list, Integer listSize) {
      
      try {
         // prompts user for row number to be edited.
         System.out.print("Enter the row number of the item you wish to edit: ");
         Scanner rowInt = new Scanner(System.in);
         Integer editRow = new Integer(rowInt.nextInt());
         // ensures user enters a number from 1 to the size of the grocery list. 
         if(editRow < 1 || editRow > (listSize - 1)){
            System.out.println("Error: Please enter a number from 1 to " + (listSize - 1));
            return listSize;
         }
         // prompts user for the item name to be changed.
         System.out.print("Enter the name of the item: ");
         Scanner itemName = new Scanner(System.in);
         String editName = itemName.nextLine();
         // prompts user for new item quantity.
         System.out.print("Enter the number of items: ");
         Scanner itemNumber = new Scanner(System.in);
         Integer editNumber = new Integer(itemNumber.nextInt());
         // checks if user enters a negative number.
         if(editNumber < 1){
            System.out.println("Error: Please enter a number greater than zero.");
            return listSize;
         }
         // makes changes to the grocery list.
         list[editRow] = editName + ", " + editNumber;
      }//end try
      catch(InputMismatchException ime) {
         System.out.println("Error: Please enter a positive number.");
      }   
      return listSize;
   }// end public static Integer edit.
   /**
    * Deletes a grocery item from an array
    * 
    * @param list is the grocery list
    * @param listSize is the size of the grocery list
    * @return new size of the grocery list
    */
   public static Integer delete(String[] list, Integer listSize) {
      // get user input
      System.out.print("Enter the row number of the item you wish to delete: ");
      Scanner keyboard = new Scanner(System.in);
      try {
         // throws an exception if not an integer
         Integer row = keyboard.nextInt();
         // check for negative integers
         if (row <= 0) {
            System.out.println("ERROR: The integer cannot be negative or zero.");
         }
          // check for integer too big
         else if (row > listSize - 1) {
            System.out.println("ERROR: The integer is too big for the list.");
         } 
         else {
            // delete item by shifting items on the right of the item to the left
            for (int i = row; i < listSize; i++) {
               list[i] = list[i + 1];
            }
            // subtract one from the size (one item deleted from list)
            --listSize;
         }
      } 
      catch (InputMismatchException exception) {
         System.out.println("ERROR: You must enter an integer to delete an item.");
      }
      return listSize;
   }

   /**
    * Displays a grocery list
    * 
    * @param list is the grocery list
    * @param listSize is the size of the grocery list
    */
   public static void display(String[] list, Integer listSize) {
      // loop through the array
      for (int i = 0; i < listSize; i++) {
         // display headings
         if (i == 0) {
            System.out.println("Row  " + list[i]);
         }
          // display grocery list items as a numbered list
         else {
            System.out.println(i + ".   " + list[i]);
         }
      }
   }

   /**
    * Write grocery list array to file
    * 
    * @param list is the grocery list
    * @param listSize is the size of the grocery list
    */
   public static void writeToFile(String outputFile, String[] list,
       Integer listSize) {
      // "PrintWriter" is a Class Used To Write to A File.
      PrintWriter fileWriter = null;
      try {
         /*
          * Must use try-catch block, because PrintWriter may throw
          * FileNotFoundException, which is a checked exception. This will connect
          * to a file in the current directory. If the file does not exists, a new
          * file will be created. If the file does exists, the file will be
          * overwritten.
          */
         fileWriter = new PrintWriter(outputFile);
      } 
      catch (FileNotFoundException exception) {
         // Print error message.
         // In order to print double quotes("),
         // the escape sequence for double quotes (\") must be used.
         System.out.print("ERROR: File not found for \"");
         System.out.println(outputFile + "\"");
      }
      // if file opened successfully, then below code executes..
      // continue program if writeToFile is not "null"
      if (fileWriter != null) {
         // loop through list (grocery list) and write to file
         for (int i = 0; i < listSize; i++) {
            fileWriter.println(list[i]);
         }
         // REMEMBER: always give feedback to the user!
         System.out.println("Wrote to file \"" + outputFile + "\"");
         // WARNING: don't forget to close the file!
         // will not write to file if not closed!
         fileWriter.close();
      }// end of "if" statement for writeToFile
   
   }

}// end of class

