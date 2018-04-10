package com.jalpha_vantage.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.jalpha_vantage.enums.CryptoSymbol;
import com.jalpha_vantage.exception.*;
import com.jalpha_vantage.domain.Currency;
import com.jalpha_vantage.domain.DigitalCurrency;
import com.jalpha_vantage.domain.DigitalCurrencyDaily;
import com.jalpha_vantage.domain.DigitalCurrencyIntraDay;
import com.jalpha_vantage.enums.CurrencySymbol;
import com.jalpha_vantage.enums.MarketList;
import com.jalpha_vantage.service.ICryptoCurrencyService;
import com.jalpha_vantage.util.ExceptionUtil;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class CryptoCurrencyTemplate implements ICryptoCurrencyService {
    private static final String ALPHA_VANTAGE_API_URL = "http://www.alphavantage.co/query?";
    private static String apiKey;
    private final RestTemplate restTemplate;

    public CryptoCurrencyTemplate(RestTemplate restTemplate, String apiKey) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
    }

    @Override
    public Currency exchangeRate(CurrencySymbol fromCurrency, CurrencySymbol toCurrency) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException {
        String fromCurrencyStr = String.valueOf(fromCurrency);
        String toCurrencyStr = String.valueOf(toCurrency);
        Currency currency = requestApiData(fromCurrencyStr, toCurrencyStr);
        return currency;
    }

    @Override
    public Currency exchangeRate(CurrencySymbol fromCurrency, DigitalCurrency toCurrency) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException {
        String fromCurrencyStr = String.valueOf(fromCurrency);
        String toCurrencyStr = String.valueOf(toCurrency).replace("_", "");
        Currency currency = requestApiData(fromCurrencyStr, toCurrencyStr);
        return currency;
    }


    @Override
    public Currency exchangeRate(CryptoSymbol fromCurrency, CurrencySymbol toCurrency) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException {
        String fromCurrencyStr = String.valueOf(fromCurrency).replace("_", "");
        String toCurrencyStr = String.valueOf(toCurrency);
        Currency currency = requestApiData(fromCurrencyStr, toCurrencyStr);
        return currency;
    }

    @Override
    public Currency exchangeRate(CryptoSymbol fromCurrency, CryptoSymbol toCurrency) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException {
        String fromCurrencyStr = String.valueOf(fromCurrency).replace("_", "");
        String toCurrencyStr = String.valueOf(toCurrency).replace("_", "");
        Currency currency = requestApiData(fromCurrencyStr, toCurrencyStr);
        return currency;
    }

    @Override
    public LinkedHashMap<LocalDateTime, DigitalCurrency> intraday(CryptoSymbol symbol, MarketList market) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException {
        String function = "DIGITAL_CURRENCY_INTRADAY";

        String queryString = ALPHA_VANTAGE_API_URL + "function=" + function + "&symbol=" + String.valueOf(symbol).replace("_", "") + "&market=" + market.toString() + "&apikey=" + apiKey + "&";
        JsonNode jsonNode = restTemplate.getForObject(queryString, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();

        LinkedHashMap<LocalDateTime, DigitalCurrency> result = new LinkedHashMap<>();

        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);

            if (mapEntry.getKey().equals("Error Message")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, function);
            }

            if (mapEntry.getKey().equals("Information")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, function);
            }
            if (mapEntry.getKey().equals("Time Series (Digital Currency Intraday)")) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDateTime dateTime = LocalDateTime.parse(timeSeriesMap.getKey(), formatter);
                    String price = String.valueOf(timeSeriesMap.getValue().get("1a. price (" + market + ")")).replaceAll("\"", "");
                    String usdPrice = String.valueOf(timeSeriesMap.getValue().get("1b. price (USD)")).replaceAll("\"", "");
                    String vol = String.valueOf(timeSeriesMap.getValue().get("2. volume")).replaceAll("\"", "");
                    String marketCap = String.valueOf(timeSeriesMap.getValue().get("3. market cap (USD)")).replaceAll("\"", "");
                    result.put(dateTime, DigitalCurrencyIntraDay.newInstance(symbol, market.name(), price, usdPrice,vol,marketCap));
                }

            }
        }

        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, DigitalCurrency> daily(CryptoSymbol symbol, MarketList market) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException {
        String function = "DIGITAL_CURRENCY_DAILY";
        LinkedHashMap<LocalDate, DigitalCurrency> result = requestApiData(function, symbol, market);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, DigitalCurrency> weekly(CryptoSymbol symbol, MarketList market) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException {
        String function = "DIGITAL_CURRENCY_WEEKLY";
        LinkedHashMap<LocalDate, DigitalCurrency> result = requestApiData(function, symbol, market);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, DigitalCurrency> monthly(CryptoSymbol symbol, MarketList market) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException {
        String function = "DIGITAL_CURRENCY_MONTHLY";
        LinkedHashMap<LocalDate, DigitalCurrency> result = requestApiData(function, symbol, market);
        return result;
    }

    private LinkedHashMap<LocalDate, DigitalCurrency> requestApiData(String function, CryptoSymbol symbol, MarketList market) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException {
        String queryString = ALPHA_VANTAGE_API_URL + "function=" + function + "&symbol=" + String.valueOf(symbol).replace("_", "") + "&market=" + market.toString() + "&apikey=" + apiKey + "&";
        JsonNode jsonNode = restTemplate.getForObject(queryString, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();

        LinkedHashMap<LocalDate, DigitalCurrency> result = new LinkedHashMap<>();

        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);
            String duration = function.substring(17).toLowerCase();
            String titleCase = String.valueOf(duration.charAt(0)).toUpperCase() + duration.substring(1);
            if (mapEntry.getKey().equals("Time Series (Digital Currency " + titleCase + ")")) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();
                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String open = String.valueOf(timeSeriesMap.getValue().get("1a. open (" + market + ")")).replaceAll("\"", "");
                    String usdOpen = String.valueOf(timeSeriesMap.getValue().get("1b. open (USD)")).replaceAll("\"", "");

                    String high = String.valueOf(timeSeriesMap.getValue().get("2a. high (" + market + ")")).replaceAll("\"", "");
                    String usdHigh = String.valueOf(timeSeriesMap.getValue().get("2b. high (USD)")).replaceAll("\"", "");

                    String low = String.valueOf(timeSeriesMap.getValue().get("3a. low (" + market + ")")).replaceAll("\"", "");
                    String usdLow = String.valueOf(timeSeriesMap.getValue().get("3b. low (USD)")).replaceAll("\"", "");

                    String close = String.valueOf(timeSeriesMap.getValue().get("4a. close (" + market + ")")).replaceAll("\"", "");
                    String usdClose = String.valueOf(timeSeriesMap.getValue().get("4b. close (USD)")).replaceAll("\"", "");

                    String vol = String.valueOf(timeSeriesMap.getValue().get("volume")).replaceAll("\"", "");

                    String marketCap = String.valueOf(timeSeriesMap.getValue().get("6. market cap (USD)")).replaceAll("\"", "");
                    result.put(localDate, DigitalCurrencyDaily.newInstance(symbol, market.name(), open, usdOpen, high,usdHigh, low,usdLow, close, usdClose, vol, marketCap));
                }

            }
        }

        return result;
    }

    private Currency requestApiData(String fromCurrency, String toCurrency) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException {
        String function = "CURRENCY_EXCHANGE_RATE";
        String queryString = ALPHA_VANTAGE_API_URL + "function=" + function + "&from_currency=" + fromCurrency + "&to_currency=" + toCurrency + "&apikey=" + apiKey + "&";
        JsonNode jsonNode = restTemplate.getForObject(queryString, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);
            if (mapEntry.getKey().equals("Realtime Currency Exchange Rate")) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    String fromCurrencyCode = String.valueOf(timeSeriesIter.next().getValue()).replaceAll("\"", "");
                    String fromCurrencyName = String.valueOf(timeSeriesIter.next().getValue()).replaceAll("\"", "");
                    String toCurrencyCode = String.valueOf(timeSeriesIter.next().getValue()).replaceAll("\"", "");
                    String toCurrencyName = String.valueOf(timeSeriesIter.next().getValue()).replaceAll("\"", "");
                    String exchangeRate = String.valueOf(timeSeriesIter.next().getValue()).replaceAll("\"", "");
                    String lastRefreshed = String.valueOf(timeSeriesIter.next().getValue()).replaceAll("\"", "");
                    String timezone = String.valueOf(timeSeriesIter.next().getValue()).replaceAll("\"", "");
                    return Currency.newCurrencyInstance(fromCurrencyCode, fromCurrencyName, toCurrencyCode, toCurrencyName, exchangeRate, lastRefreshed, timezone);
                }
            }
        }
        return null;
    }


}
