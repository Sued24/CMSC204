import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/** Class that generates a manager that instantiates a hash table structure. 
 * 
 * @author Santiago Sued
 *
 */
public class CourseDBManager implements CourseDBManagerInterface {

	CourseDBStructure structure;
	
	/** constructor that initializes a new CourseDBStructure
	 * 
	 */
	public CourseDBManager() {
		structure = new CourseDBStructure(500);	
	}
	
	/**
	 *  Adds a CourseDBElement to the structure
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		structure.add(new CourseDBElement(id, crn, credits, roomNum, instructor));
	}

	/**
	 *  Obtains an element with a specific CRN from the structure
	 */
	@Override
	public CourseDBElement get(int crn) {
		try {
			return structure.get(crn);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *  Reads a file with DBElements and adds them to the structure
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {

		
		if (input == null)
			throw new FileNotFoundException();
		Scanner reader = new Scanner(input);
		while (reader.hasNextLine()) {
			String[] t = reader.nextLine().split(" ");
			add(t[0],Integer.parseInt(t[1]),Integer.parseInt(t[2]),t[3],t[4]);
		}
		reader.close();
	}

	/**
	 * Returns an array list of all of the elements in the structure
	 */
	@Override
	public ArrayList<String> showAll() {
		return structure.showAll();
	}

}
