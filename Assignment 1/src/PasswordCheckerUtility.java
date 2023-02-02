import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/** Utility class for password validation.
 * 
 * @author Santiago Sued
 * 
 *
 */
public class PasswordCheckerUtility 
{
	/** Checks if all conditions are met.
	 * 
	 * @param password Password to validate.
	 * @return True if the password passes all tests.
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 * @throws WeakPasswordException
	 */
	public static boolean isValidPassword(java.lang.String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException, WeakPasswordException
	{
		boolean isValid = false;
		if(isValidLength(password) && hasUpperAlpha(password) && hasLowerAlpha(password) && hasDigit(password) && hasSpecialChar(password) && NoSameCharInSequence(password))
			isValid = true;
		/*
		if(isValidLength(password))
			System.out.println("valid length");
		if(hasUpperAlpha(password))
			System.out.println("hasUpperAlpha");
		if(hasLowerAlpha(password))
			System.out.println("hasLowerAlpha");
		if(hasDigit(password))
			System.out.println("has digit");
		if(hasSpecialChar(password))
			System.out.println("has Special Char");
		if(NoSameCharInSequence(password))
			System.out.println("no same char");
		*/
		return isValid;
	}
	
	/** Checks if the two entered passwords are equal.
	 * 
	 * @param password Password desired.
	 * @param passwordConfirm Same password retyped.
	 * @throws UnmatchedException
	 */
	public static void comparePasswords(java.lang.String password, java.lang.String passwordConfirm) throws UnmatchedException
	{
		if(!password.equals(passwordConfirm))
			throw new UnmatchedException();
	}
	
	/** Checks if the two entered passwords are equal, and returns a boolean value depending on test.
	 * 
	 * @param password Password desired.
	 * @param passwordConfirm Same password retyped.
	 * @return True if both passwords match.
	 */
	public static boolean comparePasswordsWithReturn(java.lang.String password, java.lang.String passwordConfirm)
	{
		boolean comparison = false;
		if(password.equals(passwordConfirm))
			comparison = true;
		return comparison;
	}
	
	/** Checks if the password has more than 6 characters.
	 * 
	 * @param password Password to validate.
	 * @return True if the password is greater than 6 characters.
	 * @throws LengthException 
	 */
	public static boolean isValidLength(java.lang.String password) throws LengthException
	{
		boolean validLength = false;
		if(password.length()>= 6)
			validLength = true;
		if (validLength == false)
			throw new LengthException();
		return validLength;
	}
	
	/** Checks if the password has an upper alphabetic character.
	 * 
	 * @param password Password to validate.
	 * @return True if the password has an upper alphabetic character.
	 * @throws NoUpperAlphaException
	 */
	public static boolean hasUpperAlpha(java.lang.String password) throws NoUpperAlphaException
	{
		boolean hasUpperAlpha = false;
		char[] passwordChar = password.toCharArray();
		for(int i = 0 ; i < password.length() ; i++)
		{
			if(Character.isUpperCase(passwordChar[i]))
			{
				hasUpperAlpha = true;
			}
		}
		if(hasUpperAlpha == false)
			throw new NoUpperAlphaException();
		return hasUpperAlpha;
	}
	
	/** Checks if the password has a lower alphabetic character.
	 * 
	 * @param password Password to validate.
	 * @return True if the password has an upper alphabetic character.
	 * @throws NoLowerAlphaException
	 */
	public static boolean hasLowerAlpha(java.lang.String password) throws NoLowerAlphaException
	{
		boolean hasLowerAlpha = false;
		char[] passwordChar = password.toCharArray();
		for(int i = 0 ; i < password.length() ; i++)
		{
			if(Character.isLowerCase(passwordChar[i]))
			{
				hasLowerAlpha = true;
			}
		}
		if(hasLowerAlpha == false)
			throw new NoLowerAlphaException();
		return hasLowerAlpha;
	}
	
	/** Checks if the password has a numerical digit.
	 * 
	 * @param password Password to validate.
	 * @return True if the password has a numerical digit.
	 * @throws NoDigitException
	 */
	public static boolean hasDigit(java.lang.String password) throws NoDigitException
	{
		boolean hasDigit = false;
		char[] passwordChar = password.toCharArray();
		for(int i = 0 ; i < password.length() ; i++)
		{
			if(Character.isDigit(passwordChar[i]))
			{
				hasDigit = true;
			}
		}
		if(hasDigit == false)
		{
			throw new NoDigitException();
		}

		return hasDigit;
	}
	
	/** Checks if the password has a special character.
	 * 
	 * @param password Password to validate.
	 * @return True if the password has a special character.
	 * @throws NoSpecialCharacterException
	 */
	public static boolean hasSpecialChar(java.lang.String password) throws NoSpecialCharacterException
	{
		boolean hasSpecialChar = false;
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
		if(!matcher.matches())
			hasSpecialChar = true;
		if(hasSpecialChar == false)
			throw new NoSpecialCharacterException();
		return hasSpecialChar;
	}
	
	/** Checks if the password has two concurrent, equal characters.
	 * 
	 * @param password Password to validate.
	 * @return True if the character has NO two concurrent, equal chacaracters.
	 * @throws InvalidSequenceException
	 */
	public static boolean NoSameCharInSequence(java.lang.String password) throws InvalidSequenceException
	{
		boolean noSame = true;
		char[] passwordChar = password.toCharArray();
		for(int i = 1 ; i < password.length() ; i++)
		{
			if(passwordChar[i] == passwordChar[i-1])
			{
				noSame = false;
			}
		}
		if (noSame == false)
			throw new InvalidSequenceException();
		return noSame;
	}
	
	/** Checks if the password has between 6 and 9 characters.
	 * 
	 * @param password Password to validate.
	 * @return True if the password has between 6 and 9 characters.
	 */
	public static boolean hasBetweenSixAndNineChars(java.lang.String password)
	{
		boolean hasBetween = false;
		if(password.length() >= 6 && password.length() <= 9)
			hasBetween = true;
		return hasBetween;
	}
	
	/** Checks if the password is valid, but has between 6 and 9 characters.
	 * 
	 * @param password Password to validate.
	 * @return True if the password is a valid, 6 to 9 character password.
	 * @throws WeakPasswordException
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 */
	public static boolean isWeakPassword(java.lang.String password) throws WeakPasswordException, LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException
	{
		boolean isWeak = false;
		if(isValidPassword(password) && hasBetweenSixAndNineChars(password))
			isWeak = true;
		if(isWeak == true)
			throw new WeakPasswordException();
		return isWeak;
	}
	
	/** Checks a list of passwords and returns the invalid ones with their attached exception.
	 * 
	 * @param passwords List of passwords to validate.
	 * @return A list of invalid passwords with their attached exception.
	 */
	public static java.util.ArrayList<java.lang.String> getInvalidPasswords(java.util.ArrayList<java.lang.String> passwords)
	{
		java.util.ArrayList<java.lang.String> badPasswords = new ArrayList<String>();
		for(int i=0 ; i<passwords.size() ; i++)
		{				
			try 
			{
				if(!isValidPassword(passwords.get(i)))
					badPasswords.add(passwords.get(i));
			} 
			catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException | NoSpecialCharacterException | InvalidSequenceException | WeakPasswordException e) 
			{				// TODO Auto-generated catch block
				badPasswords.add(passwords.get(i) + " " + e.getMessage());
			}
		}
		return badPasswords;
	}
}
