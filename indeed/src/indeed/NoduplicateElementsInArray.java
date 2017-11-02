package indeed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class NoduplicateElementsInArray {
    
    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 5, 7 };
        int[] arr2 = { 2, 2, 6, 8 };
        int[] arr3 = { 0, 9, 10, 11 };
 
        ArrayList<ArrayList<Integer>> results = solution1(new int[][] { arr1, arr2, arr3 });
        System.out.println(results);
    }
    
    public static ArrayList<ArrayList<Integer>> solution1(int[][] nums) {
        Map<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (treeMap.containsKey(nums[i][j])) {
                    treeMap.put(nums[i][j], treeMap.get(nums[i][j]) + 1);
                } else {
                    treeMap.put(nums[i][j], 1);
                }
            }
        }

        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        
        while(!treeMap.isEmpty()){
            ArrayList<Integer> list = new ArrayList<Integer>();
         
            Iterator<Map.Entry<Integer, Integer>> iterator = treeMap.entrySet().iterator();
            
            while( iterator.hasNext() ){
                
                Map.Entry<Integer, Integer> entry = iterator.next();
                
                
                list.add(entry.getKey());
                if (entry.getValue() ==1 ){
                    iterator.remove();
                } else {
                    treeMap.put(entry.getKey(), entry.getValue() - 1);
                }
                
            }
            results.add(list);
        }

        return results;
    }

}
