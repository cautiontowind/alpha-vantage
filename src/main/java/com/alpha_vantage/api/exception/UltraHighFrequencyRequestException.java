package com.alpha_vantage.api.exception;

public class UltraHighFrequencyRequestException extends Exception {
    public UltraHighFrequencyRequestException(){
        super("Please consider optimizing your API call frequency");
    }
}
