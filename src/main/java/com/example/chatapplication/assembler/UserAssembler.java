package com.example.chatapplication.assembler;

import com.example.chatapplication.entity.User;
import com.example.chatapplication.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This is the assembler of user where new user instances are created.
 * 22.01.2018
 *
 * @author Ahmet Cetin
 */
@Component
public class UserAssembler {
    private final TimeUtil timeUtil;

    @Autowired
    public UserAssembler(TimeUtil timeUtil) {
        this.timeUtil = timeUtil;
    }

    public User toUser(String username) {
        User user = new User();
        user.setUsername(username);
        user.setInsertTime(timeUtil.now());
        return user;
    }
}
