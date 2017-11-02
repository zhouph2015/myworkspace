

public class Web12306  implements Runnable{
    private int num = 10;
    
    @Override
    public void run(){
        while(true){
            
            test4();
        }
       
    }
    
    public void test(){
        if(num <= 0){
            return;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " has get ticket: " + num--);
    }
    
    
    public synchronized void test1(){
        if(num <= 0){
            return;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " has get ticket: " + num--);
    }
    
    
    public void test2(){
        
        synchronized (this) {

            if (num <= 0) {
                return;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " has get ticket: " + num--);
        }
    }

    public void test3() {
        synchronized (this) {
            if (num <= 0) {
                return;
            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " has get ticket: " + num--);
    }
    
    public void test4() {

        synchronized ((Integer) num) {

            if (num <= 0) {
                return;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " has get ticket: " + num--);
        }
    }
}
