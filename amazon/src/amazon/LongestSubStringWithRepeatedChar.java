package amazon;

import java.util.HashMap;

public class LongestSubStringWithRepeatedChar {

	public static void main(String[] args) {
	
           String test="abcaecrty";
           System.out.println(lengthOfLongestSubstring_one(test));
           System.out.println(lengthOfLongestSubstring_two(test));

	}

	public static int lengthOfLongestSubstring_one(String s) {
		if (s.length() == 0)return 0;
	    
		int[] map = new int[128];
		int max = 0, j =0;
		
		char[] str = s.toCharArray();
		int length = s.length();
		
		for( int i =0; i <length; i++){
			if(map[str[i]] > 0)
	            j =  Math.max(j, map[str[i]]);
			
			map[str[i]] = i +1;
			max =Math.max(max, i -j+1);
		}
        
        return max;

	}
	
	
	public static int lengthOfLongestSubstring_two(String s) {
		if (s.length() == 0)
			return 0;
		int max = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0, j = 0; i < s.length(); i++) {

			if (map.containsKey(s.charAt(i))) {
				//j = i;
				j = Math.max(j,map.get(s.charAt(i))+1);
			}

			map.put(s.charAt(i), i);
			max = Math.max(max, i - j + 1);

		}

		return max;

	}
}
