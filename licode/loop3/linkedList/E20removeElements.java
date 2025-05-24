package linkedList;

public class E20removeElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        //遍历链表
        ListNode s = new ListNode(-1,head);
        ListNode prev = s;
        ListNode curr = prev.next;

        while (curr != null){
            if(curr.val == val){
                //移除curr
                prev.next = curr.next;
            }else {
                prev = curr;
            }
            curr = curr.next;
        }
        return s.next;
    }
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
