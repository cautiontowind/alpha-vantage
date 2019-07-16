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
import com.jalpha_vantage.util.Utils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriUtils;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.util.stream.Collectors.joining;

public class TechnicalIndicatorTemplate implements ITechnicalIndicatorService {

    private final String apiKey;
    private final RestTemplate restTemplate;


    public TechnicalIndicatorTemplate(RestTemplate restTemplate, String apiKey) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
    }


    @Override
    public List<AbstractIndicator> getSMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        String function = "SMA";

        StringBuilder sb = new StringBuilder();
        sb.append(Utils.BASE_URI)
                .append("function=")
                .append(function)
                .append("&symbol=" )
                .append(symbol)
                .append("&interval=")
                .append(interval.getName())
                .append("&time_period=")
                .append(timePeriod)
                .append("&series_type=" )
                .append(seriesType)
                .append("&apikey=")
                .append(apiKey)
                .append("&");

        List<AbstractIndicator> result = new ArrayList<>();
        JsonNode jsonNode = restTemplate.getForObject(sb.toString(), JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);
            String keyVal = new StringBuilder().append("Technical Analysis: ").append(function).toString();
            if (mapEntry.getKey().equals(keyVal)) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();

                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String value = String.valueOf(timeSeriesMap.getValue().get("SMA"));
                    result.add(AbstractIndicator.newInstance(symbol, IndicatorType.SMA, value, localDate));
                }

            }
        }

        return result;
    }

    @Override
    public List<AbstractIndicator> getEMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.SMA, interval, timePeriod, seriesType);
    }

    @Override
    public List<AbstractIndicator> getWMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.EMA, interval, timePeriod, seriesType);
        
    }

    @Override
    public List<AbstractIndicator> getDEMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.DEMA, interval, timePeriod, seriesType);
    }

    @Override
    public List<AbstractIndicator> getTEMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.TEMA, interval, timePeriod, seriesType);
        
    }

    @Override
    public List<AbstractIndicator> getTRIMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.TRIMA, interval, timePeriod, seriesType);
    }

    @Override
    public List<AbstractIndicator> getKAMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.KAMA, interval, timePeriod, seriesType);
    }

    @Override
    public List< MamaIndicator> getMAMA(String symbol, TimeInterval interval, SeriesType seriesType, HashMap<String, String> options) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        String function = "MAMA";
        StringBuilder sb = new StringBuilder();
        sb.append(Utils.BASE_URI)
                .append("function=")
                .append(function)
                .append("&symbol=")
                .append(symbol)
                .append("&interval=")
                .append(interval.getName())
                .append("&series_type=")
                .append(seriesType)
                .append("&apikey=")
                .append(apiKey)
                .append("&");

        String encodedUrl = options.keySet().stream().map(key -> {
            try {
                return Utils.contentKeyVal(key, options.get(key));
//                return key + "=" + UriUtils.encode(options.get(key), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(joining("&", sb.toString(), ""));


        List<MamaIndicator> result = new ArrayList<>();
        JsonNode jsonNode = restTemplate.getForObject(encodedUrl, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);
            if (mapEntry.getKey().equals("Technical Analysis: " + function)) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();

                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String mama = String.valueOf(timeSeriesMap.getValue().get("MAMA"));
                    String fama = String.valueOf(timeSeriesMap.getValue().get("FAMA"));
                    result.add(MamaIndicator.newInstance(symbol, mama, fama, localDate));
                }

            }
        }

        return result;
    }


    @Override
    public List<AbstractIndicator> getT3(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.T3, interval, timePeriod, seriesType);

    }

    @Override
    public List< MacdIndicator> getMACD(String symbol, TimeInterval interval, SeriesType seriesType, HashMap<String, String> options) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        String function = "MACD";
        //String queryString = Utils.BASE_URI + "function=" + function + "&symbol=" + symbol + "&interval=" + interval.getName() + "&series_type=" + seriesType + "&apikey=" + apiKey + "&";
        StringBuilder sb = new StringBuilder();

        sb.append(Utils.BASE_URI)
                .append("function=")
                .append(function)
                .append("&symbol=")
                .append(symbol)
                .append("&interval=")
                .append(interval.getName())
                .append("&series_type=")
                .append(seriesType)
                .append("&apikey=")
                .append(apiKey)
                .append("&");


        String encodedUrl = options.keySet().stream().map(key -> {
            try {
                return Utils.contentKeyVal(key, options.get(key));
//                return key + "=" + UriUtils.encode(options.get(key), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(joining("&", sb.toString(), ""));


        List<MacdIndicator> result = new ArrayList<>();
        JsonNode jsonNode = restTemplate.getForObject(encodedUrl, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);
            if (mapEntry.getKey().equals("Technical Analysis: " + function)) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();

                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String macd = String.valueOf(timeSeriesMap.getValue().get("MACD"));
                    String signal = String.valueOf(timeSeriesMap.getValue().get("MACD_Signal"));
                    String hist = String.valueOf(timeSeriesMap.getValue().get("MACD_Hist"));
                    result.add(MacdIndicator.newInstance(symbol, macd, signal, hist,localDate));
                }

            }
        }

        return result;
    }


    @Override
    public List< MacdIndicator> getMACDEXT(String symbol, TimeInterval interval, SeriesType seriesType, HashMap<String, String> options) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        String function = "MACDEXT";
        //String queryString = Utils.BASE_URI + "function=" + function + "&symbol=" + symbol + "&interval=" + interval.getName() + "&series_type=" + seriesType + "&apikey=" + apiKey + "&";

        StringBuilder sb = new StringBuilder();
        sb.append(Utils.BASE_URI)
                .append("function=")
                .append(function)
                .append("&symbol=")
                .append(symbol)
                .append("&interval=")
                .append(interval.getName())
                .append("&series_type=")
                .append(seriesType)
                .append("&apikey=")
                .append(apiKey)
                .append("&");

        String encodedUrl = options.keySet().stream().map(key -> {
            try {
                return Utils.contentKeyVal(key, options.get(key));
//                return key + "=" + UriUtils.encode(options.get(key), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(joining("&", sb.toString(), ""));


        List<MacdIndicator> result = new ArrayList<>();
        JsonNode jsonNode = restTemplate.getForObject(encodedUrl, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);
            if (mapEntry.getKey().equals("Technical Analysis: " + function)) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();
                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String macd = String.valueOf(timeSeriesMap.getValue().get("MACDEXT"));
                    String signal = String.valueOf(timeSeriesMap.getValue().get("MACD_Signal"));
                    String hist = String.valueOf(timeSeriesMap.getValue().get("MACD_Hist"));
                    result.add(MacdIndicator.newInstance(symbol, macd, signal, hist, localDate));
                }

            }
        }

        return result;
    }

    @Override
    public List< StochIndicator> getSTOCH(String symbol, TimeInterval interval, HashMap<String, String> options) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        String function = "STOCH";
        //String queryString = Utils.BASE_URI + "function=" + function + "&symbol=" + symbol + "&interval=" + interval.getName() + "&apikey=" + apiKey + "&";

        StringBuilder sb = new StringBuilder();
        sb.append(Utils.BASE_URI)
                .append("function=")
                .append(function)
                .append("&symbol=")
                .append(symbol)
                .append("&interval=")
                .append(interval.getName())
                .append("&apikey=")
                .append(apiKey)
                .append("&");

        String encodedUrl = options.keySet().stream().map(key -> {
            try {
                return Utils.contentKeyVal(key, options.get(key));
//                return key + "=" + UriUtils.encode(options.get(key), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(joining("&", sb.toString(), ""));


        List<StochIndicator> result = new ArrayList<>();
        JsonNode jsonNode = restTemplate.getForObject(encodedUrl, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);
            if (mapEntry.getKey().equals("Technical Analysis: " + function)) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();
                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String slowK = String.valueOf(timeSeriesMap.getValue().get("SlowK"));
                    String slowD = String.valueOf(timeSeriesMap.getValue().get("SlowD"));
                    result.add(StochIndicator.newInstance(symbol, slowK, slowD, localDate));
                }

            }
        }

        return result;
    }

    @Override
    public List< StochfIndicator> getSTOCHF(String symbol, TimeInterval interval, HashMap<String, String> options) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        String function = "STOCHF";
       // String queryString = Utils.BASE_URI + "function=" + function + "&symbol=" + symbol + "&interval=" + interval.getName() + "&apikey=" + apiKey + "&";

        StringBuilder sb = new StringBuilder();
        sb.append(Utils.BASE_URI)
                .append("function=")
                .append(function)
                .append("&symbol=")
                .append(symbol)
                .append("&interval=")
                .append(interval.getName())
                .append("&apikey=")
                .append(apiKey)
                .append("&");

        String encodedUrl = options.keySet().stream().map(key -> {
            try {
                return Utils.contentKeyVal(key, options.get(key));
//                return key + "=" + UriUtils.encode(options.get(key), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(joining("&", sb.toString(), ""));


        List<StochfIndicator> result = new ArrayList<>();
        JsonNode jsonNode = restTemplate.getForObject(encodedUrl, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);
            if (mapEntry.getKey().equals("Technical Analysis: " + function)) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();
                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String fastK = String.valueOf(timeSeriesMap.getValue().get("FastK"));
                    String fastD = String.valueOf(timeSeriesMap.getValue().get("FastD"));
                    result.add(StochfIndicator.newInstance(symbol, fastK, fastD, localDate));
                }

            }
        }

        return result;
    }

    @Override
    public List<AbstractIndicator> getRSI(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.RSI, interval, timePeriod, seriesType);
        
    }

    @Override
    public List< StochfIndicator> getSTOCHRSI(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType, HashMap<String, String> options) {
        //String queryString = Utils.BASE_URI + "function=STOCHRSI&symbol=" + symbol + "&time_period=" + timePeriod + "&series_type=" + seriesType + "&interval=" + interval.getName() + "&apikey=" + apiKey + "&";

        StringBuilder sb = new StringBuilder();
        sb.append(Utils.BASE_URI)
                .append("function=STOCHRSI")
                .append("&symbol=")
                .append(symbol)
                .append("&time_period=")
                .append(timePeriod)
                .append("&interval=")
                .append(interval.getName())
                .append("&series_type=")
                .append(seriesType)
                .append("&apikey=")
                .append(apiKey)
                .append("&");

        String encodedUrl = options.keySet().stream().map(key -> {
            try {
                return Utils.contentKeyVal(key, options.get(key));
//                return key + "=" + UriUtils.encode(options.get(key), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(joining("&", sb.toString(), ""));


        List<StochfIndicator> result = new ArrayList<>();
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
                    result.add(StochfIndicator.newInstance(symbol, fastK, fastD, localDate));
                }

            }
        }

        return result;
    }

    @Override
    public List<AbstractIndicator> getWILLR(String symbol, TimeInterval interval, String timePeriod) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.WILLR, interval, timePeriod);
 
    }

    @Override
    public List<AbstractIndicator> getADX(String symbol, TimeInterval interval, String timePeriod) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.ADX, interval, timePeriod);
    }

    @Override
    public List<AbstractIndicator> getADXR(String symbol, TimeInterval interval, String timePeriod) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.ADXR, interval, timePeriod);
        
    }

    @Override
    public List<AbstractIndicator> getAPO(String symbol, TimeInterval interval, SeriesType seriesType, HashMap<String, String> options) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.APO, interval, seriesType, options);
        
    }

    @Override
    public List<AbstractIndicator> getPPO(String symbol, TimeInterval interval, SeriesType seriesType, HashMap<String, String> options) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.PPO, interval, seriesType, options);
        
    }

    @Override
    public List<AbstractIndicator> getMOM(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.MOM, interval, timePeriod, seriesType);
    }

    @Override
    public List<AbstractIndicator> getBOP(String symbol, TimeInterval interval) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.BOP, interval);
        
    }

    @Override
    public List<AbstractIndicator> getCCI(String symbol, TimeInterval interval, String timePeriod) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.CCI, interval, timePeriod);
    }

    @Override
    public List<AbstractIndicator> getCMO(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.CMO, interval, timePeriod, seriesType);
        
    }

    @Override
    public List<AbstractIndicator> getROC(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.ROC, interval, timePeriod, seriesType);
    }

    @Override
    public List<AbstractIndicator> getROCR(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.ROCR, interval, timePeriod, seriesType);
    }

    @Override
    public List< AroonIndicator> getAROON(String symbol, TimeInterval interval, String timePeriod) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        String function = "AROON";
        //String queryString = Utils.BASE_URI + "function=" + function + "&symbol=" + symbol + "&interval=" + interval.getName() + "&time_period=" + timePeriod + "&apikey=" + apiKey + "&";

        StringBuilder sb = new StringBuilder();
        sb.append(Utils.BASE_URI)
                .append("function=")
                .append(function)
                .append("&symbol=")
                .append(symbol)
                .append("&time_period=")
                .append(timePeriod)
                .append("&interval=")
                .append(interval.getName())
                .append("&apikey=")
                .append(apiKey)
                .append("&");

        List<AroonIndicator> result = new ArrayList<>();
        JsonNode jsonNode = restTemplate.getForObject(sb.toString(), JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);
            if (mapEntry.getKey().equals("Technical Analysis: " + function)) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();
                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String aroonUp = String.valueOf(timeSeriesMap.getValue().get("Aroon Up"));
                    String aroonDown = String.valueOf(timeSeriesMap.getValue().get("Aroon Up"));
                    result.add(AroonIndicator.newInstance(symbol, aroonUp, aroonDown, localDate));
                }

            }
        }

        return result;
    }

    @Override
    public List<AbstractIndicator> getAROONOSC(String symbol, TimeInterval interval, String timePeriod) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.AROONOSC, interval, timePeriod);
    }

    @Override
    public List<AbstractIndicator> getMFI(String symbol, TimeInterval interval, String timePeriod) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.MFI, interval, timePeriod);
    }

    @Override
    public List<AbstractIndicator> getTRIX(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.TRIX, interval, timePeriod, seriesType);
    }

    @Override
    public List<AbstractIndicator> getULTOSC(String symbol, TimeInterval interval, String timePeriod, HashMap<String, String> options) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.ULTOSC, interval, timePeriod, options);
    }

    @Override
    public List<AbstractIndicator> getDX(String symbol, TimeInterval interval, String timePeriod) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.ULTOSC, interval, timePeriod);
    }

    @Override
    public List<AbstractIndicator> getMINUS_DI(String symbol, TimeInterval interval, String timePeriod) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.MINUS_DI, interval, timePeriod);
    }

    @Override
    public List<AbstractIndicator> getPLUS_DI(String symbol, TimeInterval interval, String timePeriod) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.PLUS_DI, interval, timePeriod);
    }

    @Override
    public List<AbstractIndicator> getMINUS_DM(String symbol, TimeInterval interval, String timePeriod) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.MINUS_DM, interval, timePeriod);
    }

    @Override
    public List<AbstractIndicator> getPLUS_DM(String symbol, TimeInterval interval, String timePeriod) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.PLUS_DM, interval, timePeriod);
    }

    @Override
    public List< BbandsIndicator> getBBANDS(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType, HashMap<String, String> options) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        String function = "BBANDS";

        //String queryString = Utils.BASE_URI + "function=" + function + "symbol=" + symbol + "&interval=" + interval.getName() + "&time_period=" + timePeriod + "&series_type=" + seriesType + "&apikey=" + apiKey + "&";

        StringBuilder sb = new StringBuilder();
        sb.append(Utils.BASE_URI)
                .append("function=")
                .append(function)
                .append("&symbol=")
                .append(symbol)
                .append("&time_period=")
                .append(timePeriod)
                .append("&interval=")
                .append(interval.getName())
                .append("&series_type=")
                .append(seriesType)
                .append("&apikey=")
                .append(apiKey)
                .append("&");

        String encodedUrl = options.keySet().stream().map(key -> {
            try {
                return Utils.contentKeyVal(key, options.get(key));
//                return key + "=" + UriUtils.encode(options.get(key), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(joining("&", sb.toString(), ""));

        List<BbandsIndicator> result = new ArrayList<>();
        JsonNode jsonNode = restTemplate.getForObject(encodedUrl, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);
            if (mapEntry.getKey().equals("Technical Analysis: " + function)) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();
                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String realLowerBand = String.valueOf(timeSeriesMap.getValue().get("Real Lower Band"));
                    String realUpperBand = String.valueOf(timeSeriesMap.getValue().get("Real Upper Band"));
                    String realMiddleBand = String.valueOf(timeSeriesMap.getValue().get("Real Middle Band"));
                    result.add(BbandsIndicator.newInstance(symbol, realLowerBand, realMiddleBand, realUpperBand, localDate));
                }

            }
        }

        return result;
    }

    @Override
    public List<AbstractIndicator> getMIDPOINT(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.MIDPOINT, interval, timePeriod, seriesType);
    }

    @Override
    public List<AbstractIndicator> getMIDPRICE(String symbol, TimeInterval interval, String timePeriod) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.MIDPRICE, interval, timePeriod);
    }

    @Override
    public List<AbstractIndicator> getSAR(String symbol, TimeInterval interval, HashMap<String, String> options) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.SAR, interval, options);
    }

    @Override
    public List<AbstractIndicator> getTRANGE(String symbol, TimeInterval interval) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.TRANGE, interval);
    }

    @Override
    public List<AbstractIndicator> getATR(String symbol, TimeInterval interval, String timePeriod) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.ATR, interval, timePeriod);
    }

    @Override
    public List<AbstractIndicator> getNATR(String symbol, TimeInterval interval, String timePeriod) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.NATR, interval, timePeriod);
    }

    @Override
    public List<AbstractIndicator> getAD(String symbol, TimeInterval interval) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        String function = "AD";
        //String queryString = Utils.BASE_URI + "function=" + function + "&symbol=" + symbol + "&interval=" + interval.getName() + "&apikey=" + apiKey + "&";

        StringBuilder sb = new StringBuilder();
        sb.append(Utils.BASE_URI)
                .append("function=")
                .append(function)
                .append("&symbol=")
                .append(symbol)
                .append("&interval=")
                .append(interval.getName())
                .append("&apikey=")
                .append(apiKey)
                .append("&");

        List<AbstractIndicator> result = new ArrayList<>();
        JsonNode jsonNode = restTemplate.getForObject(sb.toString(), JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);

            if (mapEntry.getKey().equals("Technical Analysis: Chaikin A/D")) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();

                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String value = String.valueOf(timeSeriesMap.getValue().get("Chaikin A/D"));
                    result.add(AbstractIndicator.newInstance(symbol, IndicatorType.AD, value, localDate));
                }

            }
        }

        return result;
    }

    @Override
    public List<AbstractIndicator> getADOSC(String symbol, TimeInterval interval, HashMap<String, String> options) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.ADOSC, interval, options);
    }

    //==
    @Override
    public List<AbstractIndicator> getOBV(String symbol, TimeInterval interval) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.OBV, interval);
    }

    @Override
    public List<AbstractIndicator> getHT_TRENDLINE(String symbol, TimeInterval interval, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.HT_TRENDLINE, interval, seriesType);
    }

    @Override
    public List< HtSineIndicator> getHT_SINE(String symbol, TimeInterval interval, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        String function = "HT_SINE";
        //String queryString = Utils.BASE_URI + "function=" + function + "&symbol=" + symbol + "&interval=" + interval.getName() + "&series_type=" + seriesType + "&apikey=" + apiKey + "&";
        StringBuilder sb = new StringBuilder();
        sb.append(Utils.BASE_URI)
                .append("function=")
                .append(function)
                .append("&symbol=")
                .append(symbol)
                .append("&interval=")
                .append(interval.getName())
                .append("&series_type=")
                .append(seriesType)
                .append("&apikey=")
                .append(apiKey)
                .append("&");


        List<HtSineIndicator> result = new ArrayList<>();
        JsonNode jsonNode = restTemplate.getForObject(sb.toString(), JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);
            if (mapEntry.getKey().equals("Technical Analysis: " + function)) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();

                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String sine = String.valueOf(timeSeriesMap.getValue().get("SINE"));
                    String leadSine = String.valueOf(timeSeriesMap.getValue().get("LEAD SINE"));
                    result.add(HtSineIndicator.newInstance(symbol, sine, leadSine, localDate));
                }

            }
        }

        return result;
    }

    @Override
    public List<AbstractIndicator> getHT_TRENDMODE(String symbol, TimeInterval interval, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.HT_TRENDMODE, interval, seriesType);
    }

    @Override
    public List<AbstractIndicator> getHT_DCPERIOD(String symbol, TimeInterval interval, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.HT_DCPERIOD, interval, seriesType);
    }

    @Override
    public List<AbstractIndicator> getHT_DCPHASE(String symbol, TimeInterval interval, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        return requestApiData(symbol, IndicatorType.HT_DCPHASE, interval, seriesType);
    }

    @Override
    public List< HtPhasorIndicator> getHT_PHASOR(String symbol, TimeInterval interval, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        String function = "HT_PHASOR";
       // String queryString = Utils.BASE_URI + "function=" + function + "&symbol=" + symbol + "&interval=" + interval.getName() + "&series_type=" + seriesType + "&apikey=" + apiKey + "&";

        StringBuilder sb = new StringBuilder();
        sb.append(Utils.BASE_URI)
                .append("function=")
                .append(function)
                .append("&symbol=")
                .append(symbol)
                .append("&interval=")
                .append(interval.getName())
                .append("&series_type=")
                .append(seriesType)
                .append("&apikey=")
                .append(apiKey)
                .append("&");

        List<HtPhasorIndicator> result = new ArrayList<>();
        JsonNode jsonNode = restTemplate.getForObject(sb.toString(), JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);
            if (mapEntry.getKey().equals("Technical Analysis: " + function)) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();

                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String quadrature = String.valueOf(timeSeriesMap.getValue().get("QUADRATURE"));
                    String phase = String.valueOf(timeSeriesMap.getValue().get("PHASE"));
                    result.add(HtPhasorIndicator.newInstance(symbol, quadrature, phase, localDate));
                }

            }
        }

        return result;
    }


    private List<AbstractIndicator> requestApiData(String symbol, IndicatorType indicatorType, TimeInterval interval, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        //String queryString = Utils.BASE_URI + "function=" + indicatorType.name() + "&symbol=" + symbol + "&interval=" + interval.getName() + "&series_type=" + seriesType + "&apikey=" + apiKey + "&";
        StringBuilder sb = new StringBuilder();
        sb.append(Utils.BASE_URI)
                .append("function=")
                .append(indicatorType.name())
                .append("&symbol=")
                .append(symbol)
                .append("&interval=")
                .append(interval.getName())
                .append("&series_type=")
                .append(seriesType)
                .append("&apikey=")
                .append(apiKey)
                .append("&");

        List<AbstractIndicator> result = new ArrayList<>();
        JsonNode jsonNode = restTemplate.getForObject(sb.toString(), JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        String function = indicatorType.name();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);

            if (mapEntry.getKey().equals("Technical Analysis: " + indicatorType.name())) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();

                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String value = String.valueOf(timeSeriesMap.getValue().get(indicatorType.name()));
                    result.add(AbstractIndicator.newInstance(symbol, indicatorType, value, localDate));
                }

            }
        }

        return result;
    }


    private List<AbstractIndicator> requestApiData(String symbol, IndicatorType indicatorType, TimeInterval interval, String timePeriod) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
