package solutions;

public class PopulatingNextRightPointers {
    public void connect(TreeLinkNode root) {
        TreeLinkNode r = root;
        
        while(r != null) {
            r.next = null;
            r = r.right;
        }
        
        if(root != null) {
            connectTwoNodes(root.left, root.right);
        }
    }
    
    private void connectTwoNodes(TreeLinkNode left, TreeLinkNode right) {
        if(left == null || left.next == right) {
            return;
        }
        
        left.next = right;
        connectTwoNodes(left.left, left.right);
        connectTwoNodes(left.right, right.left);
        connectTwoNodes(right.left, right.right);
    }
}
