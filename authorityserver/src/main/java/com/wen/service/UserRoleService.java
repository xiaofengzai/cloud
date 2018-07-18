package com.wen.service;


import com.wen.model.core.QUserRole;
import com.wen.model.core.Role;
import com.wen.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;
    private final QUserRole qUserRole= QUserRole.userRole;
    public List<Role> getRolesByUsername(String username) {
        return userRoleRepository.findUserRolesByUsername(username);
    }
}
