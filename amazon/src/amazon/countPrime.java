package amazon;

public class countPrime {
	
	public static void main(String args[]){
		
		System.out.println(countPrimes1(100));
		
		System.out.println(countPrimes_two(100));
	}
	
	
	//solution1
	public static int countPrimes1(int n){
		int count = 0;
		for (int i =1; i <n; i++){
			if(isPrime(i)) count++;
		}
		return count;
	}
	
	public static boolean isPrime(int number){
		if (number <=1) return false;
		
		for(int i = 2; i*i <=number; i ++){
			
			if(number%i == 0) return false;
		}
		return true;
	}
	
	
	//solution2
	
	public static int countPrimes_two(int n){
		boolean[] isPrime = new boolean[n];
		
		//initialize all to true
		for(int i =2; i < n; i++){
			isPrime[i]= true;
		}
		
		//marked that are not prime
		for(int i =2; i*i < n; i++){
			if(!isPrime[i]) continue;
			for(int j= i*i; j< n; j+=i){
				isPrime[j] = false;
			}
			
		}
		
		// start to count
		int count =0;
		
		for (int i=2; i <n; i++){
			if(isPrime[i]) count++;
		}
		return count;
	}
	
	

}
