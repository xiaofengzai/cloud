package com.wen.repository;


import com.wen.model.core.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByUserName(String username);
}
