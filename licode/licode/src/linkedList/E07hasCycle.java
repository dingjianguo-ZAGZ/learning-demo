package linkedList;

import linkedList.Utils.ListNode;

public class E07hasCycle {
    public boolean hasCycle(ListNode head) {
        //快慢指针，快指针比慢指针快n
        //如果有环，快慢指针会重合
        if (head == null || head.next == null) {
            return false;
        }
        //因为开始f == l，与循环条件冲突， 先执行一次
        ListNode f = new ListNode(-1, head);
        ListNode l = new ListNode(-1, head);
        do {
            f = f.next.next;
            l = l.next;
            // 如果快指针指向的节点为null，或者快指针的下一个节点指向为null，说明链表中不存在环
            if (f == null || f.next == null) {
                return false;
            }
        }while (l != f);
        return true;

    }
}
