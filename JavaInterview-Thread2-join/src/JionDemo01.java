

public class JionDemo01 extends Thread{
    
    public static void main(String[] args) throws InterruptedException{
        JionDemo01 demo = new JionDemo01();
        Thread t = new Thread(demo);
        t.start();
        
        for (int i = 0; i < 100; i++){
            
            if(10 == i){
                //t.join();
                Thread.yield();
            }
            System.out.println("Main thread: " + i);
           
        }
        
    }
    
    
    @Override
    public void run(){
        for (int i = 0; i < 100; i++){
            System.out.println(" Demo thread: " + i);
        }
    }

}
