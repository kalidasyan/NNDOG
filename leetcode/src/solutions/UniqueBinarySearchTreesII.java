package solutions;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    
    private static final List<TreeNode> NULL_TREE = new ArrayList<TreeNode>();
    static {
        NULL_TREE.add(null);
    }
    
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        
        if(n < 1) {
        	result.add(null);
            return result;
        }
        
        List<List<List<TreeNode>>> uniqueTrees = new ArrayList<List<List<TreeNode>>>();
        for(int i = 0; i < n; i++) {
        	List<List<TreeNode>> row = new ArrayList<List<TreeNode>>();
        	for(int j = 0; j < n; j++) {
        		row.add(new ArrayList<TreeNode>());
        	}
        	uniqueTrees.add(row);
        }
        
        for(int i = 0; i < n; i++) {
        	uniqueTrees.get(i).get(i).add(new TreeNode(i+1));
        }
        
        for(int i = n-2; i >= 0; i--) {
            for(int j = i+1; j < n; j++) {
                buildTrees(uniqueTrees, i, j);
            }
        }
        
        return uniqueTrees.get(0).get(n-1);
    }
    
    private void buildTrees(List<List<List<TreeNode>>> uniqueTrees, int lower, int upper) {
    	List<TreeNode> trees = uniqueTrees.get(lower).get(upper);
    	
		for(int i = lower; i <= upper; i++) {
			List<TreeNode> leftTrees = NULL_TREE;
			if(lower <= i - 1) {
				leftTrees = uniqueTrees.get(lower).get(i-1);
			}
			
			List<TreeNode> rightTrees = NULL_TREE;
			if(i + 1 <= upper) {
				rightTrees = uniqueTrees.get(i+1).get(upper);
			}
			combineTrees(trees, i+1, leftTrees, rightTrees);
		}
		
	}

	private void combineTrees(List<TreeNode> trees, int rootValue,
			List<TreeNode> leftTrees, List<TreeNode> rightTrees) {
		for(TreeNode left : leftTrees) {
			for(TreeNode right : rightTrees) {
				TreeNode root = new TreeNode(rootValue);
				root.left = left;
				root.right = right;
				trees.add(root);
			}
		}
	}
	
	public void test() {
		List<TreeNode> trees = generateTrees(4);
		for(TreeNode tree : trees) {
			TreeNode.printTree(tree);
		}
	}
}
