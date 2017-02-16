import java.util.ArrayList;
import java.util.Scanner;

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
	
	//debugged but I suspect it's still unstable
	public static String[] toSortedArray(String input){
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
		
		String[] words = new String[count];
		wordsL.sort(null);
		wordsL.toArray(words);
		System.out.println("This is a list of words: "+wordsL);
		System.out.println("This is a array of words: "+printArray(words));
		
		return words ;
	}
	
	public static String[][] toFrequencyList(String[] wordList){
		System.out.println("\n\n\nEntered Frequency method");
		String whatISee = "";
		int curCount = 0;
		ArrayList<String []> wordFreq = new ArrayList<String []>();
		String [] packet = new String[2];
		
		
		for (String word: wordList ){
			if (whatISee.equals("")) {
				whatISee = word;
				System.out.println("WhatISee was empty so I filled it with: "+whatISee);
			}
			
			if (whatISee.equals(word)){
				curCount++;
				System.out.println("I kept seeing : "+word+" : so I increased the counter to : "+ curCount);
				}
			else{
				System.out.println("I stopped seeing : "+whatISee+" : So I Created a packet for that word ending the counter at : " + curCount + "\nNow I'm looking for: "+word);
				whatISee = word;
				packet[0] = whatISee;
				packet[1] = curCount + "" ;
				wordFreq.add(packet);
				curCount = 1;
				
			}
		}
		String[][] output = new String[wordFreq.size()][2];
		wordFreq.toArray(output);
		return output;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine().toLowerCase();// assume no "."s for any punctuation
		String[] words = toSortedArray(input);
		
		String[][] list = toFrequencyList(words);
		
		for (int i = 0; i < list.length ; i++){
			System.out.println(" xzword : " + list[i][0] + " : is seen : " + list[i][1] + " : times");
		}
	}

}
