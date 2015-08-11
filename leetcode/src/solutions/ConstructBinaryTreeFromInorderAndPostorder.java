package solutions;

public class ConstructBinaryTreeFromInorderAndPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || 
        		inorder.length == 0 || postorder.length == 0 || 
        		inorder.length != postorder.length) {
        	return null;
        }
        
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

	private TreeNode buildTree(int[] inorder, int li, int ri,
			int[] postorder, int lp, int rp) {
		if(li > ri) {
			return null;
		}
		
		if(li == ri) {
			return new TreeNode(inorder[li]);
		} 
		
		TreeNode root = new TreeNode(postorder[rp]);
		int rootIndex = -1;
		int rootVal = postorder[rp];
		for(int i = li; i <= ri; i++) {
			if(inorder[i] == rootVal) {
				rootIndex = i;
				break;
			}
		}
		
		int leftLength = rootIndex - li;
		TreeNode left = buildTree(inorder, li, rootIndex-1,
				postorder, lp, lp + leftLength - 1);
		
		int rightLength = ri - rootIndex;
		TreeNode right = buildTree(inorder, rootIndex+1, ri,
				postorder, rp - rightLength, rp-1);
		
		root.left = left;
		root.right = right;
		
		return root;
	}
}
