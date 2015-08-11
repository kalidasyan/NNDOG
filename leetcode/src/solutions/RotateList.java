package solutions;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return head;
        }
        
        ListNode n = head;
        int length = 0;
        while(n.next != null) {
            length++;
            n = n.next;
        }
        n.next = head;
        length++;
        
        k = k % length;
        
        if(k == 0) {
        	n.next = null;
            return head;
        }
        
        int steps = length - k - 1;
        n = head;
        for(int i = 0; i < steps; i++) {
            n = n.next;
        }
        
        ListNode newHead = n.next;
        n.next = null;
        
        return newHead;
    }
    
    public void test() {
    	int[] list = new int[]{1,2,3,4,5};
    	ListNode head = ListNode.buildList(list);
    	ListNode newHead = rotateRight(head, 6);
    	ListNode.printList(newHead);
    }
}
