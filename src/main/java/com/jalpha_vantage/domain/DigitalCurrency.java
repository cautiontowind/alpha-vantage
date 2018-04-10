package com.jalpha_vantage.domain;

import com.jalpha_vantage.enums.CryptoSymbol;

public class DigitalCurrency {
    protected CryptoSymbol symbol;
    protected String market;
    protected String volume;
    protected String marketCap;

    public CryptoSymbol getSymbol() {
        return symbol;
    }

    public void setSymbol(CryptoSymbol symbol) {
        this.symbol = symbol;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }


    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
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
        sb.append("Volume: ").append(volume);
        sb.append("Market Cap (USD) ").append(marketCap);
        return sb.toString();
    }
}
