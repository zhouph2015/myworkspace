package indeed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSAlgorithm {
    
    private static  Queue<Node> queue = new LinkedList<Node>();
    private static ArrayList<Node> nodes = new ArrayList<Node>();
    
    
    

}


class Node {
    int data;
    boolean visited;
    
    public Node(int data){
        this.data = data;
    }
}
