package com.example.chatapplication.repository;

import com.example.chatapplication.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * This is the repository interface for {@link Message}.
 * 22.01.2018
 *
 * @author Ahmet Cetin
 */
public interface MessageRepository extends JpaRepository<Message, Serializable> {
}
