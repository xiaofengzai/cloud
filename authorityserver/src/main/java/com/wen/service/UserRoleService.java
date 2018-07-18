package com.wen.service;


import com.wen.pojo.UserInfo;
import com.wen.pojo.UserRole;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class UserRoleService {

    public List<UserRole> getRoleByUser(UserInfo user) {
        if ("test".equals(user.getUserName())) {
            //@see ExpressionUrlAuthorizationConfigurer  private static String hasAnyRole(String... authorities) 带 ROLE_
            return Arrays.asList(new UserRole("ROLE_ADMIN"));
        }
        return null;
    }
}
