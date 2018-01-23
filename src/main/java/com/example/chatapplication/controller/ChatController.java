package com.example.chatapplication.controller;

import com.example.chatapplication.assembler.MessageAssembler;
import com.example.chatapplication.assembler.UserAssembler;
import com.example.chatapplication.entity.User;
import com.example.chatapplication.entity.ChatMessage;
import com.example.chatapplication.repository.MessageRepository;
import com.example.chatapplication.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

/**
 * This is the controller class where the new users are added and incoming chat messages are handled.
 * 20.01.2018
 *
 * @author Ahmet Cetin
 */
@Controller
public class ChatController {
    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
    private final UserRepository userRepository;
    private final UserAssembler userAssembler;
    private final MessageRepository messageRepository;
    private final MessageAssembler messageAssembler;

    @Autowired
    public ChatController(UserRepository userRepository, UserAssembler userAssembler, MessageRepository messageRepository, MessageAssembler messageAssembler) {
        this.userRepository = userRepository;
        this.userAssembler = userAssembler;
        this.messageRepository = messageRepository;
        this.messageAssembler = messageAssembler;
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        String username = chatMessage.getSender();
        User user = userRepository.findByUsername(username);
        if (user == null) {
            logger.error("This message comes from an unknown user. Username: " + chatMessage.getSender());
            return chatMessage;
        }

        logger.info("[" + chatMessage.getSender() + "]: " + chatMessage.getContent());
        messageRepository.save(messageAssembler.toMessage(user.getUserId()));
        return chatMessage;
    }

    @MessageMapping("/chat.addNewUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        String username = chatMessage.getSender();
        /*
         * Add username in web socket session
         */
        headerAccessor.getSessionAttributes().put("username", username);

        /*
         * Check user if not exists save new user
         */
        if (userRepository.findByUsername(username) == null) {
            userRepository.save(userAssembler.toUser(chatMessage.getSender()));
            logger.info("[NEW USER]: " + chatMessage.getSender());
        }
        return chatMessage;
    }
}