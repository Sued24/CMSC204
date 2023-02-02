/**NoUpperAlphaException class.
 * 
 * @author Santiago Sued
 *
 */
public class NoUpperAlphaException extends Exception 
{
	/**NoUpperAlphaException constructor.
	 * 
	 */
	public NoUpperAlphaException()
	{
		super("The password must contain at least one uppercase alphabetic character");
	}
}
