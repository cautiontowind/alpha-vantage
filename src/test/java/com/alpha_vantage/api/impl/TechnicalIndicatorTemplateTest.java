package com.alpha_vantage.api.impl;

import com.alpha_vantage.api.domain.*;
import com.alpha_vantage.api.enums.SeriesType;
import com.alpha_vantage.api.enums.TimeInterval;
import com.alpha_vantage.api.service.TechnicalIndicatorOperation;
import com.alpha_vantage.api.test.AbstractServiceTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TechnicalIndicatorTemplateTest extends AbstractServiceTest {
    @Autowired
    private TechnicalIndicatorOperation technicalIndicatorOperation;

    @Test
    public void testGetSMA(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getSMA("VOD.L", TimeInterval.DAILY, "60", SeriesType.close);
        assertEquals(4460, indicatorMap.size());
    }

    @Test
    public void testGetEMA(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getEMA("VOD.L", TimeInterval.DAILY, "60", SeriesType.close);
        assertEquals(4460, indicatorMap.size());
    }


    @Test
    public void testGetWMA(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getWMA("VOD.L", TimeInterval.DAILY, "60", SeriesType.close);
        assertEquals(4460, indicatorMap.size());
    }

    @Test
    public void testGetDEMA(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getDEMA("VOD.L", TimeInterval.DAILY, "60", SeriesType.close);
        assertEquals(4401, indicatorMap.size());
    }

    @Test
    public void testGetTEMA(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getTEMA("VOD.L", TimeInterval.DAILY, "60", SeriesType.close);
        assertEquals(4342, indicatorMap.size());
    }

    @Test
    public void testGetTRIMA(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getTRIMA("VOD.L", TimeInterval.DAILY, "60", SeriesType.close);
        assertEquals(4460, indicatorMap.size());
    }

    @Test
    public void testGetKAMA(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getKAMA("VOD.L", TimeInterval.DAILY, "60", SeriesType.close);
        assertEquals(4459, indicatorMap.size());
    }

    @Test
    public void testGetMAMA(){
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("fastlimit", "0.01");
        Map<LocalDate, MamaIndicator> indicatorMap = technicalIndicatorOperation.getMAMA("VOD.L", TimeInterval.DAILY, SeriesType.close, options);
        assertEquals(4487, indicatorMap.size());
    }

    @Test
    public void testGetT3(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getT3("VOD.L", TimeInterval.DAILY, "60", SeriesType.close);
        assertEquals(4165, indicatorMap.size());
    }


    @Test
    public void testGetMACD(){
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("fastlimit", "0.01");
        options.put("signalperiod", "9");
        Map<LocalDate, MacdIndicator> indicatorMap = technicalIndicatorOperation.getMACD("VOD.L", TimeInterval.DAILY, SeriesType.close, options);
        assertEquals(4486, indicatorMap.size());
    }

    @Test
    public void testGetMACDEXT(){
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("fastlimit", "0.01");
        options.put("signalperiod", "9");
        options.put("fastmatype", "1");
        Map<LocalDate, MacdIndicator> indicatorMap = technicalIndicatorOperation.getMACDEXT("VOD.L", TimeInterval.DAILY, SeriesType.close, options);
        assertEquals(4486, indicatorMap.size());
    }


    @Test
    public void testGetSTOCH(){
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("slowkperiod", "2");
        options.put("slowperiod", "2");
        options.put("slowkmatype", "1");
        Map<LocalDate, StochIndicator> indicatorMap = technicalIndicatorOperation.getSTOCH("VOD.L", TimeInterval.DAILY, options);
        assertEquals(4512, indicatorMap.size());
    }

    @Test
    public void testGetSTOCHF(){
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("fastkperiod", "2");
        options.put("fastperiod", "2");
        options.put("fastkmatype", "1");
        Map<LocalDate, StochfIndicator> indicatorMap = technicalIndicatorOperation.getSTOCHF("VOD.L", TimeInterval.DAILY, options);
        assertEquals(4516, indicatorMap.size());
    }


    @Test
    public void testGetRSI(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getRSI("VOD.L", TimeInterval.DAILY, "60", SeriesType.close);
        assertEquals(4459, indicatorMap.size());
    }


    @Test
    public void testGetSTOCHRSI(){
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("fastkperiod", "2");
        options.put("fastdperiod", "2");
        options.put("fastdmatype", "1");
        Map<LocalDate, StochfIndicator> indicatorMap = technicalIndicatorOperation.getSTOCHRSI("VOD.L", TimeInterval.DAILY, "60",SeriesType.close, options);
        assertEquals(4457, indicatorMap.size());
    }

    @Test
    public void testGetWILLR(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getWILLR("VOD.L", TimeInterval.DAILY, "60");
        assertEquals(4460, indicatorMap.size());
    }

    @Test
    public void testGetADX(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getADX("VOD.L", TimeInterval.DAILY, "60");
        assertEquals(4400, indicatorMap.size());
    }

    @Test
    public void testGetADXR(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getADXR("VOD.L", TimeInterval.DAILY, "60");
        assertEquals(4341, indicatorMap.size());
    }


    @Test
    public void testGetAPO(){
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("fastkperiod", "2");
        options.put("slowperiod", "22");
        options.put("matype", "1");
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getAPO("VOD.L", TimeInterval.DAILY, SeriesType.close, options);
        assertEquals(4498, indicatorMap.size());
    }

    @Test
    public void testGetPPO(){
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("fastkperiod", "2");
        options.put("slowperiod", "22");
        options.put("matype", "1");
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getPPO("VOD.L", TimeInterval.DAILY, SeriesType.close, options);
        assertEquals(4498, indicatorMap.size());
    }

    @Test
    public void testGetMOM(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getMOM("VOD.L", TimeInterval.DAILY, "60", SeriesType.close);
        assertEquals(4459, indicatorMap.size());
    }

    @Test
    public void testGetBOP(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getBOP("VOD.L", TimeInterval.DAILY);
        assertEquals(4519, indicatorMap.size());
    }

    @Test
    public void testGetCCI(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getCCI("VOD.L", TimeInterval.DAILY, "60");
        assertEquals(4460, indicatorMap.size());
    }

    @Test
    public void testGetCMO(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getCMO("VOD.L", TimeInterval.DAILY, "60", SeriesType.high);
        assertEquals(4459, indicatorMap.size());
    }


    @Test
    public void testGetROC(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getROC("VOD.L", TimeInterval.DAILY, "60", SeriesType.high);
        assertEquals(4459, indicatorMap.size());
    }

    @Test
    public void testGetROCR(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getROCR("VOD.L", TimeInterval.DAILY, "60", SeriesType.high);
        assertEquals(4459, indicatorMap.size());
    }


    @Test
    public void testGetAROON(){
        Map<LocalDate, AroonIndicator> indicatorMap = technicalIndicatorOperation.getAROON("VOD.L", TimeInterval.DAILY, "60");
        assertEquals(4459, indicatorMap.size());
    }

    @Test
    public void testGetAROONOSC(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getAROONOSC("VOD.L", TimeInterval.DAILY, "60");
        assertEquals(4459, indicatorMap.size());
    }

    @Test
    public void testGetMFI(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getMFI("VOD.L", TimeInterval.DAILY, "60");
        assertEquals(4459, indicatorMap.size());
    }

    @Test
    public void testGetTRIX(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getTRIX("VOD.L", TimeInterval.DAILY, "60",SeriesType.high);
        assertEquals(4341, indicatorMap.size());
    }


    @Test
    public void testGetULTOSC(){

        HashMap<String, String> options = new HashMap<String, String>();
        options.put("timeperiod1", "1");
        options.put("timeperiod2", "7");
        options.put("timeperiod3", "14");
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getULTOSC("VOD.L", TimeInterval.DAILY, "60",options);
        assertEquals(4505, indicatorMap.size());
    }

    @Test
    public void testGetDX(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getDX("VOD.L", TimeInterval.DAILY, "60");
        assertEquals(4491, indicatorMap.size());
    }

    @Test
    public void testGetMINUS_DI(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getMINUS_DI("VOD.L", TimeInterval.DAILY, "60");
        assertEquals(4459, indicatorMap.size());
    }

    @Test
    public void testGetPLUS_DI(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getPLUS_DI("VOD.L", TimeInterval.DAILY, "60");
        assertEquals(4459, indicatorMap.size());
    }

    @Test
    public void testGetMINUS_DM(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getMINUS_DM("VOD.L", TimeInterval.DAILY, "60");
        assertEquals(4460, indicatorMap.size());
    }

    @Test
    public void testGetPLUD_DM(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getPLUS_DM("VOD.L", TimeInterval.DAILY, "60");
        assertEquals(4460, indicatorMap.size());
    }

    @Test
    public void testGetBBANDS(){
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("nbdevup", "2");
        options.put("nbdevdn", "2");
        options.put("matype", "8");
        Map<LocalDate, BbandsIndicator> indicatorMap = technicalIndicatorOperation.getBBANDS("VOD.L", TimeInterval.DAILY, "60",SeriesType.high,options);
        assertEquals(4165, indicatorMap.size());
    }

    @Test
    public void testGetMIDPOINT(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getMIDPOINT("VOD.L", TimeInterval.DAILY, "60", SeriesType.high);
        assertEquals(4460, indicatorMap.size());
    }

    @Test
    public void testGetMIDPRICE(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getMIDPRICE("VOD.L", TimeInterval.DAILY, "60");
        assertEquals(4460, indicatorMap.size());
    }


    @Test
    public void testGetSAR(){
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("acceleration", "0.01");
        options.put("maximum", "0.20");
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getSAR("VOD.L", TimeInterval.DAILY, options);
        assertEquals(4518, indicatorMap.size());
    }
    @Test
    public void testGetTRANGE(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getTRANGE("VOD.L", TimeInterval.DAILY);
        assertEquals(4518, indicatorMap.size());
    }

    @Test
    public void testGetATR(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getATR("VOD.L", TimeInterval.DAILY, "60");
        assertEquals(4459, indicatorMap.size());
    }


    @Test
    public void testGetNATR(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getNATR("VOD.L", TimeInterval.DAILY, "60");
        assertEquals(4459, indicatorMap.size());
    }

    @Test
    public void testGetAD(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getAD("VOD.L", TimeInterval.DAILY);
        assertEquals(4519, indicatorMap.size());
    }

    @Test
    public void testGetADOSC(){
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("fastperiod", "2");
        options.put("slowperiod", "9");
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getADOSC("VOD.L", TimeInterval.DAILY,options);
        assertEquals(4511, indicatorMap.size());
    }

    @Test
    public void testGetOBV(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getOBV("VOD.L", TimeInterval.DAILY);
        assertEquals(4519, indicatorMap.size());
    }

    @Test
    public void testGetHT_TRENDLINE(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getHT_TRENDLINE("VOD.L", TimeInterval.DAILY, SeriesType.high);
        assertEquals(4456, indicatorMap.size());
    }

    @Test
    public void testGetHT_SINE(){
        Map<LocalDate, HtSineIndicator> indicatorMap = technicalIndicatorOperation.getHT_SINE("VOD.L", TimeInterval.DAILY, SeriesType.high);
        assertEquals(4456, indicatorMap.size());
    }

    @Test
    public void testGetTRENDMODE(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getHT_TRENDMODE("VOD.L", TimeInterval.DAILY, SeriesType.high);
        assertEquals(4519, indicatorMap.size());
    }

    @Test
    public void testGetHT_DCPERIOD(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getHT_DCPERIOD("VOD.L", TimeInterval.DAILY, SeriesType.high);
        assertEquals(4487, indicatorMap.size());
    }

    @Test
    public void testGetHT_DCPHASE(){
        Map<LocalDate, AbstractIndicator> indicatorMap = technicalIndicatorOperation.getHT_DCPHASE("VOD.L", TimeInterval.DAILY, SeriesType.high);
        assertEquals(4456, indicatorMap.size());
    }


    @Test
    public void testGetHT_PHASOR(){
        Map<LocalDate, HtPhasorIndicator> indicatorMap = technicalIndicatorOperation.getHT_PHASOR("VOD.L", TimeInterval.DAILY, SeriesType.high);
        assertEquals(4487, indicatorMap.size());
    }
/**
    @Test
    public void testGetPercentChange(){
       String change = String.valueOf(technicalIndicatorOperation.getPercentChange(214.7500, 213.7500));
    //0.00467836257
       assertEquals("0.47", change);

    }
**/
    }
