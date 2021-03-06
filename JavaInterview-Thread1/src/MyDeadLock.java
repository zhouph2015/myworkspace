

public class MyDeadLock {
    
    String str1 = "Java";
    String str2 = "UNIX";
     
    Thread trd1 = new Thread("My Thread 1"){
        public void run(){
            while(true){
                
                synchronized(str2)
                {
                   synchronized(str1)
                    {
                        System.out.println(trd1.getName()+ ": "  + str1 + str2);
                    }
                }
            }
        }
    };
     
    Thread trd2 = new Thread("My Thread 2"){
        public void run(){
            while(true){
                synchronized(str2)
                {
                    synchronized(str1)
                    {
                        System.out.println(trd2.getName() +": "+ str2 + str1);
                    }
                }
            }
        }
    };
     
    public static void main(String [] args){
        MyDeadLock mdl = new MyDeadLock();
        mdl.trd1.start();
        mdl.trd2.start();
    }

}
