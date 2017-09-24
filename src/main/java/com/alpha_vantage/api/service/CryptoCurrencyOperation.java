package com.alpha_vantage.api.service;

import com.alpha_vantage.api.domain.Currency;
import com.alpha_vantage.api.domain.DigitalCurrency;
import com.alpha_vantage.api.enums.CurrencyType;
import com.alpha_vantage.api.enums.DigitalCurrencyType;
import com.alpha_vantage.api.enums.MarketList;
import com.alpha_vantage.api.exception.*;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;

public interface CryptoCurrencyOperation {
    Currency exchangeRate(CurrencyType fromCurrency, CurrencyType toCurrency) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;
    Currency exchangeRate(CurrencyType fromCurrency, DigitalCurrency toCurrency) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;
    Currency exchangeRate(DigitalCurrencyType fromCurrency, CurrencyType toCurrency) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;
    Currency exchangeRate(DigitalCurrencyType fromCurrency, DigitalCurrencyType toCurrency) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;



    LinkedHashMap<LocalDateTime, DigitalCurrency> intraday(DigitalCurrencyType symbol, MarketList market) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;
    LinkedHashMap<LocalDate, DigitalCurrency> daily(DigitalCurrencyType symbol, MarketList market) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;
    LinkedHashMap<LocalDate, DigitalCurrency> weekly(DigitalCurrencyType symbol, MarketList market) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;
    LinkedHashMap<LocalDate, DigitalCurrency> monthly(DigitalCurrencyType symbol, MarketList market) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

}
