package amazon;

public class isMirrorTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean isMirrorTree(TreeNode root){
		if(root == null) return true;
		return isMirrorTrees(root.left, root.right);
		
	}
	
	public static boolean isMirrorTrees(TreeNode left, TreeNode right){
		if(left == null && right == null) return true;
		if(left == null) return false;
		if(right == null) return false;
		return (left.val==right.val)&&isMirrorTrees(left.right, right.left)&&isMirrorTrees(left.left, right.right);
		
	}

}
