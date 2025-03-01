package linkedList;

/**
 * 相交链表
 */
public class E022getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;
        while (true){
            if(currA == currB){
                return currA;
            }
            if(currA != null){
                currA = currA.next;
            }else {
                currA = headB;
            }
            if(currB != null){
                currB = currB.next;
            }else {
                currB = headA;
            }
        }
    }
    private class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
