package com.su.consumerMessage;

import kotlin.contracts.Returns;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.sql.Array;
import java.util.Arrays;
import java.util.List;

/**
 * 过滤消息
 */
public class FilterMessage {
    @Test
    public void producer() throws MQBrokerException, RemotingException, InterruptedException, MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer("filterConsumer");
        producer.setNamesrvAddr("192.168.66.102:9876");
        producer.start();
        List<String> list = Arrays.asList("a", "b", "c", "d");
        for (String tag : list) {
            Message message = new Message("filter_topic", tag, (tag + "hello filter").getBytes(StandardCharsets.UTF_8));
            SendResult send = producer.send(message);
        }

        producer.shutdown();

    }

    @Test
    public void consumer() throws MQClientException, InterruptedException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("filterConsumer");
        consumer.setNamesrvAddr("192.168.66.102:9876");
        consumer.subscribe("filter_topic","b");
        consumer.setMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt messageExt : list) {
                    System.out.println(new String(messageExt.getBody(),StandardCharsets.UTF_8));
                }

                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        Thread.sleep(Long.MAX_VALUE);
    }
}
