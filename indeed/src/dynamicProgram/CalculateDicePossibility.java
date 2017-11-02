package dynamicProgram;

import java.util.HashMap;

public class CalculateDicePossibility {
    
    static int count = 0;
    static HashMap<Record, Integer>  recordresults = new HashMap<Record, Integer>();
    
    public static void main(String[] args){
        
        System.out.println(solution3(10,500));
        System.out.println(count);
    }
    
    
    public static int solution1( int dices, int target){
        
        //System.out.println("loop");
       if( dices < 1 || target < 1){
           return 0;
       } else if ( dices == 1 && target <=6){
           return 1;
       } else{
           count++;
           return solution1(dices -1, target -1) 
                   +solution1(dices -1, target -2)
                   +solution1(dices -1, target -3)
                   +solution1(dices -1, target -4)
                   +solution1(dices -1, target -5)
                   +solution1(dices -1, target -6);
       }
    }
    
    public static int solution2(int dices, int target){
 
        
/*        recordresults.put(new Record(1,1), 1);
        recordresults.put(new Record(1,2), 1);
        recordresults.put(new Record(1,3), 1);
        recordresults.put(new Record(1,4), 1);
        recordresults.put(new Record(1,5), 1);
        recordresults.put(new Record(1,6), 1);*/
             
        
        
        
        if( dices < 1 || target < 1){
            return 0;
        } else if ( dices == 1 && target <=6){
            return 1;
        } 
        
        Record record = new Record(dices, target);
        
        if(recordresults.containsKey(record)){
            //System.out.println("loop");
            return recordresults.get(record);
           
        } else{
            count++;
            int sum = solution2(dices -1, target -1) 
                    +solution2(dices -1, target -2)
                    +solution2(dices -1, target -3)
                    +solution2(dices -1, target -4)
                    +solution2(dices -1, target -5)
                    +solution2(dices -1, target -6);
            
            recordresults.put(record, sum);
            return sum;
        }
    }

    public static int solution3(int dices, int target) {
        //int total = (int) Math.pow(6, dices);
        int[][] dp = new int[dices + 1][target + 1];

        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= dices; i++) {
            for (int j = 1; j <= target; j++) {
                for (int k = 1; k <= 6 && k < j; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                    count++;
                }
            }
        }

        return dp[dices][target];
    }
}

class Record{
    int dices;
    int target;
    
    public Record( int dices, int target){
        this.dices = dices;
        this.target = target;
    }
    
    @Override
    public int hashCode(){
        final int prime  =31;
        return Long.valueOf( dices * prime + target).hashCode();
        
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
  
        Record r = (Record) obj;
        if (this.dices == r.dices && this.target == r.target) {
            return true;
        } else {
            return false;
        }
    }
  
}
