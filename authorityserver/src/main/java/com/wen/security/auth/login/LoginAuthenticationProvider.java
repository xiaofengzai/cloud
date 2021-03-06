package com.wen.security.auth.login;

import com.alibaba.fastjson.JSON;
import com.wen.model.RoleTypeEnum;
import com.wen.model.core.Role;
import com.wen.model.core.User;
import com.wen.myeunm.EnumUtils;
import com.wen.security.model.UserContext;
import com.wen.service.UserInfoService;
import com.wen.service.UserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;


/**
 * 
 * @author Levin
 *
 * @since 2017-05-25
 */
@Component
public class LoginAuthenticationProvider implements AuthenticationProvider {
    private Logger logger = LoggerFactory.getLogger(LoginAuthenticationProvider.class);
	
	final BCryptPasswordEncoder encoder;
	final UserInfoService userService;
	final UserRoleService roleService;
	
	@Autowired
    public LoginAuthenticationProvider(final UserInfoService userService, final UserRoleService roleService, final BCryptPasswordEncoder encoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.encoder = encoder;
    }
	

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Assert.notNull(authentication, "No authentication data provided");
        logger.debug("[authentication info] - [{}]", JSON.toJSONString(authentication));
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        User user = userService.findByName(username);
        if(user == null) throw new UsernameNotFoundException("User not found: " + username);
        if (!encoder.matches(password,user.getPassword())) {
            throw new BadCredentialsException("Authentication Failed. Username or Password not valid.");
        }
        List<Role> roles = roleService.getRolesByUsername(username);
        if (roles == null || roles.size() <= 0) throw new InsufficientAuthenticationException("User has no roles assigned");
        
        List<GrantedAuthority> authorities = roles.stream()
                .map(role -> new SimpleGrantedAuthority(EnumUtils.getDisplayName(role.getRoleType(), RoleTypeEnum.class)))
                .collect(Collectors.toList());
        
        UserContext userContext = UserContext.create(user.getUserName(), authorities);
        
        return new UsernamePasswordAuthenticationToken(userContext, null, userContext.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
