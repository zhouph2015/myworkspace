package dynamicProgram;


public class FibonacciNum {
    
    
    public static void main(String[] args){
        
        System.out.println(solution1(6));
    }
    
    public static int solution1(int n){
        if(n ==0){
            return 0;
        } else if (n == 1){
            return 1;
        } else {
            return solution1(n -1) + solution1(n -2);
        }
        
    }
    
    public static int solution2(int n){
        
        int [] results = new int [n+1];
        results[1] = 1;
        results[2] = 1;
        for (int i =3; i <= n; i++){
            results[i] = results[i-1]+ results[i-2];
        }
        return results[n];
    }

}
