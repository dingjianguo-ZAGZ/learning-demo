package linkedList;

/**
 * 反转链表
 */
public class E023reverseList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        return reverse(prev,head);
    }

    public ListNode reverse(ListNode prev, ListNode curr) {
        //递归终止条件
        if (curr == null) {
            return prev;
        }
        ListNode temp = curr.next;
        curr.next = prev;
        return reverse(curr, temp);
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
