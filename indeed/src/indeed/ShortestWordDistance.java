package indeed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShortestWordDistance {
    
    public static void main(String [] args){
        
        String[] list = new String[]{"practice", "makes", "perfect", "coding", "makes","practice", "coding"};
        
        System.out.println(solution1(list, "practice", "coding"));
        System.out.println(solution2(list, "practice", "coding"));
    }
    
    
    
    
    public static int solution1(String[] words, String word1, String word2){
        int index1 = -1;
        int index2 = -1;
        int distance = Integer.MAX_VALUE;
        
        
        for (int i = 0 ; i < words.length; i++){
            if( words[i].equals(word1)){
                index1 = i;
                if( index2 != -1) distance = Math.min( distance, Math.abs(index1 - index2));
            }
            
            if( words[i].equals(word2)){
                index2 = i;
                if(index1 != -1) distance = Math.min(distance, Math.abs(index1 - index2));
            }
            
            System.out.println("loop");
        }
        
        return distance;
    }
    
    public static int solution2(String[] words, String word1, String word2){
        HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        
        for(int i = 0; i < words.length;i++){
            List<Integer> countList = map.get(words[i]);
            if( countList == null){
                countList = new ArrayList<Integer>();
            }
            countList.add(i);
            map.put(words[i], countList);
            
        }
        
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        
        int i = 0;
        int j = 0;
        int distance = Integer.MAX_VALUE;
        while( i < list1.size() && j < list2.size()){
           distance = Math.min(distance, Math.abs(list1.get(i) - list2.get(j)));
           if( list1.get(i) < list2.get(j)){
               i++;
           }else {
               j++;
           }
            
        }
        
        return distance;
       
        
        
    }

}
