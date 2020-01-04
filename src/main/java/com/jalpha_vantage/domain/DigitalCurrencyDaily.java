package com.jalpha_vantage.domain;

import com.jalpha_vantage.enums.CryptoSymbol;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode
public class DigitalCurrencyDaily extends DigitalCurrency {
    double open;
    double usdOpen;
    double high;
    double usdHigh;
    double low;
    double usdLow;
    double close;
    double usdClose;
    LocalDate date;


    protected DigitalCurrencyDaily(CryptoSymbol symbol, String market, double open, double usdOpen, double high, double usdHigh, double low, double usdLow, double close, double usdClose, double volume, double marketCap, LocalDate date) {
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
