package com.zirxin.jalpha_vantage.domain;

public class HtPhasorIndicator {
    private String symbol;
    private String quadrature;
    private String phase;

    private HtPhasorIndicator(String symbol, String quadrature, String phase) {
        this.symbol = symbol;
        this.quadrature = quadrature;
        this.phase = phase;
    }

    public static HtPhasorIndicator newInstance(String symbol, String quadrature, String phase) {
        return new HtPhasorIndicator(symbol, quadrature, phase);
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getQuadrature() {
        return quadrature;
    }

    public void setQuadrature(String quadrature) {
        this.quadrature = quadrature;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Symbol: ").append(getSymbol()).append(", ").append(", ")
                .append("QUADRATURE: ").append(quadrature).append(", ")
                .append("PHASE: ").append(phase);
        return sb.toString();
    }
}
