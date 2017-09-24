package com.alpha_vantage.api.domain;

import java.io.Serializable;

public class Stock implements Serializable{
    private String symbol;
    private String open;
    private String high;
    private String low;
    private String close;
    private String volume;

    private String adjustedClose;
    private String dividendAmount;
    private String splitCoefficient;


    private Stock(String symbol, String open, String high, String low, String close, String volume){
        this.symbol = symbol;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }


    public static Stock newStpckInstance(String symbol, String open, String  high, String low, String close, String volume) {
        return new Stock(symbol, open, high, low, close, volume);
    }


    private Stock(String name, String symbol, String open, String high, String low, String close, String volume, String adjustedClose, String dividendAmount, String splitCoefficient){
        this.symbol = symbol;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.adjustedClose = adjustedClose;
        this.dividendAmount = dividendAmount;
        this.splitCoefficient = splitCoefficient;
    }


    public static Stock newStpckInstance(String name, String symbol, String open, String high, String low, String close, String volume, String adjustedClose, String dividendAmount, String splitCoefficient) {
        return new Stock(name, symbol, open, high, low, close, volume, adjustedClose, dividendAmount, splitCoefficient);
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getAdjustedClose() {
        return adjustedClose;
    }

    public void setAdjustedClose(String adjustedClose) {
        this.adjustedClose = adjustedClose;
    }

    public String getDividendAmount() {
        return dividendAmount;
    }

    public void setDividendAmount(String dividendAmount) {
        this.dividendAmount = dividendAmount;
    }

    public String getSplitCoefficient() {
        return splitCoefficient;
    }

    public void setSplitCoefficient(String splitCoefficient) {
        this.splitCoefficient = splitCoefficient;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Symbol: ").append(symbol).append(", ");
        sb.append("High: ").append(high).append(", ");
        sb.append("Open: ").append(open).append(", ");
        sb.append("Low: ").append(low).append(", ");
        sb.append("Close: ").append(close).append(", ");
        sb.append("Open: ").append(open).append(", ");
        sb.append("Volume: ").append(volume).append(", ");
        sb.append("Adjusted Close: ").append(adjustedClose).append(", ");
        sb.append("Dividend Amount: ").append(dividendAmount).append(", ");
        sb.append("Split Coefficient: ").append(splitCoefficient);
        return sb.toString();
    }
}
