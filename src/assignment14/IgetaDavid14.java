package assignment14;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.*;

/**
 * Postfix calculator program
 *
 * @author Igeta, David
 * @assignment ICS 211, Assignment #14
 * @date 3/3/2015
 */
public class IgetaDavid14 {
   /**
    * main() method begins program
    *
    * @param commandlineArguments is user's input
    */   
   public static void main(String[] commandlineArguments) {
      //checks if user enters a file name
      if(commandlineArguments.length != 1) {
         JOptionPane.showMessageDialog(null, "Please enter a file name in command line.");
         //terminates program
         System.exit(0);
      }
      else {
         //creates an array of file contents
         IgetaDavid14.readFromFile(commandlineArguments[0]);
      }
   }//end main() method
   
   /**
    * reads file content's
    *
    * @param sFileName is the name of file being read
    */      
   public static void readFromFile(String sFileName) {
      File myFile = new File(sFileName);
      //scanner object which reads from file
      Scanner fileReader = null;   
      try {
         //links scanner object to file.
         fileReader = new Scanner(myFile);
      }//end try statement
      catch (FileNotFoundException fnf) {
         JOptionPane.showMessageDialog(null, "ERROR: File not found for " + sFileName);
         //terminates program
         System.exit(1);
      } 
      System.out.println("Reading from file: " + sFileName + "\n");
      //fileReader reads each line from file.
      while(fileReader.hasNextLine()) {
         //stores each line from file trimmed
         String sLine = (fileReader.nextLine()).trim();
         System.out.println("Postfix expression = " + sLine);
         
         //calculates result of postfix expression
         String sResult = IgetaDavid14.displayResult(sLine);
         System.out.println(sResult + "\n");
      }//end while loop
   }//end readFromFile() method
   
   /**
    * calculates result of postfix expression
    *
    * @param sLine is a line read from file
    * @param returns the calculated result
    */      
   public static String displayResult(String sLine) {
      //instatiate stack of strings
      StackInterface<Integer> iStack = new LinkedStack<Integer>();
      //intitialize four integer variables to be used in for loop beginning on line 91
      Integer iNum1 = new Integer(0);
      Integer iNum2 = new Integer(0);
      Integer iResult = new Integer(0);
      Integer getResult = new Integer(0);
      //create string object
      String sResultLine = null;

      //boolean to determine if sChar is an integer or valid input
      boolean bTrue = true;
      //counts how many left brackets in line
      int iLeft = 0;
      //counts how many right brackets in line
      int iRight = 0;
      
      //checks if sLine is empty
      if(sLine.length() < 1) {
         sResultLine = "ERROR: Bad character input \" \".";
         return sResultLine;
      }
      //loops through each sLine character
      for(int i = 0; i < sLine.length(); i++) {
         //stores a character from sLine
         String sChar = sLine.substring(i, i + 1);
         //checks if sChar is valid input
         boolean bValid = IgetaDavid14.bValidData(sChar, bTrue);
         //checks if sChar is an integer
         boolean bNumber = IgetaDavid14.isNumeric(sChar, bTrue);
         //checks if sChar is a valid operator
         boolean bOperator = IgetaDavid14.bOperator(sChar, bTrue);
         
         try { 
            //returns sResultLine with error message if false
            if(bValid == false && bNumber == false) {
               sResultLine = "ERROR: Bad character input.";
               return sResultLine;
            }
            //if character can be converted to an integer
            if(bNumber == true) {
               //converts to integer and pushes to iStack
               iStack.push(Integer.parseInt(sChar));
            }
            //pop integers onto iNum2 and iNum1 from iStack to calculate result
            if(bOperator == true) {
               iNum2 = iStack.pop();
               iNum1 = iStack.pop();
               //checks for errors in sLine
               if(iNum2 == 0 || iNum1 == 0) {
                  sResultLine = "ERROR: Bad character input.";
                  return sResultLine;
               }//end nested if
               //push the result onto iStack
               else {
                  getResult = IgetaDavid14.getResult(sChar, iNum1, iNum2, iResult);
                  iStack.push(getResult);
               }
            }//end if
            //attach the result from top of iStack to sResultLine
            if(i == (sLine.length() - 1)) {
               sResultLine = "" + iStack.pop();
            }
         }//end try statement
         catch(EmptyStackException ese){
            sResultLine = "ERROR: Bad character input.";
            return sResultLine;
         }         
      }//end for loop
      return "Calculate result   = " + sResultLine;
   }//end displayPostfix() method
   
   /**
    * checks if sChar is an integer
    *
    * @param sChar is a line read from file
    * @param bNumeric is a boolean value
    * @returns if number is an integer
    */ 
   public static boolean isNumeric(String sChar, boolean bNumeric) {
      //sets bNumeric to default value true
      bNumeric = true;
      try {
         Integer.parseInt(sChar);
      }
      //will return false if not an integer
      catch (NumberFormatException nfe) {
         bNumeric = false;
      }
      return bNumeric;
   }//end isNumeric() method
   
   /**
    * checks if sChar is an operator
    *
    * @param sChar is a line read from file
    * @param bOperator is a boolean value
    * @returns true if an operator
    */ 
   public static boolean bOperator(String sChar, boolean bOperator) {
      switch(sChar) {
         case "+": bOperator = true;
            break;
         case "-": bOperator = true;
            break;
         case "/": bOperator = true;
            break; 
         case "%": bOperator = true;
            break;
         case "*": bOperator = true;
            break;         
         default:  bOperator = false;                                                   
      }//end switch
      return bOperator;
   }//end bOperator() method
   
   /**
    * checks if sChar is valid
    *
    * @param sChar is a line read from file
    * @param bValid is a boolean value
    * @returns true if valid
    */ 
   public static boolean bValidData(String sChar, boolean bValid) {
      switch(sChar) {
         case "+": bValid = true;
            break;
         case "-": bValid = true;
            break;
         case "/": bValid = true;
            break; 
         case "%": bValid = true;
            break;
         case "*": bValid = true;
            break;
         case "(": bValid = true;
            break; 
         case ")": bValid = true;
            break;            
         default:  bValid = false;                                                   
      }//end switch
      return bValid;
   }//end bValidData() method
   
   /**
    * calculates result of two integers
    *
    * @param sChar is a line read from file
    * @param iNum1 is a term
    * @param iNum2 is a term
    * @returns result to two integers
    */ 
   public static Integer getResult(String sChar, Integer iNum1, Integer iNum2, Integer iResult) {
      switch(sChar) {
         case "+": iResult = iNum1 + iNum2;
            break;
         case "-": iResult = iNum1 - iNum2;
            break;
         case "/": iResult = iNum1 / iNum2;
            break; 
         case "%": iResult = iNum1 % iNum2;
            break;
         case "*": iResult = iNum1 * iNum2;
            break;                                                           
      }//end switch
      return iResult;
   }//end bOperator() method
}//end IgetaDavid14 class