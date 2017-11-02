package care.com2;


public class Monitor implements IMonitor {
    
    private String monitorState = "Stop!";
    private String name;
    private IObject subject;
    
    
    public Monitor(IObject subject, String name){
        this.subject = subject;
        this.name = name;
        System.out.println("I am the Monitor: " + name +" my status is: " + monitorState);
        
    }
    @Override
    public void Update() {
        // TODO Auto-generated method stub
        this.monitorState = subject.subjectState;
        System.out.println("I am the Monitor: " + name +" my status is: " + monitorState);
        
    }

}
