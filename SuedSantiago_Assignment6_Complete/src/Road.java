/**
 * Road class that acts as edges for the graph.
 * @author Santiago Sued
 *
 */
public class Road implements Comparable<Road> {
	Town source = null, destination =null;
	int degrees =0;
	String roadName = "";
	
	/**
	 *  Initializes a new road object based on certain parameters.
	 *  
	 * @param source	Source town.
	 * @param destination	Destination town.
	 * @param degrees	Weight of road.
	 * @param name	Name of the road.
	 */
	public Road(Town source, Town destination, int degrees, String name) {
		this.source = source;
		this.destination = destination;
		this.degrees = degrees;
		roadName = name;
	}
	
	/**
	 *  Initializes a new road object based on certain parameters and a preset weight of 1.
	 * 
	 * @param source	Source town.
	 * @param destination	Destination town.
	 * @param name	Name of the road.
	 */
	public Road(Town source, Town destination, String name) {
		this.source = source;
		this.destination = destination;
		this.degrees = 1;
		roadName = name;
	}
	
	/**
	 * Checks if any of the vertices of the road are equal to the input
	 * 
	 * @param otherTown 	Input town to check.
	 * @return True if edge is connected to town, false if not.
	 */
	public boolean contains(Town otherTown) {
		if (source.equals(otherTown))
			return true;
		if (destination.equals(otherTown))
			return true;
		return false;
	}
	
	/**
	 * Returns a string with the source and destination towns and the road name.
	 * 
	 * @return toString.
	 */
	public String toString() {
		return source + " to " + destination + " via " + getName();
	}
	
	/**
	 * Returns the name of the road.
	 * @return Name of the road.
	 */
	public String getName() {
		return roadName;
	}
	/**
	 * Returns the destination town.
	 * @return Destination Town.
	 */
	public Town getDestination() {
		return destination;
	}
	/**
	 * Returns the source town.
	 * @return Source Town.
	 */
	public Town getSource() {
		return source;
	}
	
	/**
	 * compares two roads to see if they are equal.
	 * @param otherRoad		Other road to compare to.
	 * @return 0 if their names are the same, a value otherwise.
	 */
	@Override
	public int compareTo(Road otherRoad) {
		return this.roadName.compareTo(roadName);
	}
	
	/**
	 * Obtains the weight of the road.
	 * @return Weight of the road.
	 */
	public int getWeight() {
		return degrees;
	}
	
	/**
	 * Checks two roads to see if they are equal.
	 * @param otherObj 		OtherObj to compare to.
	 * @returns True if they are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object otherObj) {
		Road otherRoad = (Road)(otherObj);
		boolean equals = false;
	//	if (source.equals(otherRoad.source) && destination.equals(otherRoad.destination))
	//		return true;
	//	if (source.equals(otherRoad.destination) && destination.equals(otherRoad.source))
	//		return true;
	//	return false;
		if((source + " to " + destination + " via " + getName()).equals(otherRoad.toString())
				|| (destination + " to " + source + " via " + getName()).equals(otherRoad.toString()))
			equals = true;
		
		return equals;
	}
}
