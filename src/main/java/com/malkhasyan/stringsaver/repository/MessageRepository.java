package com.malkhasyan.stringsaver.repository;

import com.malkhasyan.stringsaver.entity.MessageEntity;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<MessageEntity, Long> {
}
