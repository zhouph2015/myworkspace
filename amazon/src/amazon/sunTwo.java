package amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class sunTwo {

	public static void main(String[] args) {
		int[] test = new int[]{2, 7, 11, 15};
		System.out.println(Arrays.toString(solution_one(test, 26)));
		System.out.println(Arrays.toString(solution_two(test, 26)));

	}
	
	public static int[] solution_one( int[] nums, int target){
		   int[] results = new int[2];
	        
	        for(int i = 0; i < nums.length; i++){
	            results[0] = i;
	            for (int j = i+1; j < nums.length; j++){
	                if( nums[i]+nums[j] == target){
	                   results[1]=j;
	                   return results;
	                }  
	            }
	            
	        }
	        return results;
	}
	
	public static int[] solution_two(int[] numbers, int target){
		
		 int[] result = new int[2];
		    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		    for (int i = 0; i < numbers.length; i++) {
		        if (map.containsKey(target - numbers[i])) {
		            result[1] = i ;
		            result[0] = map.get(target - numbers[i]);
		            return result;
		        }
		        map.put(numbers[i], i );
		    }
		    return result;
	}

}
