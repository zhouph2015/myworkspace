package amazon;

public class findMaxProfit {
	
	public static void main(String args[]){
		
		int[] prices = new int[]{7, 1, 5, 3, 6, 4, 9, 1, 14};
		System.out.println(maxProfit(prices));
		System.out.println(maxProfit_two(prices));
		
	}
	
	
	public static int maxProfit(int [] prices){
		
		int Max = 0;
		
		for(int i = 0 ; i < prices.length; i++){
			for (int j = i + 1; j < prices.length; j++){
				int temp = prices[j] - prices[i];
				if (temp > Max) Max = temp;
				
			}
			
		}
		return Max;
	}
	
	
	public static int maxProfit_two(int[] prices){
		if( prices.length == 0) return 0;
		
		int max = 0;
		int sofaMin = prices[0];
		
		for(int i = 0; i < prices.length; i++){
			if(prices[i] > sofaMin){
				max = Math.max(max, prices[i] - sofaMin);
			}else{
				sofaMin = prices[i];
			}
		}
				
		return max;
	}

}
