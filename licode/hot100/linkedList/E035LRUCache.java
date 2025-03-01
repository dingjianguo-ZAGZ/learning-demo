package linkedList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache {
    /**
     * 自定义双线链表，存储键值对，并且维护使用和插入的顺序
     */
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    //缓存容量
    int capacity;
    //已经使用的数量
    int size;
    //保存键和节点再链表的位置
    Map<Integer,DLinkedNode> cache = new HashMap<>();
    DLinkedNode head,tail;
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        //使用伪头部，伪尾部标记链表的边界
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null){
            //没有找到
            return -1;
        }
        //找到了，更新使用
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        //判断缓存中是否包含
        DLinkedNode node = cache.get(key);
        if(node == null){
            // key 不存在，创建新节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            //添加到哈希表
            cache.put(key,newNode);
            //添加到双线链表的头部，表示最新使用
            addToHead(newNode);
            ++size;
            //判断是否需要淘汰
            if(size > capacity){
                //超出容量，淘汰最尾节点
                DLinkedNode tail = removeTail();
                //在哈希表中删除最尾节点记录
                cache.remove(tail.key);
                --size;
            }
        }else {
            //键存在，更新值并更新使用
            node.value = value;
            moveToHead(node);
        }

    }

    private void moveToHead(DLinkedNode node) {
        //先删除原来的节点
        removeNode(node);
        //在首部插入节点
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(DLinkedNode newNode) {
        newNode.prev = head;
        newNode.next = head.next;
        head.next.prev = newNode;
        head.next = newNode;
    }
}

