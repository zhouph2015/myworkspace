package amazon;

public class FirstUniqueCharacterInString {

	public static void main(String[] args) {
	
		System.out.println(firstUniqChar("lovelov"));

	}
	
	public static int firstUniqChar(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }

}
