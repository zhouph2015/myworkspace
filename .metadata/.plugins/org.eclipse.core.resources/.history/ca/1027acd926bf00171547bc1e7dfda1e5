

public class DaemonsDonotRunFinally {
    
    public static void main(String[] args) throws InterruptedException{
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
        Thread.sleep(200);
    }

}
