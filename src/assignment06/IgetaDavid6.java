package assignment06;

/**
 * 5 recursive methods with base cases.
 *
 * @author Igeta, David
 * @assignment ICS 211, Assignment #6
 * @date 2/3/2015
 */
 
public class IgetaDavid6 {
   /**
    * The main() method begins program.
    * 
    * @param commandlineArguments user input string.
    */
   public static void main(String[] commandlineArguments) {
      //ensures user enters exactly ONE number in command line.
      if(commandlineArguments.length != 1) {
         System.out.println("ERROR: Please enter ONE number in the command line.");
      }
      else {
         try {
            //converts commandlineArguments[0] to integer
            Integer iMyNum = Integer.parseInt(commandlineArguments[0]);
            //displays error if input is less than 1.
            if(iMyNum < 1) {
               System.out.println("ERROR: Please enter a number greater than 0.");
            }
            else {
               //integer objects are instantiated here and explained for each method below.
               Integer iZero = new Integer(0);
               Integer iResult = new Integer(0);
               Integer iAdd = new Integer(2);
               Integer iMyNum2 = new Integer(iMyNum);
               Integer iMyNum3 = new Integer(iMyNum);
               
               //method call prints string of x number of asterisks based on user's input.  
               String printResult = IgetaDavid6.printAsterisks(iMyNum);
               System.out.println(printResult);
               
               //method call prints a string of descending numbers based on user's input.
               printResult = IgetaDavid6.descendingNum(iMyNum, iZero);
               System.out.println(printResult);
               
               //method call prints a string of ascending numbers based on user's input.
               printResult = IgetaDavid6.ascendingNum(iMyNum);
               System.out.println(printResult);
               
               //method call prints sum of number 0 to x incrementing by 1
               Integer printIntResults = IgetaDavid6.sigmaNum(iMyNum, iMyNum2, iMyNum3);
               System.out.println(printIntResults);
               
               //method call prints sum of powers of 2 up to xth power.
               printIntResults = IgetaDavid6.powerOfNum(iResult, iAdd, iMyNum, iZero, iMyNum3);
               System.out.println(printIntResults);  
            }//end else  
         }//end try statement
         //in case user's input cannot be converted to an integer.
         catch(NumberFormatException nfe) {
            System.out.println("ERROR: Please enter an integer value.");
         }
         //in case user enters a huge integer number.
         catch(StackOverflowError soe) {
            System.out.println("ERROR: The number you entered is too large.");
         }      
      }//end else
   }//end main() method.
   
   /**
    * Prints a string of x number of asterisks inputed from user.
    * 
    * @param iCount is user's command line input.
    * @returns a string of concatenated sAsterisks.
    */
   public static String printAsterisks(Integer iCount) {
      String sAsterisks = "*";
      //base case when iCount hits 1.
      if(iCount == 1) {
         return sAsterisks;
      }
      else {
         return IgetaDavid6.printAsterisks(iCount - 1) + sAsterisks;
      }
   }//end public static printAsterisks.
   
  /**
   * Prints string of numbers in descending order.
   * 
   * @param iHi is user's command line input.
   * @param iLo is equal to zero.
   * @returns string sHiLo of concatentated numbers in descending order.
   */
   public static String descendingNum(Integer iHi, Integer iLo) {
      String sHiLo = Integer.toString(iLo) + ", ";
      //base case
      if(iLo == iHi) {
         return sHiLo;
      }
      else {
         return IgetaDavid6.descendingNum(iHi, iLo + 1) + sHiLo;
      }
   }//end public static descendingNum.
   
   /**
    * Prints a string of numbers in ascending order.
    * 
    * @param iHi is user's command line input.
    * @returns string sLoHi of concatenated numbers in ascending order.
    */      
   public static String ascendingNum(Integer iHi) {
      String sLoHi = Integer.toString(iHi) + ", ";
      //base case
      if(iHi == 0) {
         return sLoHi;
      }
      else {
         return IgetaDavid6.ascendingNum(iHi - 1) + sLoHi;
      }
   }//end public static ascendingNum
   
   /**
    * Prints the result of sigma(x).
    * 
    * @param iResult is the sum of integers.
    * @param iAdd adds to iResult.
    * @param baseCase is the sentinal value to terminate method.
    * @returns integer iResult which is the sum of sigma(x).
    */
   public static Integer sigmaNum(Integer iResult, Integer iAdd, Integer baseCase) {
     //base case
      if(baseCase == 0) {
         return iResult;
      }
      else {
         //takes the sigma values of sigma(x)
         iResult = iResult + (iAdd - 1);
         return IgetaDavid6.sigmaNum(iResult, iAdd - 1, baseCase - 1);
      }
   }//end public static sigmaNum
   
   /**
    * Prints the sum of sigma(2^x).
    * 
    * @param iResult is the result of the sum of sigma(2^x).
    * @param iAdd incrementally adds values to iResult.
    * @param iMax = commandlineArgument[0] converted to an integer.
    * @param iExp is an integer counter for exponents.
    * @param baseCase = commandlineArgument[0].
    * @returns integer iResult, sum of sigma(2^x).
    */
   public static Integer powerOfNum(Integer iResult, Integer iAdd, Integer iMax, Integer iExp, Integer baseCase) {
     //base case
      if(baseCase == -1) {
         return iResult;
      }
      else {
         //adds the value of 2^0 to iResult
         if(iExp == 0) {
            iResult += 1;
            return IgetaDavid6.powerOfNum(iResult, iAdd, iMax, iExp + 1, baseCase - 1);
         }
         //adds the value of 2^1 to iResult
         if(iExp == 1) {
            iResult += 2;
            return IgetaDavid6.powerOfNum(iResult, iAdd, iMax, iExp + 1, baseCase - 1);
         }
         //adds the values of 2^x, where x is greater than 1, to iResult
         if(iExp <= iMax) {
            iAdd = iAdd * 2; 
            iResult = iResult + iAdd;
            return IgetaDavid6.powerOfNum(iResult, iAdd, iMax, iExp + 1, baseCase - 1);
         }
         return IgetaDavid6.powerOfNum(iResult, iAdd, iMax, iExp, baseCase); 
      }//end else.
   }//end public static powerOfNum.
}//end public class IgetaDavid6.
