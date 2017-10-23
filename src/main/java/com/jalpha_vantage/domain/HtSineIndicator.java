package com.jalpha_vantage.domain;

public class HtSineIndicator {
    private String symbol;
    private String sine;
    private String leadSine;

    private HtSineIndicator(String symbol, String sine, String leadSine) {
        this.symbol = symbol;
        this.sine = sine;
        this.leadSine = leadSine;
    }

    public static HtSineIndicator newInstance(String symbol, String sine, String leadSine) {
        return new HtSineIndicator(symbol, sine, leadSine);
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSine() {
        return sine;
    }

    public void setSine(String sine) {
        this.sine = sine;
    }

    public String getLeadSine() {
        return leadSine;
    }

    public void setLeadSine(String leadSine) {
        this.leadSine = leadSine;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Symbol: ").append(getSymbol()).append(", ").append(", ")
                .append("Since: ").append(getSine()).append(", ")
                .append("Lead Sine: ").append(leadSine);
        return sb.toString();
    }
}
