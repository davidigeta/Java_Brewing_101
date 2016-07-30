package assignment08;

import javax.swing.JOptionPane;

/**
 * Person object with name and age data fields.
 *
 * @author Igeta, David
 * @assignment ICS 211, Assignment #8
 * @date 2/10/2015
 */
 public class IgetaDavid8 {
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
            JOptionPane.showMessageDialog(null, person2.toString());
         }
      }//end try statement
      //in case cannot be converted to integer
      catch (NumberFormatException nfe) {
         JOptionPane.showMessageDialog(null, "Please enter a number each person's age.");
      }
   }//end main() method
   
 }//end IgetaDavid8 public class
 
