package assignment25;

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.File;

/**
 * Patient priority queue using heaps
 *
 * @author Igeta, David
 * @assignment ICS 211, Assignment #25
 * @date 4/17/2015
 */
public class IgetaDavid25 {
   //make a priority queue of patients
   private PriorityQueue<Patient> pQueue = new PriorityQueue<Patient>();
   //keeps track of the size of array
   private int iArraySize = 0;
   
    /**
     * main() method begins program
     *
     * @param args is user input for files
     */   
   public static void main(String[] args) {
      //checks if user entered two arguments  
      if(args.length != 2) {
         JOptionPane.showMessageDialog(null, "Please enter an input and output file name.");
         //terminates program
         System.exit(0);
      }
      else {
         //instantiates mainMenu
         IgetaDavid25 mainMenu = new IgetaDavid25();
         //calls method to display menu with args as the parameter
         mainMenu.displayMenu(args);
      }      
   }//end main() method
    
    /**
     * displays a menu to user
     * @param args is the file input/output from user
     */
   public void displayMenu(String[] args) {
      //calls method to read contents from input file
      try {
         this.readFromFile(args);
      }
      catch (Exception exception) {
         JOptionPane.showMessageDialog(null, "The file \" " + args[0] + " \" could not be found.");
         //terminates program
         System.exit(1);
      } 
      //sChoiceArray of strings iChoices in menu
      String[] sChoiceArray = { "New Patient", "Next Patient", "Exit Program"};
       //stores user's choice
      int iChoice = 0;
      //stores patient's name
      String sName = "";
      //stores patient's priority
      String sPriority = "";
      int iPriority = 0;
       //displays the menu to user  
      while (iChoice != sChoiceArray.length - 1 && iChoice != 2) {
         iChoice = JOptionPane.showOptionDialog(null, //parentComponent
             "Select an option:", //display message to user
             "Patient Scheduling Menu", //title of window
             JOptionPane.YES_NO_CANCEL_OPTION, //type of option
             JOptionPane.QUESTION_MESSAGE, //type of message
             null, //no icon
             sChoiceArray, //lists options
             sChoiceArray[2]); //sets default option
         if(iChoice == -1) {
             //terminates program
            System.exit(0);   
         }
         //user selects New Patient
         if(iChoice == 0) {
            sName = JOptionPane.showInputDialog(null, "Enter the patient's name:");
            //checks if input dialog is null
            if(sName != null && sName.length() > 0) {
               //keeps displaying error message until user enters correct input
               while(iPriority < 1 || iPriority > 10) {
                  sPriority = JOptionPane.showInputDialog(null, "Enter the patient's priority:");
                  try {
                     //converts sPriority to type integer
                     iPriority = Integer.parseInt(sPriority);
                     if(iPriority < 1 || iPriority > 10) {
                        JOptionPane.showMessageDialog(null,"The patient's priority is limited to a number from 1-10.");
                     }
                  }
                  catch(NumberFormatException nfe) {
                     JOptionPane.showMessageDialog(null, "Please enter a valid integer as a priority.");
                     //terminates program
                     System.exit(1);
                  }   
               }//end while loop
               //creates new patient object and adds to queue
               Patient patient1 = new Patient(sName, iPriority);
               //adds patient1 to the queue
               pQueue.offer(patient1);
               //increases array size
               iArraySize++;
               JOptionPane.showMessageDialog(null, "Patient \"" + patient1.getName() + "\"" + " was given priority " + patient1.getPriority() + ".");
            }//end nested if statement
         }//end first if statement
         //user selects Next Patient
         if(iChoice == 1) {
            if(pQueue.empty()) {
               JOptionPane.showMessageDialog(null, "There are no patients left in queue.");
               //terminates program
               System.exit(1);
            }
            else {
               //displays the next patient in queue
               JOptionPane.showMessageDialog(null,"The next patient is " + pQueue.peek());
               //remove patient from queue
               pQueue.poll();
               //decreases array size
               iArraySize--;
            }     
         }
         //user selects Exit Program
         if(iChoice == 2) {
            //asks user if they want to save changes
            iChoice = JOptionPane.showConfirmDialog(null, 
               "Do you want to save your changes?",//display message to user
               "Confirmation", //title of window
               JOptionPane.YES_NO_OPTION); //type of option
            if(iChoice == 0) {
               //writes queue to a text file
               this.writeToFile(args);
               //informs user the changes have been made
               JOptionPane.showMessageDialog(null, "Your changes have been saved!");
               //terminates program
               System.exit(0);
            }
            else if(iChoice == 1) {
               //terminates program
               System.exit(0);
            } 
         }//end outer if statement
      }//end while loop
   }//end displayMenu() method
   
