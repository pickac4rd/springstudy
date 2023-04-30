package com.example.springstudy2.vo;

import lombok.*;
import org.springframework.security.core.parameters.P;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member {
    @Id @GeneratedValue
    private Long id;

    @NotBlank(message = "ID는 필수 입력값 입니다.")
    //@Pattern(regexp = "^[a-zA-Z0-9]{8,12}",message = "ID는 8~12자리의 영문 대/소문자, 숫자만 사용 가능합니다")
    private String userId;

    @NotBlank(message = "Password는 필수 입력값 입니다.")
    //@Pattern(regexp = "^(?=.[A-Za-z])(?=.[$@$!%#?&])[A-Za-z\\d$@$!%#?&]{8,16}$", message = "알파벳 소문자, 대문자, 특수문자 1개 이상 그리고 8~16")
    private String password;

    @NotBlank(message = "Email은 필수 입력값 입니다.")
    //@Email
    private String email;

    @NotBlank(message = "이름은 필수 입력값 입니다.")
    //@Pattern(regexp = "^[가-힣]{3,5}", message = "이름은 한글 3~5자로 입력해주세요.")
    private String name;

    private String role;

}
