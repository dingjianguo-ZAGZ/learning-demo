package linkedList;

import linkedList.Utils.ListNode;

import java.util.List;

public class E03reverseList {
    public ListNode reverseList(ListNode head) {
        if(head.next == null){
            return head;
        }
        ListNode NewHead = new ListNode(0,head);
        ListNode curr = head.next;
        //遍历链表
        while (curr != null){
            ListNode really = curr.next;

            curr.next = NewHead;
            NewHead = curr;
            curr = really;
        }
        return NewHead;

    }
}
