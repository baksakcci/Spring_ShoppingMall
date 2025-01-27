package com.studyProjectA.ShoppingMall.advice;

import com.studyProjectA.ShoppingMall.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response<?> illegalArgumentExcpetionAdvice(IllegalArgumentException e){
        return new Response<>("fail", e.getMessage().toString(), null);
    }
}
