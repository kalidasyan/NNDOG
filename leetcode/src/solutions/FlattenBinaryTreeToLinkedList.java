package solutions;

import java.util.List;

public class FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
		if(root == null) {
			return;
		}
		twist(root);
	}
	
	private TreeNode twist(TreeNode node) {
		TreeNode l = node.left;
		TreeNode r = node.right;
		
		if(l != null && r != null){
			node.left = null;
			node.right = l;
			TreeNode leftLast = twist(l);
			leftLast.right = r;
			return twist(r);
		} else if(l == null && r != null){
			return twist(r);
		} else if(l != null && r == null) {
			node.left = null;
			node.right = l;
			return twist(l);
		} else {
			return node;
		}
	}
	
	public void test() {
//		String[] tree = new String[]{"1", "2", "3", "#", "#", "#", "4"};
//		String[] tree = new String[]{"1", "2", "3", "4", "#", "#", "5", "#", "#", "#", "6"};
		String[] tree = new String[]{"1", "2", "5", "3", "4", "#", "6"};
		TreeNode root = TreeNode.deserializeTree(tree);
		flatten(root);
		List<String> newTree = TreeNode.serializeTree(root);
		
		for(String node : newTree) {
			System.out.print(node + ", ");
		}
	}
}
