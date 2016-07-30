package assignment11;

import javax.swing.JOptionPane;
import java.lang.Comparable;

/**
 * Person objects with sorting.
 * 
 * @author Igeta, David
 * @assignment ICS 211, Assignment #11
 * @date 2/20/2015
 * @justify sorting method: quickSort is best for random data because it's O(n * log n).
 * @justify sorting method: chances of random data being in order is not likely and uses less space than mergeSort.
 */
 public class IgetaDavid11 {
   /**
    * main() method starts program
    *
    * @param args is command line input from user
    */
   public static void main(String[] args) {
      //ensures user enters ten arguments in the command line
      if(args.length != 10) {
         JOptionPane.showMessageDialog(null, "Please enter a name and an age for five (5) people.");
         //terminates program
         System.exit(0);
      }
      try {
         //initializes integer variables for each Person's age
         Integer age1 = Integer.parseInt(args[1]);
         Integer age2 = Integer.parseInt(args[3]);
         Integer age3 = Integer.parseInt(args[5]);
         Integer age4 = Integer.parseInt(args[7]);
         Integer age5 = Integer.parseInt(args[9]);
         //checks if user entered an age less than one
         if(age1 < 1 || age2 < 1 || age3 < 1 || age4 < 1 || age5 < 1) {
            JOptionPane.showMessageDialog(null, "Please enter ages greater than zero.");
            //terminates program
            System.exit(0);   
         }
         else {
            //instantiate five Person objects with a name and age
            Person person1 = new Person(args[0], age1);
            Person person2 = new Person(args[2], age2);
            Person person3 = new Person(args[4], age3);
            Person person4 = new Person(args[6], age4);
            Person person5 = new Person(args[8], age5);
            
            //instantiate a Person array of five Person objects
            Person[] sPersonArray = {person1, person2, person3, person4, person5};
            JOptionPane.showMessageDialog(null, sPersonArray);
            //to prevent automatic output of Sorting.java program
            Sorting.display = false;
            //parameters arrayName, start, end
            Sorting.quickSort(sPersonArray, 0, sPersonArray.length - 1);
            JOptionPane.showMessageDialog(null, sPersonArray);
         }
      }//end try statement
      //in case cannot be converted to integer  
      catch (NumberFormatException nfe) {
      JOptionPane.showMessageDialog(null, "Please enter a number for each person's age.");
      }
   }//end main() method
}//end IgetaDavid11 class

// *********************************************************************

 /*Stores a sPersonName and iPersonAge for each person.*/
 class Person implements Comparable {
   //data fields for person's name and age
   protected String sPersonName;
   protected Integer iPersonAge;
   
   /*
    * Constructs Person object and initializes two data fields
    *
    * @param sName is the person's name
    * @param iAge is the person's age
    */
   public Person(String sName, Integer iAge) {
      sPersonName = sName;
      iPersonAge = iAge;
   }//end Person constructor
   
   /*
    * toString displays the data stored in each data field from constructor
    *
    * @returns string of person's name and age
    */
   public String toString() {
      String sResult = (sPersonName + " is " + iPersonAge + " years old.");
      return sResult;
   }//end toString() method
   
   /**
   * Accessor method used to get person's age
   * 
   * @return person's age
   */
  public Integer getAge() {
    return iPersonAge;
  }//end getAge() method
  
  /**
   * compareTo() method compares to objects and returns an integer
   * 
   * @param oObj is name of Object
   * @return person's age
   */
   public int compareTo(Object oObj) {
      //casts Object parameter to Person class variable
      Person pPerson = (Person) oObj;
      //subtracts person1 from person2
      int iResult = this.getAge() - pPerson.getAge();
      return iResult;
   }//end compareTo() method
  
 }//end Person class 
 
 // *********************************************************************