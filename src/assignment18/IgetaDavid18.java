package assignment18;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.*;

/**
 * Reads csv type file and displays sorted list
 *
 * @author Igeta, David
 * @assignment ICS 211, Assignment #18
 * @date 3/17/2015
 */
public class IgetaDavid18 {
   /**
    * main() method begins program
    *
    * @param commandlineArguments is the filename inputted from user
    */
   public static void main(String[] commandlineArguments) {
      //person's name
      String sName = "sName";
      //person's age
      Integer iAge = new Integer(0);
      //name of file
      String sFileName = "sFileName";
      //scanner object to read file contents
      Scanner fileReader = null;
      //scanner object with userDelimiter() method
      Scanner tokenComma = null;
      //string object stores each line from file
      String sLine = "sLine";
      //creates new LinkedList object
      LinkedList list = new LinkedList();
      //user's input for person's age
      String sUserInput = "";
      //user's input for person's age
      Integer iUserInput = new Integer(0);
      //used with bubbleSort() method
      Integer start = new Integer(0);
      //used with bubbleSort() method
      Integer end = new Integer(0);
      
      //checks if user entered a file name
      if(commandlineArguments.length != 1) {
         JOptionPane.showMessageDialog(null, "Please enter a file name in command line.");
         //terminates program
         System.exit(0);
      }
      sFileName = commandlineArguments[0];
      //creates new file object with the file name as a parameter
      File myFile = new File(sFileName);
      try {
         //links fileReader scanner object to the file object
         fileReader = new Scanner(myFile);
      }
      //throws if connection cannot be established
      catch(FileNotFoundException fnf) {
         JOptionPane.showMessageDialog(null, "File: " + sFileName + " was not found.");
         //terminates program
         System.exit(1);
      }
      //isolates first line of file - do not use
      sLine = fileReader.nextLine();
      try {
         //loops through each line of file
         while(fileReader.hasNextLine()) {
            //begins reading from second line in file
            sLine = fileReader.nextLine();
            //separates tokens with a comma
            tokenComma = new Scanner(sLine).useDelimiter(",");
            sName = tokenComma.next();
            iAge = Integer.parseInt(tokenComma.next());
            //creates a new person object for each line in list
            list.add(sName, iAge);
         }
         //displays result of all linked person objects
         JOptionPane.showMessageDialog(null, list.toString());
         end = list.getSize();
         //calls bubbleSort method to sort entries
         list.bubbleSort(start, end);
         //prints results
         JOptionPane.showMessageDialog(null,list.toString());

      }
      catch (NoSuchElementException nse) {
         //thrown when scanner object run into an empty space in file  
      }
      catch (NumberFormatException nfe) {
         System.out.println("ERROR: Cannot convert data to integer.");
      } 
   }//end main() method
}//end IgetaDavid18 class

//****************************************************************************************

/* creates linked list of PersonNode objects */
class LinkedList {
   //instantiate PersonNode data field - stores address to object
   private PersonNode head = null;
   private Integer size = new Integer(0);
   
   /**
    * constructor for LinkedList class data fields
    */
   public LinkedList() {
      //nothing, data fields already initialized
   }//end LinkedList constructor
      
   public void add(String name, Integer age) {
   	//if the list of PersonNode objects is empty
      if (head == null) {
         //creates and assigns to toPerson
         head = new PersonNode(name, age, null);
      }
      //if the list is not empty
      else {
         //previous points to the head
         PersonNode previous = head;
         //current starts at second node in list
         PersonNode current = head.getNext();
         //while the next node is not null
         while (current != null) {
         	//cycles through PersonNode objects until end of list
            previous = current;
            current = current.getNext();
         }
         //creates a new node that has "null" for next.
         PersonNode newPerson = new PersonNode(name, age, null);
         //sets the PersonNode previous to new node
         previous.setNext(newPerson);
         size++;
      }//end else
   }//end add() method
   
   /**
    * prints the list of PersonNode objects
    * @returns a string of concatenated sResults
    */   
   public String toString() {
   	//instantiate empty string
      String sResult = new String("");
   	//loop through all PersonNode objects in linked list
      for(PersonNode current = head; current != null; current = current.getNext()) {
      	//contatentes sResults until for loop is done
         sResult = sResult + current.toString() + "\n";
      }
      return sResult;
   }//end toString() method
   
   /**
	 * accesses data from data field size.
	 * 
	 * @return the size of the list
	 */
	public Integer getSize() {
		return size;
	}//end getSize() method
   /**
    * sorts PersonNodes' ages in ascending order
    *
    * @param
    */
   public void bubbleSort(int start, int end) {
      //temporary variables to store data for previous
      Integer ageTemp1 = new Integer(0);
      String nameTemp1 = new String("");
      //temporary variables to store data current
      Integer ageTemp2 = new Integer(0);
      String nameTemp2 = new String("");
      //previous points to the head
      PersonNode previous = head;
      //current starts at second node in list
      PersonNode current = head.getNext();
      
      //outer loop assigns PersonNode previous to each node in list
      for(int i = start + 1; i <= end; i++) {
         //inner loop compares two nodes at a time
         for(int j = 0; j <= end - i; j++) {
            //swaps if first person's age is greater then second person
            if(previous.getAge() > current.getAge()) {
               //retrieve previous PersonNode data
               ageTemp1 = previous.getAge();
               nameTemp1 = previous.getName();
               //retrieve current PersonNode data
               ageTemp2 = current.getAge();
               nameTemp2 = current.getName();
               //switch PersonNode previous and PersonNode current data with set() methods
               previous.setName(nameTemp2);
               previous.setAge(ageTemp2);
               current.setName(nameTemp1);
               current.setAge(ageTemp1);
            }
            //moves to next PersonNode if it's not null
            if(current.getNext() != null) {
               current = current.getNext();
            }   
         }//end for loop
         //assigns next PersonNode object to previous
         if(current.getNext() == null) {
            previous = previous.getNext();
            current = previous.getNext();
         }     
      }//end for loop
   }//end bubbleSort() method
}//end LinkedList class

//****************************************************************************************

/* stores data for each PersonNode object */
class PersonNode {
   //initialize three data fields set to private
   private String personName;
   private Integer personAge;
   private PersonNode personNext;
   
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
	 * @returns the printed results
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
   
   /**
	 * accesses data from data field personName.
	 * 
	 * @returns the new data
	 */
   public String getName() {
      return personName;
   }//end getName() method
   /**
	 * mutates or sets data in personName data field.
	 * 
	 * @returns the new data
	 */
   public void setName(String pName) {
      personName = pName;
   }//end setName() method
   /**
	 * accesses data from data field personAge.
	 * 
	 * @returns person's age
	 */
   public Integer getAge() {
      return personAge;
   }//end getAge() method
   /**
	 * mutates or sets data in personAge data field.
	 * 
	 * @returns the new data
	 */
   public void setAge(Integer pAge) {
      personAge = pAge;
   }//end setAge() method  
}//end PersonNode class

//****************************************************************************************