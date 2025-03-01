package linkedList;

import linkedList.Utils.ListNode;

public class E04swapPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null||head.next==null){
            return head;
        }
        ListNode pre = new ListNode(-1,head);
        ListNode res = pre;


        ListNode first;
        ListNode second;
        ListNode first2;
        while (pre.next != null&&pre.next.next!=null){
            first = pre.next;
            second = pre.next.next;
            first2 = pre.next.next.next;
            pre.next = second;
            second.next = first;
            first.next = first2;
            pre = first;
        }
        return res.next;
    }
}
