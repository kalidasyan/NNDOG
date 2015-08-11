package solutions;

public class ConvertSortedListToBinarySearchTree {
	
	ListNode node = null;
	
	public TreeNode sortedListToBST(ListNode head) {
		if(head == null) {
			return null;
		}
		
		node = head;
		int len = 0;
		while(node != null) {
			len++;
			node = node.next;
		}
		node = head;
		
		return buildTree(0, len-1);
	}

	private TreeNode buildTree(int left, int right) {
		if(left > right) {
			return null;
		}
		
		int middle = (left + right) / 2;
		TreeNode l = buildTree(left, middle-1);
		TreeNode root = new TreeNode(node.val);
		node = node.next;
		TreeNode r = buildTree(middle + 1, right);
		root.left = l;
		root.right = r;
		
		return root;
	}
	
	public void test() {
		int[] array = new int[]{1,2,3,4,5,6};
		ListNode head = ListNode.buildList(array);
//		ListNode.printList(head);
		
		TreeNode root = sortedListToBST(head);
		TreeNode.printTree(root);
	}
}
