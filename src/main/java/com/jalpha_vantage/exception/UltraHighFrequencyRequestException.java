package com.jalpha_vantage.exception;

public class UltraHighFrequencyRequestException extends Exception {
    public UltraHighFrequencyRequestException() {
        super("Please consider optimizing your API call frequency");
    }
}
