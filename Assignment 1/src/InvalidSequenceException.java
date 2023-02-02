/** InvalidSequenceException class.
 * 
 * @author Santiago Sued
 *
 */
public class InvalidSequenceException extends Exception 
{
	/** InvalidSequenceException constructor.
	 * 
	 */
	public InvalidSequenceException()
	{
		super("The password cannot contain more than two of the same character in sequence");
	}
}
