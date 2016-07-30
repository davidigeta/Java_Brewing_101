package telephoneBookProject;

/**
 * manages data input for telephone book
 * 
 * @author Igeta, David
 * @assignment ICS 211, Final Project
 * @date 05/13/2015
 */
public class TelephoneBook {
  //size of LinkedList array
  private final int SIZE = 7;
  //initialize and instantiate array of 7 LinkedList elements
  private LinkedList[] listArray = new LinkedList[SIZE];
  
  /**
   * constructor for LinkedList
   */
  public TelephoneBook() {
     //data fields already initialized
  }//end TelephoneBook constructor
  
  /**
   * hashes sName (key) and assigns to LinkedList array
   * @param sName is person's name
   * @param sPhoneNum is person's phone number
   */
  public void insert(String sName, String sPhoneNum) {
     //sName is the key for hashtable
     assert sName != null: "The key must be non-null";
     //retrieves index where this element should be
     Integer myHash = Math.abs(sName.hashCode()) % SIZE;
     //LinkedList element = null;
     
     //if the index of LinkedList array is null
     if (listArray[myHash] == null) {
        LinkedList element = new LinkedList();
        listArray[myHash] = element;
        element.add(sName, sPhoneNum);
     }
     //it not empty just add to LinkedList of PersonNodes
     else {
        listArray[myHash].add(sName,sPhoneNum);
     }
  }//end insert() method
  
  /**
   * retrieves matching PersonNode from LinkedList array
   * @param sName is person's name (key)
   * @returns the matching PersonNode
   */
  public PersonNode retrieve(String sName) {
     PersonNode findPerson = null;
     String sResult = "";
     //retrieves index where this element should be
     Integer myHash = Math.abs(sName.hashCode()) % SIZE;
     //if index is null
     if (listArray[myHash] == null) {
        return null;
     }
     findPerson = listArray[myHash].get(sName);
     sResult = findPerson.getName();
     //if a name matches the sResult key
     if (sName.equals(sResult)) {
        return findPerson;
     }
     //if match is not found
     else {
        return null;
     }      
  }//end retrieve() method
  
  /**
   * deletes matching PersonNode from LinkedList array
   * @param sName (key) is the person's name
   * @returns the matching PersonNode
   */
  public PersonNode delete(String sName) {
     PersonNode removePerson = null;
     //retrieves index where this element should be
     Integer myHash = Math.abs(sName.hashCode()) % SIZE;
     String sResult = "";
     //if index is null
     if (listArray[myHash] == null) {
        return null;
     }
     removePerson = listArray[myHash].get(sName);
     sResult = removePerson.getName();
     //if a name matches the sResult key
     if (sName.equals(sResult)) {
        listArray[myHash].remove(sName);
        return removePerson;
     }
     //if match is not found
     else {
        return null;
     }
  }//end delete() method
  
  /**
   * displays LinkedList array of PersonNodes
   * returns array data elements
   */
  public String toString() {
     String sResult = "";
     LinkedList index = null;
     //loops through each index of LinkedList array
     for (int i = 0; i < SIZE; i++) {
        index = listArray[i];
        //in index is null or of length 0
        if (index == null || listArray[i].getSize() == 0) {
           sResult = sResult + ("table[" + i + "] => null \n");
        }
        //if index has greater than 0 PersonNodes 
        else {
           sResult = (sResult + "table[" + i + "]" + listArray[i] + "\n");   
        }   
     }
     return sResult;
  }//end toString() method
}//end TelephoneBook class
