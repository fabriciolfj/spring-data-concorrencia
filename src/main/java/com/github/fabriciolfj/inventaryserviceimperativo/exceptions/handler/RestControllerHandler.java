package com.github.fabriciolfj.inventaryserviceimperativo.exceptions.handler;

import com.github.fabriciolfj.inventaryserviceimperativo.exceptions.InventoryNotFoundException;
import com.github.fabriciolfj.inventaryserviceimperativo.exceptions.TypeOperationNotFoundException;
import com.github.fabriciolfj.inventaryserviceimperativo.exceptions.model.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestControllerHandler {

    @ExceptionHandler(TypeOperationNotFoundException.class)
    public ResponseEntity<ErrorDto> handlerTypeOperationNotFoundException(final TypeOperationNotFoundException e) {
        var dto = ErrorDto.builder()
                .message(e.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(dto);
    }

    @ExceptionHandler(InventoryNotFoundException.class)
    public ResponseEntity<ErrorDto> handlerInventoryNotFound(final InventoryNotFoundException e) {
        var dto = ErrorDto.builder()
                .message(e.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(dto);
    }
}
