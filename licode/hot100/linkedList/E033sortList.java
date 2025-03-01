package linkedList;

/**
 * 排序链表
 */
public class E033sortList {
    public ListNode sortList(ListNode head) {
        //定义递归头，只有一个节点或者节点为空
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = midNode(head);
        //此时，slow节点是中间节点，可以将链表分为两部分
        ListNode rightHead = mid.next;//右链表的起点
        mid.next = null;//断开链表
        ListNode list1 = sortList(head);
        ListNode list2 = sortList(rightHead);
        //合并排序后的两部分链表
        ListNode sorted = merge(list1,list2);
        return sorted;

    }
    public ListNode midNode(ListNode head){
        //找到中间节点
        ListNode slow = head,fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    /**
     *
     * @param head1 第一部分头节点
     * @param head2 第二部分头节点
     * @return 合并后的排序链表
     */
    private ListNode merge(ListNode head1, ListNode head2) {
        //合并后链表的头节点
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead,temp1 = head1,temp2 = head2;
        //将两个有序链表合并
        while (temp1 != null && temp2 != null){
            if(temp1.val <= temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
            }else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        //加上最后一个节点
        temp.next = temp1 == null?temp2:temp1;
        return dummyHead.next;
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
