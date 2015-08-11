package solutions;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
    	if(root == null) {
    		return root;
    	}
    	
    	invert(root);
    	
    	return root;
    }

	private void invert(TreeNode n) {
		if(n == null) {
			return;
		}
		
		TreeNode left = n.left;
		TreeNode right = n.right;
		n.right = left;
		n.left = right;
		invert(left);
		invert(right);
	}
    
    public void test(){
    	String[] nodes = new String[]{"4", "2", "#", "1", "3", "6", "9"};
    	TreeNode root = TreeNode.deserializeTree(nodes);
    	root = invertTree(root);
    	TreeNode.printTree(root);	
    }
}
