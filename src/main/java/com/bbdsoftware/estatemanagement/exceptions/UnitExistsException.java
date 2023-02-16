package com.bbdsoftware.estatemanagement.exceptions;


public class UnitExistsException extends RuntimeException {
    public UnitExistsException() {
        super("UnitNumber already exists");
    }

    public UnitExistsException(String message) {
        super(message);
    }
}
