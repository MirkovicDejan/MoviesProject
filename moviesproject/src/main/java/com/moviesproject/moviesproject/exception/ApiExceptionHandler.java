package com.moviesproject.moviesproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ApiExceptionHandler {
    @ExceptionHandler(value={ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
      HttpStatus badRequest = HttpStatus.BAD_REQUEST;
     Exception exception = new Exception(
                e.getMessage(),
                e, badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

     return new ResponseEntity<>(exception,badRequest);

    }

}
