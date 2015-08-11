package solutions;

public class ConstructBinaryTreeFromPreorderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || 
        		preorder.length == 0 || inorder.length == 0 || 
        		preorder.length != inorder.length) {
        	return null;
        }
        
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
	private TreeNode buildTree(int[] preorder, int lp, int rp,
			int[] inorder, int li, int ri) {
		if(lp > rp) {
			return null;
		}
		
		if(lp == rp) {
			return new TreeNode(preorder[lp]);
		} 
		
		int rootVal = preorder[lp];
		TreeNode root = new TreeNode(rootVal);
		int rootIndex = -1;
		
		for(int i = li; i <= ri; i++) {
			if(inorder[i] == rootVal) {
				rootIndex = i;
				break;
			}
		}
		
		int leftLength = rootIndex - li;
		TreeNode left = buildTree(preorder, lp + 1, leftLength + lp,
				inorder, li, rootIndex - 1);
		
		int rightLength = ri - rootIndex;
		TreeNode right = buildTree(preorder, rp + 1 - rightLength, rp,
				inorder, rootIndex+1, ri);
		
		root.left = left;
		root.right = right;
		
		return root;
	}
}
