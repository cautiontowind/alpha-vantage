package com.alpha_vantage.api.exception;

public class InvalidApiKeyException extends Exception {
    public InvalidApiKeyException(){
        super("Please make sure your API key is valid. Alternatively, claim your free API key on (https://www.alphavantage.co/support/#api-key). It should take less than 20 seconds, and is free permanently.");
    }
}
