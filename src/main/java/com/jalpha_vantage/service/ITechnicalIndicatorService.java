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
import java.util.List;

public interface ITechnicalIndicatorService {
    List<AbstractIndicator> getSMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getEMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getWMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getDEMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getTEMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getTRIMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getKAMA(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<MamaIndicator> getMAMA(String symbol, TimeInterval interval, SeriesType seriesType, HashMap<String, String> options) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getT3(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<MacdIndicator> getMACD(String symbol, TimeInterval interval, SeriesType seriesType, HashMap<String, String> options) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<MacdIndicator> getMACDEXT(String symbol, TimeInterval interval, SeriesType seriesType, HashMap<String, String> options) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<StochIndicator> getSTOCH(String symbol, TimeInterval interval, HashMap<String, String> options) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<StochfIndicator> getSTOCHF(String symbol, TimeInterval interval, HashMap<String, String> options) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getRSI(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<StochfIndicator> getSTOCHRSI(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType, HashMap<String, String> options) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getWILLR(String symbol, TimeInterval interval, String timePeriod) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getADX(String symbol, TimeInterval interval, String timePeriod) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getADXR(String symbol, TimeInterval interval, String timePeriod) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getAPO(String symbol, TimeInterval interval, SeriesType seriesType, HashMap<String, String> options) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getPPO(String symbol, TimeInterval interval, SeriesType seriesType, HashMap<String, String> options) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getMOM(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getBOP(String symbol, TimeInterval interval) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getCCI(String symbol, TimeInterval interval, String timePeriod) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getCMO(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getROC(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getROCR(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AroonIndicator> getAROON(String symbol, TimeInterval interval, String timePeriod) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getAROONOSC(String symbol, TimeInterval interval, String timePeriod) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getMFI(String symbol, TimeInterval interval, String timePeriod) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getTRIX(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getULTOSC(String symbol, TimeInterval interval, String timePeriod, HashMap<String, String> options) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getDX(String symbol, TimeInterval interval, String timePeriod) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getMINUS_DI(String symbol, TimeInterval interval, String timePeriod) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getPLUS_DI(String symbol, TimeInterval interval, String timePeriod) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getMINUS_DM(String symbol, TimeInterval interval, String timePeriod) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getPLUS_DM(String symbol, TimeInterval interval, String timePeriod) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<BbandsIndicator> getBBANDS(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType, HashMap<String, String> options) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getMIDPOINT(String symbol, TimeInterval interval, String timePeriod, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getMIDPRICE(String symbol, TimeInterval interval, String timePeriod) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getSAR(String symbol, TimeInterval interval, HashMap<String, String> options) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getTRANGE(String symbol, TimeInterval interval) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getATR(String symbol, TimeInterval interval, String timePeriod) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getNATR(String symbol, TimeInterval interval, String timePeriod) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getAD(String symbol, TimeInterval interval) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getADOSC(String symbol, TimeInterval interval, HashMap<String, String> options) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getOBV(String symbol, TimeInterval interval) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getHT_TRENDLINE(String symbol, TimeInterval interval, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<HtSineIndicator> getHT_SINE(String symbol, TimeInterval interval, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getHT_TRENDMODE(String symbol, TimeInterval interval, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getHT_DCPERIOD(String symbol, TimeInterval interval, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<AbstractIndicator> getHT_DCPHASE(String symbol, TimeInterval interval, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

    List<HtPhasorIndicator> getHT_PHASOR(String symbol, TimeInterval interval, SeriesType seriesType) throws InvalidApiKeyException, InvalidFunctionOptionException, MalFormattedFunctionException, MissingApiKeyException, UltraHighFrequencyRequestException, ApiLimitExceeded;

}
