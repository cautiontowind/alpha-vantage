package com.jalpha_vantage.service;

import com.jalpha_vantage.enums.CryptoSymbol;
import com.jalpha_vantage.exception.*;
import com.jalpha_vantage.domain.Currency;
import com.jalpha_vantage.domain.DigitalCurrency;
import com.jalpha_vantage.enums.CurrencySymbol;
import com.jalpha_vantage.enums.MarketList;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;

public interface ICryptoCurrencyService {
    Currency exchangeRate(CurrencySymbol fromCurrency, CurrencySymbol toCurrency) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    Currency exchangeRate(CurrencySymbol fromCurrency, DigitalCurrency toCurrency) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    Currency exchangeRate(CryptoSymbol fromCurrency, CurrencySymbol toCurrency) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    Currency exchangeRate(CryptoSymbol fromCurrency, CryptoSymbol toCurrency) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;


    LinkedHashMap<LocalDateTime, DigitalCurrency> intraday(CryptoSymbol symbol, MarketList market) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, DigitalCurrency> daily(CryptoSymbol symbol, MarketList market) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, DigitalCurrency> weekly(CryptoSymbol symbol, MarketList market) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, DigitalCurrency> monthly(CryptoSymbol symbol, MarketList market) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

}
