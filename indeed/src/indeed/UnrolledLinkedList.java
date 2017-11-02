package indeed;

import java.util.Scanner;

public class UnrolledLinkedList {
    
    private ULLNode start;
    private ULLNode end;
    private int sizeNode;
    private int nNode;
    
    
    public UnrolledLinkedList(int capacity){
        start = null;
        end = null;
        nNode = 0;
        sizeNode = capacity + 1;
    }
    
    public boolean isEmpty(){
        return start == null;
    }
    
    public void insert (int x){
        if(start == null){
            start = new ULLNode(sizeNode);
            start.array[0] = x;
            start.numElements =1;
            end = start;
            nNode++;
            return;
        }
        
        if( end.numElements +1 <  end.array.length){
            end.array[end.numElements] = x;
            end.numElements++;
        } else {
            ULLNode nextNode = new ULLNode(sizeNode);
            int j = 0;
            for(int i = end.numElements/2 +1; i < end.numElements; i++){
                nextNode.array[j++] = end.array[i];
            }
            end.numElements = end.numElements/2 +1;
            nextNode.array[j++] = x;
            nextNode.numElements= j;
            end.next= nextNode;
            end= nextNode;
            nNode++;
        }
    }
    
    
    public boolean delete(int value){
        if(start == null){
            return false;
        }
        
        ULLNode ptr = start;
        
        for(int i = 0; i < ptr.numElements; i++ ){
            if(ptr.array[i] == value){
                
                for(int j = i; j + 1 < ptr.numElements; j++){
                    ptr.array[j] = ptr.array[j+1];
                }
                ptr.numElements--;
                
                if(ptr.numElements == 0){
                    start = start.next;
                    nNode--;
                }
                
                return true;
            }
        }
        
        while(ptr.next != null){
              for(int i = 0; i < ptr.next.numElements; i++ ){
                if(ptr.next.array[i] == value){
                          
                    for(int j = i; j + 1 < ptr.next.numElements; j++){
                        ptr.next.array[j] = ptr.next.array[j+1];
                    }
                    ptr.next.numElements--;
                    
                    if(ptr.next.numElements == 0){
                        if(ptr.next == end){
                            end = ptr;
                            ptr.next = null;
                            nNode--;
                        } else{
                        ptr.next = ptr.next.next;
                        }
                        nNode --;
                    }
                    return true;
                }
            }
            ptr= ptr.next;
       }
       
        return false;
        
    }
    
    /*  Function to get size of list  */
    public int getSize()
    {
        return nNode;
    }  
    /* Function to clear list */
    public void makeEmpty()
    {
        start = null;
        end = null;
        nNode = 0;
    }
    
    /* Function to display list */
    public void display()
    {
        System.out.print("\nUnrolled Linked List = ");
        if (nNode == 0) 
        {
            System.out.print("empty\n");
            return;
        }
        System.out.println();
        ULLNode ptr = start;
        while (ptr != null)
        {
            for (int i = 0; i < ptr.numElements; i++)
                System.out.print(ptr.array[i] +" ");
            System.out.println();               
            ptr = ptr.next;
        }
    }
    
    public static void main(String[] args)
    {             
        UnrolledLinkedList list = new UnrolledLinkedList(5);
        
    
        
        //list.display();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.insert(8);
        list.display();

    }
    
    
    
    

}



class ULLNode{
    
    ULLNode next;
    int numElements;
    int array[];
    
    
    public ULLNode (int n){
        next =  null;
        numElements = 0;
        array = new int[n];
    }
}
