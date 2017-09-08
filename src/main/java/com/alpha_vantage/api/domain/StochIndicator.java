package com.alpha_vantage.api.domain;

import com.alpha_vantage.api.enums.IndicatorType;

public class StochIndicator {
    private String symbol;
    private String slowK;
    private String slowD;

    protected StochIndicator(String symbol, String slowK, String slowD) {
        this.symbol = symbol;
        this.slowK = slowK;
        this.slowD = slowD;
    }

    public static StochIndicator newInstance(String symbol, String slowK, String slowD) {
       return  new StochIndicator(symbol, slowK, slowD);
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSlowK() {
        return slowK;
    }

    public void setSlowK(String slowK) {
        this.slowK = slowK;
    }

    public String getSlowD() {
        return slowD;
    }

    public void setSlowD(String slowD) {
        this.slowD = slowD;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Symbol: ").append(getSymbol()).append(", ").append(", ")
                .append("SlowK: ").append(getSlowK()).append(", ")
                .append("SlowD: ").append(slowD);
        return sb.toString();
    }
}
