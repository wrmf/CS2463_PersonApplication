/***
 * Registered Person class
 * @author William McGovern-Fagg
 */

public class RegisteredPerson extends Person {
	private String govID;
	
	/***
	 * Makes new RegisteredPerson from first and last name and government ID
	 * @param firstName input first name
	 * @param lastName input last name
	 * @param govID input government ID
	 */
	public RegisteredPerson(String firstName, String lastName, OCCCDate dob, String govID) {
		super(firstName, lastName, dob);
		this.govID = govID;
	}
	
	/***
	 * Makes new RegisteredPerson from Person and government ID
	 * @param p input person
	 * @param govID input government ID
	 */
	public RegisteredPerson (Person p, String govID) {
		super(p);
		this.govID = govID;
	}
	
	/***
	 * Clones a RegisteredPerson
	 * @param p input person
	 */
	public RegisteredPerson (RegisteredPerson p) {
		super(p.getFirstName(), p.getLastName(), p.getDOB());
		this.govID = p.govID;
	}
	
	/***
	 * Gets government ID
	 * @return government ID
	 */
	public String getGovernmentID() {
		return govID;
	}
	
	/***
	 * Sets the government ID
	 * @param govID the input id
	 */
	public void setGovernmentID(String govID) {
		this.govID = govID;
	}
	
	/***
	 * Check if two people are equal from a RegisteredPerson
	 * @param p input RegisteredPerson
	 * @return true if equal, false if not
	 */
	public boolean equals(RegisteredPerson p) {
		if(super.equals(p) && govID.toLowerCase().equals(p.getGovernmentID().toLowerCase())) {
			return true;
		}
		
		return false;
	}
	
	/***
	 * Check if one person equals another
	 * @param p input person
	 * @return true if equal, false if not
	 */
	public boolean equals(Person p) {
		return super.equals(p);
	}
	
	/***
	 * Return string of person's information
	 */
	public String toString() {
		return super.toString()+", "+govID;
	}
}
