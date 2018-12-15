package com.jalpha_vantage.service;


import com.jalpha_vantage.domain.Stock;
import com.jalpha_vantage.exception.*;
import com.jalpha_vantage.exception.*;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;

public interface IStockService {
    LinkedHashMap<LocalDateTime, Stock> intraDay(String symbol, HashMap<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    LinkedHashMap<LocalDate, Stock> daily(String symbol, HashMap<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    LinkedHashMap<LocalDate, Stock> dailyAdjustedClose(String symbol, HashMap<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    LinkedHashMap<LocalDate, Stock> weekly(String symbol, HashMap<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    LinkedHashMap<LocalDate, Stock> weeklyAdjusted(String symbol, HashMap<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    LinkedHashMap<LocalDate, Stock> monthly(String symbol, HashMap<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    LinkedHashMap<LocalDate, Stock> monthlyAdjusted(String symbol, HashMap<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;


}
