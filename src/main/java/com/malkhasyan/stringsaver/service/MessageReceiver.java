package com.malkhasyan.stringsaver.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    @Autowired
    private MessageProcessingService messageProcessingService;

    @KafkaListener(topics = "wordTopic", groupId = "wordGroup")
    public void receiveMessage(ObjectNode kafkaMessage) {
        messageProcessingService.process(kafkaMessage);
    }
}
