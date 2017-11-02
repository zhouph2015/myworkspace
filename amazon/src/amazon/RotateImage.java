package amazon;

public class RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void rotate(int[][] image){
		if(image == null || image.length <=1) 
			return;
		
		int n = image.length;
		for(int i  = 0; i < n; n++){
			for(int j = i ; j < n; j++){
				int temp = image[i][j];
				image[i][j] = image[j][i];
				image[j][i] = temp;
			}
			
		}
		
		for (int i = 0; i < n; i++){
			
			int head = 0;
			int tail = n - 1;
			
			while(head < tail){
				int temp = image[i][head];
				image[i][head] = image[i][tail];
				image[i][tail] = temp;
				head++;
				tail--;
			}
		}
		
	}

}
