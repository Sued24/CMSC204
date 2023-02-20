/** Exception class for Queue underflow.
 * 
 * @author Santiago Sued
 *
 */
public class QueueUnderflowException extends Exception{

	/**Exception constructor.
	 * 
	 */
	public QueueUnderflowException()
	{
		super("Cannot remove object from an empty queue.");
	}
}
