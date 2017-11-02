package care.com2;


public class Test {
    
    public static void main(String [] args){
        
        IObject subject = new Subject();
        subject.AddMonitor(new Monitor(subject, "Monitor_1"));
        subject.AddMonitor(new Monitor(subject, "Monitor_2"));
        subject.AddMonitor(new Monitor(subject, "Monitor_3"));

        subject.setSubjectState( "Start!");
        subject.SendMessage();

        
    }

}