//        String queryString = Utils.BASE_URI + "function=" + indicatorType.name() + "&symbol=" + symbol + "&interval=" + interval.getName() + "&time_period=" + timePeriod + "&apikey=" + apiKey + "&";
        StringBuilder sb = new StringBuilder();
        sb.append(Utils.BASE_URI)
                .append("function=")
                .append(indicatorType.name())
                .append("&symbol=")
                .append(symbol)
                .append("&interval=")
                .append(interval.getName())
                .append("&time_period=")
                .append(timePeriod)
                .append("&apikey=")
                .append(apiKey)
                .append("&");

        List<AbstractIndicator> result = new ArrayList<>();
        JsonNode jsonNode = restTemplate.getForObject(sb.toString(), JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        String function = indicatorType.name();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);
            if (mapEntry.getKey().equals("Technical Analysis: " + indicatorType.name())) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();

                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String value = String.valueOf(timeSeriesMap.getValue().get(indicatorType.name()));
                    result.add(AbstractIndicator.newInstance(symbol, indicatorType, value, localDate));
                }

            }
        }

        return result;
    }


    private List<AbstractIndicator> requestApiData(String symbol, IndicatorType indicatorType, TimeInterval interval, String timePeriod, SeriesType seriesType) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        //String queryString = Utils.BASE_URI + "function=" + indicatorType.name() + "&symbol=" + symbol + "&interval=" + interval.getName() + "&time_period=" + timePeriod + "&series_type=" + seriesType + "&apikey=" + apiKey + "&";

        StringBuilder sb = new StringBuilder();
        sb.append(Utils.BASE_URI)
                .append("function=")
                .append(indicatorType.name())
                .append("&symbol=")
                .append(symbol)
                .append("&interval=")
                .append(interval.getName())
                .append("&time_period=")
                .append(timePeriod)
                .append("&series_type=")
                .append(seriesType)
                .append("&apikey=")
                .append(apiKey)
                .append("&");

        List<AbstractIndicator> result = new ArrayList<>();
        JsonNode jsonNode = restTemplate.getForObject(sb.toString(), JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        String function = indicatorType.name();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);

            if (mapEntry.getKey().equals("Technical Analysis: " + indicatorType.name())) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();

                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String value = String.valueOf(timeSeriesMap.getValue().get(indicatorType.name()));
                    result.add(AbstractIndicator.newInstance(symbol, indicatorType, value, localDate));
                }

            }
        }

        return result;
    }


    private List<AbstractIndicator> requestApiData(String symbol, IndicatorType indicatorType, TimeInterval interval, SeriesType seriesType, HashMap<String, String> options) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        //String queryString = Utils.BASE_URI + "function=" + indicatorType.name() + "&symbol=" + symbol + "&interval=" + interval.getName() + "&series_type=" + seriesType + "&apikey=" + apiKey + "&";

        StringBuilder sb = new StringBuilder();
        sb.append(Utils.BASE_URI)
                .append("function=")
                .append(indicatorType.name())
                .append("&symbol=")
                .append(symbol)
                .append("&interval=")
                .append(interval.getName())
                .append("&series_type=")
                .append(seriesType)
                .append("&apikey=")
                .append(apiKey)
                .append("&");

        String encodedUrl = options.keySet().stream().map(key -> {
            try {
                return Utils.contentKeyVal(key, options.get(key));

//                return key + "=" + UriUtils.encode(options.get(key), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(joining("&", sb.toString(), ""));


        List<AbstractIndicator> result = new ArrayList<>();
        JsonNode jsonNode = restTemplate.getForObject(encodedUrl, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        String function = indicatorType.name();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);
            if (mapEntry.getKey().equals("Technical Analysis: " + indicatorType.name())) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();

                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String value = String.valueOf(timeSeriesMap.getValue().get(indicatorType.name()));
                    result.add(AbstractIndicator.newInstance(symbol, indicatorType, value, localDate));
                }

            }
        }

        return result;
    }


    private List<AbstractIndicator> requestApiData(String symbol, IndicatorType indicatorType, TimeInterval interval) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
