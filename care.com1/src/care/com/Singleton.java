package care.com;


public class Singleton {
    
    public static void main(String[] args){
        
        Singleton first = new Singleton("first");
        Singleton second = new Singleton("second");
        Singleton third = new Singleton("third");
        
        System.out.println(Singleton.getInstance().myname);
        System.out.println(Singleton.getInstance().myname);
        System.out.println(Singleton.getInstance().myname);
        
        
    }
    private Singleton(String name){
        this.myname= name;
    }
    private String myname;
    
    private static Singleton single = null;
    
    public static Singleton getInstance(){
     /*   if(single == null){
            single = new Singleton("first");
        }*/
        return single;
    }

}
