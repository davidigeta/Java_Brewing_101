package assignment09;

import javax.swing.JOptionPane;

/**
 * Person object with name and age data fields with phd() and birthday() methods.
 *
 * @author Igeta, David
 * @assignment ICS 211, Assignment #9
 * @date 2/13/2015
 */
 public class IgetaDavid9 {
   /*
    * main() method starts program
    *
    * @param args is command line input from user
    */
   public static void main(String[] args) {
      //ensures user enters four arguments in the command line
      if(args.length != 4) {
         JOptionPane.showMessageDialog(null, "Please enter a name and an age in the command line.");
         //terminates program
         System.exit(0);
      }    
      try {
         //initializes integer variable for each Person's age
         Integer age1 = Integer.parseInt(args[1]);
         Integer age2 = Integer.parseInt(args[3]);
         //checks if both ages inputted from user are greater than 0
         if(age1 < 1 || age2 < 1) {
            JOptionPane.showMessageDialog(null, "Please enter an age greater than zero.");
            //terminates program
            System.exit(0);   
         }
         else {
            //creates two Person objects
            Person person1 = new Person(args[0], age1);
            Person person2 = new Person(args[2], age2);
            //prints each Person object
            JOptionPane.showMessageDialog(null, person1.toString());
            //prints person1 with phd() and birthday() methods
            person1.phd();
            person1.birthday();
            JOptionPane.showMessageDialog(null, person1.toString());
            
            JOptionPane.showMessageDialog(null, person2.toString());
            //prints person2 with phd() and birthday() methods
            person2.phd();
            person2.birthday();
            JOptionPane.showMessageDialog(null, person2.toString());
         }
      }//end try statement
      //in case cannot be converted to integer
      catch (NumberFormatException nfe) {
         JOptionPane.showMessageDialog(null, "Please enter a number each person's age.");
      }
   }//end main() method
   
 }//end IgetaDavid9 public class
 
 /*Stores a sPersonName and iPersonAge for each person.*/
 class Person {
   private String sPersonName;
   private Integer iPersonAge;
   
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
    * @returns a string of person's name and age
    */
   public String toString() {
      String sResult = (sPersonName + " is " + iPersonAge + " years old.");
      return sResult;
   }//end toString() method
   
   /*includes a "Dr." prefix to data field sPersonName*/
   void phd() {
      sPersonName = "Dr. " + sPersonName;
   }
   
   /*increases data field iPersonAge by one*/
   void birthday() {
      iPersonAge++;
   }
 }//end Person class
 