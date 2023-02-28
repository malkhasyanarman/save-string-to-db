package com.malkhasyan.stringsaver.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.malkhasyan.stringsaver.dto.Message;
import com.malkhasyan.stringsaver.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class MessageProcessingService {

    @Autowired
    private MessageRepository messageRepository;

    public void process(ObjectNode kafkaMessage) {
        for (JsonNode jsonNode : kafkaMessage) {
            if(jsonNode.textValue() != null) {
                Message message = new Message();
                message.setDate_received(Timestamp.valueOf(LocalDateTime.now()));
                message.setWord(jsonNode.textValue());

                messageRepository.save(message);
            }
        }
    }
}
