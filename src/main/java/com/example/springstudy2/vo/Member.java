package com.example.springstudy2.vo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.parameters.P;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Getter
@Setter
public class Member {
    @Id @GeneratedValue
    private Long id;

    @NotBlank(message = "ID는 필수 입력값 입니다.")
    @Pattern(regexp = "^[a-zA-Z0-9]{8,12}",message = "ID는 8~12자리의 영문 대/소문자, 숫자만 사용 가능합니다")
    private String userId;

    @NotBlank(message = "Password는 필수 입력값 입니다.")
//    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,16}$",message = "Password는 8~16자리의 영문 대/소문자, 숫자만 사용 가능합니다")
    private String password;

    @NotBlank(message = "Email은 필수 입력값 입니다.")
//    @Pattern(regexp = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+$",message = "Email 양식에 맞게 입력해주세요.")
    private String email;

    @NotBlank(message = "이름은 필수 입력값 입니다.")
    @Pattern(regexp = "^[가-힣]{3,5}", message = "이름은 한글 3~5자로 입력해주세요.")
    private String name;

    private String role;

    public Member(Long id, String userId, String password, String email, String name,String role) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.name = name;
        this.role = role;
    }

    public Member() {
    }
}
