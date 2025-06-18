public class E237deleteNode {
    public void deleteNode(ListNode node) {
        //采用逻辑删除
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }
}
