package com.jalpha_vantage.domain;

public class MacdIndicator {
    private String symbol;
    private String macd;
    private String macdSignal;
    private String macdHist;

    protected MacdIndicator(String symbol, String macd, String macdSignal, String macdHist) {
        this.symbol = symbol;
        this.macd = macd;
        this.macdSignal = macdSignal;
        this.macdHist = macdHist;
    }

    public static MacdIndicator newInstance(String symbol, String macd, String macdSignal, String macdHist) {
        return new MacdIndicator(symbol, macd, macdSignal, macdHist);
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getMacd() {
        return macd;
    }

    public void setMacd(String macd) {
        this.macd = macd;
    }

    public String getMacdSignal() {
        return macdSignal;
    }

    public void setMacdSignal(String macdSignal) {
        this.macdSignal = macdSignal;
    }

    public String getMacdHist() {
        return macdHist;
    }

    public void setMacdHist(String macdHist) {
        this.macdHist = macdHist;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Symbol: ").append(getSymbol()).append(", ").append(", ")
                .append("MACD: ").append(getMacd()).append(", ")
                .append("MACD Signal: ").append(macdSignal).append(", ")
                .append("MACD Hist: ").append(macdHist);
        return sb.toString();
    }

}
