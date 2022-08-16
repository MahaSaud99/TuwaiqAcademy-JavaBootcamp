package com.example.schoolms.advise;

import com.example.schoolms.dto.apiResponse;
import com.example.schoolms.exception.apiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class studentAdvise {

    @ExceptionHandler(value = apiException.class)
    public ResponseEntity<apiResponse> apiException(apiException e){
        String msg=e.getMessage();
        return ResponseEntity.status(400).body(new apiResponse(msg));
    }

    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<apiResponse> SQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e){
        String msg=e.getMessage();
        return ResponseEntity.status(400).body(new apiResponse(msg));
    }
    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<apiResponse> EntityNotFoundException(EntityNotFoundException e) {
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(new apiResponse(msg));
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<apiResponse> MethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String msg = e.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(new apiResponse(msg));
    }


}
