package telephoneBookProject;

import javax.swing.JOptionPane;

/**
 * creates a linked list of PersonNode nodes
 * 
 * @author Igeta, David
 * @assignment ICS 211, Final Project
 * @date 05/13/2015
 */
public class LinkedList {
  //points to first node in the linked list of PersonNodes
  protected PersonNode head = null;
	//number of PersonNodes in list
  protected Integer size = new Integer(0);

  public LinkedList() {
  	//data fields already initialized
  }

	/**
	 * Adds person to front of the list
	 * @param sName is the person's name added
   * @param sPhoneNum is the person's phone number added      
	 */
  public void add(String sName, String sPhoneNum) {
  	//if list is empty
     if (head == null) {
     	//make new node and assign to head of list
        head = new PersonNode(sName, sPhoneNum, null);
     }
     //if list is not empty
     else {
        //creates new PersonNode with the current head as the nextPersonNode
        PersonNode newNode = new PersonNode(sName,sPhoneNum, head);
        //assigns the newNode as the new head of linked list
        head = newNode;
     }
  	//increase size of list
     size++;
  }

	/**
	 * gets person's address from the list.
	 * 
	 * @param position of a person in the list.
	 * @returns the address to the requested person
	 */ 
  public PersonNode get(String searchKey) {
     PersonNode previous = head;
     //second node in list
     PersonNode current = head.getNext();
     //check if empty list
     if (head == null) {
        JOptionPane.showMessageDialog(null, "Cannot get a person from an empty list!");
     }
     else {
        String sSecondNum = "";
     	//searches until it finds match or hits end of the list
        try {
           while (!current.equals(null) || !searchKey.equals(sSecondNum)) {
              //gets value of previous' phone number
              sSecondNum = previous.getName();
              //moves forward to next node if numbers don't match
              if(!searchKey.equals(sSecondNum)) { 
                 previous = current;
                 current = current.getNext(); 
              }
              else {
                 return previous;
              }  
           }//end while loop
        }
        catch(NullPointerException npe) {
           //caught if no match is found
        }
     }//end else
     return previous;
  }//end get() method
  
	/**
	 * Removes a person from list.
	 * @param searchKey is the person's name.
   * @returns whether a PersonNode was removed or not
	 */
  public boolean remove(String searchKey) {
     PersonNode previous = null;
     PersonNode current = null;
     String sName = "";
     boolean bContinue = true;
  
     try {
        //checks if list is empty
        if (head.equals(null)) {
           JOptionPane.showMessageDialog(null, "There are no records to be deleted!");
           return false;   
        }   
        //if deleting first node in list
        if (searchKey.equals(head.getName())) {
           head = head.getNext();
           size--;
           return true;
        }
        //if not first node in list
        else {
           previous = head;
           //second PersonNode in list
           current = head.getNext();
           //if a match is found
           while (!sName.equals(searchKey) && bContinue == true) {
              sName = current.getName();
              if (sName.equals(searchKey)) {
                 bContinue = false;
              }
              else {
                 previous = current;
                 current = current.getNext();
              }   
           }//end while loop
           //points previous node to node after current node.
           previous.setNext(current.getNext());
        }//end first else statement
     }//end try statement
     catch(NullPointerException npe) {
        //caught if no match is found
        return false;
     }
     size--;
     return true;
  }//end remove() method

	/**
	 * displays PersonNode data
	 * @returns a string from list in csv format
	 */
  public String toString() {
     String csvFormat = "";
     int i = 0;
  	//loops through all the PersonNode nodes in linked list
     for (PersonNode current = head; current != null; current = current.getNext()) {
     	//keep adding to end of string
        csvFormat = csvFormat + " => " + current.toString();
        i++;
     }
     return csvFormat;
  }//end toString() method

	/**
	 * accessor/get method for data field size.
	 * @return the size of the list
	 */
  public Integer getSize() {
     return size;
  }//getSize() method
}//end LinkedList class
