/** NoDigitException class.
 * 
 * @author Santiago Sued
 *
 */
public class NoDigitException extends Exception 
{
	/** NoDigitException constructor.
	 * 
	 */
	public NoDigitException()
	{
		super("The password must contain at least one digit");
	}
}
