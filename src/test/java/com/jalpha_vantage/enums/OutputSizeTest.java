package com.jalpha_vantage.enums;

import org.junit.Test;

import static com.jalpha_vantage.enums.OutputSize.COMPACT;
import static com.jalpha_vantage.enums.OutputSize.FULL;
import static org.junit.Assert.*;

public class OutputSizeTest {
    @Test
    public void uriPath(){
        assertTrue(COMPACT.uriPath().equals("outputsize=compact"));
        assertTrue(FULL.uriPath().equals("outputsize=full"));
    }

}