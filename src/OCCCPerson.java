/***
 * OCCCPerson class
 * @author William McGovern-Fagg
 *
 */

public class OCCCPerson extends RegisteredPerson {
	private String studentID;
	
	/***
	 * Create new OCCCPerson from RegisteredPerson
	 * @param p input RegisteredPerson
	 * @param studentID input student ID
	 */
	public OCCCPerson (RegisteredPerson p, String studentID) {
		super(p);
		this.studentID = studentID;
	}
	
	/***
	 * Clone OCCC Person
	 * @param p person to clone
	 */
	public OCCCPerson (OCCCPerson p) {
		super(p);
		this.studentID = p.getStudentID();
	}
	
	/***
	 * Get student ID
	 * @return student ID
	 */
	public String getStudentID() {
		return studentID;
	}
	
	/***
	 * Set student ID
	 * @param studentID inputID
	 */
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	
	/***
	 * Checks if one OCCCPerson is equal to another
	 * @param p input person
	 * @return true if yes, false if no
	 */
	public boolean equals(OCCCPerson p) {
		if(this.studentID.toLowerCase().equals(p.getStudentID().toLowerCase()) && super.equals(p)) {
			return true;
		}
		return false;
	}
	
	/***
	 * Check if this RegisteredPerson equals another
	 * @param p input RegisteredPerson
	 * @return true if yes, false if no
	 */
	public boolean equals(RegisteredPerson p) {
		return super.equals(p);
	}
	
	/***
	 * Check if one person equals another
	 * @param p input person
	 * @return true if yes, false if no
	 */
	public boolean equals(Person p) {
		return super.equals(p);
	}
	
	/***
	 * Converts person information to string
	 */
	public String toString() {
		return super.toString()+", "+studentID;
	}
}
