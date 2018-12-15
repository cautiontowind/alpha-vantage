package com.jalpha_vantage.exception;

public class ApiLimitExceeded extends Exception {
    public ApiLimitExceeded(String value){
        super(value);
    }
}
