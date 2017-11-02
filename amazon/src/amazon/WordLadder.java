package amazon;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;

public class WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int wordLadder_one(String beginword, String endword, Set<String> wordDict){
		Set<String> reached = new HashSet<String>();
		reached.add(beginword);
		if(!wordDict.contains(endword))wordDict.add(endword);
		int distance = 1;
		while(!reached.contains(endword)){
			Set<String> toAdd = new HashSet<String>();
			for(String each : reached){
				for(int i  = 0; i < each.length(); i++){
					char[] chars = each.toCharArray();
					for( char ch = 'a'; ch <= 'z'; ch++){
						chars[i] = ch;
						String word = new String(chars);
						
						if(wordDict.contains(word)){
							reached.add(word);
							wordDict.remove(word);
						}
					}
					
				}
				
			}
			distance++;
			if(toAdd.size() ==0) return 0;
			
		}
    return distance;
	}
	
	
	
	SortedSet<String> sortedSet
}
