package com.wen.service;

import com.wen.model.core.User;
import com.wen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;

    public User findByName(String username) {
        return userRepository.findByUserName(username);
    }

    public void createUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
