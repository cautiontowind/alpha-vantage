package com.jalpha_vantage.exception;

public class MalFormattedFunctionException extends Exception {
    public MalFormattedFunctionException(String function) {
        super("This API function (" + function + ") does not exist.");
    }
}
