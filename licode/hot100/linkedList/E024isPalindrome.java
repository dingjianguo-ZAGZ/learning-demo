package linkedList;

import java.util.List;
import java.util.ResourceBundle;

/**
 * 回文链表
 */
public class E024isPalindrome {
    public boolean isPalindrome(ListNode head) {
        if(head.next == null){
            return true;
        }
        //前半部分结束节点
        ListNode firstHalfEnd = endOfFirstHalf(head);
        //反转后的后半部分链表
        ListNode secondHalfStart = reverse(firstHalfEnd.next);

        //判断是否是回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean res = true;
        while (res && p2 != null){
            //比较
            if(p1.val != p2.val){
                res = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        //还原链表
        firstHalfEnd.next = reverse(secondHalfStart);
        return res;
    }

    /**
     * 反转后半部分链表
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    /**
     * 找到中间节点
     * @param head
     * @return
     */
    public ListNode endOfFirstHalf(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next.next != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
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
