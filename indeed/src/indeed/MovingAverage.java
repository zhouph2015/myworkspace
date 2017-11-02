package indeed;

import java.sql.Struct;
import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    
    
    public static void main(String[] args) throws InterruptedException{
        MovingAverage test = new MovingAverage();
        for (int i  =1; i < 100; i++){
            test.record(i);
            Thread.sleep(500);
            System.out.println(test.getAvg());
            
        }
    }
    
    Queue<Record> queue = new LinkedList<Record>();
    int sum = 0;
    
    
    
    
    public void record(int value){
        long createdTime = System.currentTimeMillis();
        queue.offer(new Record(value, createdTime));
        sum = sum+ value;
        
        while(!queue.isEmpty() && queue.peek().timestamp - System.currentTimeMillis() > 300000){
            sum = sum - queue.poll().value;
        }
    }
    
    public double getAvg(){
        
        if( queue.size() > 0){
        return sum/queue.size();
        } else {
            return 0;
        }
    }
    
    


}

class Record{
    int value;
    long timestamp;
    
    public Record( int value, long time){
        this.value = value;
        this.timestamp = time;
    }
}
