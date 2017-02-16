import java.util.ArrayList;
import java.util.Scanner;

import com.sun.javafx.collections.SortableList;

/*
 * a function takes in the raw input, and out put a 2d array containing each the works sorted in to the arrays
 * second function sorts this list of the words based on their frequency.
 * last function returns the table as a string
 */
public class FrequencyCount{
	
	public static String printArray( String[] array ){
		String string = "[ ";
		
		for(int i = 0 ; i < array.length ; i++){
			string = string +", "+ array[i];
		}
		string = string + " ]";
		return string;
	}
	
	public static int wordCount(String input){
		int count = 0;
		String currentString = input;
		int[] currentView = {0,0};
		ArrayList<String> wordsL = new ArrayList<String>();
		
		while (currentView[1] < currentString.length()){
			System.out.println("IN METHOD");
			
			currentView[1] = currentString.indexOf(" ");System.out.println("currentView[1] = "+currentView[1]);
			wordsL.add(currentString.substring(currentView[0], currentView[1]));
			//?(currentString.indexOf(" ") >= 0) (currentString.indexOf(" ")) : (currentString.indexOf(" ")) ;
			System.out.println("I see: "+currentString.substring(currentView[0], currentView[1]));
			
			currentString = currentString.substring(currentView[1]+1); System.out.println("currentString = "+currentString);
			
			count++;
			if (currentView[1] == currentString.length()-1) count++;
		}
		
		//String[] words = new String[count];
		wordsL.sort(null);
		System.out.println("This is a list of words: "+wordsL);
		//System.out.println("This is a array of words: "+printArray(words));
		
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine().toLowerCase();// assume no "."s for any punctuation
		System.out.println(wordCount(input));
		String[] words;
	}

}
