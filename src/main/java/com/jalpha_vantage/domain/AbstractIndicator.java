package com.jalpha_vantage.domain;

import com.jalpha_vantage.enums.IndicatorType;

public class AbstractIndicator {
    private String symbol;
    private IndicatorType indicatorType;
    private String value;

    protected AbstractIndicator(String symbol, IndicatorType indicatorType, String value) {
        this.symbol = symbol;
        this.indicatorType = indicatorType;
        this.value = value;
    }

    public static AbstractIndicator newInstance(String symbol, IndicatorType indicatorType, String value) {
        return new AbstractIndicator(symbol, indicatorType, value);
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public IndicatorType getIndicatorType() {
        return indicatorType;
    }

    public void setIndicatorType(IndicatorType indicatorType) {
        this.indicatorType = indicatorType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Symbol: ").append(symbol).append(", ").append(", ")
                .append("Value: ").append(value).append(", ")
                .append("Technical Indicator: ").append(indicatorType.name());
        return sb.toString();
    }
}
