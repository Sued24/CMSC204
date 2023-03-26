import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/** Class that implements a hashtable utilizing DBElements.
 * 
 * @author Santiago Sued
 *
 */

public class CourseDBStructure implements CourseDBStructureInterface{
	double loadF = 1.5;
	Node[] hashTable;
	
	/** Constructor that initializes the hashtable to the size of the next 4k+3 prime with respect to the input
	 * 
	 * @param n number input
	 */
	public CourseDBStructure(int n) {
		hashTable = new Node[getBiggerPrime((int)(n/loadF))];
	}
	
	/** Test constructor that initializes the hashtable with preset values
	 * 
	 * @param testing 
	 * @param size
	 */
	public CourseDBStructure(String testing , int size) {
		hashTable = new Node[size];
	}
	
	/**
	 * Returns the size of the hashtable
	 */
	public int getTableSize() {
		return hashTable.length;
	}
	
	/**
	 * Adds a DBElement to the hashtable. Its posicion is decided by a hash function on the course CRN. If the CRN is a duplicate, then it updates the element.
	 */
	public void add(CourseDBElement element) {
		Node elementNode = new Node(element);
		String cRN = String.valueOf(element.getCRN());
		int cRNPos = cRN.hashCode()%getTableSize();
		
		if(hashTable[cRNPos] == null)
			hashTable[cRNPos] = elementNode;
		else {
			boolean repeat = false;
			Node currentNode = hashTable[cRNPos];
			while (currentNode.next != null) {
				if (currentNode.data.getCRN() == element.getCRN()) {
					repeat = true;
					currentNode.data = element;
				}

			currentNode = currentNode.next;
			}
			if(!repeat)
				currentNode.next = elementNode;
		}
	}

	/**
	 * Obtains Element with the provided CRN.
	 */
	public CourseDBElement get(int crn) throws IOException{
		Integer crn_new= crn;
		int cRNPos = String.valueOf(crn).hashCode()%hashTable.length;
		if(hashTable[cRNPos] == null)
			throw new IOException();
		else {
			Node currentNode = hashTable[cRNPos];
			while(currentNode != null) {
				if(crn == currentNode.data.getCRN())
					return currentNode.data;
				currentNode = currentNode.next;
			}	
		}
		return null;
	}

	/**
	 * Node class to encapsulate the DBElement
	 * @author Santiago Sued
	 *
	 */
	protected class Node{
		protected CourseDBElement data;
		protected Node next;
		protected Node prev;
		
		/** Constructs node with data
		 * 
		 * @param newData Data to insert in the node
		 */
		protected Node(CourseDBElement newData) {
			data = newData;
		}
	}
	
	/** Returns next bigger primer number than the number entered
	 * 
	 * @param n Input
	 * @return Next biggest 4k+3 prime
	 */
	public static int getBiggerPrime(int n) {
		int prime = 0 , k = 0;
		while (!isPrime(prime) || prime <= n) {
			prime = 4*k+3;
			k++;
		}
		return prime;
	}
	
	/** Decides if a number is prime.
	 * 
	 * @param prime Number input
	 * @return true if prime
	 */
	private static boolean isPrime(int prime) {
		if (prime == 0)
			return false;
		if (prime == 1 || prime == 2 || prime == 3)
			return true;
		double divisor = 2;
		while (divisor <= Math.sqrt(prime)) {
			if (prime % divisor == 0)
				return false;
			else
				divisor++;
		}
		return true;
	}

	/** Provides array list of strings with all of the elements in the array
	 * 
	 */
	public ArrayList<String> showAll() {
		ArrayList<String> arrayList = new ArrayList<String>();
		Node currentNode;
		if (hashTable.length == 0)
			return null;
		
		for (int i = 0 ; i < hashTable.length ; i++) {
			if (hashTable[i] != null) {
				currentNode = hashTable[i];
				do {
					arrayList.add("\nCourse:" + currentNode.data.getID() + " CRN:" + currentNode.data.getCRN() + " Credits:" + currentNode.data.getnCredits() + " Instructor:" + currentNode.data.getiName() + " Room:" + currentNode.data.getRoomNum());
					if(currentNode.next != null)
						currentNode = currentNode.next;
				} while (currentNode.next != null);
			}
		}
			return arrayList;
	}
}
