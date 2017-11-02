package indeed;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ConvertHashSettoTreeSet {
    
    public static void main(String [] args){
        
        HashSet<String> hset= new HashSet<String>();
        hset.add("Element1");
        hset.add("Element2");
      
        hset.add("Element4");
        hset.add("Element3");
        
        System.out.println("HashSet contains: "+ hset);
        
        Set<String> tset = new TreeSet<String>(hset);
        
        System.out.println("TressSet contains: "+ tset);
        
        
        
    
        
    }

}
