package solutions;

import java.util.Stack;

public class KthSmallestElementBST {
    public int kthSmallest(TreeNode root, int k) {
    	Stack<Integer> stack = new Stack<Integer>();
    	inOrder(root, stack, k);
    	return stack.pop();
    }
    
    private void inOrder(TreeNode root, Stack<Integer> stack, int k) {
    	if(stack.size() == k) return;
    	if(root == null) return;
    	inOrder(root.left, stack, k);
    	if(stack.size() == k) return;
    	stack.push(root.val);
    	inOrder(root.right, stack, k);
    }
}
