package com.example.chatapplication.repository;

import com.example.chatapplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * This is the repository for {@link User}
 * 22.01.2018
 *
 * @author Ahmet Cetin
 */
@Transactional
public interface UserRepository extends JpaRepository<User, Serializable> {
    /**
     * This method is used to get the user entity by its username.
     *
     * @param username: the login name of the user.
     * @return the user entity.
     */
    User findByUsername(String username);
}
