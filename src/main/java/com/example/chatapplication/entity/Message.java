package com.example.chatapplication.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * This is the entity class for the messages in the chat.
 * 22.01.2018
 *
 * @author Ahmet Cetin
 */
@Table(name = "message")
@Entity
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long messageId;

    @Column(name = "written_by")
    private Long writtenBy;

    @Column(name = "insert_time")
    private Timestamp insertTime;
}
