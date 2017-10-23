package com.jalpha_vantage.exception;

public class InvalidFunctionOptionException extends Exception {
    public InvalidFunctionOptionException(String function) {
        super("Invalid API call, please visit documentation (https://www.alphavantage.co/documentation/) for function: " + function);
    }
}
