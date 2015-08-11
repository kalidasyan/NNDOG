package solutions;


public class ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
		if(num == null || num.length == 0) {
			return null;
		}
		
		return sortedArrayToBST(num, 0, num.length-1);
	}
	
	private TreeNode sortedArrayToBST(int[] num, int left, int right) {
		if(left > right) {
			return null;
		}
		
		if(left == right) {
			return new TreeNode(num[left]);
		}
		
		int middle = (left + right) / 2;
		
		TreeNode root = new TreeNode(num[middle]);
		TreeNode l = sortedArrayToBST(num, left, middle-1);
		TreeNode r = sortedArrayToBST(num, middle + 1, right);
		root.left = l;
		root.right = r;
		
		return root;
	}
	
	public void test() {
		int[] num = new int[]{1,2,3,4,5,6};
		TreeNode root = sortedArrayToBST(num);
		TreeNode.printTree(root);
	}
}
