import java.util.ArrayList;
/**
 * 
 * @author Santiago Sued
 *
 * @param <T> Generic queue class with data type T.
 */
public class MyQueue<T> implements QueueInterface<T> {
	
	private ArrayList<T> queue;
	private int size;
	
	/** Constructor that instantiate queue of a specific type with a given size.
	 * 
	 * @param size Maximum size of the queue.
	 */
	public MyQueue(int size) {
		queue = new ArrayList<T>(size);
		this.size = size;
	}
	/** Constructor that instantiate queue of a specific type with the default array list size;
	 * 
	 */
	public MyQueue() {
		queue = new ArrayList<T>();
		size = 10;
	}
	
	/** Determines if the queue is empty.
	 * @return True if queue is empty.
	 */ 
	public boolean isEmpty() {
		return (queue.size() == 0);
	}

	/** Determines if the queue is full.
	 * @return True if queue is full.
	 */
	public boolean isFull() {
		return (queue.size() == size);
	}

	/** Returns and removes the first item of the queue.
	 *  @return The item dequeued.
	 *  @throws QueueUnderflowException
	 */
	public T dequeue() throws QueueUnderflowException {
		T dequeued;
		if(!isEmpty())
		{
			dequeued = queue.get(queue.size()-1);
			queue.remove(queue.size()-1);
			return dequeued;
		}
		else throw new QueueUnderflowException();
		//return null;
	}

	/** Returns the size of the queue.
	 * @return Size of the queue.
	 */
	public int size() {
		return queue.size();
	}

	/** Adds a given item to the back of the queue.
	 * @return True if the addition is succesful.
	 * @param e Is the item to be added.
	 * @throws QueueOverflowException
	 */
	public boolean enqueue(T e) throws QueueOverflowException {
		if(!isFull())
		{
			queue.add(0,e);
			return true;
		}
		else throw new QueueOverflowException();
	}

	/** ToString method for queue.
	 * @return ToString.
	 */
	public String toString() {
		String toString = "";
		for(int i = queue.size()-1 ; i >= 0 ; i--)
			toString += queue.get(i);
		return toString;
	}
	
	/** ToString method for queue.
	 * @return ToString.
	 * @param Delimiter between each queue item.
	 */
	public String toString(String delimiter) {
		String toString = "";
		for(int i = queue.size()-1 ; i >= 0 ; i--)
		{
			toString += queue.get(i);
			if(i != 0)
			{
				toString += delimiter;
			}
		}
		return toString;
	}

	/** Fills queue with items from an array list.
	 * @param List to add items from.
	 * @throws QueueOverflowException
	 */
	public void fill(ArrayList<T> list) throws QueueOverflowException{
		ArrayList<T> listCopy = new ArrayList<T>(list);
		for(int i = 0 ; i < listCopy.size(); i++)
			enqueue(list.get(i));
	}
}
