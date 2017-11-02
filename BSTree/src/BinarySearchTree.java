

public class BinarySearchTree {
     private TreeNode root;
public BinarySearchTree(){
    	 
     }
  public BinarySearchTree(TreeNode node){
	    this.root= node;
    	 
     }
     public void insert(Integer value){
    	 root = insert(this.root,value);
     }
     
     public TreeNode getRoot(){
    	 return this.root;
     }
	
     private TreeNode insert( TreeNode node, Integer value){
    	 if (node == null){
    		 node = new TreeNode(value);
    	 } else if( value >= node.val){
    		 node.right= insert(node.right, value);
    	 } else{
    		 node.left = insert(node.left, value);
    	 }
    	 
    	 return node;
     }
     
     public boolean search(Integer value){
    	 
    	 return search(this.root,  value);
     }
     
     private boolean search(TreeNode node, Integer value){
    	 
    	 if(node == null){
    		 return false;
    	 } else if (node.val == value){
    		 return true;
    	 }else if(value >  node.val){
    		 return search(node.right, value);
    	 }else{
    		 return search(node.left, value);
    	 }
     }
     
     
     
     public void deleteItem(Integer value){
    	 root = deleteItem(root, value);
    	 
     }
     
     private TreeNode deleteItem(TreeNode node, Integer value){
    	 if( node == null){
    		 return null;
    	 } else if( value > node.val){
    		 return deleteItem(node.right, value);
    	 } else if( value < node.val){
    		 return deleteItem(node.left, value);
    	 } else {
    		 if(node.left == null && node.right == null){
    			 return null;
    		 }
    		 
    		 if(node.left == null) return node.right;
    		 if(node.right == null) return node.left;
    		 
    		 TreeNode temp = node;
    		 Integer record = findMinimumFromRight(node.right);
    		 node.right = deleteItem(node.right, record);
    		 node.val = record;
    		 
    	 }
         return node;
    	 
     }
     
     
     private Integer findMinimumFromRight(TreeNode node){
    	 if(node.left == null)
    		 return node.val;
    	 
    	 return findMinimumFromRight(node.left);
     }
     
     public void inOrderTraversal(){
    	 inOrderTrversal(root);
     }
     
     public void inOrderTrversal(TreeNode node){
    	 if(node != null){
    		 inOrderTrversal(node.left);
    		 System.out.println(node.val);
    		 inOrderTrversal(node.right);
    		 
    	 }
    	 
     }
     
     public void preOrderTraversal(){
    	 preOrderTrversal(root);
     }
     
     public void preOrderTrversal(TreeNode node){
    	 if(node != null){
    		 System.out.println(node.val);
    		 preOrderTrversal(node.left);
    		 preOrderTrversal(node.right);
    		 
    	 }
    	 
     }
	
	
}
