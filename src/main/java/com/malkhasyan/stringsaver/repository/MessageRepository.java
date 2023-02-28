package com.malkhasyan.stringsaver.repository;

import com.malkhasyan.stringsaver.dto.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
