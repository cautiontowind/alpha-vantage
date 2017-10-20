package com.zirxin.jalpha_vantage.impl;

import com.zirxin.jalpha_vantage.domain.*;
import com.zirxin.jalpha_vantage.enums.SeriesType;
import com.zirxin.jalpha_vantage.enums.TimeInterval;
import com.zirxin.jalpha_vantage.exception.*;
import com.zirxin.jalpha_vantage.service.ITechnicalIndicatorService;
import com.zirxin.jalpha_vantage.test.AbstractServiceTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class TechnicalIndicatorTemplateTest extends AbstractServiceTest {
    @Autowired
    private ITechnicalIndicatorService technicalIndicatorOperation;

    @Test
    public void testGetSMA() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getSMA("VOD.L", TimeInterval.DAILY, "60", SeriesType.close);
            assertEquals(4460, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetEMA() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getEMA("VOD.L", TimeInterval.DAILY, "60", SeriesType.close);
            assertEquals(4460, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }


    @Test
    public void testGetWMA() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getWMA("VOD.L", TimeInterval.DAILY, "60", SeriesType.close);
            assertEquals(4460, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetDEMA() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getDEMA("VOD.L", TimeInterval.DAILY, "60", SeriesType.close);
            assertEquals(4401, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetTEMA() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getTEMA("VOD.L", TimeInterval.DAILY, "60", SeriesType.close);
            assertEquals(4342, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetTRIMA() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getTRIMA("VOD.L", TimeInterval.DAILY, "60", SeriesType.close);
            assertEquals(4460, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetKAMA() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getKAMA("VOD.L", TimeInterval.DAILY, "60", SeriesType.close);
            assertEquals(4459, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetMAMA() {
        try {
            HashMap<String, String> options = new HashMap<String, String>();
            options.put("fastlimit", "0.01");
            Map<LocalDate, MamaIndicator> indicatorMap = technicalIndicatorOperation.getMAMA("VOD.L", TimeInterval.DAILY, SeriesType.close, options);
            assertEquals(4487, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetT3() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getT3("VOD.L", TimeInterval.DAILY, "60", SeriesType.close);
            assertEquals(4165, indicatorMap.size());

        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }


    @Test
    public void testGetMACD() {

        HashMap<String, String> options = new HashMap<String, String>();
        options.put("fastlimit", "0.01");
        options.put("signalperiod", "9");
        try {
            Map<LocalDate, MacdIndicator> indicatorMap = technicalIndicatorOperation.getMACD("VOD.L", TimeInterval.DAILY, SeriesType.close, options);
            assertEquals(4486, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
        }
    }

    @Test
    public void testGetMACDEXT() {
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("fastlimit", "0.01");
        options.put("signalperiod", "9");
        options.put("fastmatype", "1");
        try {
            Map<LocalDate, MacdIndicator> indicatorMap = technicalIndicatorOperation.getMACDEXT("VOD.L", TimeInterval.DAILY, SeriesType.close, options);
            assertEquals(4486, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }


    @Test
    public void testGetSTOCH() {
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("slowkperiod", "2");
        options.put("slowperiod", "2");
        options.put("slowkmatype", "1");
        try {
            Map<LocalDate, StochIndicator> indicatorMap = technicalIndicatorOperation.getSTOCH("VOD.L", TimeInterval.DAILY, options);
            assertEquals(4512, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetSTOCHF() {
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("fastkperiod", "2");
        options.put("fastperiod", "2");
        options.put("fastkmatype", "1");
        try {
            Map<LocalDate, StochfIndicator> indicatorMap = technicalIndicatorOperation.getSTOCHF("VOD.L", TimeInterval.DAILY, options);
            assertEquals(4516, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }


    @Test
    public void testGetRSI() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getRSI("VOD.L", TimeInterval.DAILY, "60", SeriesType.close);
            assertEquals(4459, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }


    @Test
    public void testGetSTOCHRSI() {
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("fastkperiod", "2");
        options.put("fastdperiod", "2");
        options.put("fastdmatype", "1");
        try {
            Map<LocalDate, StochfIndicator> indicatorMap = technicalIndicatorOperation.getSTOCHRSI("VOD.L", TimeInterval.DAILY, "60", SeriesType.close, options);
            assertEquals(4457, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetWILLR() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getWILLR("VOD.L", TimeInterval.DAILY, "60");
            assertEquals(4460, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetADX() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getADX("VOD.L", TimeInterval.DAILY, "60");
            assertEquals(4400, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetADXR() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getADXR("VOD.L", TimeInterval.DAILY, "60");
            assertEquals(4341, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }


    @Test
    public void testGetAPO() {
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("fastkperiod", "2");
        options.put("slowperiod", "22");
        options.put("matype", "1");
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getAPO("VOD.L", TimeInterval.DAILY, SeriesType.close, options);
            assertEquals(4498, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetPPO() {
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("fastkperiod", "2");
        options.put("slowperiod", "22");
        options.put("matype", "1");
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getPPO("VOD.L", TimeInterval.DAILY, SeriesType.close, options);
            assertEquals(4498, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetMOM() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getMOM("VOD.L", TimeInterval.DAILY, "60", SeriesType.close);
            assertEquals(4459, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetBOP() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getBOP("VOD.L", TimeInterval.DAILY);
            assertEquals(4519, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetCCI() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getCCI("VOD.L", TimeInterval.DAILY, "60");
            assertEquals(4460, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetCMO() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getCMO("VOD.L", TimeInterval.DAILY, "60", SeriesType.high);
            assertEquals(4459, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }


    @Test
    public void testGetROC() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getROC("VOD.L", TimeInterval.DAILY, "60", SeriesType.high);
            assertEquals(4459, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetROCR() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getROCR("VOD.L", TimeInterval.DAILY, "60", SeriesType.high);
            assertEquals(4459, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }


    @Test
    public void testGetAROON() {
        try {
            Map<LocalDate, AroonIndicator> indicatorMap = technicalIndicatorOperation.getAROON("VOD.L", TimeInterval.DAILY, "60");
            assertEquals(4459, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetAROONOSC() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getAROONOSC("VOD.L", TimeInterval.DAILY, "60");
            assertEquals(4459, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetMFI() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getMFI("VOD.L", TimeInterval.DAILY, "60");
            assertEquals(4459, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetTRIX() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getTRIX("VOD.L", TimeInterval.DAILY, "60", SeriesType.high);
            assertEquals(4341, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }


    @Test
    public void testGetULTOSC() {

        HashMap<String, String> options = new HashMap<String, String>();
        options.put("timeperiod1", "1");
        options.put("timeperiod2", "7");
        options.put("timeperiod3", "14");
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getULTOSC("VOD.L", TimeInterval.DAILY, "60", options);
            assertEquals(4505, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetDX() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getDX("VOD.L", TimeInterval.DAILY, "60");
            assertEquals(4491, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetMINUS_DI() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getMINUS_DI("VOD.L", TimeInterval.DAILY, "60");
            assertEquals(4459, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetPLUS_DI() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getPLUS_DI("VOD.L", TimeInterval.DAILY, "60");
            assertEquals(4459, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetMINUS_DM() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getMINUS_DM("VOD.L", TimeInterval.DAILY, "60");
            assertEquals(4460, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetPLUD_DM() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getPLUS_DM("VOD.L", TimeInterval.DAILY, "60");
            assertEquals(4460, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetBBANDS() {
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("nbdevup", "2");
        options.put("nbdevdn", "2");
        options.put("matype", "8");
        try {
            Map<LocalDate, BbandsIndicator> indicatorMap = technicalIndicatorOperation.getBBANDS("VOD.L", TimeInterval.DAILY, "60", SeriesType.high, options);
            assertEquals(4165, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetMIDPOINT() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getMIDPOINT("VOD.L", TimeInterval.DAILY, "60", SeriesType.high);
            assertEquals(4460, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetMIDPRICE() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getMIDPRICE("VOD.L", TimeInterval.DAILY, "60");
            assertEquals(4460, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }


    @Test
    public void testGetSAR() {
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("acceleration", "0.01");
        options.put("maximum", "0.20");
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getSAR("VOD.L", TimeInterval.DAILY, options);
            assertEquals(4518, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetTRANGE() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getTRANGE("VOD.L", TimeInterval.DAILY);
            assertEquals(4518, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetATR() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getATR("VOD.L", TimeInterval.DAILY, "60");
            assertEquals(4459, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }


    @Test
    public void testGetNATR() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getNATR("VOD.L", TimeInterval.DAILY, "60");
            assertEquals(4459, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetAD() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getAD("VOD.L", TimeInterval.DAILY);
            assertEquals(4519, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetADOSC() {
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("fastperiod", "2");
        options.put("slowperiod", "9");
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getADOSC("VOD.L", TimeInterval.DAILY, options);
            assertEquals(4511, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetOBV() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getOBV("VOD.L", TimeInterval.DAILY);
            assertEquals(4519, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetHT_TRENDLINE() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getHT_TRENDLINE("VOD.L", TimeInterval.DAILY, SeriesType.high);
            assertEquals(4456, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetHT_SINE() {
        try {
            Map<LocalDate, HtSineIndicator> indicatorMap = technicalIndicatorOperation.getHT_SINE("VOD.L", TimeInterval.DAILY, SeriesType.high);
            assertEquals(4456, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetTRENDMODE() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getHT_TRENDMODE("VOD.L", TimeInterval.DAILY, SeriesType.high);
            assertEquals(4519, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetHT_DCPERIOD() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getHT_DCPERIOD("VOD.L", TimeInterval.DAILY, SeriesType.high);
            assertEquals(4487, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }

    @Test
    public void testGetHT_DCPHASE() {
        try {
            Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getHT_DCPHASE("VOD.L", TimeInterval.DAILY, SeriesType.high);
            assertEquals(4456, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }


    @Test
    public void testGetHT_PHASOR() {
        try {
            Map<LocalDate, HtPhasorIndicator> indicatorMap = technicalIndicatorOperation.getHT_PHASOR("VOD.L", TimeInterval.DAILY, SeriesType.high);
            assertEquals(4487, indicatorMap.size());
        } catch (InvalidApiKeyException ex1) {
            ex1.printStackTrace();
            fail("Invalid Api Key Exception");
        } catch (InvalidFunctionOptionException ex2) {
            ex2.printStackTrace();
            fail("Required Function Properties Missing or is Invalid in Exception");
        } catch (MalFormattedFunctionException ex3) {
            ex3.printStackTrace();
            fail("Invalid Function Exception");
        } catch (MissingApiKeyException ex4) {
            ex4.printStackTrace();
            fail("Missing Api Key Exception");
        } catch (UltraHighFrequencyRequestException ex5) {
            ex5.printStackTrace();
            fail("Ultra High Frequency Request Exception");
        }
    }
}
