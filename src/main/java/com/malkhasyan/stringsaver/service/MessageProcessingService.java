package com.malkhasyan.stringsaver.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.malkhasyan.stringsaver.entity.MessageEntity;
import com.malkhasyan.stringsaver.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class MessageProcessingService {

    public MessageProcessingService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    private MessageRepository messageRepository;

    public void process(ObjectNode kafkaMessage) {
        for (JsonNode jsonNode : kafkaMessage) {
            if(jsonNode.textValue() != null) {
                MessageEntity messageEntity = new MessageEntity();
                messageEntity.setDateReceived(Timestamp.valueOf(LocalDateTime.now()));
                messageEntity.setWord(jsonNode.textValue());

                messageRepository.save(messageEntity);
            }
        }
    }
}
