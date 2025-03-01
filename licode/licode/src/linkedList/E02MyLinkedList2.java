package linkedList;

import java.util.Currency;

/**
 * 双向链表
 */
public class E02MyLinkedList2 {

    public static void main(String[] args) {
        E02MyLinkedList2 myLinkedList2 = new E02MyLinkedList2();
        myLinkedList2.addAtHead(1);
        myLinkedList2.addAtTail(3);
        myLinkedList2.addAtIndex(1,2);
        int i = myLinkedList2.get(1);
        System.out.println(i);
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode pre;

        public ListNode(int val) {
            this.val = val;
        }
    }

    int size;
    ListNode head, tail;

    //构造方法，初始化链表，定义长度，头节点，尾节点
    public E02MyLinkedList2() {
        size = 0;
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        return getNode(index).val;
    }

    public ListNode getNode(int index) {
        ListNode curr;
        //判断更短路径
        if (index >= size / 2) {
            //tail开始
            curr = tail;
            for (int i = 0; i < size - index; i++) {
                curr = curr.pre;
            }
        } else {
            curr = head;
            for (int i = 0; i <= index; i++) {
                curr = curr.next;
            }
        }
        return curr;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        ListNode addNode = new ListNode(val);
        ListNode pred = head;
        if (index <= 0) {
            index = 0;
        }
        if (index == size) {
            //获得最后一个节点
            pred = getNode(index - 1);
        } else {
            pred = getNode(index).pre;
        }
        addNode.next = pred.next;
        pred.next.pre = addNode;
        addNode.pre = pred;
        pred.next = addNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {

        }
        //找到index的前驱
        ListNode curr = getNode(index);
        curr.next.pre = curr.pre;
        curr.pre.next = curr.next;
        size--;
    }

}
