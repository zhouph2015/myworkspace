package amazon;

public class InventBST {
	
	public static void main(String [] args){
		
	}
	
	public static TreeNode inventBST(TreeNode root){
		if (root == null) return null;
		
		TreeNode temp = root.left;
		root.left = inventBST(root.right);
		root.right = inventBST(temp);
		return root;
	}

}
