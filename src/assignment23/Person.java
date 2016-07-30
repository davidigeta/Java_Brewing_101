package assignment23;

/**
 * A comparable person with ssn, tax, & name data fields
 * 
 * @author William McDaniel Albritton
 * */
public class Person implements java.lang.Comparable<Person> {
	// data fields
	private int ssn = 0;
	private double tax = 0.0;
	private String name = new String("name");

	/**
	 * Constructor
	 * 
	 * @param ssnParameter
	 *            is the person's ssn
	 * @param taxParameter
	 *            is the person's tax
	 * @param nameParameter
	 *            is the person's name
	 */
	public Person(int ssnParameter, double taxParameter, 
			String nameParameter)
			throws PersonException {
		// ssn error checking
		// for simplicity, we keep the ssn number to 4 digits
		if (ssnParameter < 1000 || ssnParameter > 9999) {
			throw new PersonException(
					"Please keep the SSN as a 4-digit number.");
		}
		ssn = ssnParameter;
		tax = taxParameter;
		name = nameParameter;
	}

	/**
	 * Overloaded constructor for String data input
	 * 
	 * @param ssnParameter
	 *            is the person's ssn
	 * @param taxParameter
	 *            is the person's tax
	 * @param nameParameter
	 *            is the person's name
	 */
	public Person(String ssnParameter, String taxParameter, 
			String nameParameter)
			throws PersonException {
		// calls the 1st constructor
		// converts strings to appropriate data type
		this(Integer.parseInt(ssnParameter), 
				Double.parseDouble(taxParameter),
				nameParameter);
	}

	/**
	 * Overloaded constructor for "searchKey" Person (only contains the SSN, which is
	 * the search key)
	 * 
	 * @param ssnParameter
	 *            is the person's ssn
	 */
	public Person(int ssnParameter) throws PersonException {
		// calls 1st constructor
		this(ssnParameter, 0.0, "SEARCH KEY");
	}

	/**
	 * Overloaded constructor for "searchKey" Person (only contains the SSN, which is
	 * the search key)
	 * 
	 * @param ssnParameter
	 *            is the person's ssn
	 */
	public Person(String ssnParameter) throws PersonException {
		// convert from string & call 1st constructor
		// put in placeholder values
		this(Integer.parseInt(ssnParameter), 0.0, "SEARCH KEY");
	}

	/**
	 * Automatically called by println() or print() Used to make a CSV (comma
	 * separated values) excel database
	 * 
	 * @return a String of the Person
	 */
	public String toString() {
		String csvFormat = ssn + "," + tax + "," + name;
		return csvFormat;
	}

	/**
	 * Method to compare objects
	 * 
	 * @param person2
	 *            is a second Person
	 * @return 0 if equal, negative if(person1<person2), positive
	 *         if(person1>person2)
	 */
	public int compareTo(Person person2) {
		int difference = ssn - person2.getSSN();
		return difference;
	}

	/**
	 * Accessor method
	 * 
	 * @return the Person's SSN
	 */
	public int getSSN() {
		return ssn;
	}

	/**
	 * Accessor method
	 * 
	 * @return the Person's tax
	 */
	public double getTax() {
		return tax;
	}	

	/**
	 * Accessor method
	 * 
	 * @return the Person's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Mutator method
	 * 
	 * @param taxParameter
	 *            is the person's tax
	 */
	public void setTax(double taxParameter) {
		tax = taxParameter;
	}

	/**
	 * Mutator method
	 * 
	 * @param taxParameter
	 *            is the person's tax
	 */
	public void setTax(String taxParameter) {
		// convert from string & call 1st setTax() method
		this.setTax(Double.parseDouble(taxParameter));
	}

	/**
	 * Method main is used as a driver to test the class
	 * 
	 * @param args
	 *            is not used
	 */
	public static void main(String[] args) {
		// test constructors & toString method
		System.out.println("TEST constructors and toString() method:");
		Person person1 = new Person(5000, 123.45, "Nami");
		System.out.println(person1.toString());
		Person person2 = new Person("7000", "-67.89", "Nalu");
		System.out.println(person2.toString());
		// variable "searchKey" only contains the SSN search key
		Person searchKey = new Person(7000);
		System.out.println(searchKey);

		// test compareTo method
		System.out.println("\nTEST compareTo() method");
		System.out.println("person1 = " + person1.toString());
		System.out.println("person2 = " + person2.toString());
		System.out.println("person1.compareTo(person2) = "
				+ person1.compareTo(person2));
		System.out.println("person2.compareTo(person1) = "
				+ person2.compareTo(person1));
		System.out.println("searchKey = " + searchKey);
		System.out.println("person2.compareTo(searchKey) = "
				+ person2.compareTo(searchKey));

		// test set method
		System.out.println("\nTEST set method:");
		person2.setTax(9000000.99);
		System.out.println("person2 = " + person2.toString());

		// check exceptions
		System.out.println("\nTEST exceptions:");
		try {
			person1 = new Person(1, 123.45, "Buruma");
		} catch (PersonException exception) {
			System.out.println(exception.toString());
		}
	}// end main
}// end class

// ********************************************************************
/** For use with the Person class */
class PersonException extends RuntimeException {
	/**
	 * Constructor
	 * 
	 * @param message
	 *            Describes the cause of the error
	 */
	public PersonException(String message) {
		super(message);
	}
}// end class

/*PROGRAM OUTPUT:
TEST constructors and toString() method:
5000,123.45,Nami
7000,-67.89,Nalu
7000,0.0,SEARCH KEY

TEST compareTo() method
person1 = 5000,123.45,Nami
person2 = 7000,-67.89,Nalu
person1.compareTo(person2) = -2000
person2.compareTo(person1) = 2000
searchKey = 7000,0.0,SEARCH KEY
person2.compareTo(searchKey) = 0

TEST set method:
person2 = 7000,9000000.99,Nalu

TEST exceptions:
PersonException: Please keep the SSN as a 4-digit number.
*/