

public class RabbitApp {
    
    public static void main(String[] args){
        
        Rabbit rab = new Rabbit();
        Tortise tor = new Tortise();
        tor.start();
        rab.start();
        
        for (int i = 0; i < 100; i++){
            System.out.println("main run=> " +i + " steps");
        }
    }

}
