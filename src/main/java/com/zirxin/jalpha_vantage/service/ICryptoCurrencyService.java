package com.zirxin.jalpha_vantage.service;

import com.zirxin.jalpha_vantage.domain.Currency;
import com.zirxin.jalpha_vantage.domain.DigitalCurrency;
import com.zirxin.jalpha_vantage.enums.CurrencyType;
import com.zirxin.jalpha_vantage.enums.DigitalCurrencyType;
import com.zirxin.jalpha_vantage.enums.MarketList;
import com.zirxin.jalpha_vantage.exception.*;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;

public interface ICryptoCurrencyService {
    Currency exchangeRate(CurrencyType fromCurrency, CurrencyType toCurrency) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    Currency exchangeRate(CurrencyType fromCurrency, DigitalCurrency toCurrency) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    Currency exchangeRate(DigitalCurrencyType fromCurrency, CurrencyType toCurrency) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    Currency exchangeRate(DigitalCurrencyType fromCurrency, DigitalCurrencyType toCurrency) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;


    LinkedHashMap<LocalDateTime, DigitalCurrency> intraday(DigitalCurrencyType symbol, MarketList market) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, DigitalCurrency> daily(DigitalCurrencyType symbol, MarketList market) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, DigitalCurrency> weekly(DigitalCurrencyType symbol, MarketList market) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, DigitalCurrency> monthly(DigitalCurrencyType symbol, MarketList market) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

}
