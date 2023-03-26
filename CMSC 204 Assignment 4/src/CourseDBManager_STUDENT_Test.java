import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** Student test class 
 * 
 * @author Santiago Sued
 *
 */
public class CourseDBManager_STUDENT_Test {
	private CourseDBManagerInterface dataMgr = new CourseDBManager();

	/** JUnit setup method 
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dataMgr = new CourseDBManager();
	}
	
/** JUnit teardown method
 * 
 * @throws Exception
 */
	@After
	public void tearDown() throws Exception {
		dataMgr = null;
	}

	/** Adds and compares the element
	 * 
	 */
	@Test
	public void testAddToDB() {
		try {
			dataMgr.add("CMSC203",30504,4,"SC450","Joey Bag-O-Donuts");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/* Tests the showall method
	 * 
	 */
	@Test
	public void testShowAll() {
		dataMgr.add("CMSC203",30504,4,"SC450","Joey Bag-O-Donuts");
		dataMgr.add("CMSC203",30503,4,"SC450","Jill B. Who-Dunit");
		dataMgr.add("CMSC204",30559,4,"SC450","BillyBob Jones");
		ArrayList<String> list = dataMgr.showAll();
		assertEquals(list.get(0),"\nCourse:CMSC204 CRN:30559 Credits:4 Instructor:BillyBob Jones Room:SC450");
	 	assertEquals(list.get(1),"\nCourse:CMSC203 CRN:30503 Credits:4 Instructor:Jill B. Who-Dunit Room:SC450");
		assertEquals(list.get(2),"\nCourse:CMSC203 CRN:30504 Credits:4 Instructor:Joey Bag-O-Donuts Room:SC450");
	}
	
	/**
	 * Tests the readFile method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC203 30504 4 SC450 Joey Bag-O-Donuts");
			inFile.print("CMSC204 30503 4 SC450 Jill B. Who-Dunit");
			
			inFile.close();
			dataMgr.readFile(inputFile);
			assertEquals("CMSC203",dataMgr.get(30504).getID());
			assertEquals("CMSC204",dataMgr.get(30503).getID());
			assertEquals("SC450",dataMgr.get(30503).getRoomNum());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}