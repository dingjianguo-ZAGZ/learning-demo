package linkedList;


import linkedList.Utils.ListNode;

public class E01Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        //设置哨兵节点
        ListNode s = new ListNode(1,head);
        //将哨兵节点加入到头节点之前
        ListNode prev = s;
        ListNode curr = prev.next;
        while (curr != null){
            if(curr.val == val){
                prev.next = curr.next;
            }else {
                prev = curr;
            }
        }
        return head;
    }
}
