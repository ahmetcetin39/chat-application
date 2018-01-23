package com.example.chatapplication.assembler;

import com.example.chatapplication.entity.Message;
import com.example.chatapplication.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This is the assembler of messages where new message instances are created.
 * 22.01.2018
 *
 * @author Ahmet Cetin
 */
@Component
public class MessageAssembler {
    private final TimeUtil timeUtil;

    @Autowired
    public MessageAssembler(TimeUtil timeUtil) {
        this.timeUtil = timeUtil;
    }

    public Message toMessage(Long userId) {
        Message message = new Message();
        message.setWrittenBy(userId);
        message.setInsertTime(timeUtil.now());
        return message;
    }
}
