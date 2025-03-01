package com.su.consumer;

import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(
        topic = "${demo.rocketmq.topic}",
        consumerGroup = "${demo.rocketmq.consumer}",
        //过滤方式
        selectorType = SelectorType.TAG,
        selectorExpression = "a",
        //消费模式 顺序 并发
        consumeMode = ConsumeMode.CONCURRENTLY,
        //消息模式 广播 集群
        messageModel = MessageModel.CLUSTERING

)
public class ConsumerMessage implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        System.out.println(message);
    }
}
