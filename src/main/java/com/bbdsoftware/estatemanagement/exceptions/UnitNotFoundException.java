package com.bbdsoftware.estatemanagement.exceptions;

public class UnitNotFoundException extends RuntimeException {
    public UnitNotFoundException() {
        super("UnitNumber does not exist.");
    }
}
