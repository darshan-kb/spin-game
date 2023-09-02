package com.spin.game.error;

import com.spin.game.exception.DrawCloseException;
import com.spin.game.exception.UserNotFoundException;
import com.spin.game.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(DrawCloseException.class)
    public ResponseEntity<ApiResponse> handleDrawClosedRequest(){
        ApiResponse ar = new ApiResponse("Draw Closed",false);
        return new ResponseEntity<ApiResponse>(ar, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponse> handleUserNotFoundRequest(){
        ApiResponse apiResponse = new ApiResponse("User not found", false);
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
    }
}
