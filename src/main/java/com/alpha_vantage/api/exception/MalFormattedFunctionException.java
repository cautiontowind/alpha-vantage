package com.alpha_vantage.api.exception;

public class MalFormattedFunctionException extends Exception{
    public MalFormattedFunctionException(String function){
        super("This API function ("+function+") does not exist.");
    }
}
