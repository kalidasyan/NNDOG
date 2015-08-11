package solutions;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
	
	public static ListNode buildList(int[] array) {
		if(array == null || array.length == 0) {
			return null;
		}
    	ListNode head = new ListNode(array[0]);
    	ListNode n = head;
    	for(int i = 1; i < array.length; i++) {
    		n.next = new ListNode(array[i]);
    		n = n.next;
    	}
    	n.next = null;
    	
    	return head;
	}
	
	public static void printList(ListNode head) {
		ListNode h = head;
		while(h != null) {
			System.out.print(h.val + ", ");
			h = h.next;
		}
		System.out.println();
	}
}
