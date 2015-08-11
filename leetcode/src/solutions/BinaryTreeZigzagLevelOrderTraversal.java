package solutions;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<TreeNode> level = new ArrayList<TreeNode>();
    	
    	if(root == null) {
    		return result;
    	}
    	level.add(root);
    	boolean leftToRight = true;
    	while(!level.isEmpty()) {
    		traversal(result, level, leftToRight);
    		leftToRight = !leftToRight;
    		List<TreeNode> nextLevel = new ArrayList<TreeNode>();
    		for(TreeNode node : level) {
    			if(node.left != null){
    				nextLevel.add(node.left);
    			}
    			if(node.right != null){
    				nextLevel.add(node.right);
    			}
    		}
    		level = nextLevel;
    	}
    	
    	return result;
    }

	private void traversal(List<List<Integer>> result, List<TreeNode> level,
			boolean leftToRight) {
		List<Integer> value = new ArrayList<Integer>();
		if(leftToRight) {
			for(int i = 0; i < level.size(); i++) {
				value.add(level.get(i).val);
			}
		} else {
			for(int i = level.size() - 1; i >= 0; i--) {
				value.add(level.get(i).val);
			}
		}
		
		result.add(value);
	}
}
