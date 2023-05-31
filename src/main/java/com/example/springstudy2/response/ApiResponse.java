package com.example.springstudy2.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;
    private String errorCode;

    public static <T> ApiResponse<T> loginSuccess(T data){
        return new ApiResponse<>(true,"로그인 성공!",data,null);
    }

    public static ApiResponse<?> changeRoleSuccess(){
        return new ApiResponse<>(true,"권한 변경 성공!",null,null);
    }

    public static ApiResponse<?> changeRoleFail(){
        return new ApiResponse<>(false,"권한 변경 실패!",null,"E05");
    }

    public static ApiResponse<?> authenticationFail(){
        return new ApiResponse<>(false,"로그인 실패!",null,"E02");
    }

    public static ApiResponse<?> authorizationFail(){
        return new ApiResponse<>(false,"권한 없음!",null,"E01");
    }
}
