import java.util.ArrayList;

/**
 * 
 * @author Santiago Sued
 *
 * @param <T> Generic stack class with data type T.
 */
public class MyStack<T> implements StackInterface<T> {
	
	private ArrayList<T> stack;
	private int size;
	
	/** Constructor for stack with given size.
	 * 
	 * @param size Size of stack.
	 */
	public MyStack(int size) {
		stack = new ArrayList<T>(size);
		this.size = size;
	}
	
	/** Constructor for stack with default size for array list.
	 * 
	 */
	public MyStack() {
		stack = new ArrayList<T>();
		size = 10;
	}
	
	/** Determines if the stack is empty.
	 * @return True if stack is empty.
	 */ 
	public boolean isEmpty() {
	
			return stack.size()==0;
	}
	
	/** Determines if the stack is full.
	 * @return True if stack is full.
	 */
	public boolean isFull() {
		return stack.size() == size;
	}

	/** Returns and removes the last item of the stack.
	 *  @return The item popped.
	 *  @throws StackUnderflowException
	 */
	public T pop() throws StackUnderflowException {
		if(isEmpty())
		{
			throw new StackUnderflowException();
			
		}
		
		T popped = stack.get(stack.size()-1);
		stack.remove(size()-1);
			
		return popped;
	}

	/** Returns the last item of the stack.
	 *  @return The item at the top.
	 *  @throws StackUnderflowException
	 */
	public T top() throws StackUnderflowException {
		if(isEmpty())
		{
			throw new StackUnderflowException();
		}
		else
		
		return stack.get(size()-1);
	}

	/** Returns the size of the stack.
	 * @return Size of the stack.
	 */
	public int size() {
		return stack.size();
	}
	
	/** Adds item to bottom of stack
	 * @param Item to add.
	 * @return True if item is added
	 * throws StackOverflowException
	 */ 
	public boolean push(T e) throws StackOverflowException {
		if(!isFull())
		{
			stack.add(e);
			return true;
		}
		else 
		{
			throw new StackOverflowException();
		}
	}
	/** ToString method for stack.
	 * @return ToString.
	 */
	public String toString()
	{
		String toString = "";
		for(int i = 0 ; i < stack.size() ; i++)
			toString += stack.get(i);
		return toString;
	}
	
	/** ToString method for stack.
	 * @return ToString.
	 * @param Delimiter between each stack item.
	 */
	public String toString(String delimiter) {
		String toString = "";
		for(int i = 0 ; i < stack.size() ; i++)
		{
			toString += stack.get(i);
			if(i != stack.size()-1)
				toString += delimiter;
		}
		return toString;
	}
	
	/** Fills stack with items from an array list.
	 * @param List to add items from.
	 * @throws QueueOverflowException
	 */
	public void fill(ArrayList<T> list) throws StackOverflowException { // deep copy?
		ArrayList<T> listCopy = new ArrayList<T>(list);
		for(int i = 0 ; i < listCopy.size(); i++)
			push(list.get(i));
	}
}
