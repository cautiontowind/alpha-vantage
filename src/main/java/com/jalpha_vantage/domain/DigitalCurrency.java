package com.jalpha_vantage.domain;

import com.jalpha_vantage.enums.CryptoSymbol;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.time.LocalDate;
import java.time.ZonedDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class DigitalCurrency {
    protected CryptoSymbol symbol;
    protected String market;
    protected double volume;
    protected double marketCap;


    public static DigitalCurrencyDaily daily(CryptoSymbol symbol, String market, double open, double usdOpen, double high, double usdHigh, double low, double usdLow, double close, double usdClose, double volume, double marketCap, LocalDate date) {
        return new DigitalCurrencyDaily(symbol,market,open,usdOpen,high,usdHigh,low,usdLow,close,usdClose,volume,marketCap,date);
    }

    public static DigitalCurrencyIntraDay intraDay(CryptoSymbol symbol, String market, double price, double usdPrice, double volume, double marketCap, ZonedDateTime dateTime) {
        return new DigitalCurrencyIntraDay(symbol, market, price, usdPrice, volume, marketCap,dateTime);
    }
}
