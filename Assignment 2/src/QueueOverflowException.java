/** Exception class for Queue overflow.
 * 
 * @author Santiago Sued
 *
 */
public class QueueOverflowException extends Exception{

	/**Exception constructor.
	 * 
	 */
	public QueueOverflowException()
	{
		super("Cannot add object to full queue.");
	}
}
