package com.example.springstudy2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MemberDetailService memberDetailService;

    @Autowired
    AuthenticationFailureHandler customFailureHandler;

    @Autowired
    AuthenticationSuccessHandler customLoginSuccessHandler;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/script/**", "image/**", "/fonts/**", "lib/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/user/availability/**", "/*").permitAll() //아무나 접근 가능한 URL
                .antMatchers("/user/test").hasRole("USER") //USER 권한 있을경우만 접근 가능
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/loginProcess") //Login 요청 URL
                .defaultSuccessUrl("/")
                .successHandler(customLoginSuccessHandler)
                .failureHandler(customFailureHandler)
                .and()
                .logout() // 로그아웃 관련 처리
                .logoutUrl("/logout") // 로그아웃 URL 설정
                .logoutSuccessUrl("/") // 로그아웃 성공 후 이동할 URL 설정
                .invalidateHttpSession(true) // 로그아웃 후 세션 초기화 설정
                .deleteCookies("JSESSIONID") // 로그아웃 후 쿠기 삭제 설정
                .and();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberDetailService).passwordEncoder(passwordEncoder());
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new CustomAuthenticationProvider();
    }

}
