package com.jalpha_vantage.domain;

import com.jalpha_vantage.enums.CryptoSymbol;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class DigitalCurrency {
    protected CryptoSymbol symbol;
    protected String market;
    protected BigDecimal volume;
    protected BigDecimal marketCap;


    public static DigitalCurrencyDaily daily(CryptoSymbol symbol, String market, double open, double usdOpen, double high, double usdHigh, double low, double usdLow, double close, double usdClose, BigDecimal volume, BigDecimal marketCap, LocalDate date) {
        return new DigitalCurrencyDaily(symbol,market,open,usdOpen,high,usdHigh,low,usdLow,close,usdClose,volume,marketCap,date);
    }

    public static DigitalCurrencyIntraDay intraDay(CryptoSymbol symbol, String market, double price, double usdPrice, BigDecimal volume, BigDecimal marketCap, LocalDateTime dateTime) {
        return new DigitalCurrencyIntraDay(symbol, market, price, usdPrice, volume, marketCap,dateTime);
    }
}
