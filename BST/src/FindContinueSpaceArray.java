import java.util.PriorityQueue;

// Easy question1 for amazon

public class FindContinueSpaceArray {
	public static void main(String[] args) {
		  int array[] = new int[]{1,1,1,0,0,0,0,1,0,0,1,1};
		  
		  System.out.println(findSmallestContinueIndex(array, 3));
	           
	   
	}

	
	public static int findSmallestContinueIndex(int[] array, int size){
		
		
		int findIndex = 0;
		int findSize = 0;
		int smallestSize = size;
		
		for (int i = 0; i < array.length; i++){
			
			if(array[i] == 0){
				findSize++;
			} else if( array[i] != 0){
				
				if (findSize <= smallestSize && findSize >=size){
					smallestSize = findSize;
					findIndex = i-smallestSize;
				}
				findSize = 0;
			}
		}
		return findIndex;
	}
	
	
	public static int findSmallestContinueIndex_two(int[] array, int size){
		
		
		PriorityQueue<Integer> pq  = new PriorityQueue<Integer>();
	}
	
	
}
