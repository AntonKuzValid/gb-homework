package ru.geekbrains.data.advice;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.geekbrains.data.advice.annotation.ProductDatabaseException;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@ControllerAdvice(annotations = ProductDatabaseException.class)
public class ExceptionAdvice {

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Response> handleResultDataException(EmptyResultDataAccessException e) {
        return getResponse(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public  ResponseEntity<Response> handleNoSuchElException(NoSuchElementException e){
        return getResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<Response> getResponse(String mes, HttpStatus status) {
        String message = String.format("%s %s", LocalDateTime.now(), mes);
        Response response = new Response(message);
        return new ResponseEntity<>(response, status);
    }
}
