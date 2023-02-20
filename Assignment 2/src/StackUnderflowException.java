/** Exception class for Stack underflow.
 * 
 * @author Santiago Sued
 *
 */
public class StackUnderflowException extends Exception{

	/**Exception constructor.
	 * 
	 */
	public StackUnderflowException()
	{
		super("Cannot remove or look at an object from an empty stack.");
	}
}
