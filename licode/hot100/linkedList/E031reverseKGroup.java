package linkedList;

public class E031reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        //定义虚拟头节点
        ListNode hair = new ListNode(-1,head);
        //当前节点的前驱节点
        ListNode pre = hair;
        while (head != null){
            //每一部分的尾节点
            ListNode tail = pre;
           //判断剩余部分 的长度是否大于 K
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if(tail == null){
                    //如果长度小于 k 直接返回
                    return hair.next;
                }
            }
            //下一部分的第一个节点
            ListNode next = tail.next;
            //反转链表
            ListNode[] reverse = reverse(head,tail);
            head = reverse[0];
            tail = reverse[1];
            //把子链表重新接回原链表
            pre.next = head;
            tail.next = next;
            pre = tail;
            head = tail.next;
        }
        return hair.next;
    }

    /**
     * 反转链表
     * @param head
     * @param tail
     * @return
     */
    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail){
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p =next;
        }
        //返回反转后的子链表，头尾反转
        return new ListNode[]{tail,head};
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
