package com.jalpha_vantage.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.jalpha_vantage.domain.Stock;
import com.jalpha_vantage.exception.*;
import com.jalpha_vantage.service.IStockService;
import com.jalpha_vantage.util.ExceptionUtil;
import com.jalpha_vantage.util.Utils;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.util.stream.Collectors.joining;

public class StockTemplate implements IStockService {


    private final RestTemplate restTemplate;


    private static String apiKey;

    //@Autowired
    public StockTemplate(RestTemplate restTemplate, String apiKey) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
    }

    @Override
    public List<Stock> intraDay(String symbol, HashMap<String, String> options)
            throws InvalidApiKeyException,
            InvalidFunctionOptionException,
            MalFormattedFunctionException,
            MissingApiKeyException,
            UltraHighFrequencyRequestException,
            ApiLimitExceeded {
        String function = "TIME_SERIES_INTRADAY";

        StringBuilder sb = new StringBuilder();
        sb.append(Utils.BASE_URI)
                .append("function=")
                .append(function)
                .append("&symbol=")
                .append(symbol)
                .append("&apikey=")
                .append(apiKey)
                .append("&");

        String encodedUrl = options.keySet().stream().map(key -> {
            try {
                return Utils.contentKeyVal(key, options.get(key));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(joining("&", sb.toString(), ""));


        List<Stock> result = new ArrayList<>();

        JsonNode jsonNode = restTemplate.getForObject(encodedUrl, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);
            String keyVal = new StringBuilder().append("Time Series ").append("(").append(options.get("interval")).append(")").toString();
            if (mapEntry.getKey().equals(keyVal)) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDateTime dateTime = LocalDateTime.parse(timeSeriesMap.getKey(), formatter);
                    Stock stock = intraStock(symbol, timeSeriesMap, dateTime);
                    result.add(stock);
                }

            }
        }

        return result;
    }



    @Override
    public List<Stock> daily(String symbol, HashMap<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        String function = "TIME_SERIES_DAILY";
        StringBuilder sb = new StringBuilder();
        sb.append(Utils.BASE_URI)
                .append("function=")
                .append(function)
                .append("&symbol=")
                .append(symbol)
                .append("&apikey=")
                .append(apiKey)
                .append("&");

        String encodedUrl = options.keySet().stream().map(key -> {
            try {
                return Utils.contentKeyVal(key, options.get(key));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(joining("&", sb.toString(), ""));
        List<Stock> result = new ArrayList<>();
        JsonNode jsonNode = restTemplate.getForObject(encodedUrl, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);
            if (mapEntry.getKey().equals("Time Series (Daily)")) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();
                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    Stock stock = dailyStock(symbol, timeSeriesMap,localDate);
                    result.add(stock);
                }

            }
        }
        return result;
    }




    @Override
    public List<Stock> dailyAdjustedClose(String symbol, HashMap<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        String function = "TIME_SERIES_DAILY_ADJUSTED";
        StringBuilder sb = new StringBuilder();
        sb.append(Utils.BASE_URI)
                .append("function=")
                .append(function)
                .append("&symbol=")
                .append(symbol)
                .append("&apikey=")
                .append(apiKey)
                .append("&");

        String encodedUrl = options.keySet().stream().map(key -> {
            try {
                return Utils.contentKeyVal(key, options.get(key));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(joining("&", sb.toString(), ""));


        List<Stock> result = new ArrayList<>();
        JsonNode jsonNode = restTemplate.getForObject(encodedUrl, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);
            if (mapEntry.getKey().equals("Time Series (Daily)")) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();
                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String open = String.valueOf(timeSeriesMap.getValue().get("1. open")).replaceAll("\"", "");
                    String high = String.valueOf(timeSeriesMap.getValue().get("2. high")).replaceAll("\"", "");
                    String low = String.valueOf(timeSeriesMap.getValue().get("3. low")).replaceAll("\"", "");
                    String close = String.valueOf(timeSeriesMap.getValue().get("4. close")).replaceAll("\"", "");
                    String adjustedClose = String.valueOf(timeSeriesMap.getValue().get("5. adjusted close")).replaceAll("\"", "");
                    String volume = String.valueOf(timeSeriesMap.getValue().get("6. volume")).replaceAll("\"", "");
                    String dividendAmount = String.valueOf(timeSeriesMap.getValue().get("7. dividend amount")).replaceAll("\"", "");
                    String splitCoefficient = String.valueOf(timeSeriesMap.getValue().get("8. split coefficient")).replaceAll("\"", "");

                    result.add(Stock.daily("", symbol, open, high, low, close, volume, adjustedClose, dividendAmount, splitCoefficient, localDate));
                }

            }
        }
        return result;
    }



    @Override
    public List<Stock> weekly(String symbol, HashMap<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        String function = "TIME_SERIES_WEEKLY";
        StringBuilder sb = new StringBuilder();
        sb.append(Utils.BASE_URI)
                .append("function=")
                .append(function)
                .append("&symbol=")
                .append(symbol)
                .append("&apikey=")
                .append(apiKey)
                .append("&");


        String encodedUrl = options.keySet().stream().map(key -> {
            try {
                return Utils.contentKeyVal(key, options.get(key));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(joining("&", sb.toString(), ""));

        List<Stock> result = new ArrayList<>();
        JsonNode jsonNode = restTemplate.getForObject(encodedUrl, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);
            if (mapEntry.getKey().equals("Weekly Time Series")) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();
                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    Stock stock = dailyStock(symbol, timeSeriesMap, localDate);
                    result.add(stock);
                }

            }
        }
        return result;
    }



    public List<Stock> weeklyAdjusted(String symbol, HashMap<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        String function = "TIME_SERIES_WEEKLY_ADJUSTED";
        StringBuilder sb = new StringBuilder();
        sb.append(Utils.BASE_URI)
                .append("function=")
                .append(function)
                .append("&symbol=")
                .append(symbol)
                .append("&apikey=")
                .append(apiKey)
                .append("&");


        String encodedUrl = options.keySet().stream().map(key -> {
            try {
                return Utils.contentKeyVal(key, options.get(key));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(joining("&", sb.toString(), ""));

        List<Stock> result = new ArrayList<>();
        JsonNode jsonNode = restTemplate.getForObject(encodedUrl, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);
            if (mapEntry.getKey().equals("Weekly Adjusted Time Series")) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();
                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    Stock stock = dailyStock(symbol, timeSeriesMap, localDate);
                    result.add(stock);
                }

            }
        }
        return result;
    }



    @Override
    public List<Stock> monthly(String symbol, HashMap<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        String function = "TIME_SERIES_MONTHLY";
        StringBuilder sb = new StringBuilder();
        sb.append(Utils.BASE_URI)
                .append("function=")
                .append(function)
                .append("&symbol=")
                .append(symbol)
                .append("&apikey=")
                .append(apiKey)
                .append("&");

        String encodedUrl = options.keySet().stream().map(key -> {
            try {
                return Utils.contentKeyVal(key, options.get(key));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(joining("&", sb.toString(), ""));

        List<Stock> result = new ArrayList<>();;
        JsonNode jsonNode = restTemplate.getForObject(encodedUrl, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);
            if (mapEntry.getKey().equals("Monthly Time Series")) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();
                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    Stock stock = dailyStock(symbol, timeSeriesMap, localDate);
                    result.add(stock);
                }

            }
        }
        return result;
    }



    public List<Stock> monthlyAdjusted(String symbol, HashMap<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        String function = "TIME_SERIES_MONTHLY_ADJUSTED";
        StringBuilder sb = new StringBuilder();
        sb.append(Utils.BASE_URI)
                .append("function=")
                .append(function)
                .append("&symbol=")
                .append(symbol)
                .append("&apikey=")
                .append(apiKey)
                .append("&");

        String encodedUrl = options.keySet().stream().map(key -> {
            try {
                return Utils.contentKeyVal(key, options.get(key));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(joining("&", sb.toString(), ""));

        List<Stock> result = new ArrayList<>();
        JsonNode jsonNode = restTemplate.getForObject(encodedUrl, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);
            if (mapEntry.getKey().equals("Monthly Adjusted Time Series")) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();
                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    Stock stock = dailyStock(symbol, timeSeriesMap, localDate);
                    result.add(stock);
                }

            }
        }
        return result;
    }

    Stock intraStock(String symbol, Map.Entry<String, JsonNode> seriesMap, LocalDateTime date){
        String open = String.valueOf(seriesMap.getValue().get("1. open")).replaceAll("\"", "");
        String high = String.valueOf(seriesMap.getValue().get("2. high")).replaceAll("\"", "");
        String low = String.valueOf(seriesMap.getValue().get("3. low")).replaceAll("\"", "");
        String close = String.valueOf(seriesMap.getValue().get("4. close")).replaceAll("\"", "");
        String volume = String.valueOf(seriesMap.getValue().get("5. volume")).replaceAll("\"", "");
        return Stock.intraDay(symbol, open, high, low, close, volume, date);
    }


    Stock dailyStock(String symbol, Map.Entry<String, JsonNode> seriesMap, LocalDate date){
        String open = String.valueOf(seriesMap.getValue().get("1. open")).replaceAll("\"", "");
        String high = String.valueOf(seriesMap.getValue().get("2. high")).replaceAll("\"", "");
        String low = String.valueOf(seriesMap.getValue().get("3. low")).replaceAll("\"", "");
        String close = String.valueOf(seriesMap.getValue().get("4. close")).replaceAll("\"", "");
        String volume = String.valueOf(seriesMap.getValue().get("5. volume")).replaceAll("\"", "");
        return Stock.daily(symbol, open, high, low, close, volume, date);
    }


}
