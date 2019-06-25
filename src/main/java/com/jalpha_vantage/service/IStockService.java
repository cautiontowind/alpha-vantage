package com.jalpha_vantage.service;


import com.jalpha_vantage.domain.Stock;
import com.jalpha_vantage.exception.*;
import com.jalpha_vantage.exception.*;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public interface IStockService {
    
    List<Stock> intraDay(String symbol, HashMap<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<Stock> daily(String symbol, HashMap<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<Stock> dailyAdjustedClose(String symbol, HashMap<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<Stock> weekly(String symbol, HashMap<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<Stock> weeklyAdjusted(String symbol, HashMap<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<Stock> monthly(String symbol, HashMap<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<Stock> monthlyAdjusted(String symbol, HashMap<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;


}
