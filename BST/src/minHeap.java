import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class minHeap {
	
	private  int [] array;
	private int size;
	private int position;

	
	
	public minHeap( int size  ){
		
		this.size = size;
		
	}
	
	public minHeap( int [] arr){
		this.size = arr.length;
		this.position = 0;
		if(arr.length > 0){
		    this.array = new int [arr.length +1];
		    
		    for(int i=0; i<arr.length; i++){
		    	insert(arr[i]);
		    }
		}
		
	}
	
	
	public void insert(int x){
		if(position== 0){
			array[1] = x;
			position = 2;
		} else{
			array[position++] = x;
			bubbleUp();
		}
			
		
	}
	
	public void bubbleUp(){
		
		int index = position -1;
		
		while(index >=1 && array[index/2] > array[index]){
			int temp = array[index];
			array[index] = array[index/2];
			array[index/2] = temp;
			index = index/2;
			
		}
		
	}
	
	public int extractMin(){
		int min = array[1];
		array[1]=array[position-1];
		array[position-1]=0;
		position--;		
		sinkDown(1);
		return min;
	}
	
	public void sinkDown(int k) {
		int smallest = k;
		if (2 * k < position && array[2 * k] < array[smallest]) {
			smallest = 2 * k;
		} else if (2 * k + 1 < position && array[2 * k + 1] < array[smallest]) {
			smallest = 2 * k;
		}

		if (smallest != k) {
			swap(k, smallest);
			sinkDown(smallest);
		}
	}
	
	public void swap(int a, int b){
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	

	
	public static void main(String args[]){
		
		Random rn = new Random();
		

		int [] array1 = new int[8];
        for (int i = 0 ; i < 8; i++){
            array1[i] =Math.abs(rn.nextInt()%37);

        }
        
        System.out.println(Arrays.toString(array1));
        minHeap test1 = new minHeap(array1);
        
        
             
        System.out.println(test1.toString());
        
        System.out.println(test1.extractMin());
        
        System.out.println(test1.toString());

	}
	
	/*
	private void sinkDown(int index) {
		int left = 2 * index + 1;
		int right = 2 * index + 2;
		int smallest = 0;

		if (left <= heapSize && array.get(left) < array.get(index))
			smallest = left;
		else
			smallest = index;

		if (right <= heapSize && array.get(right) < array.get(smallest))
			smallest = right;

		if (smallest != index) {
			Integer temp = array.get(index);
			array.set(index, array.get(smallest));
			array.set(smallest, temp);
			sinkDown(smallest);
		}
	}
	
	
	private void BuildMinHeap(){
		heapSize= array.size() -1;
		
		for( int i = array.size()/2; i >= 0; i--){
			MinHeapIFY(i);
		}
	}
	*/
	
	public String toString(){
		
		return Arrays.toString(array);
		
	}

}
