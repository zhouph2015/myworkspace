package indeed;


class ValueWithTime<V>{
    V value;
    long createdTime;
    
    

public void ValueWithTime(V v){
    this.value=v;
    this.createdTime = System.currentTimeMillis(); 
}
}

