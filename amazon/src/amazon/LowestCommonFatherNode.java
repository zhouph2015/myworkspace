package amazon;

public class LowestCommonFatherNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public static TreeNode lowestCommonFater(TreeNode root, TreeNode p, TreeNode q){
		if( p.val < root.val&& 	q.val < root.val){
			return lowestCommonFater(root.left, p, q);
     	} else if( p.val > root.val && q.val > root.val){
     		return lowestCommonFater(root.right, p, q);
     	} else{
     		return root;
     	}
		
	}
	
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (root.val > p.val && root.val > q.val)
                root = root.left;
            else if (root.val < p.val && root.val < q.val)
                root = root.right;
            else
                return root;
        }
    }
	
	

}
