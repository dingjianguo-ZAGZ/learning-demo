package com.su.test.product;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

import static com.su.test.Utils.Sleeper.sleep;

public class Test {
    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue(2);
        for (int i = 0; i < 3; i++) {
            int id = i;
            new Thread(()->{
                queue.put(new Message(id,"值："+id));
            },"生产者"+i).start();
        }
        new Thread(()->{
            while (true){
                sleep(1);
                Message message = queue.take();
            }
        },"消费者").start();
    }
}

/**
 * 消息队列，存放消息（java线程之间的通信）
 */
@Slf4j(topic = "c.messageQueue")
class MessageQueue{
    //双端队列存放消息
    private LinkedList<Message> queue;
    //容量
    private int capacity;

    public MessageQueue(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<>();
    }
    //获取消息
    public Message take(){
        synchronized (queue){
            while (queue.isEmpty()){
                log.debug("没有消息");
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //从队列头部获取消息
            Message message = queue.removeFirst();
            log.debug("已消费消息"+message);
            //唤醒生产者
            queue.notifyAll();
            return message;
        }
    }
    //存放消息
    public void put(Message message){
        synchronized (queue){
            while (queue.size() == capacity){
                log.debug("队列已满，不能存放");
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //向队列尾部添加消息
            queue.addLast(message);
            log.debug("已生产消息"+message);
            //唤醒消费者
            queue.notifyAll();
        }
    }
}
/**
 * 消息类
 */
class Message{
    private int id;
    private Object value;

    public Message(int id, Object value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}

