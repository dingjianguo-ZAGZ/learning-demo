public class E24swapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode s = new ListNode(-1,head);
        ListNode curr = s;
        ListNode next = s.next;
        while (next != null && next.next != null){
            ListNode temp = next.next;
            curr.next = temp;
            next.next = temp.next;
            temp.next = next;
            curr = next;
            next = curr.next;
        }
        return s.next;
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
