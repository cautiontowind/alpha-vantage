package com.alpha_vantage.api.service;



import com.alpha_vantage.api.domain.Stock;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;

public interface StockOperation {
    LinkedHashMap<LocalDateTime, Stock> intraDay(String symbol, HashMap<String, String> options) throws UnsupportedEncodingException;
    LinkedHashMap<LocalDate, Stock> daily(String symbol, HashMap<String, String> options) throws UnsupportedEncodingException;
    LinkedHashMap<LocalDate, Stock> dailyAdjustedClose(String symbol, HashMap<String, String> options) throws UnsupportedEncodingException;
    LinkedHashMap<LocalDate, Stock> weekly(String symbol, HashMap<String, String> options) throws UnsupportedEncodingException;
    LinkedHashMap<LocalDate, Stock> monthly(String symbol, HashMap<String, String> options) throws UnsupportedEncodingException;



}
