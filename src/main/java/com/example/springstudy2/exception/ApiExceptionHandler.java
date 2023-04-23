//package com.example.springstudy2.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//public class ApiExceptionHandler {
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
//        BindingResult bindingResult = ex.getBindingResult();
//
//        StringBuilder builder = new StringBuilder();
//        for (FieldError fieldError : bindingResult.getFieldErrors()) {
//            builder.append(fieldError.getDefaultMessage());
//            builder.append("\n");
//        }
//
//        ApiException apiException = new ApiException(
//                builder.toString(),
//                HttpStatus.BAD_REQUEST
//        );
//
//        return new ResponseEntity<>(
//                apiException,
//                HttpStatus.BAD_REQUEST
//        );
//    }
//}
