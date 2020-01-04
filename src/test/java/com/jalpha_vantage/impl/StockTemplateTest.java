package com.jalpha_vantage.impl;

import com.jalpha_vantage.domain.DailyStock;
import com.jalpha_vantage.domain.IntraStock;
import com.jalpha_vantage.domain.StockQuote;
import com.jalpha_vantage.exception.*;
import com.jalpha_vantage.service.IStockService;
import com.jalpha_vantage.test.AbstractServiceTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

import static junit.framework.TestCase.*;

public class StockTemplateTest extends AbstractServiceTest {

    @Autowired
    IStockService stockOperation;

    @Test
    public void testQuote(){
        try{
        StockQuote quote = stockOperation.quote("BARC.L");
        assertNotNull(quote);
//        assertNotNull(quote);
        }catch (Exception ex){
            fail(ex.getMessage());
        }
    }
    @Test
    public void testIntraDay() {
        try {
            HashMap<String, String> params = new HashMap<String, String>();
            params.put("interval", "1min");
            List<IntraStock> stocks = stockOperation.intraDay("BP.L", params);
            //Closed on the Weekends, so it has no data (Test was ran on a weekend)
            assertEquals(100, stocks.size());
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
            fail("Unsupported Encoding Exception");
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");
        }
    }

    @Test
    public void testDaily() {
        try {
            HashMap<String, String> params = new HashMap<String, String>();
            List<DailyStock> stocks = stockOperation.daily("BARC.L", params);
            assertEquals(100, stocks.size());

        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
            fail("Unsupported Encoding Exception");
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");
        }
    }

    @Test
    public void testDailyAdjustedClose() {
        try {
            HashMap<String, String> params = new HashMap<String, String>();
            List<DailyStock> stocks = stockOperation.dailyAdjustedClose("vod.l", params);
            assertEquals(100, stocks.size());
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
            fail("Unsupported Encoding Exception");
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");
        }
    }

    @Test
    public void testWeekly() {
        try {
            HashMap<String, String> params = new HashMap<String, String>();
            List<DailyStock> stocks = stockOperation.weekly("vod.l", params);
            assertEquals(925, stocks.size());
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
            fail("Unsupported Encoding Exception");
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");
        }
    }

    @Test
    public void testWeeklyAdjusted() {
        try {
            HashMap<String, String> params = new HashMap<String, String>();
            List<DailyStock> stocks = stockOperation.weeklyAdjusted("vod.l", params);
            assertEquals(931, stocks.size());
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
            fail("Unsupported Encoding Exception");
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");
        }
    }

    @Test
    public void testMonthly() {
        try {
            HashMap<String, String> params = new HashMap<String, String>();
            List<DailyStock> stocks = stockOperation.monthly("vod.l", params);
            assertEquals(212, stocks.size());
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
            fail("Unsupported Encoding Exception");
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");
        }
    }

    @Test
    public void testMonthlyAdjusted() {
        try {
            HashMap<String, String> params = new HashMap<String, String>();
            List<DailyStock> stocks = stockOperation.monthlyAdjusted("vod.l", params);
            assertEquals(213, stocks.size());
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
            fail("Unsupported Encoding Exception");
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");
        }
    }
}
