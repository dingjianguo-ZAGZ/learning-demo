package com.su.sendmessage;

import ch.qos.logback.classic.net.SocketNode;
import com.su.domain.Order;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class SimpleMessageTest {

    /**
     * 全局消息生产者
     * @throws MQClientException
     * @throws MQBrokerException
     * @throws RemotingException
     * @throws InterruptedException
     */
    @Test
    public void producer() throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        //1.创建生产者
        DefaultMQProducer producer = new DefaultMQProducer("producer");
        //2.rocketMQ的位置
        producer.setNamesrvAddr("192.168.66.102:9876");
        //3.启动生产者
        producer.start();

        //1.初始化消息对象
        Message message = new Message("SimpleMessageTest","tags","hello rocketmq".getBytes(StandardCharsets.UTF_8));
        //2.发送消息
        SendResult send = producer.send(message);
        //3.打印结果
        System.out.println("消息发送："+send);
        //4.关闭生产者
        producer.shutdown();


    }

    @Test
    public void OrderMQProducer() throws MQBrokerException, RemotingException, InterruptedException, MQClientException {
        //1.创建生产者
        DefaultMQProducer producer = new DefaultMQProducer("producer-group-test");
        //2.rocketMQ的位置
        producer.setNamesrvAddr("192.168.66.102:9876");
        //3.启动生产者
        producer.start();

        List<Order> orderList = getOrderList();
        for (int i = 0; i < orderList.size(); i++) {
            //定义消息内容
            String body = "["+orderList.get(i)+"]";
            Message message = new Message("jubu_order_topic","",body.getBytes(StandardCharsets.UTF_8));
            //发送消息
            SendResult sendResult = producer.send(message, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                    long index = (Long) o % orderList.size();
                    return list.get((int) index);
                }
            }, 1);
            System.out.println(String.format("消息发送状态:%s, orderId:%s, queueId:%d, body:%s",
                    sendResult.getSendStatus(),
                    orderList.get(i).getOrderId(),
                    sendResult.getMessageQueue().getQueueId(),
                    body));
        }

    }

    /**
     * 全局消息消费者
     * @throws MQClientException
     * @throws InterruptedException
     */
    @Test
    public void consumer () throws MQClientException, InterruptedException {
        //1.创建消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("producer");
        //2.rocket的位置
        consumer.setNamesrvAddr("192.168.66.102:9876");
        //3.订阅主题
        consumer.subscribe("SimpleMessageTest","*");
        //4.监听消息
        consumer.setMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt messageExt : list) {
                    System.out.println(new String(messageExt.getBody(),StandardCharsets.UTF_8));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        //5.启动消费者
        consumer.start();
        //6.永远运行
        Thread.sleep(Long.MAX_VALUE);
    }

    /**
     * 局部消息消费者
     * @throws MQClientException
     * @throws InterruptedException
     */
    @Test
    public void OrderMQConsumer () throws MQClientException, InterruptedException {
        //1.创建消费者
        DefaultMQPushConsumer orderMQConsumer = new DefaultMQPushConsumer("producer-group-test");
        //2.rocket的位置
        orderMQConsumer.setNamesrvAddr("192.168.66.102:9876");
        //3.订阅主题
        orderMQConsumer.subscribe("jubu_order_topic","*");
        //4.监听消息
        orderMQConsumer.registerMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {
                for (MessageExt messageExt : list) {
                    System.out.println("消费线程："+Thread.currentThread().getName()+"队列id"+messageExt.getQueueId()+"消息内容："+new String(messageExt.getBody()));
                }
                // 标记该消息已经被成功消费
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });

        //5.启动消费者
        orderMQConsumer.start();
        //6.永远运行
        Thread.sleep(Long.MAX_VALUE);
    }

    public static List<Order> getOrderList() {
        List<Order> orderList = new ArrayList<>();
        Order orderDemo = new Order();
        orderDemo.setOrderId(1L);
        orderDemo.setOrderStatus("ORDER_CREATE");
        orderList.add(orderDemo);

        orderDemo = new Order();
        orderDemo.setOrderId(2L);
        orderDemo.setOrderStatus("ORDER_CREATE");
        orderList.add(orderDemo);

        orderDemo = new Order();
        orderDemo.setOrderId(1L);
        orderDemo.setOrderStatus("ORDER_PAYED");
        orderList.add(orderDemo);

        orderDemo = new Order();
        orderDemo.setOrderId(2L);
        orderDemo.setOrderStatus("ORDER_PAYED");
        orderList.add(orderDemo);

        orderDemo = new Order();
        orderDemo.setOrderId(2L);
        orderDemo.setOrderStatus("ORDER_COMPLETE");
        orderList.add(orderDemo);

        orderDemo = new Order();
        orderDemo.setOrderId(3L);
        orderDemo.setOrderStatus("ORDER_CREATE");
        orderList.add(orderDemo);

        orderDemo = new Order();
        orderDemo.setOrderId(4L);
        orderDemo.setOrderStatus("ORDER_CREATE");
        orderList.add(orderDemo);

        orderDemo = new Order();
        orderDemo.setOrderId(3L);
        orderDemo.setOrderStatus("ORDER_PAYED");
        orderList.add(orderDemo);

        orderDemo = new Order();
        orderDemo.setOrderId(1L);
        orderDemo.setOrderStatus("ORDER_COMPLETE");
        orderList.add(orderDemo);

        orderDemo = new Order();
        orderDemo.setOrderId(3L);
        orderDemo.setOrderStatus("ORDER_COMPLETE");
        orderList.add(orderDemo);

        orderDemo = new Order();
        orderDemo.setOrderId(4L);
        orderDemo.setOrderStatus("ORDER_PAYED");
        orderList.add(orderDemo);

        orderDemo = new Order();
        orderDemo.setOrderId(4L);
        orderDemo.setOrderStatus("ORDER_COMPLETE");
        orderList.add(orderDemo);

        return orderList;
    }
}
