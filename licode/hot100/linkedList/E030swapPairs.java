package linkedList;

public class E030swapPairs {
    public ListNode swapPairs(ListNode head) {
        //两个节点是一组
        //定义虚拟头节点
        ListNode pre = new ListNode(-1,head);
        ListNode prev = pre;
        ListNode curr = head;
        while (curr != null && curr.next != null){
            //交换节点
            ListNode temp = curr.next.next;
            prev.next = curr.next;
            prev.next.next = curr;
            curr.next = temp;
            //迭代
            prev = curr;
            curr = curr.next;
        }
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
