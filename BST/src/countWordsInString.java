import java.util.ArrayList;
import java.util.StringTokenizer;

public class countWordsInString {

	public static void main(String[] args) {
	   String testString = "  This string has five     words.  aa..";
	   
	   System.out.println(countWordsInString_one(testString.trim()));
	   
	   System.out.println(countWordsUsingStringTokenizer(testString.trim()));
	   
	   System.out.println(countWordsInString_three(testString));

	}
	
	public static int countWordsInString_one(String testString){
		if(testString == null || testString.isEmpty()){
			return 0;
		}
		String[] words = testString.split("\\s+");
		return words.length;
		
	}
	
	public static int countWordsUsingStringTokenizer(String sentence) {
		if (sentence == null || sentence.isEmpty()) {
			return 0;
		}
		StringTokenizer tokens = new StringTokenizer(sentence);

		return tokens.countTokens();
	}
	
	public static int countWordsInString_three(String sentence){
		
		if(sentence == null || sentence.isEmpty()){
			return 0;
		}
		char[] words = sentence.toCharArray();
		int counts = 0;
		
		boolean isWord = false;
		ArrayList<Character> punctrations = new ArrayList<Character>();
		
		String puntractionslist =  ".,:;";
		
		for (int i = 0; i < puntractionslist.length(); i ++){
			punctrations.add(puntractionslist.charAt(i));
		}
		
		int endOfLine= words.length - 1;
		
		for (int i = 0; i < words.length; i++){
			if(punctrations.contains(words[i])){
				counts ++;
				isWord = false;
				continue;
			}
		     else if(Character.isLetter(words[i]) && i != endOfLine ){
				isWord = true;
			}else if(!Character.isLetter(words[i]) && isWord){
				counts ++;
				isWord= false;
			} else if ( Character.isLetter(words[i]) && i == endOfLine){
				counts ++;
			}else if(punctrations.contains(words[i])){
				counts ++;
			}
		}
		
		return counts;
		
	}

}
