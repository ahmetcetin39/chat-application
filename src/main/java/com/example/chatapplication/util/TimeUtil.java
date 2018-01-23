package com.example.chatapplication.util;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 * This is the time util where time related operations are written.
 * 22.01.2018
 *
 * @author Ahmet Cetin
 */
@Component
public class TimeUtil {
    /**
     * This method is used to get the current timestamp.
     *
     * @return the current timestamp.
     */
    public Timestamp now() {
        return new Timestamp(Calendar.getInstance().getTimeInMillis());
    }
}
