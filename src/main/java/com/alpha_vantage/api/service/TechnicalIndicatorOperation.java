package com.alpha_vantage.api.service;

import com.alpha_vantage.api.domain.*;
import com.alpha_vantage.api.enums.SeriesType;
import com.alpha_vantage.api.enums.TimeInterval;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;

public interface TechnicalIndicatorOperation {
    LinkedHashMap<LocalDate, AbstractIndicator> getSMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType);
    LinkedHashMap<LocalDate, AbstractIndicator> getEMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType);
    LinkedHashMap<LocalDate, AbstractIndicator> getWMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType);
    LinkedHashMap<LocalDate, AbstractIndicator> getDEMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType);
    LinkedHashMap<LocalDate, AbstractIndicator> getTEMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType);
    LinkedHashMap<LocalDate, AbstractIndicator> getTRIMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType);
    LinkedHashMap<LocalDate, AbstractIndicator> getKAMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType);
    LinkedHashMap<LocalDate, MamaIndicator> getMAMA(String symbol, TimeInterval interval, SeriesType seriesType, HashMap<String, String> options);
    LinkedHashMap<LocalDate, AbstractIndicator> getT3(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType);
    LinkedHashMap<LocalDate, MacdIndicator> getMACD(String symbol, TimeInterval interval, SeriesType seriesType, HashMap<String, String> options);
    LinkedHashMap<LocalDate, MacdIndicator> getMACDEXT(String symbol, TimeInterval interval, SeriesType seriesType, HashMap<String, String> options);
    LinkedHashMap<LocalDate, StochIndicator> getSTOCH(String symbol, TimeInterval interval, HashMap<String, String> options);
    LinkedHashMap<LocalDate, StochfIndicator> getSTOCHF(String symbol, TimeInterval interval, HashMap<String, String> options);
    LinkedHashMap<LocalDate, AbstractIndicator> getRSI(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType);
    LinkedHashMap<LocalDate, StochfIndicator> getSTOCHRSI(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType, HashMap<String, String> options);
    LinkedHashMap<LocalDate, AbstractIndicator> getWILLR(String symbol, TimeInterval interval, String timePeriod);
    LinkedHashMap<LocalDate, AbstractIndicator> getADX(String symbol, TimeInterval interval, String timePeriod);
    LinkedHashMap<LocalDate, AbstractIndicator> getADXR(String symbol, TimeInterval interval, String timePeriod);
    LinkedHashMap<LocalDate, AbstractIndicator> getAPO(String symbol, TimeInterval interval, SeriesType seriesType, HashMap<String, String> options);
    LinkedHashMap<LocalDate, AbstractIndicator> getPPO(String symbol, TimeInterval interval, SeriesType seriesType, HashMap<String, String> options);
    LinkedHashMap<LocalDate, AbstractIndicator> getMOM(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType);
    LinkedHashMap<LocalDate, AbstractIndicator> getBOP(String symbol, TimeInterval interval);
    LinkedHashMap<LocalDate, AbstractIndicator> getCCI(String symbol, TimeInterval interval, String timePeriod);
    LinkedHashMap<LocalDate, AbstractIndicator> getCMO(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType);
    LinkedHashMap<LocalDate, AbstractIndicator> getROC(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType);
    LinkedHashMap<LocalDate, AbstractIndicator> getROCR(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType);
    LinkedHashMap<LocalDate, AroonIndicator> getAROON(String symbol, TimeInterval interval, String timePeriod);
    LinkedHashMap<LocalDate, AbstractIndicator> getAROONOSC(String symbol, TimeInterval interval, String timePeriod);
    LinkedHashMap<LocalDate, AbstractIndicator> getMFI(String symbol, TimeInterval interval, String timePeriod);
    LinkedHashMap<LocalDate, AbstractIndicator> getTRIX(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType);
    LinkedHashMap<LocalDate, AbstractIndicator> getULTOSC(String symbol, TimeInterval interval, String timePeriod, HashMap<String, String> options);
    LinkedHashMap<LocalDate, AbstractIndicator> getDX(String symbol, TimeInterval interval, String timePeriod);
    LinkedHashMap<LocalDate, AbstractIndicator> getMINUS_DI(String symbol, TimeInterval interval, String timePeriod);
    LinkedHashMap<LocalDate, AbstractIndicator> getPLUS_DI(String symbol, TimeInterval interval, String timePeriod);
    LinkedHashMap<LocalDate, AbstractIndicator> getMINUS_DM(String symbol, TimeInterval interval, String timePeriod);
    LinkedHashMap<LocalDate, AbstractIndicator> getPLUS_DM(String symbol, TimeInterval interval, String timePeriod);
    LinkedHashMap<LocalDate, BbandsIndicator> getBBANDS(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType, HashMap<String, String> options);
    LinkedHashMap<LocalDate, AbstractIndicator> getMIDPOINT(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType);
    LinkedHashMap<LocalDate, AbstractIndicator> getMIDPRICE(String symbol, TimeInterval interval, String timePeriod);
    LinkedHashMap<LocalDate, AbstractIndicator> getSAR(String symbol, TimeInterval interval, HashMap<String, String> options);
    LinkedHashMap<LocalDate, AbstractIndicator> getTRANGE(String symbol, TimeInterval interval);
    LinkedHashMap<LocalDate, AbstractIndicator> getATR(String symbol, TimeInterval interval, String timePeriod);
    LinkedHashMap<LocalDate, AbstractIndicator> getNATR(String symbol, TimeInterval interval, String timePeriod);
    LinkedHashMap<LocalDate, AbstractIndicator> getAD(String symbol, TimeInterval interval);
    LinkedHashMap<LocalDate, AbstractIndicator> getADOSC(String symbol, TimeInterval interval, HashMap<String, String> options);
    LinkedHashMap<LocalDate, AbstractIndicator> getOBV(String symbol, TimeInterval interval);
    LinkedHashMap<LocalDate, AbstractIndicator> getHT_TRENDLINE(String symbol, TimeInterval interval, SeriesType seriesType);
    LinkedHashMap<LocalDate, HtSineIndicator> getHT_SINE(String symbol, TimeInterval interval, SeriesType seriesType);
    LinkedHashMap<LocalDate, AbstractIndicator> getHT_TRENDMODE(String symbol, TimeInterval interval, SeriesType seriesType);
    LinkedHashMap<LocalDate, AbstractIndicator> getHT_DCPERIOD(String symbol, TimeInterval interval, SeriesType seriesType);
    LinkedHashMap<LocalDate, AbstractIndicator> getHT_DCPHASE(String symbol, TimeInterval interval, SeriesType seriesType);
    LinkedHashMap<LocalDate, HtPhasorIndicator> getHT_PHASOR(String symbol, TimeInterval interval, SeriesType seriesType);

}
