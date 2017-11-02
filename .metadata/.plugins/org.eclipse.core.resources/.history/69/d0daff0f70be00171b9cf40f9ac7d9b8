import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Call {
    
    public static void main(String[] args) throws InterruptedException, ExecutionException{
        ExecutorService serv = Executors.newFixedThreadPool(2);//new ExecutorService();
        Race tortoise = new Race("Tortoise", 1000);
        Race rabbit = new Race("Rabbit", 500);
        Future<Integer> relts1 = serv.submit(tortoise);
        Future<Integer> relts2 = serv.submit(rabbit);
        Thread.sleep(2000);
        tortoise.setFlag(false);
        rabbit.setFlag(false);
       
            Thread.sleep(2000);
            int num1 = relts1.get();
            int num2 = relts2.get();
            System.out.println("Tortoise has run: " + tortoise.getStep() + " steps");
            System.out.println("Rabbit has run: " + rabbit.getStep() + " steps");
       
        
        
        
    }

}
 class Race implements Callable<Integer>{
     
     private String  name;
     private long time;
     private boolean flag = true;
     private int step = 0;
     
     public Race(String name, long time){
         super();
         this.name=name;
         this.time=time;
     }
     public int getStep(){
         return step;
     }
     public void setFlag(boolean flag){
         this.flag=flag;
     }
     

    @Override
    public Integer call() throws Exception {
        // TODO Auto-generated method stub
        
        while(flag){
            Thread.sleep(time);
            step++;

        } 
        return step;
    }
     
 }
