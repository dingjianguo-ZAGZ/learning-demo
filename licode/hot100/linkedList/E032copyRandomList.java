package linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * 随机链表的复制
 */
public class E032copyRandomList {
    //已经创建的节点，创建技巧，用键保存原链表的节点，值保存拷贝链表的节点
    //优点：两个链表节点一一对应，通过get(原链表节点)，可以获得拷贝链表的节点

    //痛点：找不到拷贝链表的head，使用上面的键值对存储方式解决问题
    Map<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        //定义递归头
        if(head == null){
            return null;
        }
        if(!map.containsKey(head)){
            //不存在，创建并加入MAP
            Node node = new Node(head.val);
            map.put(head,node);
            //设置 next 和 random
            //递归创建节点
            node.next = copyRandomList(head.next);
            node.random = copyRandomList(head.random);
        }
        return map.get(head);

    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}