package assignment08;

/*Stores a sPersonName and iPersonAge for each person.*/
public class Person {
  private String sPersonName;
  private Integer iPersonAge;
  
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
   * @returns a string of person's name and age
   */
  public String toString() {
     String sResult = (sPersonName + " is " + iPersonAge + " years old.");
     return sResult;
  }//end toString() method
}//end Person class