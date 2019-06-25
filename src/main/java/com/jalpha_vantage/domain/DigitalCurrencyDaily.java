package com.jalpha_vantage.domain;

import com.jalpha_vantage.enums.CryptoSymbol;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@Getter
@Setter
@ToString(callSuper = true)
public class DigitalCurrencyDaily extends DigitalCurrency {
    String open;
    String usdOpen;
    String high;
    String usdHigh;
    String low;
    String usdLow;
    String close;
    String usdClose;
    LocalDate date;


    protected DigitalCurrencyDaily(CryptoSymbol symbol, String market, String open,String usdOpen, String high,String usdHigh, String low,String usdLow, String close,String usdClose, String volume, String marketCap, LocalDate date) {
        this.symbol = symbol;
        this.market = market;
        this.open = open;
        this.usdOpen = usdOpen;
        this.high = high;
        this.usdHigh = usdHigh;
        this.low = low;
        this.usdLow = usdLow;
        this.close = close;
        this.usdClose = usdClose;
        this.volume = volume;
        this.marketCap = marketCap;
        this.date = date;
    }

}
