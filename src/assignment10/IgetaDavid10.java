package assignment10;

import javax.swing.JOptionPane;

/**
 * Person object with name and age data fields with phd() and birthday() methods.
 *
 * @author Igeta, David
 * @assignment ICS 211, Assignment #10
 * @date 2/17/2015
 */
 public class IgetaDavid10 {
   /*
    * main() method starts program
    *
    * @param args is command line input from user
    */
   public static void main(String[] args) {
      //ensures user enters three arguments in the command line
      if(args.length != 3) {
         JOptionPane.showMessageDialog(null, "Please enter a first name, last name, and an age.");
         //terminates program
         System.exit(0);
      }    
      try {
         //initializes integer variable for each Person's age
         Integer age1 = Integer.parseInt(args[2]);
         //checks if both ages inputted from user are greater than 0
         if(age1 < 1) {
            JOptionPane.showMessageDialog(null, "Please enter an age greater than zero.");
            //terminates program
            System.exit(0);   
         }
         else {
            Earthling earthling1 = new Earthling(args[0], args[1], age1);
            //prints each Earthling object
            JOptionPane.showMessageDialog(null, earthling1.toString());
            //prints earthling1 with phd() and birthday() methods
            earthling1.phd();
            earthling1.birthday();
            JOptionPane.showMessageDialog(null, earthling1.toString()); 
         }
      }//end try statement
      //in case cannot be converted to integer
      catch (NumberFormatException nfe) {
         JOptionPane.showMessageDialog(null, "Please enter a number for person's age.");
      }
   }//end main() method
   
 }//end IgetaDavid10 public class
 
 /*Stores a sPersonName and iPersonAge for each person.*/
 class Person {
   //data fields are protected because of Earthlings subclass
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
   
   /*includes a "Dr." prefix to data field sPersonName*/
   void phd() {
      sPersonName = "Dr. " + sPersonName;
   }
   
   /*increases data field iPersonAge by one*/
   void birthday() {
      iPersonAge++;
   }
 }//end Person class
 
 /*Stores sFamilyName for person.*/
 class Earthling extends Person {
   private String sFamilyName;
   
   /*
    * Constructs Person object and initializes three data fields
    *
    * @param sFirstName is person's first name
    * @param sLastName is person's last name
    * @param iAge is person's age
    */
   public Earthling(String sFirstName, String sLastName, Integer iAge) {
      //allows Earthling class to use the first name and age from Person class
      super(sFirstName, iAge);
      sFamilyName = sLastName;
   }//end Earthling constructor

   /*
    * toString displays the data stored in each data field from constructor
    *
    * @returns string of person's full name and age
    */
   public String toString() {
      String sResult = sPersonName + " " + sFamilyName + " is " 
                     + iPersonAge + " years old.";
      return sResult;
   }//end toString() method
 }//end Earthling class
 