   /**
    * reads file contents and adds to MyQueue object
    * @param args is the file input/output from user
    */
   private void readFromFile(String[] args) throws FileNotFoundException {
      File myFile = new File(args[0]);
      String sLine = "sLine";
      //instantiate fileReader and tokenComma scanners
      Scanner fileReader = null;
      Scanner tokenComma = null;
      //instatiate and initialize variable for patient's name and priority
      int iPriority = 0;
      String sName = "";
      
      try {
         //establishes connection with file and scanner object
         fileReader = new Scanner(myFile);
      }
      catch(FileNotFoundException fnf) {
         JOptionPane.showMessageDialog(null, "The file \"" + args[0] + "\" could not be found.");
         //terminates program
         System.exit(1);
      }   
      //skips the first line in file
      sLine = fileReader.nextLine();
        
      //loops until last line of file
      while(fileReader.hasNextLine()) {
         sLine = fileReader.nextLine();
         //separates tokens with a comma
         tokenComma = new Scanner(sLine).useDelimiter(",");
         iPriority = Integer.parseInt(tokenComma.next());
         sName = tokenComma.next();
         
         //creates new patient object and adds to queue
         Patient patient1 = new Patient(sName, iPriority);
         //adds patient1 to the queue
         pQueue.offer(patient1);
         //increases array size
         iArraySize++;
      }
      //closes fileReader
      fileReader.close();
   }//end readFromFile() method
    
    /**
     * writes the queue of patients to a text file
     * @param args is the file input/output from user
     */
   private void writeToFile(String[] args) {
      //initializes fileWriter
      PrintWriter fileWriter = null;
      String fileData = "";
      
      try {
         //makes connection to fileWriter and output file
         fileWriter = new PrintWriter(args[1]);
         //writes the column names to file
         fileWriter.println("priority, name");
         
         //polls from queue until empty
         for(int i = 0; i < iArraySize; i++) {
            //concatenates each record to fileData
            fileData = (fileData + pQueue.peek() + "\n");
            pQueue.poll();
         } 
      
          //cycles through each char of fileData
         for(int i = 0; i < fileData.length(); i++) {
            String sChar = fileData.substring(i, i + 1);
            //prints a newline if when a \n is encountered
            if(sChar.equals("\n")) {
               fileWriter.println();
            }
            //concatenates each char to form each word
            else {
               fileWriter.print(sChar);
            }      
         }//end for loop
         //closes the fileWriter 
         fileWriter.close(); 
      }//end try statement
      catch (FileNotFoundException fnf) {
         JOptionPane.showMessageDialog(null, "Please close file \"" + args[1] + "\" before saving.");
         //terminates program
         System.exit(1);
      }
   }//end writeToFile() method
}//end IgetaDavid25 class

//********************************************************************************

/**
 * stores patient's name and priority information
 *
 * @author Igeta, David
 * @assignment ICS 211, Assignment #25
 * @date 4/17/2015
 */
class Patient implements java.lang.Comparable<Patient> {
    //instantiate data fields
   protected String patientName;
   protected Integer patientPriority;
    
    /**
     * patient constructor
     * 
     * @param sName is the name of the patient
     * @param iPriority is the patient's priority in queue
     */
   public Patient(String sName, Integer iPriority) {
      patientName = sName;
      patientPriority = iPriority;
   }//end patient constructor
    
    /**
     * compares two patient's priorities
     *
     * @param patient2 is the second patient
     * @returns the difference
     */
   public int compareTo(Patient patient2) { 
      int result = 1;
      java.lang.Comparable iPriority = (java.lang.Comparable) patientPriority;
      java.lang.Comparable iPriority2 = (java.lang.Comparable) patient2.getPriority();
      /*
       * The commented code in this method was intended to compare two patients names
       * if their priorities were the same (lines 273-275, and lines 277-280)
       */
      //java.lang.Comparable sName = (java.lang.Comparable) patientName;
      //java.lang.Comparable sName2 = (java.lang.Comparable) patient2.getName();
      //compares the patient's priorities
      result = iPriority.compareTo(iPriority2);
      //if same then compare their names
      //if(result == 0) {
         //result = sName.compareTo(sName2);
      //}
      return result;
   }//end compareTo() method
    
    /**
     * prints the name of patient
     * @returns the patient's name as a string
     */
   public String toString() {
      String sResult = "";
      sResult = (patientPriority + "," + patientName);   
      return sResult;
   }
   
   /**
     * gets the priority of patient
     * @returns priority of patient
     */
   public Integer getPriority() {
      return patientPriority;
   }
   
   /**
     * gets the name of patient
     * @returns name of patient
     */
   public String getName() {
      return patientName;
   }
}//end Patient() class

//********************************************************************************