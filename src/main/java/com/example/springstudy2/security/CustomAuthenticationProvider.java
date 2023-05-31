package com.example.springstudy2.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;


public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    MemberDetailService memberDetailService;

    @Autowired
    PasswordEncoder passwordEncoder;


    //인증 관련
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String)authentication.getCredentials();

        SecurityMember securityMember = (SecurityMember) memberDetailService.loadUserByUsername(username);

        if(passwordEncoder.matches(password, securityMember.getPassword())){
            throw new BadCredentialsException("BadCredentialException");
        }

        //추가적인 검증...

        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(securityMember.getMember(),
                null,
                securityMember.getAuthorities());


        return authenticationToken;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
