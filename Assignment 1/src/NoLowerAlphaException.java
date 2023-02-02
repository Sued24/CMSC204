/** NoLowerAlphaException class.
 * 
 * @author Santiago Sued
 *
 */
public class NoLowerAlphaException extends Exception 
{
	/** NoLowerAlphaException constructor.
	 * 
	 */
	NoLowerAlphaException()
	{
		super("The password must contain at least one lowercase alphabetic character");
	}
}
