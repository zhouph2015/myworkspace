package indeed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class AdStore {
    
    HashMap<Integer, Integer>  store;
    
    
    public static void main(String[] args){
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i <9; i++){
            list.add(i*10);
            
        }
        
        AdStore adstore = new AdStore(list);
        while( adstore.store.size() > 0){
            System.out.println(adstore.get());
        }
    }
    
    
    public AdStore(List<Integer> list){
        store = new HashMap<Integer, Integer>();
        for(int i = 1; i <= list.size(); i++){
            store.put(i, list.get(i-1));
        }
    }
    
    public int get(){
        if(store.size()== 0) return 0;
        int size = store.size();
        int results;
        Random rdm = new Random();
        int returnIndex = Math.abs(rdm.nextInt())%size +1;
        if (returnIndex < size){
            results= store.get(returnIndex);
            store.put(returnIndex, store.get(size));
            store.remove(size);
        } else{
            results= store.get(returnIndex);
            store.remove(returnIndex);
        }
        return results;
    }

}
