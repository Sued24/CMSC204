
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {
	ArrayList<String> passwords;
	@Before
	public void setUp() throws Exception {
		String[] p = {
		"a1A#b1Bc1Cd1D"
		,"334455BB#"
		,"Im2cool4U"
		,"george2ZZZ#"
		,"4Sale#"
		,"bertha22"
		,"4wardMarch#"
		,"august30"
		,"a2cDe"
		,"ApplesxxYYzz#"
		,"aa11bb"
		,"pilotProject"
		,"myPassword"
		,"myPassword2"
		,"myPassword2#"
		};
		
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(p));
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}
	
	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidLength("abcAB"));
			assertFalse(PasswordCheckerUtility.isValidLength("hellooooooooo"));
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a lengthExcepetion",true);			
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.hasUpperAlpha("abcAB"));
			assertFalse(PasswordCheckerUtility.hasUpperAlpha("hellooooooooo"));
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaExcepetion",true);			
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.hasLowerAlpha("abcAB"));
			assertFalse(PasswordCheckerUtility.hasLowerAlpha("HELLLOOO"));
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);			
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{
			assertFalse(PasswordCheckerUtility.isWeakPassword("#StronkP4sword!"));
			assertTrue(PasswordCheckerUtility.isWeakPassword("#We4k"));
		}
		catch(WeakPasswordException e)
		{
			assertTrue("Successfully threw a WeakPasswordExcepetion",true);			
		}
		catch(Exception e)
		{
			assertTrue("Threw other exception", true);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			assertTrue(PasswordCheckerUtility.NoSameCharInSequence("abcAB"));
			assertFalse(PasswordCheckerUtility.NoSameCharInSequence("HELLLOOO"));
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw an InvalidSequenceException",true);			
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try{
			assertTrue(PasswordCheckerUtility.hasDigit("abcA2B"));
			assertFalse(PasswordCheckerUtility.hasDigit("HELLLOOO"));
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw a NoDigitExcepetion",true);			
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("#SuperN4isPword"));
			assertFalse(PasswordCheckerUtility.isValidPassword("12345"));
		}
		catch(Exception e)
		{
			assertTrue("Successfully threw an exception",true);			
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords()
	{
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(passwords);
		assertEquals(results.size(), 12);
		assertEquals(results.get(0), "334455BB# The password must contain at least one lowercase alphabetic character");
		assertEquals(results.get(1), "Im2cool4U The password must contain at least one special character");
	}
}
