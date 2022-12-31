package com.github.fabriciolfj.inventaryserviceimperativo.exceptions;

import com.github.fabriciolfj.inventaryserviceimperativo.exceptions.enums.Errors;

public class InventoryNegativeException extends RuntimeException {

    public InventoryNegativeException() {
        super(Errors.ERROR_2.toMessage());
    }
}
