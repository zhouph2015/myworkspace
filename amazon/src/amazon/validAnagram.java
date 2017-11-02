package amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class validAnagram {
	
	public static void main(String[] args) {
		String phrase1 = "tbeclassroom";
	      phrase1 = (phrase1.toLowerCase()).trim();
	     

	      String phrase2 = "teb  classroom";
	      
	      System.out.println(isAnagram(phrase1, phrase2));
	      System.out.println(isAnagram_two(phrase1, phrase2));
	      System.out.println(isAnagramsFaster(phrase1, phrase2));

	}
	public static boolean isAnagram(String firstWord, String secondWord) {
	     char[] word1 = firstWord.replaceAll("[\\s]", "").toCharArray();
	     char[] word2 = secondWord.replaceAll("[\\s]", "").toCharArray();
	     
	     System.out.println(word1.toString());
	     System.out.println(word2.toString());
	     Arrays.sort(word1);
	     Arrays.sort(word2);
	     return Arrays.equals(word1, word2);
	}
	
	
	public static boolean isAnagram_two(String firstWord, String secondWord){
		
		Map<Character, Integer> lettersInWord1 = new HashMap<Character, Integer>();
		char[] word1 = firstWord.toLowerCase().trim().replaceAll("[\\s]", "").toCharArray();
		char[] word2 = secondWord.toLowerCase().trim().replaceAll("[\\s]", "").toCharArray();
		for (char c : word1){
			int count = 1;
			if(lettersInWord1.containsKey(c)){
				count = lettersInWord1.get(c) + 1;
			}
			lettersInWord1.put(c, count);
		
		}
		
		for (char c : word2){
			int count = -1;
			if(lettersInWord1.containsKey(c)){
				count = lettersInWord1.get(c) - 1;
			}
			lettersInWord1.put(c, count);
		}
		
		for (char c: lettersInWord1.keySet()){
			if(lettersInWord1.get(c) !=0)
				return false;
		}
		
		return true;
	}
	
	
	
	public static boolean isAnagramsFaster(String firstWord, String secondWord){
		
		char[] word1 = firstWord.toLowerCase().replaceAll("[\\s]", "").toCharArray();
		char[] word2 = secondWord.toLowerCase().replaceAll("[\\s]", "").toCharArray();
		
		int[] counts = new int[26];
		
		for (int i =0; i < word1.length; i++){
			
			counts[word1[i] -97]++;
			counts[word2[i]-97] --;
			
		}
		
		for (int i = 0; i <26; i++){
			if(counts[i] != 0)
				return false;
		}
		return true;
		
	}

}
