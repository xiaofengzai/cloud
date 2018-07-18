package com.wen.repository;


import com.wen.model.core.Role;
import com.wen.model.core.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {
    @Query("SELECT userRole.role FROM UserRole userRole WHERE userRole.user.userName =:username")
    List<Role> findUserRolesByUsername(@Param("username") String username);
}
