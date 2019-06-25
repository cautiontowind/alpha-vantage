package com.jalpha_vantage.domain;

import com.jalpha_vantage.enums.CryptoSymbol;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
public class DigitalCurrencyIntraDay extends DigitalCurrency {
    String price;
    String usdPrice;
    LocalDateTime dateTime;

    protected DigitalCurrencyIntraDay(CryptoSymbol symbol, String market, String price, String usdPrice, String volume, String marketCap, LocalDateTime dateTime) {
        this.symbol = symbol;
        this.market = market;
        this.price = price;
        this.usdPrice = usdPrice;
        this.volume = volume;
        this.marketCap = marketCap;
        this.dateTime = dateTime;
    }





}
