package linkedList;

public class E029removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //定义虚拟节点，因为可能删除的是第一个节点
        ListNode pre = new ListNode(-1,head);
        //定义快慢指针
        ListNode slow = head;
        ListNode fast = head;
        //记录当前节点的前驱节点
        ListNode prev = pre;
        //找到快指针起始位置
        int i = 0;
        while (i<n){
            fast = fast.next;
            i++;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
            prev = prev.next;
        }
        //此时 prev 是要删除节点的前驱节点，slow 是要删除的节点
        prev.next = slow.next;
        return pre.next;
    }

    public class ListNode {
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
