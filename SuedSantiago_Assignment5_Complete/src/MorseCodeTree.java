import java.util.ArrayList;

/**
 *  Generates a Morse Code Tree with several methods upon constructing.
 * @author Santiago Sued
 *
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	/**
	 * Root node.
	 */
	private TreeNode<String> root;
	
	/**
	 *  Constructor initializes root node to empty String and calls build Tree.
	 */
	public MorseCodeTree() {
		root = new TreeNode<String>("");
		buildTree();
	}
	
	/**
	 *  Returns root of tree.
	 */
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}

	/**
	 * Sets root of tree.
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
	}

	/**
	 * Insert node in position determined by code.
	 */
	@Override
	public void insert(String code, String result) {
		addNode(root, code, result);
	}

	/**
	 * Method used recursively in insert method.
	 */
	@Override
	public void addNode(TreeNode<String> node, String code, String letter) {
		TreeNode<String> traverseNode = node; // Creates traverse node to go through the tree.
//		System.out.println("Code is: " + code + ", for letter " + letter);
//		boolean nul = node == null;
//		System.out.println("Node is null: " + nul);
//		System.out.println("left is null:" + node.lChild == null);
//		System.out.println("right is null:" + node.rChild == null);
		
		if (code.length() == 1) { // If length is 1 do the following:
//			System.out.println("length is 1");
			if (code.equals(".")) { // If dot, adds the traverse node to left.
//				System.out.println("adding node to LEFT");
				traverseNode.lChild = new TreeNode<String>(letter);
			}
			else if (code.equals("-")) { // If dot, adds the traverse node to right.
//				System.out.println("adding node to RIGHT");
				traverseNode.rChild = new TreeNode<String>(letter);
			}
		}
		else {
//			System.out.println("length is " + code.length() + ", recursing");
//			System.out.println("Last digit of code is: " + code.substring(last - 1));
			if (code.charAt(0) == '.') { // If dot, do traverseNode left child.
//				System.out.println("recursion, moving LEFT");
				traverseNode = node.lChild;
			}
			if (code.charAt(0) == '-') { // If dot, do traverseNode right child.
//				System.out.println("recursion, moving RIGHT");
				traverseNode = node.rChild;
			}
			addNode(traverseNode, code.substring(1), letter); //recurse.
		}
	}

	/**
	 *  Fetch method calls fetchnode method recursively.
	 */
	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
	}

	/**
	 *  Fetch node method returns data of node at code value.
	 */
	@Override
	public String fetchNode(TreeNode<String> node, String code) {
		TreeNode<String> traverseNode = node; // tempNode to traverse
		String returnString = ""; // String that will hold fetch value.
		
		if (code.length()==1) { // If length is 1 read code and get left or right value.
			if (code.equals(".")) {
				returnString = traverseNode.lChild.getData();
			}
			 if(code.equals("-")) {
				returnString = traverseNode.rChild.getData();
				}
			return returnString; // Return the value.
		}
		else {
			if (code.charAt(0) == '.') { // If dot go left.
				traverseNode = traverseNode.lChild;
			}
			else if (code.charAt(0) == '-') {// If slash go right.
				traverseNode = traverseNode.rChild;  
			}
		}
		return fetchNode(traverseNode, code.substring(1)); // Recurse.
	}

	/**
	 *  Delete method not implemented.
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 *  Delete method not implemented.
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 *  Builds morse code tree.
	 */
	@Override
	public void buildTree() {
		insert("." , "e");
		insert("-" , "t");
		insert(".." , "i");
		insert(".-" , "a"); 
		insert("-." , "n"); 
		insert("--" , "m");
		insert("..." , "s");
		insert("..-" , "u");
		insert(".-." , "r");
		insert(".--" , "w");
		insert("-.." , "d");
		insert("-.-" , "k");
		insert("--." , "g");
		insert("---" , "o");
		insert("...." , "h");
		insert("...-" , "v");
		insert("..-." , "f");
		insert(".-.." , "l");
		insert(".--." , "p");
		insert(".---" , "j");
		insert("-..." , "b");
		insert("-..-" , "x");
		insert("-.-." , "c");
		insert("-.--" , "y");
		insert("--.." , "z");
		insert("--.-" , "q");
	}

	/**
	 *  Creates linked list of items in the array.
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> toStringList = new ArrayList<String>();
		LNRoutputTraversal(root, toStringList);
		
		return toStringList;
	}

	/**
	 *  Creates adds data to the input list in inorder order.
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> node, ArrayList<String> list) {
		if (node.lChild != null)
			LNRoutputTraversal(node.lChild, list);
		System.out.println("Now adding " + node.data + " to the list");	
		list.add(node.data);
		if (node.rChild != null)
			LNRoutputTraversal(node.rChild, list);
	}
}
