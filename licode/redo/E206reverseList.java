public class E206reverseList {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode pre = prev;
        while ( curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            pre.next = next;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private class ListNode {
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