//        String queryString = Utils.BASE_URI + "function=" + indicatorType.name() + "&symbol=" + symbol + "&interval=" + interval.getName() + "&apikey=" + apiKey + "&";

        StringBuilder sb = new StringBuilder();
        sb.append(Utils.BASE_URI)
                .append("function=")
                .append(indicatorType.name())
                .append("&symbol=")
                .append(symbol)
                .append("&interval=")
                .append(interval.getName())
                .append("&apikey=")
                .append(apiKey)
                .append("&");

        List<AbstractIndicator> result = new ArrayList<>();
        JsonNode jsonNode = restTemplate.getForObject(sb.toString(), JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        String function = indicatorType.name();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);
            if (mapEntry.getKey().equals("Technical Analysis: " + indicatorType.name())) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();

                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String value = String.valueOf(timeSeriesMap.getValue().get(indicatorType.name()));
                    result.add(AbstractIndicator.newInstance(symbol, indicatorType, value, localDate));
                }

            }
        }

        return result;
    }


    private List<AbstractIndicator> requestApiData(String symbol, IndicatorType indicatorType, TimeInterval interval, String timePeriod, HashMap<String, String> options) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
        //String queryString = Utils.BASE_URI + "function=" + indicatorType.name() + "&symbol=" + symbol + "&interval=" + interval.getName() + "&time_period=" + timePeriod + "&apikey=" + apiKey + "&";
        StringBuilder sb = new StringBuilder();
        sb.append(Utils.BASE_URI)
                .append("function=")
                .append(indicatorType.name())
                .append("&symbol=")
                .append(symbol)
                .append("&interval=")
                .append(interval.getName())
                .append("&time_period=")
                .append(timePeriod)
                .append("&apikey=")
                .append(apiKey)
                .append("&");

        String encodedUrl = options.keySet().stream().map(key -> {
            try {
                return Utils.contentKeyVal(key, options.get(key));
//                return key + "=" + UriUtils.encode(options.get(key), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(joining("&", sb.toString(), ""));


        List<AbstractIndicator> result = new ArrayList<>();
        JsonNode jsonNode = restTemplate.getForObject(encodedUrl, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        String function = indicatorType.name();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);
            if (mapEntry.getKey().equals("Technical Analysis: " + indicatorType.name())) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();

                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String value = String.valueOf(timeSeriesMap.getValue().get(indicatorType.name()));
                    result.add(AbstractIndicator.newInstance(symbol, indicatorType, value, localDate));
                }

            }
        }

        return result;
    }


    private List<AbstractIndicator> requestApiData(String symbol, IndicatorType indicatorType, TimeInterval interval, HashMap<String, String> options) throws MissingApiKeyException, InvalidFunctionOptionException, InvalidApiKeyException, MalFormattedFunctionException, UltraHighFrequencyRequestException, ApiLimitExceeded {
//        String queryString = Utils.BASE_URI + "function=" + indicatorType.name() + "&symbol=" + symbol + "&interval=" + interval.getName() + "&apikey=" + apiKey + "&";
        StringBuilder sb = new StringBuilder();
        sb.append(Utils.BASE_URI)
                .append("function=")
                .append(indicatorType.name())
                .append("&symbol=")
                .append(symbol)
                .append("&interval=")
                .append(interval.getName())
                .append("&apikey=")
                .append(apiKey)
                .append("&");

        String encodedUrl = options.keySet().stream().map(key -> {
            try {
                return Utils.contentKeyVal(key, options.get(key));
//                return key + "=" + UriUtils.encode(options.get(key), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(joining("&", sb.toString(), ""));

        List<AbstractIndicator> result = new ArrayList<>();
        JsonNode jsonNode = restTemplate.getForObject(encodedUrl, JsonNode.class);
        Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
        String function = indicatorType.name();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> mapEntry = it.next();
            ExceptionUtil.handleException(mapEntry, function);
            if (mapEntry.getKey().equals("Technical Analysis: " + indicatorType.name())) {
                JsonNode node = mapEntry.getValue();
                Iterator<Map.Entry<String, JsonNode>> timeSeriesIter = node.fields();
                while (timeSeriesIter.hasNext()) {
                    Map.Entry<String, JsonNode> timeSeriesMap = timeSeriesIter.next();

                    LocalDate localDate = LocalDate.parse(timeSeriesMap.getKey(), DateTimeFormatter.ISO_LOCAL_DATE);
                    String value = String.valueOf(timeSeriesMap.getValue().get(indicatorType.name()));
                    result.add(AbstractIndicator.newInstance(symbol, indicatorType, value, localDate));
                }

            }
        }

        return result;
    }
}
