package com.github.fabriciolfj.inventaryserviceimperativo.exceptions;

import com.github.fabriciolfj.inventaryserviceimperativo.domain.TypeOperation;
import com.github.fabriciolfj.inventaryserviceimperativo.exceptions.enums.Errors;

public class TypeOperationNotFoundException extends RuntimeException {

    public TypeOperationNotFoundException() {
        super(Errors.ERROR_1.toMessage());
    }
}
