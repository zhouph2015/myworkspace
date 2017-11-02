import java.util.Deque;
import java.util.LinkedList;

public class maxDepthTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree  testTree = new BinarySearchTree();
		testTree.insert(4);
		testTree.insert(5);
		testTree.insert(3);
		testTree.insert(9);
		testTree.insert(1);
		testTree.insert(24);
		testTree.insert(6);
		
		System.out.println(maxDepth_one(testTree.getRoot()));
		
		

	}
	
	public static int maxDepth_one(TreeNode root){
		if(root==null) return 0;
		return 1+ Math.max(maxDepth_one(root.left), maxDepth_one(root.right));
	}
	
	public static int maxDepth_two(TreeNode root){
		if(root == null) return 0;
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		
		stack.push(root);
		int count = 0;
		
	}

}
