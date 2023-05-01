import java.util.ArrayList;
/**
 * Town class will act as vertices in graph
 * @author sueds
 */

public class Town implements Comparable<Town> {

	public void setTownName(String townName) {
		this.townName = townName;
	}

	private String townName;
//	private ArrayList<Town> adjTowns; // Parallel ArrayLists of Town + Road combination
//	private ArrayList<Road> roadToAdjTowns;
	
	/**
	 * Instantiates a new Town object with a given name.
	 * @param townName	Name of the town.
	 */
	public Town(String townName) {
		this.townName = townName;
	}
	
	/**
	 * Instantiates a new Town, copying from another town object.
	 * @param otherTown Other town object to copy from.
	 */
	public Town(Town otherTown) {
		this.townName = otherTown.getName();
	}
	
	/**
	 * Compares two town object with respect to their name.
	 * @param otherTown Other town object to compare.
	 * @return 0 if they are the same object or an integer if they are not.
	 */
	@Override
	public int compareTo(Town otherTown) {
		return this.townName.compareTo(otherTown.townName);
	}
	
	/** 
	 * Returns the name of the town.
	 * @return Name of the town.
	 */
	public String getName() {
		return townName;
	}
	
	/**
	 * Returns a string with the name of the town.
	 * @return A string with the name of the town.
	 */
	public String toString() {
		return this.getName();
	}
	
	/**
	 * Returns a hashcode based on the town name.
	 * @return hashcode.
	 */
	public int hashCode() {
		return this.townName.hashCode();
	}
	
	/** Compares to town to see if they are equal.
	 * @param obj	Object to copy from
	 * @return true if the objects are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		Town townn = (Town) obj;
		if((this.townName.toLowerCase().equals(townn.getName().toLowerCase())) || this == townn) {
			return true;
		}
		return false;
//	    if (obj instanceof Town) {
//	        Town otherTown = (Town) obj;
//	        return (compareTo(otherTown) == 0);
//	    }
//	    return false;
//	}
}
}
