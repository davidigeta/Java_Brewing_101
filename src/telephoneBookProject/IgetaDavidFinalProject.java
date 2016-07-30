package telephoneBookProject;

import javax.swing.JOptionPane;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.util.*;

/**
 * TelephoneBook Final Project with hashing
 * 
 * @author Igeta, David
 * @assignment ICS 211, Final Project
 * @date 05/13/2015
 */
public class IgetaDavidFinalProject {
   //create object with TelephoneBook class
   TelephoneBook book = new TelephoneBook();
   
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
         IgetaDavidFinalProject mainMenu = new IgetaDavidFinalProject();
         //calls method to display menu with args as the parameter
         mainMenu.displayMenu(args);
      } 
   }//end main() method
   
   public void displayMenu(String[] args) {
      //menu choices
      String[] sChoiceArray = {"Insert Phone Number", //iMenuChoice 0
                              "Retrieve Phone Number",//iMenuChoice 1
                              "Delete Phone Number",  //iMenuChoice 2
                              "Display Phone Book",   //iMenuChoice 3
                              "End Program"};         //iMenuChoice 4
      //user's choice
      int iMenuChoice = 0;
      //person's phone number
      String sPhoneNum = "";
      //person's name
      String sName = "";
      //sentinel value to continue program
      boolean bContinue = false;
      //valid phone number
      boolean bPhoneLen = false;
      
      try {
         //call readFromFile() method here before menu is presented to user
         this.readFromFile(args);
      }
      catch (Exception myException) {
         JOptionPane.showMessageDialog(null, "ERROR: The file \"" + args[0] + "\" could not be found.");
         //terminates program
         System.exit(1);
      } 
      
      //displays the menu to user while user doesn't exit or close window 
      while (iMenuChoice != sChoiceArray.length - 1 && iMenuChoice != -1) {
         iMenuChoice = JOptionPane.showOptionDialog(null, //parentComponent
            "Select an option below:",                    //display message to user
            "Telephone Book Menu",                        //title of window
            JOptionPane.YES_NO_CANCEL_OPTION,             //type of option
            JOptionPane.QUESTION_MESSAGE,                 //type of message
            null,                                         //no icon
            sChoiceArray,                                 //lists options
            sChoiceArray[4]);                             //sets End Program as default option
            
         switch (iMenuChoice) {
            case 0: 
               //error checking for user input of name 
               while (bContinue == false) {
                  sName = JOptionPane.showInputDialog(null, "Enter person's name:");
                  //if sName is null
                  if (sName == null || sName.equals("")) {
                     JOptionPane.showMessageDialog(null, "Please enter a name.");
                  }
                  else {
                     bContinue = true;
                  }   
               }//end outer while loop   
               //reset bContinue
               bContinue = false;
               
               //error checking for user input number
               while(bContinue == false) {
                  sPhoneNum = JOptionPane.showInputDialog(null, "Enter person's telephone number: ");
                  try {
                     //calls method to check phone number validity
                     bPhoneLen = this.validPhoneNum(sPhoneNum);
                  }
                  catch (NullPointerException npe) {
                     //throws if user enters cancel or exits window
                  }   
                  //phone number is invalid
                  if(bPhoneLen == false) {
                     JOptionPane.showMessageDialog(null, 
                        "Please enter a phone number in the following format: 123-4567");
                  }
                  //if true
                  else {
                     bContinue = true;
                  }
               }//end while loop
               //reset bContinue
               bContinue = false;
               
               //converts name to upper case and trims
               sName = sName.toUpperCase().trim();
               sPhoneNum = sPhoneNum.trim();
               //calls insert() method from TelephoneBook class
               book.insert(sName, sPhoneNum);
               JOptionPane.showMessageDialog(null, "The record \"" + sName + 
                  "\" has been successfully added!");
               //end case 0
               break;
            case 1:
               while(bContinue == false) {  
                  sName = JOptionPane.showInputDialog(null, 
                     "Enter person's name to retrieve phone number:");
                   //checks if user input is greater than 0
                  if(sName == null || sName.length() < 1) {
                     JOptionPane.showMessageDialog(null, 
                        "Please enter a name.");
                  }
                  //if valid convert to uppercase and trim input
                  else {
                     sName = sName.toUpperCase().trim();
                     bContinue = true;
                  }
               }//end while loop
               //reset bContinue
               bContinue = false;
               //calls method to retrieve record and assigns to retievePerson
               PersonNode retrievePerson = book.retrieve(sName);
               //if a record match is not found
               if (retrievePerson == null) {
                  JOptionPane.showMessageDialog(null, "The record \"" + sName + "\" could could not be found.");
               }
               else {
                  //calls method to get PersonNode's telephone number
                  JOptionPane.showMessageDialog(null, "The telephone number is: " + retrievePerson.getTelephoneNumber());
               }   
               //end case 1         
               break;  
            case 2:  
               while(bContinue == false) {  
                  sName = JOptionPane.showInputDialog(null, "Enter person's name to be deleted:");
                  //checks if input length is greater than 0
                  if(sName == null || sName.length() < 1) {
                     JOptionPane.showMessageDialog(null, "Please enter a person's name.");
                  }
                  //else convert to uppercase and trim input
                  else {
                     sName = sName.toUpperCase().trim();
                     bContinue = true;
                  }
               }//end while loop
               //reset bContinue
               bContinue = false;
               PersonNode deletePerson = null;
               try {
                  //call method to delete record below
                  deletePerson = book.delete(sName);
               }
               catch (NullPointerException npe) {
                  //throws if index is null
               }   
               //if a match was not found
               if (deletePerson == null) {
                  JOptionPane.showMessageDialog(null, "The record \"" + sName + 
                     "\" could not be deleted because it does not exist.");
               }
               else {
                  //calls method to get PersonNode's name
                  JOptionPane.showMessageDialog(null, deletePerson.getName() + " has been successfully deleted!");
               }   
               //end case 2
               break;
            case 3:  System.out.println(book); //calls toString() method in TelephoneBook class
               break;
            case 4:  
               iMenuChoice = JOptionPane.showConfirmDialog(null,
                  "Do you want to save your changes?",//display message to user
                  "Exit Confirmation", //title of window
                  JOptionPane.YES_NO_OPTION); //type of option
               if(iMenuChoice == 0) {
                  //writes queue to a text file
                  this.writeToFile(args);
                  //informs user the changes have been made
                  JOptionPane.showMessageDialog(null, "Your changes have been saved!");
                  //terminates program
                  System.exit(0);
               }
               //if user selects 'NO' or closes window
               else if(iMenuChoice == 1 || iMenuChoice == -1) {
                  System.out.println("Unsaved Changes! " + "\nTerminating Program..."
                           + "\n//////////////////////////////////////////////////\n");
                  //terminates program
                  System.exit(0);
               }                           
         }//end switch
      }//end while      
   }//end displayMenu() method
   
   /**
    * method returns true if a valid phone number
    *
    * @param sPhoneNum is phone number inputted from user
    * @returns validity of number
    */
   private boolean validPhoneNum (String sPhoneNum) {
      String sChar = "";
      int i = 0; //counter loop
      int j = 0; //counts number of hyphens
      final int HYPHEN = 1; //number of hyphen that should be in number
      final int PHONE_LEN = 8; //lenght of phone number
      //loops through user input
      for (i = 0; i < sPhoneNum.length(); i++) {
         sChar = sPhoneNum.substring(i, i + 1);
         try {
            //if sChar is a hyphen, count it
            if (sChar.equals("-")) {
               i++;
               j++;
            }
            else {
               //tries to parse sChar to int
               Integer.parseInt(sChar);
            }
         }
         catch (NumberFormatException nfe) {
            //if a char is not a number or a hyphen, quit
            return false;
         }
      }//end for loop
      //only valid only if one hyphen and length of 8
      if (i != PHONE_LEN || j != HYPHEN) {
         return false;
      }
      else {
         return true;
      }      
   }//end validPhoneNum() method
    
   /**
    * reads file contents and adds to PersonNode
    * @param args is the file input/output from user
    */
   private void readFromFile(String[] args) throws FileNotFoundException {
      //instantiates and initializes File object
      File myFile = new File(args[0]);
      //instantiate fileReader and tokenComma scanners here for scope
      Scanner fileReader = null, tokenComma = null;
      //instatiate and initialize file line, person's name/number
      String sLine = "", sName = "", sPhoneNum = "";
   
      //establishes connection with file and scanner object
      fileReader = new Scanner(myFile);
      //skips column title line in file
      sLine = fileReader.nextLine();
      //loops until last line of file
      while(fileReader.hasNextLine()) {
         sLine = fileReader.nextLine();
         //separates tokens with a comma
         tokenComma = new Scanner(sLine).useDelimiter(",");
         sName = tokenComma.next();
         sPhoneNum = tokenComma.next();
         //creates a new record for each line in file 
         book.insert(sName, sPhoneNum);
      }
      //closes fileReader
      fileReader.close();
      System.out.println("Reading from input file: " + args[0] + "...\n");
   }//end readFromFile() method
   
   /**
     * writes LinkedList array of PersonNodes to csv file
     * @param args is the file input/output from user
     */
   private void writeToFile(String[] args) {
      //initializes fileWriter
      PrintWriter fileWriter = null;
      String fileData = "";
      //skips each instance of table[i] when written to file
      final int SKIP = 11; 
      
      try {
         //makes connection to fileWriter and output file
         fileWriter = new PrintWriter(args[1]);
         //writes the column names to file
         fileWriter.println("Name, Telephone");
         
         //concatenates each record to fileData
         fileData = (fileData + book + "\n");
      
          //cycles through each char of fileData
         for(int i = SKIP; i < fileData.length(); i++) {
            String sChar = fileData.substring(i, i + 1);
            
            switch (sChar) {
               case "=":   //do nothing
                  break;
               case ">":   fileWriter.println();
                  break;
               case "\n":  fileWriter.println();
                           //skips the 'table[i]' whenever a new line is encountered
                           i += SKIP;
                  break;            
               case "n":   //do nothing
                  break;
               case "u":   //do nothing
                  break;
               case "l":   //do nothing
                  break;                                                                                     
               default:    fileWriter.print(sChar);                              
            }//end switch statement
         }//end for loop
         //closes the fileWriter 
         fileWriter.close();
         System.out.println("Saved to \"" + args[1] + "\"" + "\nTerminating Program..."
                           + "\n//////////////////////////////////////////////////\n");
      }//end try statement
      catch (FileNotFoundException fnf) {
         JOptionPane.showMessageDialog(null, "Please close file \"" + args[1] + "\" before saving.");
         //terminates program
         System.exit(1);
      }
   }//end writeToFile() method

}//end IgetaDavidFinalProject class
