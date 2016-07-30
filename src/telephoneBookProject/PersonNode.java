package telephoneBookProject;

/**
 * stores each person's name and number
 * 
 * @author Igeta, David
 * @assignment ICS 211, Final Project
 * @date 05/13/2015
 */
public class PersonNode {
  //instantiate three data fields for each Person
  protected String personName;
  protected String personPhoneNum;
  protected PersonNode nextPerson;
  
  /**
   * constructor for PersonNode
   * @param sName is person's name
   * @param sPhoneNum is person's number
   * @param person is the next person node
   */
  public PersonNode(String sName, String sPhoneNum, PersonNode person) {
     personName = sName;
     personPhoneNum = sPhoneNum;
     nextPerson = person;
  }//end PersonNode constructor 
  
  /**
   * displays person's data
   * @returns the person's data as a string
   */
  public String toString() {
     String sResult = "";
     sResult = (personName + "," + personPhoneNum);
     return sResult;
  }//end toString() method
   
   /**
    * accesses data from personName data field
    * @returns the name of person
    */
  public String getName() {
     return personName;
  }//end getName() method
  
  /**
   * accesses data from personPhoneNum data field
   * @returns the person's phone number
   */
  public String getTelephoneNumber() {
     return personPhoneNum;
  }//end getTelephoneNumber() method
   
   /**
    * accesses data from nextPerson data field
    * returns the next person
    */
  public PersonNode getNext() {
     return nextPerson;
  }//end getNext() method
    
    /**
     * mutates/sets new data in nextPerson data field
     */
  public void setNext(PersonNode setNext) {
     nextPerson = setNext;
  }//end setNext() method
     
}//end class PersonNode
