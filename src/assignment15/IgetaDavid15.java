package assignment15;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.*;

/**
 * Grocery list with nodes
 *
 * @author Igeta, David
 * @assignment ICS 211, Assignment #15
 * @date 3/6/2015
 */
public class IgetaDavid15 {
   /**
    * main() method begins program
    *
    * @param args is input from user
    */
   public static void main(String[] args) {
      //initialize each iAge variable
      Integer iAge1 = new Integer(0);
      Integer iAge3 = new Integer(0);
      Integer iAge5 = new Integer(0);
      Integer iAge7 = new Integer(0);
      Integer iAge9 = new Integer(0);
      //stores all person objects at once
      String sResult = "";
      //checks if user enters a file name
      if(args.length != 10) {
         JOptionPane.showMessageDialog(null, "Please enter a name and age for 5 people.");
         //terminates program
         System.exit(0);
      }
      //checks if user entered a integer value for each person's age     
      try {
         iAge1 = Integer.parseInt(args[1]);
         iAge3 = Integer.parseInt(args[3]);
         iAge5 = Integer.parseInt(args[5]);
         iAge7 = Integer.parseInt(args[7]);
         iAge9 = Integer.parseInt(args[9]);
      }//end try
      catch(NumberFormatException nfe) {
         JOptionPane.showMessageDialog(null, "Please enter a valid age for each person.");
         //terminate program
         System.exit(1);
      }
      //instatiate five PersonNode objects
      PersonNode person1 = new PersonNode(args[0], iAge1, null);
      PersonNode person2 = new PersonNode(args[2], iAge3, null);
      PersonNode person3 = new PersonNode(args[4], iAge5, null);
      PersonNode person4 = new PersonNode(args[6], iAge7, null);
      PersonNode person5 = new PersonNode(args[8], iAge9, null);
      //link nodes together
      person1.setNext(person2);
		person2.setNext(person3);
		person3.setNext(person4);
		person4.setNext(person5);
		person5.setNext(null);
      
      //prints each person object with a for loop until next person object is null
      for(PersonNode i = person1; i != null; i = i.getNext()) {
         sResult = sResult + "\n" + i.toString();
      }
      JOptionPane.showMessageDialog(null, sResult); 
   }//end main() method   
}//end IgetaDavid15 class

//********************************************************************************

/*stores data for PersonNode object */
class PersonNode {
   //initialize three data fields set to protected in case of future subclasses
   protected String personName;
   protected Integer personAge;
   protected PersonNode personNext;
   /**
    * constructor initializes data fields and creates objects
    * 
    * @param sName is the name of person
    * @param iAge is the age of person
    * @param pNext is the next object in queue 
    */
   public PersonNode(String sName, Integer iAge, PersonNode pNext) {
      personName = sName;
      personAge = iAge;
      personNext = pNext;
   }//end PersonNode constructor
   
   /**
	 * displays data stored in each node.
	 * 
	 * @returns the data
	 */
   public String toString() {
       String sResult = personName + " is " + personAge + " years old.";
       return sResult;
   }//end toString() method
   
   /**
	 * accesses data from data field personNext.
	 * 
	 * @returns the data
	 */
   public PersonNode getNext() {
      return personNext;
   }//end getNext() method
   
   /**
	 * mutates or sets data in personNext data field.
	 * 
	 * @returns the new data
	 */
   public void setNext(PersonNode pNext) {
      personNext = pNext;
   }//end setNext() method 
}//end PersonNode class

//********************************************************************************