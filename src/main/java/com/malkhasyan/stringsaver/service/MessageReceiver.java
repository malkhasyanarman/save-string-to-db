package com.malkhasyan.stringsaver.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    private MessageProcessingService messageProcessingService;

    public MessageReceiver(MessageProcessingService messageProcessingService) {
        this.messageProcessingService = messageProcessingService;
    }

    @KafkaListener(topics = "${spring.kafka.consumer.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void receiveMessage(ObjectNode kafkaMessage) {
        messageProcessingService.process(kafkaMessage);
    }
}
