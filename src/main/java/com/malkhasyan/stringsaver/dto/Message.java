package com.malkhasyan.stringsaver.dto;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @SequenceGenerator(name = "message-id-generator", sequenceName = "message_id", allocationSize = 1)
    private Long id;
    private Timestamp date_received;
    private String word;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getDate_received() {
        return date_received;
    }

    public void setDate_received(Timestamp date_received) {
        this.date_received = date_received;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

}
