package com.jalpha_vantage.domain;

import com.jalpha_vantage.enums.CryptoSymbol;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Getter
@Setter
@ToString(callSuper = true)
public class DigitalCurrencyIntraDay extends DigitalCurrency {
    double price;
    double usdPrice;
    ZonedDateTime dateTime;

    protected DigitalCurrencyIntraDay(CryptoSymbol symbol, String market, double price, double usdPrice, BigDecimal volume, BigDecimal marketCap, ZonedDateTime dateTime) {
        this.symbol = symbol;
        this.market = market;
        this.price = price;
        this.usdPrice = usdPrice;
        this.volume = volume;
        this.marketCap = marketCap;
        this.dateTime = dateTime;
    }





}
