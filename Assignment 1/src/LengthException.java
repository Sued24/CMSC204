/** Length Exception class.
 * 
 * @author Santiago Sued
 *
 */

public class LengthException extends Exception 
{
	/** LengthException constructor.
	 * 
	 */
	public LengthException()
	{
		super ("The password must be at least 6 characters long");
	}
}
