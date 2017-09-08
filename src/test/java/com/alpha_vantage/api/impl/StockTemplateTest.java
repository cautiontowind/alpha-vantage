package com.alpha_vantage.api.impl;

import com.alpha_vantage.api.domain.Stock;
import com.alpha_vantage.api.service.StockOperation;
import com.alpha_vantage.api.test.AbstractServiceTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class StockTemplateTest extends AbstractServiceTest {

    @Autowired
    StockOperation stockOperation;


    @Test
    public void testIntraDay(){
        try {
            HashMap<String, String> params = new HashMap<String, String>();
            Map<LocalDateTime, Stock> stocks = stockOperation.intraDay("msft",params);
            //Closed on the Weekends, so it has no data (Test was ran on a weekend)
            assertEquals(0, stocks.size());
            for(LocalDateTime key : stocks.keySet()){
                System.out.println(key+" => "+stocks.get(key));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testDaily(){
        try {
            HashMap<String, String> params = new HashMap<String, String>();
            Map<LocalDate, Stock> stocks = stockOperation.daily("vod.l",params);
            assertEquals(100, stocks.size());
            for(LocalDate key : stocks.keySet()){
                System.out.println(key+" => "+stocks.get(key));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDailyAdjustedClose(){
        try {
            HashMap<String, String> params = new HashMap<String, String>();
            Map<LocalDate, Stock> stocks = stockOperation.dailyAdjustedClose("vod.l",params);
            assertEquals(100, stocks.size());
            for(LocalDate key : stocks.keySet()){
                System.out.println(key+" => "+stocks.get(key));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWeekly(){
        try {
            HashMap<String, String> params = new HashMap<String, String>();
            Map<LocalDate, Stock> stocks = stockOperation.weekly("vod.l",params);
            assertEquals(925, stocks.size());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testMonthly(){
        try {
            HashMap<String, String> params = new HashMap<String, String>();
            Map<LocalDate, Stock> stocks = stockOperation.monthly("vod.l",params);
            assertEquals(212, stocks.size());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
