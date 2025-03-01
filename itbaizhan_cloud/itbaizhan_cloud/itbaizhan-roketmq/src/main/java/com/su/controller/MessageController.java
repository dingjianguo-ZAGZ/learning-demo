package com.su.controller;

import com.su.producer.MessageProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Autowired

    private MessageProducer messageProducer;
    @GetMapping("/send")
    public SendResult send(String message){
       return messageProducer.sendMessage(message);
    }
}
