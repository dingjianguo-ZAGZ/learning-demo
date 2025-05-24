package linkedList;

public class E23removeNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //快慢指针找到倒数第n个节点
        ListNode prev = new ListNode(-1,head);
        ListNode s = prev;
        ListNode f = head;
        //找到起始位置
        while (n > 0){
            f = f.next;
            n--;
        }
        //移动快慢指针
        while (f != null){
            s = s.next;
            f = f.next;
        }
        //f == null，s.next是要被删除的节点
        ListNode temp = s.next.next;
        s.next = temp;
        return prev.next;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
