package assignment07;

/**
 * 5 recursive methods printing strings.
 *
 * @author Igeta, David
 * @assignment ICS 211, Assignment #7
 * @date 2/6/2015
 */
 
public class IgetaDavid7 {
   /**
    * The main() method starts program
    * 
    * @param commandlineArguments[0] is a string inputted from user.
    */
   public static void main(String[] commandlineArguments) {
   //ensures user enters exactly ONE number in command line.
      if(commandlineArguments.length != 2) {
         System.out.println("ERROR: Please enter ONE integer and ONE string of text in the command line.");
      }
      else {
         try {
            //converts commandlineArguments[0] to integer.
            Integer iProduct = Integer.parseInt(commandlineArguments[0]);
            //instantiates a string from user's input.
            String sString = commandlineArguments[1];
            //displays error if iProduct is negative.
            if(iProduct < 0) {
               System.out.println("ERROR: Please enter a positive number.");
            }
            else {
               //integer prints each char of sString x number of time in methods below.
               Integer iCharCount = new Integer(2);
               Integer baseCase = new Integer(1);
               
               //method call prints string of x number of times based on user's input.  
               String printResult = IgetaDavid7.printString(iProduct, sString);
               System.out.println(printResult);
               
               //method call prints sString.charAt(0) x number of times based on user's input.
               printResult = IgetaDavid7.printCharAt(iProduct, sString);
               System.out.println(printResult);
               
               //method call prints each char in sString twice.
               printResult = IgetaDavid7.printTwice(iCharCount, sString);
               System.out.println(printResult);
               
               //method call prints each char in sString thrice backwards.
               printResult = IgetaDavid7.printThriceBackwards(iCharCount, sString);
               System.out.println(printResult);
               
               //method call to print decrementing length of string with recursion.
               printResult = IgetaDavid7.printCountDown(baseCase, iProduct, sString);
               System.out.println(printResult);
               
            }//end else
         }//end try statement
         //in case user's input cannot be converted to an integer.
         catch(NumberFormatException nfe) {
            System.out.println("ERROR: Please enter an integer value for your first entry.");
         }
         //in case user enters a huge integer number.
         catch(StackOverflowError soe) {
            System.out.println("ERROR: The number you entered is too large.");
         } 
      }//end else
   }//end main() method
   
   /**
    * Prints string of x number of times based on user's input.
    * 
    * @param baseCase determines how many times to print string.
    * @param sWord is the string inputted from user.
    * @returns a string of concatenated sUserString.
    */
   public static String printString(Integer baseCase, String sWord) {
      String sUserString = sWord;
      //base case as baseCase counts down
      if(baseCase.equals(1)) {
         return sUserString;
      }
      else {
         return IgetaDavid7.printString(baseCase - 1, sWord) + sUserString;
      }
   }//end printString method 
   
   /**
    * Prints sString.charAt(0) x number of times based on user's input.
    * 
    * @param baseCase determines how many times to print string.
    * @param sWord is the string inputted from user.
    * @returns a string of concatenated sUserString.
    */
   public static String printCharAt(Integer baseCase, String sWord) {
      String sChar = "" + sWord.charAt(0);
      //base case as baseCase counts down
      if(baseCase.equals(1)) {
         return sChar;
      }
      else {
         return IgetaDavid7.printCharAt(baseCase - 1, sWord) + sChar;
      }
   }//end printCharAt method
   
   /**
    * Prints each char in sWord twice.
    * 
    * @param iTwice prints each char twice.
    * @param sWord is the string inputted from user.
    * @returns a string of concatenated sWord.
    */
   public static String printTwice(Integer iTwice, String sWord) {
      int iLen = sWord.length();
      //base case when iLen == 1
      if(iLen == 0) {
         return sWord;
      }
      else {
         //base case prints each char twice
         if (iTwice > 1) {
            return IgetaDavid7.printTwice(iTwice - 1, sWord) + sWord.substring(iLen - 1, iLen);
         }
         //resets iTwice
         iTwice = 2;
         return IgetaDavid7.printTwice(iTwice, sWord.substring(0, iLen - 1)) + sWord.substring(iLen - 1, iLen);
      }
   }//end printTwice method
   
   /**
    * Prints each char in sWord thrice.
    * 
    * @param iThrice prints each char thrice.
    * @param sWord is the string inputted from user.
    * @returns a string of concatenated sWord.
    */
   public static String printThriceBackwards(Integer iThrice, String sWord) {
      int iLen = sWord.length();
      //base case when iLen == 1
      if(iLen == 0) {
         return sWord;
      }
      else {
         //base case prints each char thrice
         if (iThrice > 0) {
            return IgetaDavid7.printThriceBackwards(iThrice - 1, sWord) + sWord.substring(0, 1);
         }
         //resets iThrice
         iThrice = 2;
         return IgetaDavid7.printThriceBackwards(iThrice, sWord.substring(1, iLen)) + sWord.substring(0, 1);
      }   
   }//end printThriceBackwards method

   /**
    * Prints decrementing length of string with recursion.
    * 
    * @param baseCase is an integer.
    * @param iProduct is an integer length of sString.
    * @param sWord is the string inputted from user.
    * @returns a string of concatenated sCountDown.
    */  
   public static String printCountDown(Integer baseCase, Integer iProduct, String sWord) {
      int iLen = sWord.length();
      //integer that's printed before each string in reverse
      int iAdd = (iProduct - (iLen - 1));
      //checks if x is zero and skips assigning it to sCountDown
      if(iAdd == 0) {
         return IgetaDavid7.printCountDown(baseCase + 1, iProduct + 1, sWord);
      }
      String sCountDown = iAdd + " " + sWord.substring(iLen - baseCase, iLen) + ", ";
      //base case when iLen is approached
      if(baseCase == iLen) {
         return sCountDown;
      }
      else {
         return IgetaDavid7.printCountDown(baseCase + 1, iProduct + 1, sWord) + sCountDown;
      }   
   }//end printCountDown method
}//end public class
