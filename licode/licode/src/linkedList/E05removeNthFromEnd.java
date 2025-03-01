package linkedList;

import linkedList.Utils.ListNode;

public class E05removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //快慢指针
        //定义哨兵节点
        ListNode s = new ListNode(-1,head);
        ListNode f = s;
        ListNode l = s;
        //始终保持f 和 l差n+1个节点
        for (int i = 0; i < n; i++) {
            f = f.next;
        }
        while (f.next != null) {
            f = f.next;
            l = l.next;
        }
        l.next = l.next.next;
        return s.next;

    }

}
