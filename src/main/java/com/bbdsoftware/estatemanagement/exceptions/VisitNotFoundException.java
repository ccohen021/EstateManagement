package com.bbdsoftware.estatemanagement.exceptions;

public class VisitNotFoundException extends Exception {
    public VisitNotFoundException() {
        super("No visit for that VisitID");
    }
}
