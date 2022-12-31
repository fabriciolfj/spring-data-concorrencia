package com.github.fabriciolfj.inventaryserviceimperativo.exceptions;

import com.github.fabriciolfj.inventaryserviceimperativo.exceptions.enums.Errors;

public class InventoryNotFoundException extends RuntimeException {

    public InventoryNotFoundException() {
        super(Errors.ERROR_1.toMessage());
    }
}
