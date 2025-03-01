package linkedList;

import linkedList.Utils.ListNode;

public class E06getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //A B 两个都走一次，走到交点的步数相同
        //若没有交点，currA currB都走完A B 两链表最后指向null
        ListNode currA = headA;
        ListNode currB = headB;
        while (true){
            if(currA == currB){
                return currA;
            }
            if(currA == null){
                currA = headB;//currA走完A链表，走B
            }else {
                currA = currA.next;
            }
            if(currB == null){
                currB = headA;//currA走完A链表，走B
            }else {
                currB = currB.next;
            }

        }
    }
}
