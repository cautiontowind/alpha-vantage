package com.alpha_vantage.api.service.impl;

import com.alpha_vantage.api.domain.Stock;
import com.alpha_vantage.api.exception.*;
import com.alpha_vantage.api.service.StockOperation;
import com.alpha_vantage.api.util.ExceptionUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriUtils;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.joining;


public class StockTemplate implements StockOperation {
    private static String apiKey;
    private static final String ALPHA_VANTAGE_API_URL = "http://www.alphavantage.co/query?";

    private final RestTemplate restTemplate;


    public StockTemplate(RestTemplate restTemplate, String apiKey){
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
    }



    @Override
    public LinkedHashMap<LocalDateTime, Stock> intraDay(String symbol, HashMap<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException {
        String function = "TIME_SERIES_INTRADAY";
        String queryString = ALPHA_VANTAGE_API_URL+"function="+function+"&symbol="+symbol+"&apikey="+apiKey+"&";

        String encodedUrl = options.keySet().stream().map(key -> {
            try {
                return key + "=" + UriUtils.encode(options.get(key), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(joining("&", queryString, ""));


        LinkedHashMap<LocalDateTime, Stock> result = new LinkedHashMap<>();
        JsonNode jsonNode = restTemplate.getForObject(encodedUrl, JsonNode.class);
        Iterator<Map.Entry<String,JsonNode>> it = jsonNode.fields();
        while(it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);
            String interval = "("+options.get("interval")+")";
            if(mapEntry.getKey().equals("Time Series "+interval)){
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String,JsonNode>> timeSeriesIter = node.fields();
                while(timeSeriesIter.hasNext()){
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDateTime dateTime = LocalDateTime.parse(timeSeriesMap.getKey(), formatter);
                    String open = String.valueOf(timeSeriesMap.getValue().get("1. open")).replaceAll("\"","");
                    String high = String.valueOf(timeSeriesMap.getValue().get("2. high")).replaceAll("\"","");
                    String low = String.valueOf(timeSeriesMap.getValue().get("3. low")).replaceAll("\"","");
                    String close = String.valueOf(timeSeriesMap.getValue().get("4. close")).replaceAll("\"","");
                    String volume = String.valueOf(timeSeriesMap.getValue().get("5. volume")).replaceAll("\"","");
                    result.put(dateTime, Stock.newStpckInstance(symbol,  open, high, low, close,volume));
                }

            }
        }

        return result;
    }



    @Override
    public LinkedHashMap<LocalDate, Stock> daily(String symbol, HashMap<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException{
        String function = "TIME_SERIES_DAILY";
        String queryString = ALPHA_VANTAGE_API_URL+"function="+function+"&symbol="+symbol+"&apikey="+apiKey+"&";
        String encodedUrl = options.keySet().stream().map(key -> {
            try {
                return key + "=" + UriUtils.encode(options.get(key), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(joining("&", queryString, ""));

        LinkedHashMap<LocalDate, Stock> result = new LinkedHashMap<>();
        JsonNode jsonNode = restTemplate.getForObject(encodedUrl, JsonNode.class);
        Iterator<Map.Entry<String,JsonNode>> it = jsonNode.fields();
        while(it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);
            if(mapEntry.getKey().equals("Time Series (Daily)")){
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String,JsonNode>> timeSeriesIter = node.fields();
                while(timeSeriesIter.hasNext()){
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();
                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String open = String.valueOf(timeSeriesMap.getValue().get("1. open")).replaceAll("\"","");
                    String high = String.valueOf(timeSeriesMap.getValue().get("2. high")).replaceAll("\"","");
                    String low = String.valueOf(timeSeriesMap.getValue().get("3. low")).replaceAll("\"","");
                    String close = String.valueOf(timeSeriesMap.getValue().get("4. close")).replaceAll("\"","");
                    String volume = String.valueOf(timeSeriesMap.getValue().get("5. volume")).replaceAll("\"","");
                    result.put(localDate, Stock.newStpckInstance(symbol, open, high, low, close,volume));
                }

            }
        }
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, Stock> dailyAdjustedClose(String symbol, HashMap<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException {
        String function = "TIME_SERIES_DAILY_ADJUSTED";
        String queryString = ALPHA_VANTAGE_API_URL+"function="+function+"&symbol="+symbol+"&apikey="+apiKey+"&";
        String encodedUrl = options.keySet().stream().map(key -> {
            try {
                return key + "=" + UriUtils.encode(options.get(key), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(joining("&", queryString, ""));

        LinkedHashMap<LocalDate, Stock> result = new LinkedHashMap<>();
        JsonNode jsonNode = restTemplate.getForObject(encodedUrl, JsonNode.class);
        Iterator<Map.Entry<String,JsonNode>> it = jsonNode.fields();
        while(it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);
            if(mapEntry.getKey().equals("Time Series (Daily)")){
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String,JsonNode>> timeSeriesIter = node.fields();
                while(timeSeriesIter.hasNext()){
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();
                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String open = String.valueOf(timeSeriesMap.getValue().get("1. open")).replaceAll("\"","");
                    String high = String.valueOf(timeSeriesMap.getValue().get("2. high")).replaceAll("\"","");
                    String low = String.valueOf(timeSeriesMap.getValue().get("3. low")).replaceAll("\"","");
                    String close = String.valueOf(timeSeriesMap.getValue().get("4. close")).replaceAll("\"","");
                    String adjustedClose = String.valueOf(timeSeriesMap.getValue().get("5. adjusted close")).replaceAll("\"","");
                    String volume = String.valueOf(timeSeriesMap.getValue().get("6. volume")).replaceAll("\"","");
                    String dividendAmount = String.valueOf(timeSeriesMap.getValue().get("7. dividend amount")).replaceAll("\"","");
                    String splitCoefficient = String.valueOf(timeSeriesMap.getValue().get("8. split coefficient")).replaceAll("\"","");

                    result.put(localDate, Stock.newStpckInstance("",symbol, open, high,low, close,volume,adjustedClose,dividendAmount,splitCoefficient));
                }

            }
        }
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, Stock> weekly(String symbol, HashMap<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException {
        String function = "TIME_SERIES_WEEKLY";
        String queryString = ALPHA_VANTAGE_API_URL+"function="+function+"&symbol="+symbol+"&apikey="+apiKey+"&";
        String encodedUrl = options.keySet().stream().map(key -> {
            try {
                return key + "=" + UriUtils.encode(options.get(key), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(joining("&", queryString, ""));

        LinkedHashMap<LocalDate, Stock> result = new LinkedHashMap<>();
        JsonNode jsonNode = restTemplate.getForObject(encodedUrl, JsonNode.class);
        Iterator<Map.Entry<String,JsonNode>> it = jsonNode.fields();
        while(it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);
            if(mapEntry.getKey().equals("Weekly Time Series")){
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String,JsonNode>> timeSeriesIter = node.fields();
                while(timeSeriesIter.hasNext()){
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();
                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String open = String.valueOf(timeSeriesMap.getValue().get("1. open")).replaceAll("\"","");
                    String high = String.valueOf(timeSeriesMap.getValue().get("2. high")).replaceAll("\"","");
                    String low = String.valueOf(timeSeriesMap.getValue().get("3. low")).replaceAll("\"","");
                    String close = String.valueOf(timeSeriesMap.getValue().get("4. close")).replaceAll("\"","");
                    String volume = String.valueOf(timeSeriesMap.getValue().get("5. volume")).replaceAll("\"","");
                    result.put(localDate, Stock.newStpckInstance(symbol, open, high, low, close,volume));
                }

            }
        }
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, Stock> monthly(String symbol, HashMap<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException{
        String function = "TIME_SERIES_MONTHLY";
        String queryString = ALPHA_VANTAGE_API_URL+"function="+function+"&symbol="+symbol+"&apikey="+apiKey+"&";
        String encodedUrl = options.keySet().stream().map(key -> {
            try {
                return key + "=" + UriUtils.encode(options.get(key), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(joining("&", queryString, ""));

        LinkedHashMap<LocalDate, Stock> result = new LinkedHashMap<>();
        JsonNode jsonNode = restTemplate.getForObject(encodedUrl, JsonNode.class);
        Iterator<Map.Entry<String,JsonNode>> it = jsonNode.fields();
        while(it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);
            if(mapEntry.getKey().equals("Monthly Time Series")){
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String,JsonNode>> timeSeriesIter = node.fields();
                while(timeSeriesIter.hasNext()){
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();
                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String open = String.valueOf(timeSeriesMap.getValue().get("1. open")).replaceAll("\"","");
                    String high = String.valueOf(timeSeriesMap.getValue().get("2. high")).replaceAll("\"","");
                    String low = String.valueOf(timeSeriesMap.getValue().get("3. low")).replaceAll("\"","");
                    String close = String.valueOf(timeSeriesMap.getValue().get("4. close")).replaceAll("\"","");
                    String volume = String.valueOf(timeSeriesMap.getValue().get("5. volume")).replaceAll("\"","");
                    result.put(localDate, Stock.newStpckInstance(symbol, open, high, low, close,volume));
                }

            }
        }
        return result;
    }



}
