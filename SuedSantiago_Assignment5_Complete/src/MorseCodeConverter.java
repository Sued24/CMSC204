import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * MorseCodeConverter mainframe to convert from english to morse visa versa.
 * @author Santiago Sued
 *
 */

public class MorseCodeConverter {

	/**
	 * Creates a morse code tree to undergo the operation.
	 */
	static MorseCodeTree morseCode = new MorseCodeTree();
	
	/**
	 * Unnecessary constructor.
	 */
	public MorseCodeConverter() {
		
	}
	/** Converts morse code in a file to english words.
	 * 
	 * @param codeFile File that contains morse code.
	 * @return translated String.
	 * @throws FileNotFoundException If file is not found.
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException{
		Scanner scanner = new Scanner(codeFile); // Creates a scanner object.
		String returnString = ""; // Return String that outputs.
		
		while(scanner.hasNextLine()) 
			returnString += scanner.nextLine()+ "\n";
		scanner.close();
		return convertToEnglish(returnString.trim());
	}
	/**
	 *  Converts morse to english code.
	 * @param code morse code to translate.
	 * @return english translation.
	 */
	public static String convertToEnglish(String code) {
		String[] codeWords; 
		String[] codeLetters;
		String englishString = ""; // english translation
		codeWords = code.split(" / "); 
		for(int i = 0;i < codeWords.length;i++) {
			codeWords[i] = codeWords[i].trim();
			codeLetters = codeWords[i].split(" ");
			for(int j = 0 ; j < codeLetters.length ; j++) {
				englishString += morseCode.fetch(codeLetters[j]);
			}
			englishString += " ";
		}
		englishString = englishString.trim();
		return englishString;
	}
	
	/** prints the elements of the morse code tree in inorder ordering.
	 * 
	 * @return A string of the printTree.
	 */
	public static String printTree() {
		ArrayList<String> treeList = morseCode.toArrayList();
		String printString = "";
		
		for(int i = 0 ; i < treeList.size() ; i++)
		{
			if(i == treeList.size()-1)
				printString +=  (treeList.get(i));
			else
			printString +=  (treeList.get(i) + " ");
		}
		
		return printString;
		}
}
