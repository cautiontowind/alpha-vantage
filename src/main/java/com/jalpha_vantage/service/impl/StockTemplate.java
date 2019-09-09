package com.jalpha_vantage.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.jalpha_vantage.domain.DailyStock;
import com.jalpha_vantage.domain.IntraStock;
import com.jalpha_vantage.domain.Stock;
import com.jalpha_vantage.exception.*;
import com.jalpha_vantage.service.IStockService;
import com.jalpha_vantage.util.ExceptionUtil;
import com.jalpha_vantage.util.Utils;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.util.stream.Collectors.joining;

public class StockTemplate implements IStockService {


    private final RestTemplate restTemplate;

    private final String apiKey;

    //@Autowired
    public StockTemplate(RestTemplate restTemplate, String apiKey) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
    }

    @Override
    public List<IntraStock> intraDay(String symbol, Map<String, String> options)
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


        List<IntraStock> result = new ArrayList<>();

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
                    ZonedDateTime dateTime = LocalDateTime.parse(timeSeriesMap.getKey(), formatter).atZone(ZoneId.of("US/Eastern"));
                    IntraStock stock = intraStock(symbol, timeSeriesMap, dateTime);
                    result.add(stock);
                }

            }
        }

        return result;
    }



    @Override
    public List<DailyStock> daily(String symbol, Map<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded {
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
        List<DailyStock> result = new ArrayList<>();
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
                    DailyStock stock = dailyStock(symbol, timeSeriesMap,localDate);
                    result.add(stock);
                }

            }
        }
        return result;
    }




    @Override
    public List<DailyStock> dailyAdjustedClose(String symbol, Map<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded {
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


        List<DailyStock> result = new ArrayList<>();
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
                    double open = Double.valueOf(timeSeriesMap.getValue().get("1. open").toString().replaceAll("\"", "").trim());
                    double high = Double.valueOf(timeSeriesMap.getValue().get("2. high").toString().replaceAll("\"", "").trim());
                    double low = Double.valueOf(timeSeriesMap.getValue().get("3. low").toString().replaceAll("\"", "").trim());
                    double close = Double.valueOf(timeSeriesMap.getValue().get("4. close").toString().replaceAll("\"", "").trim());
                    double adjustedClose = Double.valueOf(timeSeriesMap.getValue().get("5. adjusted close").toString().replaceAll("\"", "").trim());
                    BigDecimal volume = new BigDecimal(timeSeriesMap.getValue().get("6. volume").toString().replaceAll("\"", "").trim());
                    double dividendAmount = Double.valueOf(timeSeriesMap.getValue().get("7. dividend amount").toString().replaceAll("\"", ""));
                    double splitCoefficient = Double.valueOf(timeSeriesMap.getValue().get("8. split coefficient").toString().replaceAll("\"", ""));

                    result.add(Stock.daily("", symbol, open, high, low, close, volume, adjustedClose, dividendAmount, splitCoefficient, localDate));
                }

            }
        }
        return result;
    }



    @Override
    public List<DailyStock> weekly(String symbol, Map<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded {
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

        List<DailyStock> result = new ArrayList<>();
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
                    DailyStock stock = dailyStock(symbol, timeSeriesMap, localDate);
                    result.add(stock);
                }

            }
        }
        return result;
    }



    public List<DailyStock> weeklyAdjusted(String symbol, Map<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded {
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

        List<DailyStock> result = new ArrayList<>();
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
                    DailyStock stock = dailyStock(symbol, timeSeriesMap, localDate);
                    result.add(stock);
                }

            }
        }
        return result;
    }



    @Override
    public List<DailyStock> monthly(String symbol, Map<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded {
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

        List<DailyStock> result = new ArrayList<>();;
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
                    DailyStock stock = dailyStock(symbol, timeSeriesMap, localDate);
                    result.add(stock);
                }

            }
        }
        return result;
    }



    public List<DailyStock> monthlyAdjusted(String symbol, Map<String, String> options) throws UnsupportedEncodingException, InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded {
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

        List<DailyStock> result = new ArrayList<>();
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
                    DailyStock stock = dailyStock(symbol, timeSeriesMap, localDate);
                    result.add(stock);
                }

            }
        }
        return result;
    }

    IntraStock intraStock(String symbol, Map.Entry<String, JsonNode> seriesMap, ZonedDateTime date){
        double open = Double.valueOf(seriesMap.getValue().get("1. open").toString().replaceAll("\"", "").trim());
        double high = Double.valueOf(seriesMap.getValue().get("2. high").toString().replaceAll("\"", "").trim());
        double low = Double.valueOf(seriesMap.getValue().get("3. low").toString().replaceAll("\"", "").trim());
        double close = Double.valueOf(seriesMap.getValue().get("4. close").toString().replaceAll("\"", "").trim());
        BigDecimal volume = new BigDecimal(seriesMap.getValue().get("5. volume").toString().replaceAll("\"", "").trim());
        return Stock.intraDay(symbol, open, high, low, close, volume, date);
    }


    DailyStock dailyStock(String symbol, Map.Entry<String, JsonNode> seriesMap, LocalDate date){
        double open = Double.valueOf(seriesMap.getValue().get("1. open").toString().replaceAll("\"", "").trim());
        double high = Double.valueOf(seriesMap.getValue().get("2. high").toString().replaceAll("\"", "").trim());
        double low = Double.valueOf(seriesMap.getValue().get("3. low").toString().replaceAll("\"", "").trim());
        double close = Double.valueOf(seriesMap.getValue().get("4. close").toString().replaceAll("\"", "").trim());
        BigDecimal volume = new BigDecimal(seriesMap.getValue().get("5. volume").toString().replaceAll("\"", "").trim());
        return Stock.daily(symbol, open, high, low, close, volume, date);
    }


}
