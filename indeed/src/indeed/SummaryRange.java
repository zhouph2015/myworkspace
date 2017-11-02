package indeed;

import java.util.ArrayList;
import java.util.List;

public class SummaryRange {

    public static void main(String[] args){
        
        int [] num = new int []{0,1,2,4,5,7};
        int [] num1 = new int []{1,1,1,1,1,1};
        int [] num2 = new int []{-1,1,2,4,5,7};
        System.out.println(solution1(num2));
    }
    
    
    
    public static List<String> solution1(int[] nums){
        List<String> list = new ArrayList();
        if(nums.length==1){
            list.add(+nums[0]+"");
        }
        
        for(int i = 0; i < nums.length; i++){
            int a = nums[i];
            while(i+1< nums.length && ((nums[i+1] - nums[i]==1) || nums[i+1]== a)){
                i++;
            }
            if(a!= nums[i]){
                list.add(a+"->"+nums[i]);
            } else {
                list.add(a+"");
            }
        }
        return list;
    }
    
    
    
}
