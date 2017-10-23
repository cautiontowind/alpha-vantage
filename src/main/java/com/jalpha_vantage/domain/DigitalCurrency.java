package com.jalpha_vantage.domain;

import com.jalpha_vantage.enums.CryptoSymbol;

public class DigitalCurrency {
    protected CryptoSymbol symbol;
    protected String market;
    protected String volume;

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

    public void setVolumeA(String volume) {
        this.volume = volume;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Symbol: ").append(symbol).append(", ");
        sb.append("Market: ").append(market).append(", ");
        sb.append("Volume A: ").append(volume);
        return sb.toString();
    }
}
