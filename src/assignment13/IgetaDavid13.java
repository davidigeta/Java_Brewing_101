package assignment13;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.*;

/**
 * Postfix calculator program
 *
 * @author Igeta, David
 * @assignment ICS 211, Assignment #13
 * @date 2/27/2015
 */
public class IgetaDavid13 {
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
         IgetaDavid13.readFromFile(commandlineArguments[0]);
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
         System.out.println("Infix expression   = " + sLine);
         
         //converts infix to postfix
         String sPostfix = IgetaDavid13.displayPostFix(sLine);
         System.out.println(sPostfix + "\n");
      }//end while loop
   }//end readFromFile() method
   
   /**
    * converts infix to postfix
    *
    * @param sLine is a line read from file
    */      
   public static String displayPostFix(String sLine) {
      //instantiate stack of strings
      StackInterface<String> stack = new ArrayStack<String>();
      //boolean to determine if sChar is an integer or operator
      boolean bTrue = true;
      //instantiate an empty string	
      String sPostfixLine = new String();
      //counts how many left brackets in line
      int iBracketCount = 0;
      //counts how many right brackets in line
      int iBracket2Count = 0;
      
      //checks if sLine is empty
      if(sLine.length() < 1) {
         sPostfixLine = "ERROR: Bad character input.";
         return sPostfixLine;
      }   
      //loops through each char of sLine
      for(int i = 0; i < sLine.length(); i++){
         //isolates each character	
         String sChar = sLine.substring(i, i + 1);
         //checks for bad input
         if(sChar.equals("@") || sChar.equals("A")) {
            sPostfixLine = "ERROR: Bad character input.";
            return sPostfixLine;
         }
         //returns true if sChar is an operator
         boolean bOperator = IgetaDavid13.bOperator(sChar, bTrue);
         //pushes sChar onto stack if '('
         if(sChar.equals("(")) {
            //push sChar onto stack		
            stack.push(sChar);
            iBracketCount++;
         }
         //pushes sChar onto stack if a valid operator
         if(bOperator == true) {
            stack.push(sChar);
         }   
         //checks if sChar is an integer
         boolean isNumeric = IgetaDavid13.isNumeric(sChar, bTrue);
         //adds sChar to sPostfixLine if an integer
         if(isNumeric == true) {
            sPostfixLine = sPostfixLine + sChar;
         }
         //initialized here to be used in while loop nested in try statement below
         //boolean bPeek = true;
         try {
            if(sChar.equals(")")) {
               iBracket2Count++;
               
               //while(!stack.peek().equals(")") || bPeek == true) {
                 while(!stack.peek().equals(null)) {
                  if(stack.peek().equals("(")) {
                     stack.pop();  
                  }
                  else {
                     sPostfixLine = sPostfixLine + stack.pop(); 
                  }
                  //checks top item on stack
                  //bPeek = IgetaDavid13.bPeek(sChar, bTrue);
               }//end while   
            }//end if
         }//end try
        catch(EmptyStackException ese) {
         }          
      }//end for loop
      //checks if the number of left and right parentheses match up
      if(iBracketCount != iBracket2Count) {
         sPostfixLine = "ERROR: Bad character input.";
         return sPostfixLine;
      }
      return "Postfix expression = " + sPostfixLine;
   }//end displayPostfix() method
   
   /**
    * checks if sChar is an integer
    *
    * @param sChar is a line read from file
    * @param bNumeric is a boolean value
    * @returns if number is an integer
    */ 
   public static boolean isNumeric(String sChar, boolean bNumeric) {
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
}//end IgetaDavid13 class