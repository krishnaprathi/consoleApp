package com.exception;

public class InvalidInputException extends Exception {

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String message;
    public InvalidInputException(String message) {
        super(message);
        setMessage(message);
    }

}
