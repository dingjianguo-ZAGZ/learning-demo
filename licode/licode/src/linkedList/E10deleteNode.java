package linkedList;

import linkedList.Utils.ListNode;

public class E10deleteNode {
    public void deleteNode(ListNode node) {
        //无法得知前一个节点，
        //只能逻辑删除，将要删除的节点的值覆盖，将下一个节点删除
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
