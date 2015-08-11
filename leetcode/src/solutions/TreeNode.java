package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
	private static final String NULL_VALUE = "#";
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public static TreeNode deserializeTree(String[] nodes) {
		if (nodes == null || nodes.length == 0) {
			return null;
		}

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

		int val = Integer.parseInt(nodes[0]);
		TreeNode root = new TreeNode(val);
		queue.add(root);

		int index = 1;
		while (index < nodes.length && !queue.isEmpty()) {
			TreeNode n = queue.removeFirst();

			//Create left child.
			String strLeft = nodes[index++];
			if (strLeft.equals(NULL_VALUE)) {
				n.left = null;
			} else {
				TreeNode l = new TreeNode(Integer.parseInt(strLeft));
				n.left = l;
				queue.add(l);
			}

			if (index >= nodes.length) {
				break;
			}
			
			//Create right child.
			String strRight = nodes[index++];
			if (strRight.equals(NULL_VALUE)) {
				n.right = null;
			} else {
				TreeNode r = new TreeNode(Integer.parseInt(strRight));
				n.right = r;
				queue.add(r);
			}
		}

		return root;
	}

	public static List<String> serializeTree(TreeNode root) {
		List<String> tree = new ArrayList<String>();
		if (root == null) {
			return tree;
		}

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode n = queue.removeFirst();
			if (n != null) {
				tree.add(String.valueOf(n.val));
				queue.add(n.left);
				queue.add(n.right);
			} else {
				tree.add("#");
			}
		}

		return tree;
	}
	
	public static void printTree(TreeNode root) {
		List<String> serializedTree = TreeNode.serializeTree(root);
		
		for(String node : serializedTree) {
			System.out.print(node + ", ");
		}
		
		System.out.println();
	}
}
