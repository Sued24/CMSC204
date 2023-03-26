/** Class that implements the CourseDBElement
 * 
 * @author Santiago Sued
 *
 */
public class CourseDBElement implements Comparable{

	private String courseID, nRoom, iName;
	private int nCredits, cRN;
	
	/** Constructor that assigns the different fields of DBElement
	 * 
	 * @param CourseID ID of the class
	 * @param cRN Number of the class
	 * @param nCredits Credits of the class
	 * @param nRoom Number of the room
	 * @param iName Instructor Name
	 */
	public CourseDBElement(String CourseID, int cRN, int nCredits, String nRoom, String iName) {
		this.courseID = CourseID;
		this.cRN = cRN;
		this.nCredits = nCredits;
		this.nRoom = nRoom;
		this.iName = iName;
	}

	/**
	 * Unused compareTo method
	 */
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * Returns ID of the class
	 * @return ID of the class
	 */
	public String getID() {
		return courseID;
	}

	/**
	 * Returns Number of the room
	 * @return Number of the room
	 */
	public String getRoomNum() {
		return nRoom;
	}

	/**
	 * Returns Instructor Name
	 * @return Instructor Name
	 */
	public String getiName() {
		return iName;
	}

	/**
	 * Returns nCredits
	 * @return nCredits
	 */
	public int getnCredits() {
		return nCredits;
	}

	/**
	 * Returns Number of the class
	 * @return Number of the class
	 */
	public int getCRN() {
		return cRN;
	}
}
