package indeed;

import java.sql.Struct;
import java.util.ArrayList;

public class MyLinkedList {
    private  Integer MAX_LST = 50;
    private  int NULL = -1;
     ArrayList<Integer> item ;
     ArrayList<Integer> next;
     
     int head;
     int tail;
     int size;
     
     
     public MyLinkedList(){
         head = NULL;
         tail = NULL;
         size = 0;
         item = new ArrayList<>();
         next= new ArrayList<>();
       
         
     }
     
     public void add (Integer value){
    
     }
     
     
     public Struct Node {
         Integer value;
         int index;
     }
}
