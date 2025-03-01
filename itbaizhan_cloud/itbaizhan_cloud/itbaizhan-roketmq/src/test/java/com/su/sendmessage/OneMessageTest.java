package com.su.sendmessage;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class OneMessageTest {
    @Test
    public void producer() throws MQClientException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("one_producer");
        producer.setNamesrvAddr("192.168.66.102:9876");
        producer.start();
        Message message = new Message("one_topic", "", "hello one".getBytes(StandardCharsets.UTF_8));
        producer.sendOneway(message);

        producer.shutdown();
    }


    @Test
    public void consumer () throws MQClientException, InterruptedException {
        //1.创建消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("one_producer");
        //2.rocket的位置
        consumer.setNamesrvAddr("192.168.66.102:9876");
        //3.订阅主题
        consumer.subscribe("one_topic","*");
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
}
