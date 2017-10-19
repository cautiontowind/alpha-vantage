package com.zirxin.jalpha_vantage.domain;

public class StochfIndicator {
    private String symbol;
    private String fastK;
    private String fastD;

    protected StochfIndicator(String symbol, String fastK, String fastD) {
        this.symbol = symbol;
        this.fastK = fastK;
        this.fastD = fastD;
    }

    public static StochfIndicator newInstance(String symbol, String fastK, String fastD) {
        return new StochfIndicator(symbol, fastK, fastD);
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getFastK() {
        return fastK;
    }

    public void setFastK(String fastK) {
        this.fastK = fastK;
    }

    public String getFastD() {
        return fastD;
    }

    public void setFastD(String fastD) {
        this.fastD = fastD;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Symbol: ").append(getSymbol()).append(", ").append(", ")
                .append("FlastK: ").append(getFastK()).append(", ")
                .append("FastD: ").append(fastD);
        return sb.toString();
    }
}
