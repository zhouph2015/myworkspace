package indeed;


public class CommonAncestorOfGitNode {
    
    
    public int getHeight(GitNode node){
        int height = 0;
        while( node.parent != null){
            height++;
            node = node.parent;
        }
        return height;
    }
    
    
    public GitNode lowestCommonNode(GitNode node1, GitNode node2){
        if(node1 == null || node2 == null) return null;
        
        int h1 = getHeight(node1);
        int h2 = getHeight(node2);
        if(h1 < h2){
            node2=node2.parent;
            h2--;
        }
        if(h2 < h1){
            node1=node1.parent;
            h1--;
        }
        
        while(node1 != null && node2!=null){
            if(node1==node2){
                return node1;
            }else{
                node1=node1.parent;
                node2=node2.parent;
            }
            
           
        }
        return null;
        
    }

}



class GitNode{
    int val;
    GitNode left;
    GitNode right;
    GitNode parent;
    
    public GitNode(int value){
        this.val = value;
        left = null;
        right = null;
        parent = null;
        
    }
}






