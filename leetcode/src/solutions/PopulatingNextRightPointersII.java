package solutions;

public class PopulatingNextRightPointersII {
    public void connect(TreeLinkNode root) {
        init(root);
        TreeLinkNode node = null;
        TreeLinkNode preChild = null;
        TreeLinkNode nextHead = root;
        while(nextHead != null) {
        	node = nextHead;
        	preChild = null;
        	nextHead = null;
            while(node != null) {
            	TreeLinkNode child = connectTwoNodes(node.left, node.right);
            	
            	//Get the head of the next level
            	if(nextHead == null && child != null) {
            		nextHead = child;
            	}
            	
            	if(child != null) {
            		if(preChild != null) {
            			preChild.next = child;
            		}
            		if(node.right != null) {
            			preChild = node.right;
            		} else {
            			preChild = node.left;
            		}
            		
            	}
            	
        		node = node.next;
            }
        }

    }
    
    private TreeLinkNode connectTwoNodes(TreeLinkNode left, TreeLinkNode right) {
        if(left == null && right == null) {
            return null;
        } else if (left != null && right == null) {
            return left;
        } else if (left == null && right != null) {
            return right;
        } else {
        	left.next = right;
            return left;
        }
		
	}

	private void init(TreeLinkNode node){
        if(node == null) return;
        
        node.next = null;
        init(node.left);
        init(node.right);
    }
}
