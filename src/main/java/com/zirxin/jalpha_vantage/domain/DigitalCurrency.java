package com.zirxin.jalpha_vantage.domain;

public class DigitalCurrency {
    protected String symbol;
    protected String market;
    protected String volumeB;
    protected String volumeA;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }


    public String getVolumeA() {
        return volumeA;
    }

    public void setVolumeA(String volumeA) {
        this.volumeA = volumeA;
    }


    public String getVolumeB() {
        return volumeB;
    }

    public void setVolumeB(String volumeB) {
        this.volumeB = volumeB;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Symbol: ").append(symbol).append(", ");
        sb.append("Market: ").append(market).append(", ");
        sb.append("Volume A: ").append(volumeA).append(", ");
        sb.append("Volume B: ").append(volumeB).append(", ");
        return sb.toString();
    }
}
