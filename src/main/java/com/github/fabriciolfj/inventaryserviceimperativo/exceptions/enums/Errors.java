package com.github.fabriciolfj.inventaryserviceimperativo.exceptions.enums;

import java.util.ResourceBundle;

public enum Errors {

    ERROR_1,
    ERROR_2;

    public String toMessage() {
        var bundle = ResourceBundle.getBundle("messages/exceptions");
        return bundle.getString(this.name() + ".message");
    }
}
