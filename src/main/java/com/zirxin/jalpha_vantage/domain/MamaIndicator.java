package com.zirxin.jalpha_vantage.domain;

public class MamaIndicator {
    private String symbol;
    private String mama;
    private String fama;

    private MamaIndicator(String symbol, String mama, String fama) {
        this.symbol = symbol;
        this.mama = mama;
        this.fama = fama;
    }

    public static MamaIndicator newInstance(String symbol, String mama, String fama) {
        return new MamaIndicator(symbol, mama, fama);
    }

    public String getFama() {
        return fama;
    }

    public void setFama(String fama) {
        this.fama = fama;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getMama() {
        return mama;
    }

    public void setMama(String mama) {
        this.mama = mama;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Symbol: ").append(getSymbol()).append(", ").append(", ")
                .append("MAMA: ").append(getMama()).append(", ")
                .append("FAMA: ").append(fama);
        return sb.toString();
    }

}
