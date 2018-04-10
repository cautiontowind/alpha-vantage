package com.jalpha_vantage.domain;

import com.jalpha_vantage.enums.CryptoSymbol;

public class DigitalCurrencyDaily extends DigitalCurrency {
    String open;
    String usdOpen;
    String high;
    String usdHigh;
    String low;
    String usdLow;
    String close;
    String usdClose;


    private DigitalCurrencyDaily(CryptoSymbol symbol, String market, String open,String usdOpen, String high,String usdHigh, String low,String usdLow, String close,String usdClose, String volume, String marketCap) {
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
    }

    public static DigitalCurrencyDaily newInstance(CryptoSymbol symbol, String market, String open,String usdOpen, String high,String usdHigh, String low, String usdLow, String close, String usdClose, String volume, String marketCap) {
        return new DigitalCurrencyDaily(symbol, market, open,usdOpen,high, usdHigh ,low,usdLow, close, usdClose, volume, marketCap);
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getUsdOpen() {
        return usdOpen;
    }

    public void setUsdOpen(String usdOpen) {
        this.usdOpen = usdOpen;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getUsdHigh() {
        return usdHigh;
    }

    public void setUsdHigh(String usdHigh) {
        this.usdHigh = usdHigh;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getUsdLow() {
        return usdLow;
    }

    public void setUsdLow(String usdLow) {
        this.usdLow = usdLow;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getUsdClose() {
        return usdClose;
    }

    public void setUsdClose(String usdClose) {
        this.usdClose = usdClose;
    }

    public String getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(String marketCap) {
        this.marketCap = marketCap;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Symbol: ").append(symbol).append(", ");
        sb.append("Market: ").append(market).append(", ");
        sb.append("Open: ").append(open).append(", ");
        sb.append("Open (USD): ").append(usdOpen).append(", ");
        sb.append("High: ").append(high).append(", ");
        sb.append("High(USD): ").append(usdHigh).append(", ");
        sb.append("Low: ").append(low).append(", ");
        sb.append("Low (USD): ").append(usdLow);
        sb.append("Close: ").append(close).append(", ");
        sb.append("Close (USD): ").append(usdClose).append(", ");
        sb.append("Volume: ").append(volume).append(", ");
        sb.append("Market Cap (USD): ").append(marketCap);
        return sb.toString();
    }
}
