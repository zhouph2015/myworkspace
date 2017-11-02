package indeed;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringProcess {
    
    
    public static void main(String [] args){
        
        String [] dict = new String[]{"leet", "let", "code", "cod"};
        String target = "leetcode";
         System.out.println(checkCounpondWords(dict, target));
    }
    
    
    
    public static List<String>  checkCounpondWords(String[] dict, String target){
        ArrayList<String> results = new ArrayList<String>();
        
        Set<String>  set = new HashSet<String>();
        for (int i  = 0; i < dict.length; i++){
            set.add(dict[i]);
        }
        
        for (int j = 1; j < target.length(); j++){
            String word1 = target.substring(0, j);
            String word2 = target.substring(j);
            if(set.contains(word1)&& set.contains(word2)){
                results.add(word1);
                results.add(word2);
            }
            
        }
        
        return results;
    }

}
