package solutions;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) {
            return head;
        }
        
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        
        ListNode pre = newHead;
        
        for(int i = 1; i < m; i++) {
            pre = pre.next;
        }
        
        ListNode n1 = pre.next;
        
        for(int i = m+1; i <= n; i++) {
            ListNode n2 = n1.next;
            n1.next = n1.next.next;
            n2.next = pre.next;
            pre.next = n2;
        }
        
        return newHead.next;
    }
}
