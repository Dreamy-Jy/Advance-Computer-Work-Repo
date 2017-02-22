import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Scanner;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import javafx.print.Collation;

/*
 * a function takes in the raw input, and out put a 2d array containing each the works sorted in to the arrays
 * second function sorts this list of the words based on their frequency.
 * last function returns the table as a string
 */
public class FrequencyCount{
	
	public static class Word {
		int freq;
		String word;
		
		public Word(int freq, String word){
			this.freq = freq;
			this.word = word;
		}
		
		public String toString(){
			return "[ "+freq+", \""+word+"\" ]";
		}
	}

	
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
	//buggy and unstable
	public static ArrayList<Word> toFrequencyList(String[] wordList){
		System.out.println("\n\n\nEntered Frequency method");
		String whatISee = "";
		int curCount = 0;
		ArrayList<Word> wordFreq = new ArrayList<Word>();
		String [] packet = new String[2];
		//ArrayList words = new  ArrayList();
		
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
				wordFreq.add(new Word(curCount , whatISee));//System.out.println("inSide the packet is: "+word);
				System.out.println("- the word is: "+wordFreq.get(wordFreq.size()-1));
				curCount = 1;
				
			}
		}
		return wordFreq;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine().toLowerCase();// assume no "."s for any punctuation
		String[] words = toSortedArray(input);
		
		ArrayList<Word> orderedList = toFrequencyList(words);
		
		orderedList.sort(new Comparator<Word>(){
			@Override
			public int compare(Word o1, Word o2){
				return Integer.compare(o1.freq, o2.freq);
			}
		});
		
		for (int i = 0; i < orderedList.size() ; i++){
			System.out.println("word : " + orderedList.get(i).word + " : is seen : " + orderedList.get(i).freq + " : times");
		}
	}

}
