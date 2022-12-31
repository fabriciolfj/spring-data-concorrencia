package com.github.fabriciolfj.inventaryserviceimperativo.exceptions;

import com.github.fabriciolfj.inventaryserviceimperativo.exceptions.enums.Errors;

public class UpdateInvalidInventoryException extends RuntimeException {

    public UpdateInvalidInventoryException() {
        super(Errors.ERROR_2.toMessage());
    }
}
