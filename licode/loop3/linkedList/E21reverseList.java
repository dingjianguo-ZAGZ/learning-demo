package linkedList;

/**
 * 反转链表
 */
public class E21reverseList {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;

        //双指针迭代
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null){
            //记录下一个节点
            next = curr.next;
            //操作当前节点
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
