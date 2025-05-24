package linkedList;

public class E24getIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode hA = headA;
        ListNode hB = headB;
        while (true){
            if(hA == hB) return hA;
            if(hA == null){
                hA = headB;
            }else {
                hA = hA.next;
            }
            if(hB == null){
                hB = headA;
            }else {
                hB = hB.next;
            }
        }
    }


    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
