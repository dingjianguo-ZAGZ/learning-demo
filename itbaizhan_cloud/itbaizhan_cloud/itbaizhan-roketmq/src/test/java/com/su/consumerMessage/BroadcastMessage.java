package com.su.consumerMessage;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.apache.rocketmq.remoting.protocol.heartbeat.MessageModel;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 消费模式
 * 集群消费
 */
public class BroadcastMessage {
    @Test
    public void producer() throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("broadcast_producer");
        producer.setNamesrvAddr("192.168.66.102:9876");
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message message = new Message("broadcast_topic", "", ("集群模式"+i).getBytes(StandardCharsets.UTF_8));
            producer.send(message);
        }
        producer.shutdown();
    }


    @Test
    public void consumer() throws MQClientException, InterruptedException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("broadcast_producer");
        //2.rocket的位置
        consumer.setNamesrvAddr("192.168.66.102:9876");
        //3.订阅主题
        consumer.subscribe("broadcast_topic","*");
        //4.设置消费模式
        consumer.setMessageModel(MessageModel.CLUSTERING);
        //5.监听消息
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
    @Test
    public void consumer2() throws MQClientException, InterruptedException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("broadcast_producer");
        //2.rocket的位置
        consumer.setNamesrvAddr("192.168.66.102:9876");
        //3.订阅主题
        consumer.subscribe("broadcast_topic","*");
        //4.设置消费模式
        consumer.setMessageModel(MessageModel.CLUSTERING);
        //5.监听消息
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
}

