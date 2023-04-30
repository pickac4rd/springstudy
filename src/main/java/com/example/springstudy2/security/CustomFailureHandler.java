package com.example.springstudy2.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String msg;
        if(exception instanceof BadCredentialsException) {
            msg = "아이디 또는 비밀번호가 일치하지 않습니다.";
        } else if (exception instanceof InternalAuthenticationServiceException) {
            msg = "내부적으로 발생한 시스템 문제로 현재 요청을 처리할 수 없습니다.";
        } else if (exception instanceof UsernameNotFoundException) {
            msg = "계정이 존재하지 않습니다.";
        } else{
            msg = "알 수 없는 이유로 로그인에 실패하였습니다.";
        }

        setDefaultFailureUrl("/login?error=true&exception="+msg);

        super.onAuthenticationFailure(request, response, exception);
    }
}
