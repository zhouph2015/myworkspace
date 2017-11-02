import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class countOddIntegerInArray {

	public static void main(String[] args) {
		  int array[] = new int[]{2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2};
	           
	        System.out.println(getOddOccurance(array));
	        System.out.println(getOddOccurance_two(array));
	        System.out.println(getOddOccurance_three(array));
	        System.out.println(getOddOccurance_four(array));
	        System.out.println(getOddOccurance_five(array));
	}
	
	public static int getOddOccurance(int[] array) {

		for (int i = 0; i < array.length; i++) {
			int findNumber = array[i];
			int count = 0;
			for (int j = 0; j < array.length; j++) {
				if (array[j] == findNumber) {
					count++;
				}
			}

			if (count % 2 != 0) {
				return findNumber;
			}

		}
		return -1;
	}
	
	
	public static int getOddOccurance_two(int[] array) {
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		int count = 1;
		int findNumber = array[0];
		for (int i = 1; i < array.length; i++) {

			if (array[i] == findNumber) {
				count++;
			} else if (i != array.length - 1) {

				findNumber = array[i];
				if (count % 2 != 0) {
					return findNumber;
				}
				count = 1;
			}
		}

		if (count % 2 != 0) {
			return findNumber;
		}
		return -1;
	}
	
	public static int getOddOccurance_three(int [] array){
		
		HashMap<Integer, Integer>  occuranceMap= new HashMap<Integer, Integer>();
		
		for (int i = 0; i < array.length; i++){
			if(occuranceMap.containsKey(array[i])){
				int count = occuranceMap.get(array[i]);
				occuranceMap.put(array[i], count +1);
			} else{
				occuranceMap.put(array[i], 1);
			}
		}
		
		for ( Integer key:occuranceMap.keySet() ){
			
			if(occuranceMap.get(key)%2 != 0 )
				return key;
		}
		
		return -1;
	}
	
	public static int getOddOccurance_four(int [] array){
		
		int product = 1;
		
		for (int i = 0; i < array.length -1 ; i = i+2){
			
			product = product*array[i];
			product= product/array[i +1];
	
		}
        
		if(array.length%2 !=0)
			product = product*array[array.length -1];
		
		return product;
	}
	
	
public static int getOddOccurance_five(int [] array){
		

    int res = 0;
    for (int i = 0; i < array.length; i++) 
    {
        res = res ^ array[i];
    }
    return res;
	}

}
