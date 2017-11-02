package Cardcode;


public class Counter {
    public volatile static int count = 0;
    public static void inc(){
        
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        increase();
    }
    
    public synchronized static void increase() {
        count++;
    }

    public static void main(String[] args) throws InterruptedException{
        for (int i = 0; i < 1000; i++){
            new Thread( new Runnable(){
                @Override
                public void run(){
                    Counter.inc();
                }
            }).start();
        }
        
        Thread.sleep(1000);
        System.out.println("results Counter.count=" + Counter.count);
    }
}
