package com.wen.controller;

import com.wen.ApiBeanUtils;
import com.wen.model.RoleTypeEnum;
import com.wen.model.core.Role;
import com.wen.model.core.User;
import com.wen.myeunm.EnumUtils;
import com.wen.security.auth.token.extractor.TokenExtractor;
import com.wen.security.auth.token.verifier.TokenVerifier;
import com.wen.security.config.TokenProperties;
import com.wen.security.config.WebSecurityConfig;
import com.wen.security.exceptions.InvalidTokenException;
import com.wen.security.model.UserContext;
import com.wen.security.model.token.RawAccessToken;
import com.wen.security.model.token.RefreshToken;
import com.wen.security.model.token.Token;
import com.wen.security.model.token.TokenFactory;
import com.wen.service.UserInfoService;
import com.wen.service.UserRoleService;
import com.wen.viewmodel.CreateUserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
public class GatewayController {
    @Autowired
    private final TokenProperties tokenProperties;
    @Autowired
    private final TokenVerifier tokenVerifier;
    @Autowired
    private final TokenFactory tokenFactory;
    @Autowired
    private final TokenExtractor tokenExtractor;
    @Autowired
    private final UserInfoService userInfoService;
    @Autowired
    private final UserRoleService userRoleService;

    @Autowired
    public GatewayController(TokenProperties tokenProperties, TokenVerifier tokenVerifier, TokenFactory tokenFactory, TokenExtractor tokenExtractor, UserInfoService userInfoService, UserRoleService userRoleService) {
        this.tokenProperties = tokenProperties;
        this.tokenVerifier = tokenVerifier;
        this.tokenFactory = tokenFactory;
        this.tokenExtractor = tokenExtractor;
        this.userInfoService = userInfoService;
        this.userRoleService = userRoleService;
    }


    @GetMapping("/test1")
    public String test1() {
        return "test1";
    }

    @PostMapping("/register")
    public String register(@RequestBody CreateUserViewModel request) {
        User user= ApiBeanUtils.copyProperties(request,User.class);
        userInfoService.createUser(user);
        return "success";
    }

    @GetMapping("/api/test2")
    public String test2() {
        return "test2";
    }

    @GetMapping("/manage/test3")
    public String test3() {
        return "test3";
    }

    @GetMapping("/api/auth/refresh_token")
    public Token refreshToken(HttpServletRequest request) {
        String tokenPayload = tokenExtractor.extract(request.getHeader(WebSecurityConfig.TOKEN_HEADER_PARAM));
        RawAccessToken rawToken = new RawAccessToken(tokenPayload);
        RefreshToken refreshToken = RefreshToken.create(rawToken, tokenProperties.getSigningKey()).orElseThrow(() -> new InvalidTokenException("Token验证失败"));

        String jti = refreshToken.getJti();
        if (!tokenVerifier.verify(jti)) {
            throw new InvalidTokenException("Token验证失败");
        }

        String subject = refreshToken.getSubject();
        User user = Optional.ofNullable(userInfoService.findByName(subject)).orElseThrow(() -> new UsernameNotFoundException("用户未找到: " + subject));
        List<Role> roles = Optional.ofNullable(userRoleService.getRolesByUsername(subject)).orElseThrow(() -> new InsufficientAuthenticationException("用户没有分配角色"));
        List<GrantedAuthority> authorities = roles.stream()
                .map(role -> new SimpleGrantedAuthority(EnumUtils.getDisplayName(role.getRoleType(), RoleTypeEnum.class)))
                .collect(Collectors.toList());

        UserContext userContext = UserContext.create(user.getUserName(), authorities);
        return tokenFactory.createAccessToken(userContext);
    }


}
