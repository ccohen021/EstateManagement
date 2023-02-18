package com.bbdsoftware.estatemanagement.exceptions;

public class EmailNotFoundException extends Exception {
    public EmailNotFoundException() {
        super("Email not found");
    }
}
