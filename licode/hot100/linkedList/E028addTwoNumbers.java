package linkedList;

import java.util.Calendar;

public class E028addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //定义头和尾节点
       ListNode head = null,tail = null;
        //进位
        int num = 0;
        while (l1 != null || l2 != null){
            //如果两个链表长度不一样，可以看作一个链表元素和 0 相加
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + num;
            if(head == null){
                head = tail = new ListNode(sum % 10);
            }else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            num = sum / 10; //进位
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        //如果遍历完两个链表之后，还有进位，则需要多加一个节点
        if(num > 0){
            tail.next = new ListNode(num);
        }
        return head;
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
