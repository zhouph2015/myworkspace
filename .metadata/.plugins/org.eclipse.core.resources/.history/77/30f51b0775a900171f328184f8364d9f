package care.com2;

import java.util.ArrayList;
import java.util.List;

public class Subject extends IObject {
    private List<IMonitor> monitorList;// = new ArrayList<IMonitor>();
    
    
    public Subject(){
        this.monitorList  = new ArrayList<IMonitor>();
    }

    @Override
    public void AddMonitor(IMonitor monitor) {
        // TODO Auto-generated method stub
        monitorList.add(monitor);
    }

    @Override
    public void RemoveMonitor(IMonitor monitor) {
        // TODO Auto-generated method stub
        monitorList.remove(monitor);
    }

    @Override
    public void SendMessage() {
        // TODO Auto-generated method stub
        for (IMonitor m : monitorList)  //发送给所有添加过的观察者，让观察者执行update方法以同步更新自身状态
        {
            m.Update();
        }
        
    }

    public List<IMonitor> getMonitorList() {
        return monitorList;
    }

    public void setMonitorList(List<IMonitor> monitorList) {
        this.monitorList = monitorList;
    }

    
    
    
    

}
