

public class maxSumLeafToRoot {
    
    static int maxSum = Integer.MIN_VALUE;
    static Node maxLeaf = null;

    
    public void maxSum(Node root, int sum){
        if(root!=null){
            sum = sum +root.data;
            if(sum > maxSum && root.left== null && root.right == null){
                maxLeaf = root;
                maxSum = sum;
            }
            
            maxSum(root.left, sum);
            maxSum(root.right, sum);
        }
        
    }
    
    public boolean path(Node root, Node leaf){
        if(root == null) return false;
        if( root == leaf || path(root.left, leaf) || path(root.right, leaf)){
            System.out.print("" + root.data);
            return true;
        }
           return false;
    } 
    
    public static void main (String[] args) throws java.lang.Exception
    {
        Node root = new Node(1);
        root.left = new Node (2);
        root.right = new Node (3);
        root.left.left = new Node (4);
        root.left.right = new Node (5);
        root.right.left = new Node (6);
        root.right.left.left = new Node (8);

        maxSumLeafToRoot i = new maxSumLeafToRoot();
        i.maxSum(root,0);
        System.out.println("Maximum Sum Leaf to Root path " + maxSum);
        System.out.print("Path :");
        i.path(root,maxLeaf);

    }

}

class Node{
    int data;
    Node left;
    Node right;
    public Node (int data){
        this.data = data;
        left = null;
        right = null;
    }
}