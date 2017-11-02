import java.util.ArrayList;

public class nWayTreeMinCostOption2 {
    
    private static int minCost = Integer.MAX_VALUE;
    private static TreeNode minLeaf = null;
    
    
    public void findMinCostLeaf( TreeNode root, int sum){
        
        if(root != null){
            sum = sum + root.val;
            if(sum < minCost && (root.children == null || root.children.size() == 0)){
                minCost= sum;
                minLeaf = root;
            }
            
            for(TreeNode child: root.children){
                findMinCostLeaf(child, sum);
            }
            
        }
        
    }
    
    public boolean path(TreeNode root, TreeNode leaf){
     
        if(root == null) return false;
        
        if(root == leaf) {
            System.out.print(root.val +" " );
            return true;   
        }
        
        if(root.children != null && root.children.size() != 0){
            for (TreeNode child : root.children){
                if(path(child, leaf)){
                    System.out.print(root.val + " ");
                    return true;   
                }
            }
        }
        
        return false;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1, 3);
        root.children.add(new TreeNode(2, 3));
        root.children.add(new TreeNode(3, 3));
        root.children.add( new TreeNode(4, 3));
       
        root.children.get(0).children.add( new TreeNode(10, 3));
        
        nWayTreeMinCostOption2 test = new nWayTreeMinCostOption2();
        
        test.findMinCostLeaf(root, 0);
        System.out.println(minCost);
        
        System.out.println("Path: ");
        test.path(root, minLeaf);
        
    }


    static class TreeNode {
        int val;
        ArrayList<TreeNode> children;
         
        public TreeNode(int val, int n) {
            this.val = val;
            this.children = new ArrayList<TreeNode>();
        }
    }

}
