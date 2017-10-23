package com.jalpha_vantage.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.jalpha_vantage.domain.*;
import com.jalpha_vantage.enums.IndicatorType;
import com.jalpha_vantage.enums.TimeInterval;
import com.jalpha_vantage.exception.*;
import com.jalpha_vantage.domain.*;
import com.jalpha_vantage.enums.SeriesType;
import com.jalpha_vantage.exception.*;
import com.jalpha_vantage.service.ITechnicalIndicatorService;
import com.jalpha_vantage.util.ExceptionUtil;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriUtils;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.joining;

public class TechnicalIndicatorTemplate implements ITechnicalIndicatorService {

    private static final String ALPHA_VANTAGE_API_URL = "http://www.alphavantage.co/query?";
    private static String apiKey;
    private final RestTemplate restTemplate;


    public TechnicalIndicatorTemplate(RestTemplate restTemplate, String apiKey) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
    }


    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getSMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        String function = "SMA";
        String queryString = ALPHA_VANTAGE_API_URL + "function=" + function + "&symbol=" + symbol + "&interval=" + interval.getName() + "&time_period=" + timePeriod + "&series_type=" + seriesType + "&apikey=" + apiKey + "&";
        LinkedHashMap<LocalDate, AbstractIndicator> result = new LinkedHashMap<>();
        JsonNode jsonNode = restTemplate.getForObject(queryString, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            if (mapEntry.getKey().equals("Error Message")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, function);
            }

            if (mapEntry.getKey().equals("Information")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, function);
            }

            if (mapEntry.getKey().equals("Technical Analysis: " + function)) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();

                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String value = String.valueOf(timeSeriesMap.getValue().get("SMA"));
                    result.put(localDate, AbstractIndicator.newInstance(symbol, IndicatorType.SMA, value));
                }

            }
        }

        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getEMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.SMA, interval, timePeriod, seriesType);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getWMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.EMA, interval, timePeriod, seriesType);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getDEMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.DEMA, interval, timePeriod, seriesType);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getTEMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.TEMA, interval, timePeriod, seriesType);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getTRIMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.TRIMA, interval, timePeriod, seriesType);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getKAMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.KAMA, interval, timePeriod, seriesType);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, MamaIndicator> getMAMA(String symbol, TimeInterval interval, SeriesType seriesType, HashMap<String, String> options) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        String function = "MAMA";
        String queryString = ALPHA_VANTAGE_API_URL + "function=" + function + "&symbol=" + symbol + "&interval=" + interval.getName() + "&series_type=" + seriesType + "&apikey=" + apiKey + "&";
        String encodedUrl = options.keySet().stream().map(key -> {
            try {
                return key + "=" + UriUtils.encode(options.get(key), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(joining("&", queryString, ""));


        LinkedHashMap<LocalDate, MamaIndicator> result = new LinkedHashMap<>();
        JsonNode jsonNode = restTemplate.getForObject(encodedUrl, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            if (mapEntry.getKey().equals("Error Message")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, function);
            }

            if (mapEntry.getKey().equals("Information")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, function);
            }
            if (mapEntry.getKey().equals("Technical Analysis: " + function)) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();

                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String mama = String.valueOf(timeSeriesMap.getValue().get("MAMA"));
                    String fama = String.valueOf(timeSeriesMap.getValue().get("FAMA"));
                    result.put(localDate, MamaIndicator.newInstance(symbol, mama, fama));
                }

            }
        }

        return result;
    }


    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getT3(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.T3, interval, timePeriod, seriesType);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, MacdIndicator> getMACD(String symbol, TimeInterval interval, SeriesType seriesType, HashMap<String, String> options) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        String function = "MACD";
        String queryString = ALPHA_VANTAGE_API_URL + "function=" + function + "&symbol=" + symbol + "&interval=" + interval.getName() + "&series_type=" + seriesType + "&apikey=" + apiKey + "&";
        String encodedUrl = options.keySet().stream().map(key -> {
            try {
                return key + "=" + UriUtils.encode(options.get(key), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(joining("&", queryString, ""));


        LinkedHashMap<LocalDate, MacdIndicator> result = new LinkedHashMap<>();
        JsonNode jsonNode = restTemplate.getForObject(encodedUrl, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            if (mapEntry.getKey().equals("Error Message")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, function);
            }

            if (mapEntry.getKey().equals("Information")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, function);
            }
            if (mapEntry.getKey().equals("Technical Analysis: " + function)) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();

                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String macd = String.valueOf(timeSeriesMap.getValue().get("MACD"));
                    String signal = String.valueOf(timeSeriesMap.getValue().get("MACD_Signal"));
                    String hist = String.valueOf(timeSeriesMap.getValue().get("MACD_Hist"));
                    result.put(localDate, MacdIndicator.newInstance(symbol, macd, signal, hist));
                }

            }
        }

        return result;
    }


    @Override
    public LinkedHashMap<LocalDate, MacdIndicator> getMACDEXT(String symbol, TimeInterval interval, SeriesType seriesType, HashMap<String, String> options) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        String function = "MACDEXT";
        String queryString = ALPHA_VANTAGE_API_URL + "function=" + function + "&symbol=" + symbol + "&interval=" + interval.getName() + "&series_type=" + seriesType + "&apikey=" + apiKey + "&";
        String encodedUrl = options.keySet().stream().map(key -> {
            try {
                return key + "=" + UriUtils.encode(options.get(key), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(joining("&", queryString, ""));


        LinkedHashMap<LocalDate, MacdIndicator> result = new LinkedHashMap<>();
        JsonNode jsonNode = restTemplate.getForObject(encodedUrl, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            if (mapEntry.getKey().equals("Error Message")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, function);
            }

            if (mapEntry.getKey().equals("Information")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, function);
            }
            if (mapEntry.getKey().equals("Technical Analysis: " + function)) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();
                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String macd = String.valueOf(timeSeriesMap.getValue().get("MACDEXT"));
                    String signal = String.valueOf(timeSeriesMap.getValue().get("MACD_Signal"));
                    String hist = String.valueOf(timeSeriesMap.getValue().get("MACD_Hist"));
                    result.put(localDate, MacdIndicator.newInstance(symbol, macd, signal, hist));
                }

            }
        }

        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, StochIndicator> getSTOCH(String symbol, TimeInterval interval, HashMap<String, String> options) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        String function = "STOCH";
        String queryString = ALPHA_VANTAGE_API_URL + "function=" + function + "&symbol=" + symbol + "&interval=" + interval.getName() + "&apikey=" + apiKey + "&";
        String encodedUrl = options.keySet().stream().map(key -> {
            try {
                return key + "=" + UriUtils.encode(options.get(key), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(joining("&", queryString, ""));


        LinkedHashMap<LocalDate, StochIndicator> result = new LinkedHashMap<>();
        JsonNode jsonNode = restTemplate.getForObject(encodedUrl, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            if (mapEntry.getKey().equals("Error Message")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, function);
            }

            if (mapEntry.getKey().equals("Information")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, function);
            }
            if (mapEntry.getKey().equals("Technical Analysis: " + function)) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();
                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String slowK = String.valueOf(timeSeriesMap.getValue().get("SlowK"));
                    String slowD = String.valueOf(timeSeriesMap.getValue().get("SlowD"));
                    result.put(localDate, StochIndicator.newInstance(symbol, slowK, slowD));
                }

            }
        }

        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, StochfIndicator> getSTOCHF(String symbol, TimeInterval interval, HashMap<String, String> options) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        String function = "STOCHF";
        String queryString = ALPHA_VANTAGE_API_URL + "function=" + function + "&symbol=" + symbol + "&interval=" + interval.getName() + "&apikey=" + apiKey + "&";
        String encodedUrl = options.keySet().stream().map(key -> {
            try {
                return key + "=" + UriUtils.encode(options.get(key), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(joining("&", queryString, ""));


        LinkedHashMap<LocalDate, StochfIndicator> result = new LinkedHashMap<>();
        JsonNode jsonNode = restTemplate.getForObject(encodedUrl, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            if (mapEntry.getKey().equals("Error Message")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, function);
            }

            if (mapEntry.getKey().equals("Information")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, function);
            }
            if (mapEntry.getKey().equals("Technical Analysis: " + function)) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();
                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String fastK = String.valueOf(timeSeriesMap.getValue().get("FastK"));
                    String fastD = String.valueOf(timeSeriesMap.getValue().get("FastD"));
                    result.put(localDate, StochfIndicator.newInstance(symbol, fastK, fastD));
                }

            }
        }

        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getRSI(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.RSI, interval, timePeriod, seriesType);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, StochfIndicator> getSTOCHRSI(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType, HashMap<String, String> options) {
        String queryString = ALPHA_VANTAGE_API_URL + "function=STOCHRSI&symbol=" + symbol + "&time_period=" + timePeriod + "&series_type=" + seriesType + "&interval=" + interval.getName() + "&apikey=" + apiKey + "&";
        String encodedUrl = options.keySet().stream().map(key -> {
            try {
                return key + "=" + UriUtils.encode(options.get(key), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(joining("&", queryString, ""));


        LinkedHashMap<LocalDate, StochfIndicator> result = new LinkedHashMap<>();
        JsonNode jsonNode = restTemplate.getForObject(encodedUrl, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            if (mapEntry.getKey().equals("Technical Analysis: STOCHRSI")) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();
                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String fastK = String.valueOf(timeSeriesMap.getValue().get("FastK"));
                    String fastD = String.valueOf(timeSeriesMap.getValue().get("FastD"));
                    result.put(localDate, StochfIndicator.newInstance(symbol, fastK, fastD));
                }

            }
        }

        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getWILLR(String symbol, TimeInterval interval, String timePeriod) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.WILLR, interval, timePeriod);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getADX(String symbol, TimeInterval interval, String timePeriod) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.ADX, interval, timePeriod);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getADXR(String symbol, TimeInterval interval, String timePeriod) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.ADXR, interval, timePeriod);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getAPO(String symbol, TimeInterval interval, SeriesType seriesType, HashMap<String, String> options) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.APO, interval, seriesType, options);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getPPO(String symbol, TimeInterval interval, SeriesType seriesType, HashMap<String, String> options) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.PPO, interval, seriesType, options);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getMOM(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.MOM, interval, timePeriod, seriesType);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getBOP(String symbol, TimeInterval interval) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.BOP, interval);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getCCI(String symbol, TimeInterval interval, String timePeriod) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.CCI, interval, timePeriod);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getCMO(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.CMO, interval, timePeriod, seriesType);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getROC(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.ROC, interval, timePeriod, seriesType);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getROCR(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.ROCR, interval, timePeriod, seriesType);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AroonIndicator> getAROON(String symbol, TimeInterval interval, String timePeriod) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        String function = "AROON";
        String queryString = ALPHA_VANTAGE_API_URL + "function=" + function + "&symbol=" + symbol + "&interval=" + interval.getName() + "&time_period=" + timePeriod + "&apikey=" + apiKey + "&";
        LinkedHashMap<LocalDate, AroonIndicator> result = new LinkedHashMap<>();
        JsonNode jsonNode = restTemplate.getForObject(queryString, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            if (mapEntry.getKey().equals("Error Message")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, function);
            }

            if (mapEntry.getKey().equals("Information")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, function);
            }
            if (mapEntry.getKey().equals("Technical Analysis: " + function)) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();
                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String aroonUp = String.valueOf(timeSeriesMap.getValue().get("Aroon Up"));
                    String aroonDown = String.valueOf(timeSeriesMap.getValue().get("Aroon Up"));
                    result.put(localDate, AroonIndicator.newInstance(symbol, aroonUp, aroonDown));
                }

            }
        }

        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getAROONOSC(String symbol, TimeInterval interval, String timePeriod) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.AROONOSC, interval, timePeriod);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getMFI(String symbol, TimeInterval interval, String timePeriod) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.MFI, interval, timePeriod);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getTRIX(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.TRIX, interval, timePeriod, seriesType);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getULTOSC(String symbol, TimeInterval interval, String timePeriod, HashMap<String, String> options) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.ULTOSC, interval, timePeriod, options);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getDX(String symbol, TimeInterval interval, String timePeriod) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.ULTOSC, interval, timePeriod);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getMINUS_DI(String symbol, TimeInterval interval, String timePeriod) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.MINUS_DI, interval, timePeriod);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getPLUS_DI(String symbol, TimeInterval interval, String timePeriod) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.PLUS_DI, interval, timePeriod);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getMINUS_DM(String symbol, TimeInterval interval, String timePeriod) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.MINUS_DM, interval, timePeriod);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getPLUS_DM(String symbol, TimeInterval interval, String timePeriod) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.PLUS_DM, interval, timePeriod);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, BbandsIndicator> getBBANDS(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType, HashMap<String, String> options) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        String function = "BBANDS";

        String queryString = ALPHA_VANTAGE_API_URL + "function=" + function + "symbol=" + symbol + "&interval=" + interval.getName() + "&time_period=" + timePeriod + "&series_type=" + seriesType + "&apikey=" + apiKey + "&";
        String encodedUrl = options.keySet().stream().map(key -> {
            try {
                return key + "=" + UriUtils.encode(options.get(key), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(joining("&", queryString, ""));

        LinkedHashMap<LocalDate, BbandsIndicator> result = new LinkedHashMap<>();
        JsonNode jsonNode = restTemplate.getForObject(encodedUrl, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            if (mapEntry.getKey().equals("Error Message")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, function);
            }

            if (mapEntry.getKey().equals("Information")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, function);
            }
            if (mapEntry.getKey().equals("Technical Analysis: " + function)) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();
                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String realLowerBand = String.valueOf(timeSeriesMap.getValue().get("Real Lower Band"));
                    String realUpperBand = String.valueOf(timeSeriesMap.getValue().get("Real Upper Band"));
                    String realMiddleBand = String.valueOf(timeSeriesMap.getValue().get("Real Middle Band"));

                    result.put(localDate, BbandsIndicator.newInstance(symbol, realLowerBand, realMiddleBand, realUpperBand));
                }

            }
        }

        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getMIDPOINT(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.MIDPOINT, interval, timePeriod, seriesType);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getMIDPRICE(String symbol, TimeInterval interval, String timePeriod) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.MIDPRICE, interval, timePeriod);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getSAR(String symbol, TimeInterval interval, HashMap<String, String> options) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.SAR, interval, options);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getTRANGE(String symbol, TimeInterval interval) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.TRANGE, interval);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getATR(String symbol, TimeInterval interval, String timePeriod) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.ATR, interval, timePeriod);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getNATR(String symbol, TimeInterval interval, String timePeriod) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.NATR, interval, timePeriod);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getAD(String symbol, TimeInterval interval) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        String function = "AD";
        String queryString = ALPHA_VANTAGE_API_URL + "function=" + function + "&symbol=" + symbol + "&interval=" + interval.getName() + "&apikey=" + apiKey + "&";
        LinkedHashMap<LocalDate, AbstractIndicator> result = new LinkedHashMap<>();
        JsonNode jsonNode = restTemplate.getForObject(queryString, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            if (mapEntry.getKey().equals("Error Message")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, function);
            }

            if (mapEntry.getKey().equals("Information")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, function);
            }

            if (mapEntry.getKey().equals("Technical Analysis: Chaikin A/D")) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();

                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String value = String.valueOf(timeSeriesMap.getValue().get("Chaikin A/D"));
                    result.put(localDate, AbstractIndicator.newInstance(symbol, IndicatorType.AD, value));
                }

            }
        }

        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getADOSC(String symbol, TimeInterval interval, HashMap<String, String> options) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.ADOSC, interval, options);
        return result;
    }

    //==
    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getOBV(String symbol, TimeInterval interval) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.OBV, interval);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getHT_TRENDLINE(String symbol, TimeInterval interval, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.HT_TRENDLINE, interval, seriesType);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, HtSineIndicator> getHT_SINE(String symbol, TimeInterval interval, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        String function = "HT_SINE";
        String queryString = ALPHA_VANTAGE_API_URL + "function=" + function + "&symbol=" + symbol + "&interval=" + interval.getName() + "&series_type=" + seriesType + "&apikey=" + apiKey + "&";
        LinkedHashMap<LocalDate, HtSineIndicator> result = new LinkedHashMap<>();
        JsonNode jsonNode = restTemplate.getForObject(queryString, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            if (mapEntry.getKey().equals("Error Message")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, function);
            }

            if (mapEntry.getKey().equals("Information")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, function);
            }
            if (mapEntry.getKey().equals("Technical Analysis: " + function)) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();

                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String sine = String.valueOf(timeSeriesMap.getValue().get("SINE"));
                    String leadSine = String.valueOf(timeSeriesMap.getValue().get("LEAD SINE"));
                    result.put(localDate, HtSineIndicator.newInstance(symbol, sine, leadSine));
                }

            }
        }

        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getHT_TRENDMODE(String symbol, TimeInterval interval, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.HT_TRENDMODE, interval, seriesType);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getHT_DCPERIOD(String symbol, TimeInterval interval, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.HT_DCPERIOD, interval, seriesType);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, AbstractIndicator> getHT_DCPHASE(String symbol, TimeInterval interval, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        LinkedHashMap<LocalDate, AbstractIndicator> result = requestApiData(symbol, IndicatorType.HT_DCPHASE, interval, seriesType);
        return result;
    }

    @Override
    public LinkedHashMap<LocalDate, HtPhasorIndicator> getHT_PHASOR(String symbol, TimeInterval interval, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        String function = "HT_PHASOR";
        String queryString = ALPHA_VANTAGE_API_URL + "function=" + function + "&symbol=" + symbol + "&interval=" + interval.getName() + "&series_type=" + seriesType + "&apikey=" + apiKey + "&";
        LinkedHashMap<LocalDate, HtPhasorIndicator> result = new LinkedHashMap<>();
        JsonNode jsonNode = restTemplate.getForObject(queryString, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            if (mapEntry.getKey().equals("Error Message")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, function);
            }

            if (mapEntry.getKey().equals("Information")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, function);
            }
            if (mapEntry.getKey().equals("Technical Analysis: " + function)) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();

                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String quadrature = String.valueOf(timeSeriesMap.getValue().get("QUADRATURE"));
                    String phase = String.valueOf(timeSeriesMap.getValue().get("PHASE"));
                    result.put(localDate, HtPhasorIndicator.newInstance(symbol, quadrature, phase));
                }

            }
        }

        return result;
    }


    private LinkedHashMap<LocalDate, AbstractIndicator> requestApiData(String symbol, IndicatorType indicatorType, TimeInterval interval, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        String queryString = ALPHA_VANTAGE_API_URL + "function=" + indicatorType.name() + "&symbol=" + symbol + "&interval=" + interval.getName() + "&series_type=" + seriesType + "&apikey=" + apiKey + "&";
        LinkedHashMap<LocalDate, AbstractIndicator> result = new LinkedHashMap<>();
        JsonNode jsonNode = restTemplate.getForObject(queryString, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            if (mapEntry.getKey().equals("Error Message")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, indicatorType.name());
            }

            if (mapEntry.getKey().equals("Information")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, indicatorType.name());
            }

            if (mapEntry.getKey().equals("Technical Analysis: " + indicatorType.name())) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();

                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String value = String.valueOf(timeSeriesMap.getValue().get(indicatorType.name()));
                    result.put(localDate, AbstractIndicator.newInstance(symbol, indicatorType, value));
                }

            }
        }

        return result;
    }


    private LinkedHashMap<LocalDate, AbstractIndicator> requestApiData(String symbol, IndicatorType indicatorType, TimeInterval interval, String timePeriod) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        String queryString = ALPHA_VANTAGE_API_URL + "function=" + indicatorType.name() + "&symbol=" + symbol + "&interval=" + interval.getName() + "&time_period=" + timePeriod + "&apikey=" + apiKey + "&";
        LinkedHashMap<LocalDate, AbstractIndicator> result = new LinkedHashMap<>();
        JsonNode jsonNode = restTemplate.getForObject(queryString, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            if (mapEntry.getKey().equals("Error Message")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, indicatorType.name());
            }

            if (mapEntry.getKey().equals("Information")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, indicatorType.name());
            }
            if (mapEntry.getKey().equals("Technical Analysis: " + indicatorType.name())) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();

                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String value = String.valueOf(timeSeriesMap.getValue().get(indicatorType.name()));
                    result.put(localDate, AbstractIndicator.newInstance(symbol, indicatorType, value));
                }

            }
        }

        return result;
    }


    private LinkedHashMap<LocalDate, AbstractIndicator> requestApiData(String symbol, IndicatorType indicatorType, TimeInterval interval, String timePeriod, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        String queryString = ALPHA_VANTAGE_API_URL + "function=" + indicatorType.name() + "&symbol=" + symbol + "&interval=" + interval.getName() + "&time_period=" + timePeriod + "&series_type=" + seriesType + "&apikey=" + apiKey + "&";
        LinkedHashMap<LocalDate, AbstractIndicator> result = new LinkedHashMap<>();
        JsonNode jsonNode = restTemplate.getForObject(queryString, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            if (mapEntry.getKey().equals("Error Message")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, indicatorType.name());
            }

            if (mapEntry.getKey().equals("Information")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, indicatorType.name());
            }

            if (mapEntry.getKey().equals("Technical Analysis: " + indicatorType.name())) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();

                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String value = String.valueOf(timeSeriesMap.getValue().get(indicatorType.name()));
                    result.put(localDate, AbstractIndicator.newInstance(symbol, indicatorType, value));
                }

            }
        }

        return result;
    }


    private LinkedHashMap<LocalDate, AbstractIndicator> requestApiData(String symbol, IndicatorType indicatorType, TimeInterval interval, SeriesType seriesType, HashMap<String, String> options) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        String queryString = ALPHA_VANTAGE_API_URL + "function=" + indicatorType.name() + "&symbol=" + symbol + "&interval=" + interval.getName() + "&series_type=" + seriesType + "&apikey=" + apiKey + "&";
        String encodedUrl = options.keySet().stream().map(key -> {
            try {
                return key + "=" + UriUtils.encode(options.get(key), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(joining("&", queryString, ""));


        LinkedHashMap<LocalDate, AbstractIndicator> result = new LinkedHashMap<>();
        JsonNode jsonNode = restTemplate.getForObject(encodedUrl, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            if (mapEntry.getKey().equals("Error Message")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, indicatorType.name());
            }

            if (mapEntry.getKey().equals("Information")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, indicatorType.name());
            }
            if (mapEntry.getKey().equals("Technical Analysis: " + indicatorType.name())) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();

                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String value = String.valueOf(timeSeriesMap.getValue().get(indicatorType.name()));
                    result.put(localDate, AbstractIndicator.newInstance(symbol, indicatorType, value));
                }

            }
        }

        return result;
    }


    private LinkedHashMap<LocalDate, AbstractIndicator> requestApiData(String symbol, IndicatorType indicatorType, TimeInterval interval) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        String queryString = ALPHA_VANTAGE_API_URL + "function=" + indicatorType.name() + "&symbol=" + symbol + "&interval=" + interval.getName() + "&apikey=" + apiKey + "&";
        LinkedHashMap<LocalDate, AbstractIndicator> result = new LinkedHashMap<>();
        JsonNode jsonNode = restTemplate.getForObject(queryString, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            if (mapEntry.getKey().equals("Error Message")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, indicatorType.name());
            }

            if (mapEntry.getKey().equals("Information")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, indicatorType.name());
            }
            if (mapEntry.getKey().equals("Technical Analysis: " + indicatorType.name())) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();

                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String value = String.valueOf(timeSeriesMap.getValue().get(indicatorType.name()));
                    result.put(localDate, AbstractIndicator.newInstance(symbol, indicatorType, value));
                }

            }
        }

        return result;
    }


    private LinkedHashMap<LocalDate, AbstractIndicator> requestApiData(String symbol, IndicatorType indicatorType, TimeInterval interval, String timePeriod, HashMap<String, String> options) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        String queryString = ALPHA_VANTAGE_API_URL + "function=" + indicatorType.name() + "&symbol=" + symbol + "&interval=" + interval.getName() + "&time_period=" + timePeriod + "&apikey=" + apiKey + "&";
        String encodedUrl = options.keySet().stream().map(key -> {
            try {
                return key + "=" + UriUtils.encode(options.get(key), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(joining("&", queryString, ""));


        LinkedHashMap<LocalDate, AbstractIndicator> result = new LinkedHashMap<>();
        JsonNode jsonNode = restTemplate.getForObject(encodedUrl, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            if (mapEntry.getKey().equals("Error Message")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, indicatorType.name());
            }

            if (mapEntry.getKey().equals("Information")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, indicatorType.name());
            }
            if (mapEntry.getKey().equals("Technical Analysis: " + indicatorType.name())) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();

                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String value = String.valueOf(timeSeriesMap.getValue().get(indicatorType.name()));
                    result.put(localDate, AbstractIndicator.newInstance(symbol, indicatorType, value));
                }

            }
        }

        return result;
    }


    private LinkedHashMap<LocalDate, AbstractIndicator> requestApiData(String symbol, IndicatorType indicatorType, TimeInterval interval, HashMap<String, String> options) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException {
        String queryString = ALPHA_VANTAGE_API_URL + "function=" + indicatorType.name() + "&symbol=" + symbol + "&interval=" + interval.getName() + "&apikey=" + apiKey + "&";

        String encodedUrl = options.keySet().stream().map(key -> {
            try {
                return key + "=" + UriUtils.encode(options.get(key), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(joining("&", queryString, ""));

        LinkedHashMap<LocalDate, AbstractIndicator> result = new LinkedHashMap<>();
        JsonNode jsonNode = restTemplate.getForObject(encodedUrl, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            if (mapEntry.getKey().equals("Error Message")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, indicatorType.name());
            }

            if (mapEntry.getKey().equals("Information")) {
                String value = mapEntry.getValue().toString();
                ExceptionUtil.handleExceptions(value, indicatorType.name());
            }
            if (mapEntry.getKey().equals("Technical Analysis: " + indicatorType.name())) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();

                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String value = String.valueOf(timeSeriesMap.getValue().get(indicatorType.name()));
                    result.put(localDate, AbstractIndicator.newInstance(symbol, indicatorType, value));
                }

            }
        }

        return result;
    }
}
