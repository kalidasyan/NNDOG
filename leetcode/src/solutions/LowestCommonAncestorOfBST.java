package solutions;

public class LowestCommonAncestorOfBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return root;
        }
        
        TreeNode n = root;
        while(n != null) {
            if(p.val == n.val || q.val == n.val) {
                return n;
            }
            
            if( (p.val < n.val && q.val > n.val) || (p.val > n.val && q.val < n.val) ){
                return n;
            } else if(p.val < n.val){
                n = n.left;
            } else {
                n = n.right;
            }
        }
        
        return n;
    }
}
