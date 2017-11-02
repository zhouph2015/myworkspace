

public class SynDemo {
    
    public static void main(String[] args){
     
        JvmThread thrd1=  new JvmThread(0);
        JvmThread thrd2=  new JvmThread(0);
        thrd1.start();
        thrd2.start();
    }

}

class JvmThread extends Thread{
    private long time;
    public JvmThread(){
        
    }
    
    public JvmThread(long time){
        this.time=time;
    }
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + "The Jvm created: " +Jvm.getInstance3(time));
    }
}

/*
 * singleton model
 * 1. priviate construct
 * 2. private static variable
 * 3. a public getInstance method
 * 
 */

class Jvm{
    private static Jvm instance = null;
    private Jvm(){        
    }
    
    public static synchronized Jvm getInstance(long time){
        if(null == instance){
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            instance = new Jvm();
        }       
        return instance;
    }
    
    public static Jvm getInstance2(long time){
        synchronized(Jvm.class){
        if(null == instance){
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            instance = new Jvm();
        }   
        }
        return instance;
    }
    
    public static Jvm getInstance3(long time){
        if (null == instance) {
            synchronized (Jvm.class) {
                if (null == instance) {
                    try {
                        Thread.sleep(time);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    instance = new Jvm();
                }
            }
        }
        return instance;
    }
}
