package com.example.chatapplication.entity;

import lombok.Data;

/**
 * This model is used to hold each written message in the chat.
 * 20.01.2018
 *
 * @author Ahmet Cetin
 */
@Data
public class ChatMessage {
    private MessageType type;
    private String content;
    private String sender;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }
}
