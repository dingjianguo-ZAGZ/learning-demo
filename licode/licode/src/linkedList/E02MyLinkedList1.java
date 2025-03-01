package linkedList;

/**
 * 单向链表
 */
public class E02MyLinkedList1 {
    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

    }

    int size;
    ListNode head;

    public E02MyLinkedList1() {
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        //如果index非法
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode pred = head;
        //包含虚拟头节点，index=0时需要被处理
        for (int i = 0; i <= index; i++) {
            pred = pred.next;
        }
        return pred.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        /*ListNode addNode = new ListNode(val);
        ListNode tail = new ListNode();
        for(int i = 0;i<size;i++){
            tail = head.next;
        }
        size++;
        tail.next = addNode;*/

        //利用循环找到当前的最后一个节点
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        //如果index非法
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size++;
        //找到index节点的前驱
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        ListNode addNode = new ListNode(val);
        addNode.next = pred.next;
        pred.next = addNode;
    }

    public void deleteAtIndex(int index) {
        //如果index非法
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        if(index == 0){
            head = head.next;
            return;
        }
        //找到当前节点的前驱
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }

        pred.next = pred.next.next;

    }

}
