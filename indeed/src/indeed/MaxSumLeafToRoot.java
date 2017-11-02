package indeed;

import java.util.ArrayList;

public class MaxSumLeafToRoot {
    
    static ArrayList<Integer> results = new ArrayList<Integer>();
    
    
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode (2);
        root.right = new TreeNode (3);
        root.left.left = new TreeNode (4);
        root.left.right = new TreeNode (5);
        root.right.left = new TreeNode (6);
        root.right.left.left = new TreeNode (8);
        
   
        System.out.println(maxSum(root));
        
        System.out.println(results);
        
        System.out.println("feafe");
        
        
        
    
        
    }
    
    
    
    public static int maxSum(TreeNode root){
        if(root == null) return 0;
        
           //results.add(root.val);
           int maxValue = maxSum(root.left);
           TreeNode max = root.left;
           int rightvalue = maxSum(root.right);
           if(rightvalue > maxValue){
               maxValue = rightvalue;
               max = root.right;
           }
           if(max != null)
              results.add(max.val);
           //System.out.println(maxValue);
          return root.val + maxValue;
    }

}


