import java.util.ArrayList;
import java.util.List;

public class nWayTreeMinCost {
    
    private static int minCost = Integer.MAX_VALUE;

    public List<Integer> findMinCostFromRootToLeaf(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> curr = new ArrayList<>();
        curr.add(root.val);

        findMinCostHelper(root, root.val, curr, result);
        return result;
   }

    private void findMinCostHelper(TreeNode root, int cost, List<Integer> 
                                   curr, List<Integer> result) {
       if (root.children == null || root.children.length == 0) {
            if (cost < minCost) {
                minCost = cost;
                result.clear();
                result.addAll(curr);
            }
            return;
        }
        for (TreeNode child : root.children) {
            curr.add(child.val);
            findMinCostHelper(child, cost + child.val, curr, result);
            curr.remove(curr.size() - 1);
        }
    }     

    static class TreeNode {
        int val;
        TreeNode[] children;
         
        public TreeNode(int val, int n) {
            this.val = val;
            this.children = new TreeNode[n];
        }
    }
}
