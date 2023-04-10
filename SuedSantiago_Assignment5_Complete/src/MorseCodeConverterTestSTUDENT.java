
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
 * Student test method for morse code.
 * @author Santiago Sued
 *
 */
public class MorseCodeConverterTestSTUDENT {
	
	@Before
	/**
	 * set up method
	 * @throws Exception
	 */
	public void setUp() throws Exception {
	}

	@After
	/**
	 * teardown method
	 * @throws Exception
	 */
	public void tearDown() throws Exception {
	}

	@Test
	/**
	 * Test method, tests if convert to english works.
	 */
	public void testConvertToEnglishString() {	
		String converter1 = MorseCodeConverter.convertToEnglish(".... . .-.. .-.. --- / .-- --- .-. .-.. -.. ");
		assertEquals("hello world",converter1);
	}

}