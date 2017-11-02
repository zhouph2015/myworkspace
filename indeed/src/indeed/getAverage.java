package indeed;

import java.util.Collections;
import java.util.PriorityQueue;

public class getAverage {
    
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    
    
    public void MedianFinder(){
        
        maxHeap = new PriorityQueue<Integer>(1,Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>();
        
    }
    
    public void addNum(int num){
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        
        if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
        
    }
    
    public int getMedian(){
        if( maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek())/2;
        } else {
            return maxHeap.size();
        }
        
    }

}
