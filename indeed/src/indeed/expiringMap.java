package indeed;

import java.util.HashMap;

public class expiringMap<K, V> extends HashMap<K,V> {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    
    HashMap<K, ValueWithTime> map = new HashMap<K, ValueWithTime>();

    public static void main(String[] args) throws InterruptedException{
        
        expiringMap<Integer, Integer> testmap = new expiringMap<Integer, Integer>();
        testmap.put(4, 6);
        System.out.println(testmap.get(4));
        
        Thread.sleep(200);
        
        System.out.println(testmap.get(4));
    }
    
    
    
    
    
    public V put(K key, V value){
        
        ValueWithTime<V> v = new ValueWithTime<V>();
        v.value= value;
        v.createdTime = System.currentTimeMillis();
        
        return (V) map.put(key, v);
        
    }
    @Override
    public V get(Object key){
        ValueWithTime value = map.get(key);
        
        if (value != null){
            long currentTime = System.currentTimeMillis();
            
            if(currentTime - value.createdTime <= 1000){
                return (V)value.value;
            } else {
                return null;
            }
        } 
        return null;
    }
    
    
    
    
}




