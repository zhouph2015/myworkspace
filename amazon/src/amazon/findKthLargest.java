package amazon;

import java.util.Arrays;
import java.util.PriorityQueue;

public class findKthLargest {

	public static void main(String[] args) {
		int [] nums = new int[]{3,2,1,5,6,4};
		
		System.out.println(findKthLargest_two(nums, 3));
		
		System.out.println(findKthLargest_three(nums, 3));

	}
	public static int findKthLargest_one(int [] nums, int k){
		final int len = nums.length;
		Arrays.sort(nums);
		return nums[len - k];
		
	}
	
	public static int findKthLargest_two(int[] nums, int k) {

	    PriorityQueue<Integer> pq = new PriorityQueue<>();
	    for(int val : nums) {
	        pq.offer(val);

	       // if(pq.size() > k) {
	        //    pq.poll();
	       // }
	    }
	    
	    System.out.println("before pull");
	    System.out.println(Arrays.toString(pq.toArray()));
	    
	    while(pq.size()>k){
	    	 pq.poll();
	    }
	    System.out.println("after pull");
	    System.out.println(Arrays.toString(pq.toArray()));
	    return pq.peek();
	}
	
	
	public static int findKthLargest_three(int[] nums, int k) {
		int n = nums.length;
		int target = n - k;
		quicksort(nums, 0, n-1, target);
		return nums[n-k];
		}
	
	private static void quicksort(int[] nums, int start, int end, int target){
	    if(start >= end){
	        return;
	    }
	    int mid = start + (end - start)/2;
	    int pivot = choosePivot(nums[mid], nums[start], nums[end]);
	    //int pivot = nums[mid];
	    int i = start;
	    int j = end;
	    while(i <= j){
	        while(nums[i] < pivot){
	            i++;
	        }
	        while(nums[j] > pivot){
	            j--;
	        }
	        if(i <= j){
	            if(nums[i] != nums[j]){
	                swap(nums, i, j);
	            }
	            i++;
	            j--;
	        }
	    }
	    if(target <= i - 1){
	        quicksort(nums, start, i - 1, target);
	    }
	    else{
	        quicksort(nums, i, end, target);
	    }
	}

	private static int choosePivot(int a, int b, int c){
	    if(a > b){
	        if(c > a){
	            return a;
	        }
	        else if(c > b){
	            return c;
	        }
	        else{
	            return b;
	        }
	    }
	    else{
	        if(c > b){
	            return b;
	        }
	        else if(c > a){
	            return c;
	        }
	        else{
	            return a;
	        }
	    }
	}

	private static void swap(int[] nums, int i, int j){
	    int tmp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = tmp;
	}

}
