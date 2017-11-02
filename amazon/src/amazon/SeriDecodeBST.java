package amazon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SeriDecodeBST {
	private static final String SEP = ",";
    private static final String NULL = "null";
	
    public static void main(String [] args){
    	BinarySearchTree tree = new BinarySearchTree();
    	tree.insert(5);
    	tree.insert(2);
    	tree.insert(1);
    	tree.insert(7);
    	tree.insert(6);
    	tree.insert(8);
    	tree.inOrderTraversal();
    	
    	System.out.println("****");
    	
       	tree.preOrderTraversal();
    	
    	String resutls =serialize(tree.getRoot());
        System.out.println(resutls);
        
        TreeNode newtree = deserialize(resutls);
        
        BinarySearchTree tree2 = new BinarySearchTree(newtree);
        
    	tree2.inOrderTraversal();
    	
    	System.out.println("****");
    	
       	tree2.preOrderTraversal();
    	
    }
    
    public static String serialize(TreeNode root){
    	StringBuilder sb = new StringBuilder();
    	if(root == null) return NULL;
    	
    	Stack<TreeNode> st= new Stack<TreeNode>();
    	st.push(root);
    	while(!st.empty()){
    		root = st.pop();
    		sb.append(root.val).append(SEP);
    		if(root.right!= null) st.push(root.right);
    		if(root.left!= null) st.push(root.left);
    		
    	}
      	return sb.toString();
    }
    
    
    
    
 // Decodes your encoded data to tree.
    // pre-order traversal
    public static TreeNode deserialize(String data) {
        if (data.equals(NULL)) return null;
        String[] strs = data.split(SEP);
        Queue<Integer> q = new LinkedList<>();
        for (String e : strs) {
            q.offer(Integer.parseInt(e));
        }
        return getNode(q);
    }
    
    // some notes:
    //   5
    //  3 6
    // 2   7
    private static TreeNode getNode(Queue<Integer> q) { //q: 5,3,2,6,7
        if (q.isEmpty()) return null;
        TreeNode root = new TreeNode(q.poll());//root (5)
        Queue<Integer> samllerQueue = new LinkedList<>();
        while (!q.isEmpty() && q.peek() < root.val) {
            samllerQueue.offer(q.poll());
        }
        //smallerQueue : 3,2   storing elements smaller than 5 (root)
        root.left = getNode(samllerQueue);
        //q: 6,7   storing elements bigger than 5 (root)
        root.right = getNode(q);
        return root;
    }
}
