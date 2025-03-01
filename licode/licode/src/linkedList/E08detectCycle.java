package linkedList;

import linkedList.Utils.ListNode;

public class E08detectCycle {
    public ListNode detectCycle(ListNode head) {
        //找到环的入口 正好走 a + x圈
        ListNode f = head;
        ListNode l = head;
        //f 一次走两步 l 一次走1步，当第一次相遇
        // f = a + n圈 + k步 = 2l  l = a + n1圈 + k步
        //f-l=2l-l=l = （n -n1）圈
        //找到第一次相遇
        while (f != null && f.next != null) {
            f = f.next.next;
            l = l.next;
            if(l == f){
                //相遇的f l 在同一个节点
                //找到环的入口：此时 l = （n -n1）圈,再走 a 步，正好走到入口
                //怎么确定 a? 此时 f=l ,l回到起点，一次都走一步，正好走a步在环口相遇
                l = head;
                while (l != f){
                    f = f.next;
                    l = l.next;
                }
                return l;
            }
        }
        return null;
    }
}
