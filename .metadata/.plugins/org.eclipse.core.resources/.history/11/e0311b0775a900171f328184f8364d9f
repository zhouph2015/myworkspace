package care.com2;

import java.util.List;

public  abstract class IObject {
    
    String subjectState;
    
    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }
    
    abstract void AddMonitor(IMonitor monitor);  //添加一个观察者

    abstract void RemoveMonitor(IMonitor monitor); //移除一个观察者

    abstract void SendMessage(); //向所有观察者发送消息

}
