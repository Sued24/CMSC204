/**NoSpecialCharacterException class.
 * 
 * @author Santiago Sued
 *
 */
public class NoSpecialCharacterException extends Exception 
{
	/**NoSpecialCharacterException constructor.
	 * 
	 */
	NoSpecialCharacterException()
	{
		super("The password must contain at least one special character");
	}
}
