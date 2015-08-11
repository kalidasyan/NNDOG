package solutions;

import java.util.Stack;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stackP = new Stack<TreeNode>();
        Stack<TreeNode> stackQ = new Stack<TreeNode>();
        
        boolean containsP = findPath(root, p, stackP);
        boolean containsQ = findPath(root, q, stackQ);
        
	    TreeNode commonParent = null;
	    if(!containsP || !containsQ) {
	        return commonParent;
	    }
	    
	    while(!stackP.isEmpty() && !stackQ.isEmpty() && stackP.peek() == stackQ.peek()){
	        commonParent = stackP.pop();
	        stackQ.pop();
	    }
	    
	    return commonParent;
    }
    
    public boolean findPath(TreeNode root, TreeNode n, Stack<TreeNode> stack) {
        if(root == null) return false;
        //Do not compare value, compare the reference directly!!
        if(root == n || findPath(root.left, n, stack) || findPath(root.right, n, stack)) {
            stack.push(root);
            return true;
        }
        return false;
    }
}