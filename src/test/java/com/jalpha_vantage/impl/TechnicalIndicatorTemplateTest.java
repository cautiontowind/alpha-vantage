package com.jalpha_vantage.impl;

import com.jalpha_vantage.domain.*;
import com.jalpha_vantage.exception.*;
import com.jalpha_vantage.domain.*;
import com.jalpha_vantage.enums.SeriesType;
import com.jalpha_vantage.enums.TimeInterval;
import com.jalpha_vantage.exception.*;
import com.jalpha_vantage.service.ITechnicalIndicatorService;
import com.jalpha_vantage.test.AbstractServiceTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class TechnicalIndicatorTemplateTest extends AbstractServiceTest {
    @Autowired
    private ITechnicalIndicatorService technicalIndicatorOperation;

    @Test
    public void testGetSMA() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getSMA("VOD.L", TimeInterval.DAILY, "60", SeriesType.close);
            assertEquals(4460, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");
        }
    }

    @Test
    public void testGetEMA() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getEMA("VOD.L", TimeInterval.DAILY, "60", SeriesType.close);
            assertEquals(4460, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");
        }
    }


    @Test
    public void testGetWMA() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getWMA("VOD.L", TimeInterval.DAILY, "60", SeriesType.close);
            assertEquals(4460, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");
        }
    }

    @Test
    public void testGetDEMA() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getDEMA("VOD.L", TimeInterval.DAILY, "60", SeriesType.close);
            assertEquals(4401, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");
        }
    }

    @Test
    public void testGetTEMA() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getTEMA("VOD.L", TimeInterval.DAILY, "60", SeriesType.close);
            assertEquals(4342, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");
        }
    }

    @Test
    public void testGetTRIMA() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getTRIMA("VOD.L", TimeInterval.DAILY, "60", SeriesType.close);
            assertEquals(4460, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");}
    }

    @Test
    public void testGetKAMA() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getKAMA("VOD.L", TimeInterval.DAILY, "60", SeriesType.close);
            assertEquals(4459, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");
        }
    }

    @Test
    public void testGetMAMA() {
        try {
            HashMap<String, String> options = new HashMap<String, String>();
            options.put("fastlimit", "0.01");
            List<MamaIndicator> indicatorList = technicalIndicatorOperation.getMAMA("VOD.L", TimeInterval.DAILY, SeriesType.close, options);
            assertEquals(4487, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");
        }
    }

    @Test
    public void testGetT3() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getT3("VOD.L", TimeInterval.DAILY, "60", SeriesType.close);
            assertEquals(4165, indicatorList.size());

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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");
        }
    }


    @Test
    public void testGetMACD() {

        HashMap<String, String> options = new HashMap<String, String>();
        options.put("fastlimit", "0.01");
        options.put("signalperiod", "9");
        try {
            List<MacdIndicator> indicatorList = technicalIndicatorOperation.getMACD("VOD.L", TimeInterval.DAILY, SeriesType.close, options);
            assertEquals(4486, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
        }
    }

    @Test
    public void testGetMACDEXT() {
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("fastlimit", "0.01");
        options.put("signalperiod", "9");
        options.put("fastmatype", "1");
        try {
            List<MacdIndicator> indicatorList = technicalIndicatorOperation.getMACDEXT("VOD.L", TimeInterval.DAILY, SeriesType.close, options);
            assertEquals(4486, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");
        }
    }


    @Test
    public void testGetSTOCH() {
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("slowkperiod", "2");
        options.put("slowperiod", "2");
        options.put("slowkmatype", "1");
        try {
            List<StochIndicator> indicatorList = technicalIndicatorOperation.getSTOCH("VOD.L", TimeInterval.DAILY, options);
            assertEquals(4512, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");
        }
    }

    @Test
    public void testGetSTOCHF() {
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("fastkperiod", "2");
        options.put("fastperiod", "2");
        options.put("fastkmatype", "1");
        try {
            List<StochfIndicator> indicatorList = technicalIndicatorOperation.getSTOCHF("VOD.L", TimeInterval.DAILY, options);
            assertEquals(4516, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");
        }
    }


    @Test
    public void testGetRSI() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getRSI("VOD.L", TimeInterval.DAILY, "60", SeriesType.close);
            assertEquals(4459, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");
        }
    }


    @Test
    public void testGetSTOCHRSI() {
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("fastkperiod", "2");
        options.put("fastdperiod", "2");
        options.put("fastdmatype", "1");
        try {
            List<StochfIndicator> indicatorList = technicalIndicatorOperation.getSTOCHRSI("VOD.L", TimeInterval.DAILY, "60", SeriesType.close, options);
            assertEquals(4457, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");
        }
    }

    @Test
    public void testGetWILLR() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getWILLR("VOD.L", TimeInterval.DAILY, "60");
            assertEquals(4460, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");
        }
    }

    @Test
    public void testGetADX() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getADX("VOD.L", TimeInterval.DAILY, "60");
            assertEquals(4400, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");
        }
    }

    @Test
    public void testGetADXR() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getADXR("VOD.L", TimeInterval.DAILY, "60");
            assertEquals(4341, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");
        }
    }


    @Test
    public void testGetAPO() {
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("fastkperiod", "2");
        options.put("slowperiod", "22");
        options.put("matype", "1");
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getAPO("VOD.L", TimeInterval.DAILY, SeriesType.close, options);
            assertEquals(4498, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");
        }
    }

    @Test
    public void testGetPPO() {
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("fastkperiod", "2");
        options.put("slowperiod", "22");
        options.put("matype", "1");
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getPPO("VOD.L", TimeInterval.DAILY, SeriesType.close, options);
            assertEquals(4498, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");
        }
    }

    @Test
    public void testGetMOM() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getMOM("VOD.L", TimeInterval.DAILY, "60", SeriesType.close);
            assertEquals(4459, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");
        }
    }

    @Test
    public void testGetBOP() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getBOP("VOD.L", TimeInterval.DAILY);
            assertEquals(4519, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");
        }
    }

    @Test
    public void testGetCCI() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getCCI("VOD.L", TimeInterval.DAILY, "60");
            assertEquals(4460, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");}
    }

    @Test
    public void testGetCMO() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getCMO("VOD.L", TimeInterval.DAILY, "60", SeriesType.high);
            assertEquals(4459, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");
        }
    }


    @Test
    public void testGetROC() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getROC("VOD.L", TimeInterval.DAILY, "60", SeriesType.high);
            assertEquals(4459, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");
        }
    }

    @Test
    public void testGetROCR() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getROCR("VOD.L", TimeInterval.DAILY, "60", SeriesType.high);
            assertEquals(4459, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");
        }
    }


    @Test
    public void testGetAROON() {
        try {
            List<AroonIndicator> indicatorList = technicalIndicatorOperation.getAROON("VOD.L", TimeInterval.DAILY, "60");
            assertEquals(4459, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");}
    }

    @Test
    public void testGetAROONOSC() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getAROONOSC("VOD.L", TimeInterval.DAILY, "60");
            assertEquals(4459, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");
        }
    }

    @Test
    public void testGetMFI() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getMFI("VOD.L", TimeInterval.DAILY, "60");
            assertEquals(4459, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");}
    }

    @Test
    public void testGetTRIX() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getTRIX("VOD.L", TimeInterval.DAILY, "60", SeriesType.high);
            assertEquals(4341, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");}
    }


    @Test
    public void testGetULTOSC() {

        HashMap<String, String> options = new HashMap<String, String>();
        options.put("timeperiod1", "1");
        options.put("timeperiod2", "7");
        options.put("timeperiod3", "14");
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getULTOSC("VOD.L", TimeInterval.DAILY, "60", options);
            assertEquals(4505, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");}
    }

    @Test
    public void testGetDX() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getDX("VOD.L", TimeInterval.DAILY, "60");
            assertEquals(4491, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");}
    }

    @Test
    public void testGetMINUS_DI() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getMINUS_DI("VOD.L", TimeInterval.DAILY, "60");
            assertEquals(4459, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");}
    }

    @Test
    public void testGetPLUS_DI() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getPLUS_DI("VOD.L", TimeInterval.DAILY, "60");
            assertEquals(4459, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");}
    }

    @Test
    public void testGetMINUS_DM() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getMINUS_DM("VOD.L", TimeInterval.DAILY, "60");
            assertEquals(4460, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");}
    }

    @Test
    public void testGetPLUD_DM() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getPLUS_DM("VOD.L", TimeInterval.DAILY, "60");
            assertEquals(4460, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");}
    }

    @Test
    public void testGetBBANDS() {
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("nbdevup", "2");
        options.put("nbdevdn", "2");
        options.put("matype", "8");
        try {
            List<BbandsIndicator> indicatorList = technicalIndicatorOperation.getBBANDS("VOD.L", TimeInterval.DAILY, "60", SeriesType.high, options);
            assertEquals(4165, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");}
    }

    @Test
    public void testGetMIDPOINT() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getMIDPOINT("VOD.L", TimeInterval.DAILY, "60", SeriesType.high);
            assertEquals(4460, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");}
    }

    @Test
    public void testGetMIDPRICE() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getMIDPRICE("VOD.L", TimeInterval.DAILY, "60");
            assertEquals(4460, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");}
    }


    @Test
    public void testGetSAR() {
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("acceleration", "0.01");
        options.put("maximum", "0.20");
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getSAR("VOD.L", TimeInterval.DAILY, options);
            assertEquals(4518, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");}
    }

    @Test
    public void testGetTRANGE() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getTRANGE("VOD.L", TimeInterval.DAILY);
            assertEquals(4518, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");}
    }

    @Test
    public void testGetATR() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getATR("VOD.L", TimeInterval.DAILY, "60");
            assertEquals(4459, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");}
    }


    @Test
    public void testGetNATR() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getNATR("VOD.L", TimeInterval.DAILY, "60");
            assertEquals(4459, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");}
    }

    @Test
    public void testGetAD() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getAD("VOD.L", TimeInterval.DAILY);
            assertEquals(4519, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");}
    }

    @Test
    public void testGetADOSC() {
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("fastperiod", "2");
        options.put("slowperiod", "9");
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getADOSC("VOD.L", TimeInterval.DAILY, options);
            assertEquals(4511, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");}
    }

    @Test
    public void testGetOBV() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getOBV("VOD.L", TimeInterval.DAILY);
            assertEquals(4519, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");}
    }

    @Test
    public void testGetHT_TRENDLINE() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getHT_TRENDLINE("VOD.L", TimeInterval.DAILY, SeriesType.high);
            assertEquals(4456, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");}
    }

    @Test
    public void testGetHT_SINE() {
        try {
            List<HtSineIndicator> indicatorList = technicalIndicatorOperation.getHT_SINE("VOD.L", TimeInterval.DAILY, SeriesType.high);
            assertEquals(4456, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");}
    }

    @Test
    public void testGetTRENDMODE() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getHT_TRENDMODE("VOD.L", TimeInterval.DAILY, SeriesType.high);
            assertEquals(4519, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");}
    }

    @Test
    public void testGetHT_DCPERIOD() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getHT_DCPERIOD("VOD.L", TimeInterval.DAILY, SeriesType.high);
            assertEquals(4487, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");}
    }

    @Test
    public void testGetHT_DCPHASE() {
        try {
            List<AbstractIndicator> indicatorList = technicalIndicatorOperation.getHT_DCPHASE("VOD.L", TimeInterval.DAILY, SeriesType.high);
            assertEquals(4456, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");}
    }


    @Test
    public void testGetHT_PHASOR() {
        try {
            List<HtPhasorIndicator> indicatorList = technicalIndicatorOperation.getHT_PHASOR("VOD.L", TimeInterval.DAILY, SeriesType.high);
            assertEquals(4487, indicatorList.size());
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
        } catch (ApiLimitExceeded apiLimitExceeded) {
            apiLimitExceeded.printStackTrace();
            fail("Exceeded Api Limit");}
    }
}
