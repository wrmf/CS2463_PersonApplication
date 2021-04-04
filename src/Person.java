/***
 * Person class
 * @author William McGovern-Fagg
 *
 */

public class Person {
	private String firstName;
	private String lastName;
	private OCCCDate dob;
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = new OCCCDate();
	}
	
	public Person(String firstName, String lastName, OCCCDate dob) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}
	
	public Person(Person p) {
		firstName = p.firstName;
		lastName = p.lastName;
		this.dob = p.dob;
	}
	
	/***
	 * Get the last name of the person
	 * @return the last name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/***
	 * Get the last name of the person
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/***
	 * Set first name of a person
	 * @param input  input first name
	 */
	public void setFirstName(String input) {
		firstName = input;
	}
	
	/***
	 * Set last name of a person
	 * @param input input last name
	 */
	public void setLastName(String input) {
		lastName = input;
	}
	
	public OCCCDate getDOB() {
		return this.dob;
	}
	
	public String toString() {
		return lastName+", "+firstName+" ("+dob.toString()+")";
	}
	
	/***
	 * Check if one person equals another
	 * @param p
	 * @return
	 */
	public boolean equals(Person p) {
		if(firstName.toLowerCase().equals(p.firstName.toLowerCase()) && 
				lastName.toLowerCase().equals(p.lastName.toLowerCase()) && 
				dob.getYear() == p.dob.getYear() && 
				dob.getDayOfMonth() == p.dob.getDayOfMonth() && 
				dob.getMonthNumber() == p.dob.getMonthNumber()) {
			return true;
		}
		return false;
	}
	
	/***
	 * Make person eat
	 */
	public void eat() {
		System.out.println(firstName + " " + lastName + " is eating...");
	}
	
	/***
	 * Make person sleep
	 */
	public void sleep() {
		System.out.println(firstName + " " + lastName + " is sleeping...");
	}
	
	/***
	 * Make person play
	 */
	public void play() {
		System.out.println(firstName + " " + lastName + " is playing...");
	}
	
	/***
	 * Make person run
	 */
	public void run() {
		System.out.println(firstName + " " + lastName + " is running...");
	}
	
	
	
}
