package com.jalpha_vantage.domain;

import com.jalpha_vantage.enums.CryptoSymbol;

public class DigitalCurrencyIntraDay extends DigitalCurrency {
    String price;
    String usdPrice;

    private DigitalCurrencyIntraDay(CryptoSymbol symbol, String market, String price, String usdPrice, String volume) {
        this.symbol = symbol;
        this.market = market;
        this.price = price;
        this.usdPrice = usdPrice;
        this.volume = volume;
    }

    public static DigitalCurrency newInstance(CryptoSymbol symbol, String market, String price, String usdPrice, String volume) {
        return new DigitalCurrencyIntraDay(symbol, market, price, usdPrice, volume);
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUsdPrice() {
        return usdPrice;
    }

    public void setUsdPrice(String usdPice) {
        this.usdPrice = usdPice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Symbol: ").append(symbol).append(", ");
        sb.append("Market: ").append(market).append(", ");
        sb.append("Price: ").append(price).append(", ");
        sb.append("Price (USD): ").append(price).append(", ");
        sb.append("Volume: ").append(volume).append(", ");
        return sb.toString();
    }

}
