package linkedList;

/**
 * 环形链表
 */
public class E026detectCycle {
    public ListNode hasCycle(ListNode head) {
        //需要返回环的起点，让快慢指针在起点重合
        ListNode p = new ListNode(-1);
        p.next = head;
        ListNode fast = p;
        ListNode slow = p;
        while (fast != null && fast.next != null){
           fast = fast.next.next;
           slow = slow.next;
           if(slow == fast){
               fast = p;
               while (slow != fast){
                   slow = slow.next;
                   fast = fast.next;
               }
               return slow;
           }
        }
        return null;
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
