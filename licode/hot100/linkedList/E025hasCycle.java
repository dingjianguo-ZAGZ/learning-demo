package linkedList;

/**
 * 环形链表
 */
public class E025hasCycle {
    public boolean hasCycle(ListNode head) {
        //快慢指针，能相遇，说明有环
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
