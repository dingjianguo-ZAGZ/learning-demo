package linkedList;

import java.time.temporal.Temporal;
import java.util.LinkedList;

public class E22swapPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        ListNode s = new ListNode(-1,head);
        ListNode prev = s;
        ListNode curr = s.next;
        while (curr != null && curr.next != null){
            ListNode next = curr.next;
            ListNode temp = next.next;
            prev.next = next;
            next.next = curr;
            curr.next = temp;
            prev = curr;
            curr = temp;
        }
        return s.next;
    }
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
