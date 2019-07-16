package com.jalpha_vantage.service;

import com.jalpha_vantage.domain.DigitalCurrencyDaily;
import com.jalpha_vantage.enums.CryptoSymbol;
import com.jalpha_vantage.exception.*;
import com.jalpha_vantage.domain.Currency;
import com.jalpha_vantage.domain.DigitalCurrency;
import com.jalpha_vantage.enums.CurrencySymbol;
import com.jalpha_vantage.enums.MarketList;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface ICryptoCurrencyService {
    Currency exchangeRate(CurrencySymbol fromCurrency, CurrencySymbol toCurrency) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    Currency exchangeRate(CurrencySymbol fromCurrency, DigitalCurrency toCurrency) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    Currency exchangeRate(CryptoSymbol fromCurrency, CurrencySymbol toCurrency) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    Currency exchangeRate(CryptoSymbol fromCurrency, CryptoSymbol toCurrency) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    Currency exchangeRate(CryptoSymbol symbol, MarketList list)  throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

//    List<DigitalCurrency> intraday(CryptoSymbol symbol, MarketList market) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;


    List<DigitalCurrencyDaily> daily(CryptoSymbol symbol, MarketList market) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<DigitalCurrencyDaily> weekly(CryptoSymbol symbol, MarketList market) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<DigitalCurrencyDaily> monthly(CryptoSymbol symbol, MarketList market) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

}
