package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SumFor3 {

	public static void main(String[] args) {
		
		int[] num = new int[]{-1, 0, 1, 2, -1,-1,3, -4};
		List<List<Integer>> list =threeSumSolution_one(num);
		
		Iterator<List<Integer>> smallList = list.iterator();
				
		while(smallList.hasNext()){
		
		System.out.println(Arrays.toString(smallList.next().toArray()));
		
		}
		System.out.println("**************");
		
	    List<List<Integer>> list2 =threeSumSolution_one(num);
		
		Iterator<List<Integer>> smallList2 = list2.iterator();
				
		while(smallList2.hasNext()){
		
		System.out.println(Arrays.toString(smallList2.next().toArray()));
		
		}
		
		
		
		
	}
	
	public static  List<List<Integer>> threeSumSolution_one(int[] num){
	
		Arrays.sort(num);
		List<List<Integer>> res = new LinkedList<>();

		for (int i = 0; i < num.length - 2; i++) {
			
			if(i == 0 || (i > 0 && num[i] !=num[i-1]) ){
			int lo = i+1, hi = num.length -1, sum =0 - num[i];
			
			while(lo < hi){
				if (num[lo] + num[hi] == sum) {
                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
                    while (lo < hi && num[lo] == num[lo+1]) lo++;
                    while (lo < hi && num[hi] == num[hi-1]) hi--;
                    lo++; hi--;
                } else if (num[lo] + num[hi] < sum) lo++;
                else hi--;
				
				
			}
			
			}

		}
		
		
		
		return res;
	}
	
	public static  List<List<Integer>> threeSumSolution_two(int[] num){
		Arrays.sort(num);
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		
		for (int i = 0; i < num.length - 2; i++){
			int lo = i +1, hi = num.length - 1, sum = 0 - num[i];
			while(lo < hi){
				
				 if(num[i]+num[lo]+num[hi]==0)
		            {
		                List<Integer> l= new ArrayList<Integer>();
		                l.add(num[i]);
		                l.add(num[lo]);
		                l.add(num[hi]);
		                if(set.add(l))
		                list.add(l);
		                lo++;
		                hi--;
		            }
		            else if(num[i]+num[lo]+num[hi]<0)
		            lo++;
		            else
		            hi--;
				
			}
			
		}
		return list;
		
	}

}
