package com.alpha_vantage.api.domain;

import com.alpha_vantage.api.enums.IndicatorType;

public class BbandsIndicator {
    private String symbol;
    private String realUpperBand;
    private String realLowerBand;
    private String realMiddleBand;


    protected BbandsIndicator(String symbol, String realLowerBand, String realMiddleBand, String realUpperBand) {
        this.symbol = symbol;
        this.realUpperBand = realUpperBand;
        this.realLowerBand = realLowerBand;
        this.realMiddleBand = realMiddleBand;

    }

    public static BbandsIndicator newInstance(String symbol, String realLowerBand, String realMiddleBand, String realUpperBand) {
        return new BbandsIndicator(symbol, realLowerBand, realMiddleBand, realUpperBand);
    }

    public String getRealUpperBand() {
        return realUpperBand;
    }

    public void setRealUpperBand(String realUpperBand) {
        this.realUpperBand = realUpperBand;
    }

    public String getRealLowerBand() {
        return realLowerBand;
    }

    public void setRealLowerBand(String realLowerBand) {
        this.realLowerBand = realLowerBand;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getRealMiddleBand() {
        return realMiddleBand;
    }

    public void setRealMiddleBand(String realMiddleBand) {
        this.realMiddleBand = realMiddleBand;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Symbol: ").append(getSymbol()).append(", ").append(", ")
                .append("Real Upper Band: ").append(realUpperBand).append(", ")
                .append("Real Middle Band: ").append(getRealMiddleBand()).append(", ")
                .append("Real Lower Band: ").append(realLowerBand);

        return sb.toString();
    }
}
