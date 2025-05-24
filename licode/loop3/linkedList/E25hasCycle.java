package linkedList;

public class E25hasCycle {
    public boolean hasCycle(ListNode head) {
        //快慢指针，有环，会相逢
        ListNode f = head;
        ListNode s = head;
        while (f != null && f.next != null ){
            f = f.next.next;
            s = s.next;
            if(s == f) return true;
        }
        return false;
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
