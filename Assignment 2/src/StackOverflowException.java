/** Exception class for Stack overflow.
 * 
 * @author Santiago Sued
 *
 */
public class StackOverflowException extends Exception{

	/**Exception constructor.
	 * 
	 */
	public StackOverflowException()
	{
		super("Cannot add object to full stack.");
	}
}