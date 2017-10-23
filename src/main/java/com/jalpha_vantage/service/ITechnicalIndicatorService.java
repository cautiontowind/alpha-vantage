package com.jalpha_vantage.service;

import com.jalpha_vantage.domain.*;
import com.jalpha_vantage.enums.SeriesType;
import com.jalpha_vantage.enums.TimeInterval;
import com.jalpha_vantage.exception.*;
import com.jalpha_vantage.domain.*;
import com.jalpha_vantage.exception.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;

public interface ITechnicalIndicatorService {
    LinkedHashMap<LocalDate, AbstractIndicator> getSMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getEMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getWMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getDEMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getTEMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getTRIMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getKAMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, MamaIndicator> getMAMA(String symbol, TimeInterval interval, SeriesType seriesType, HashMap<String, String> options) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getT3(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, MacdIndicator> getMACD(String symbol, TimeInterval interval, SeriesType seriesType, HashMap<String, String> options) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, MacdIndicator> getMACDEXT(String symbol, TimeInterval interval, SeriesType seriesType, HashMap<String, String> options) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, StochIndicator> getSTOCH(String symbol, TimeInterval interval, HashMap<String, String> options) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, StochfIndicator> getSTOCHF(String symbol, TimeInterval interval, HashMap<String, String> options) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getRSI(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, StochfIndicator> getSTOCHRSI(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType, HashMap<String, String> options) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getWILLR(String symbol, TimeInterval interval, String timePeriod) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getADX(String symbol, TimeInterval interval, String timePeriod) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getADXR(String symbol, TimeInterval interval, String timePeriod) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getAPO(String symbol, TimeInterval interval, SeriesType seriesType, HashMap<String, String> options) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getPPO(String symbol, TimeInterval interval, SeriesType seriesType, HashMap<String, String> options) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getMOM(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getBOP(String symbol, TimeInterval interval) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getCCI(String symbol, TimeInterval interval, String timePeriod) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getCMO(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getROC(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getROCR(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AroonIndicator> getAROON(String symbol, TimeInterval interval, String timePeriod) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getAROONOSC(String symbol, TimeInterval interval, String timePeriod) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getMFI(String symbol, TimeInterval interval, String timePeriod) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getTRIX(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getULTOSC(String symbol, TimeInterval interval, String timePeriod, HashMap<String, String> options) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getDX(String symbol, TimeInterval interval, String timePeriod) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getMINUS_DI(String symbol, TimeInterval interval, String timePeriod) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getPLUS_DI(String symbol, TimeInterval interval, String timePeriod) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getMINUS_DM(String symbol, TimeInterval interval, String timePeriod) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getPLUS_DM(String symbol, TimeInterval interval, String timePeriod) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, BbandsIndicator> getBBANDS(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType, HashMap<String, String> options) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getMIDPOINT(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getMIDPRICE(String symbol, TimeInterval interval, String timePeriod) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getSAR(String symbol, TimeInterval interval, HashMap<String, String> options) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getTRANGE(String symbol, TimeInterval interval) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getATR(String symbol, TimeInterval interval, String timePeriod) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getNATR(String symbol, TimeInterval interval, String timePeriod) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getAD(String symbol, TimeInterval interval) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getADOSC(String symbol, TimeInterval interval, HashMap<String, String> options) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getOBV(String symbol, TimeInterval interval) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getHT_TRENDLINE(String symbol, TimeInterval interval, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, HtSineIndicator> getHT_SINE(String symbol, TimeInterval interval, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getHT_TRENDMODE(String symbol, TimeInterval interval, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getHT_DCPERIOD(String symbol, TimeInterval interval, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, AbstractIndicator> getHT_DCPHASE(String symbol, TimeInterval interval, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

    LinkedHashMap<LocalDate, HtPhasorIndicator> getHT_PHASOR(String symbol, TimeInterval interval, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException;

}
