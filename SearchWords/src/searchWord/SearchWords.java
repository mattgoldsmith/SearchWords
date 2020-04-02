package searchWord;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JTextField;

import java.util.HashMap;
/**
 * Write a description of class SearchWord here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SearchWords{
	
    // instance variables - replace the example below with your own
    private Scanner in;
    private ArrayList<String> words;
    private ArrayList<String> filteredWords;

    /**
     * Constructor for objects of class SearchWord
     */
    public SearchWords(){
    	
        // initialise instance variables
        File file = new File("src/Dictionary/words_alpha.txt");
        words = new ArrayList<String>();
        //Scanner in;
		try {
			in = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        while (in.hasNextLine()){
            words.add(in.nextLine());
        }        
    } 
    
    public void filterByLength(int i){
    	
    	if(filteredWords == null){
    		filteredWords = new ArrayList<String>();
    	}
    	else if(filteredWords.size() > 0){
    		filteredWords.clear();
    	}

    	for(String word : words){
    		if(word.length() == i){
    			filteredWords.add(word);
    		}
    	}
    	
    	//Print out the number of words with the correct length
    	System.out.println(filteredWords.size());
    	
    	/**HashMap<Integer,Character> hashmap = new HashMap<Integer,Character>();
    	hashmap.put(1, 't');
    	hashmap.put(2, 'a');
    	hashmap.put(4, 'l');
    	
    	//Print out the criteria
    	for(Integer key : hashmap.keySet()){
    		System.out.println(key + " : " + hashmap.get(key));
    	}
    	
    	//filterByLetters(hashmap);
    	
    	//Print out the number of words that match the criteria
    	System.out.println(filteredWords.size());
    	
    	//Print out the words with the correct letters
    	for(String word : filteredWords){
    		System.out.println(word);
    	}**/
    }
    
    public void filterByLetters(HashMap<Integer,JTextField> hash){
    	
    	ArrayList<String> list = new ArrayList<String>();
    	
    	//Compare given letters to words
    	for(String word : filteredWords){
    		for(Integer key : hash.keySet()){
    			if(hash.get(key).getText().trim().length() < 1){
    				continue;
    			}
    			if(hash.get(key).getText().toLowerCase().trim().charAt(0) != word.charAt(key-1)){
    				list.add(word);
    				break;
    			}
    		}
    	}
    	
    	//Remove mismatching words
    	for(String word : list){
    		filteredWords.remove(word);
    	}
    	
    	for(String word : filteredWords){
    		System.out.println(word);
    	}
    }
    
    public ArrayList<String> getWords(){
    	return words;
    }
    
    public ArrayList<Integer> getLengths(){
    	ArrayList<Integer> lengths = new ArrayList<Integer>();
    	
    	for(String word : words){
    		//put the unique length of the word into the lengths array
    		if(lengths.contains(word.length())){
    			continue;
    		}
    		else{
    			lengths.add(word.length());
    		}
    	}
    	
    	return lengths;
    }
    
    public ArrayList<String> getFilteredWords(){
    	return filteredWords;
    }
    
}
