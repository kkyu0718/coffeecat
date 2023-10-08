package com.coffeecat.coffeecatbootauth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class AuthControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(AuthException.UserDuplicatedException.class)
    public ProblemDetail handleUserNotFoundException(AuthException.UserDuplicatedException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(AuthException.WrongSocialTypeException.class)
    public ProblemDetail handleUserNotFoundException(AuthException.WrongSocialTypeException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

}
