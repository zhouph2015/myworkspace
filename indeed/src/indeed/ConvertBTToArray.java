package indeed;

import java.util.LinkedList;
import java.util.Queue;

public class ConvertBTToArray {
    
    
    private Queue<TreeNode> nodeQueue = new LinkedList<>();
    private Queue<Integer> indexQueue = new LinkedList<>();
    
    public Integer[]  compressTree(TreeNode root){
        int height = getTreeHeight(root);
        int n = (int) Math.pow(2, height);
        Integer[] array = new Integer[n];
        
        nodeQueue.offer(root);
        indexQueue.offer(1);
        while(!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.poll();
            int index = indexQueue.poll();
            array[index] = node.val;
            if(node.left != null){
                nodeQueue.add(node.left);
                indexQueue.add(2 * index);
            }
            
            if(node.right != null){
                nodeQueue.add(node.right);
                indexQueue.add(2 * index +1);
            }
            
          
        }
        return array;
        
    }
    
    private int getTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getTreeHeight(root.left);
        int right = getTreeHeight(root.right);
        return Math.max(left, right) + 1;
    }

    
    
 
    
    
    public static void main(String[] args) throws InterruptedException { 
        ConvertBTToArray sol = new ConvertBTToArray(); 
        TreeNode root = new TreeNode(2); 
        root.left = new TreeNode(4); 
        root.right = new TreeNode(5); 
        root.left.left = new TreeNode(6); 
        root.right.left = new TreeNode(1); 
        root.right.right = new TreeNode(7); 
        root.left.left.left = new TreeNode(8); 
        root.right.right.right = new TreeNode(9); 
        Integer[] result = sol.compressTree(root); 
        for (Integer e : result) {
            System.out.print(e + " ");
            } 
        System.out.println(""); 
        }

    
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val){
        this.val = val;
    }
}
