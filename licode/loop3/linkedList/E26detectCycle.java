package linkedList;

public class E26detectCycle {
    public ListNode detectCycle(ListNode head) {
        //快慢指针
        ListNode f = head;
        ListNode s = head;
        while (f != null && f.next != null){
            f = f.next.next;
            s = s.next;
            if(f == s){
                //相遇，有环 ---> 找环的入口
                //f 比 s 多走了 x个环   a + m环在环的入口
                //s 回起点 走，f 从现在走，相逢刚好走了a步到入口
                s = head;
                //每次都走一步
                while (s != f){
                    s = s.next;
                    f = f.next;
                }
                return s;
            }
        }
        return null;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
