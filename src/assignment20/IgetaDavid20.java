package assignment20;

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.File;

/**
 * File input/output queues using nodes
 *
 * @author Igeta, David
 * @assignment ICS 211, Assignment #20
 * @date 3/31/2015
 */
public class IgetaDavid20 {
   //make a queue of nodes
   private LinkedQueue<String> queue = new MyQueue<String>();

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
         IgetaDavid20 mainMenu = new IgetaDavid20();
         //calls method to display menu
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
      String[] sChoiceArray = { "Offer Person", "Poll Person", "Peek Person", "Display Queue", "Exit Program"};
       //stores user's choice
      int iChoice = 0;
      //stores user's input
      String sInput = "";
       //displays the menu to user  
      while (iChoice != sChoiceArray.length - 1 || iChoice != -1) {
         iChoice = JOptionPane.showOptionDialog(null, //parentComponent
             "Press a Button", //display message to user
             "People Queue", //title of window
             JOptionPane.YES_NO_CANCEL_OPTION, //type of option
             JOptionPane.QUESTION_MESSAGE, //type of message
             null, //no icon
             sChoiceArray, //lists options
             sChoiceArray[4]); //sets default option
         if(iChoice == -1) {
             //terminates program
            System.exit(0);   
         }
         if(iChoice == 0) {
            sInput = JOptionPane.showInputDialog(null, "Enter a Person's name:");
            if(sInput != null && sInput.length() > 0) {
               //adds name to the end of the queue
               queue.offer(sInput);
               JOptionPane.showMessageDialog(null, "\"" + sInput + "\"" + " was successfully added to the end of the line!");
            }    
         }
         if(iChoice == 1) {
            //removes name at beginning of the queue
            JOptionPane.showMessageDialog(null, queue.poll() + " is next in line.");   
         }
         if(iChoice == 2) {
            //displays who's at the front of the queue
            JOptionPane.showMessageDialog(null, queue.peek() + " is in front of the line.");   
         }
         if(iChoice == 3) {
            //calls method to display the person queue
            this.displayQueue();   
         }
         if(iChoice == 4) {
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
      
      Scanner fileReader = new Scanner(myFile);  
      //loops until last line of file
      while(fileReader.hasNextLine()) {
         sLine = fileReader.nextLine();
         //adds each line to the queue
         queue.offer(sLine);
      }
      //closes fileReader
      fileReader.close();
   }//end readFromFile() method
   
    /**
     * displays the queue to user
     */
   private void displayQueue() {
      String showQueue = queue.toString();
      JOptionPane.showMessageDialog(null, showQueue);
   }//end displayQueue() method
    
    /**
     * writes the queue of names to a text file
     * @param args is the file input/output from user
     */
   private void writeToFile(String[] args) {
      //initializes fileWriter
      PrintWriter fileWriter = null;
      try {
         //makes connection to fileWriter and output file
         fileWriter = new PrintWriter(args[1]);
      }
      catch (FileNotFoundException fnf) {
         JOptionPane.showMessageDialog(null, "Sorry! Changes could not be saved.");
      }
      //stores contents of file 
      String fileData = queue.toString();
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
      }
      //closes the fileWriter 
      fileWriter.close(); 
   }//end writeToFile() method
}//end IgetaDavid20 class

//********************************************************************************

/**
 * Stores data fields derived from LinkedQueue() method
 *
 * @author Igeta, David
 * @assignment ICS 211, Assignment #20
 * @date 3/31/2015
 */
class MyQueue<T> extends LinkedQueue<T> {
    //no additional data fields in MyQueue
   public MyQueue() {
      super();
   }//end MyQueue constructor
    
    /**
     * prints the queue to a string
     * @returns the data as a string
     */
   public String toString() {
      String sResult = "";
      Node<T> frontNode = endNode.getNext();
      //loops from first node to the last node
      while(!frontNode.equals(endNode)) {
         sResult = sResult + frontNode.getData() + "\n";
         frontNode = frontNode.getNext();
      }
      //adds the lastNode that while loop missed to sResult
      sResult = sResult + endNode;
      return sResult;
   }
}//end MyQueue() class

//********************************************************************************