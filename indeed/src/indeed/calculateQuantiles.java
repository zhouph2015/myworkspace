package indeed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class calculateQuantiles {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long Q = scanner.nextInt();
        int M = scanner.nextInt();
        long N = 0;
        Pair[] pairs = new Pair[M];
        for (int i = 0; i < M; i++) {
            int v = scanner.nextInt();
            long c = (long) scanner.nextInt();
            N += c;
            Pair pair = new Pair(v, c);
            pairs[i] = pair;
        }
        // sort the array according to the vi
        Arrays.sort(pairs, new MyPairComparator());
        // Calculate the accmulated count
        for (int i = 1; i < M; i++) {
            pairs[i].count += pairs[i - 1].count;
        }
        // Find all the quantiles
        @SuppressWarnings("rawtypes")
        List<Integer> result = findQuantiles(N, Q, pairs);
        for (Integer num : result) {
            System.out.println(num);
        }
        scanner.close();
    }

    public static List findQuantiles(long N, long Q, Pair[] pairs) {
        List<Integer> result = new ArrayList<Integer>();
        if (N <= 0 || Q <= 1 || pairs == null || pairs.length == 0) {
            return result;
        }
        // Find the i-th quantile
        for (long i = 1; i < Q; i++) {
            long index = (long) Math.ceil((double) N * i / Q);
            int quantile = binarySearch(pairs, index);
            result.add(quantile);
        }
        return result;
    }
    
    
    
    private static int binarySearch(Pair[] pairs, long target){
        int lo = 0;
        int hi = pairs.length -1;
        while(lo + 1 < hi){
            int mid = lo +(hi - lo)/2;
            
            if(pairs[mid].count == target){
                return pairs[mid].value;
            } else if( pairs[mid].count > target){
                hi = mid;
            }else{
                lo = mid;
            }
        }
        
        if(pairs[lo].count >= target){
            return pairs[lo].value;
        }else{
            return pairs[hi].value;
        }
        
    }
    
    static class Pair {
        int value;
        long count;
        
        public Pair(int value, long count){
            this.value=value;
            this.count= count;
        }
    }
    
    
    static class MyPairComparator implements Comparator<Pair>{

        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.value - o2.value;
        }
        
    }

}
