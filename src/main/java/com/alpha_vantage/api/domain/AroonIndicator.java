package com.alpha_vantage.api.domain;

import com.alpha_vantage.api.enums.IndicatorType;

public class AroonIndicator{
    private String symbol;
    private String aroonDown;
    private String aroonUp;


    private AroonIndicator(String symbol, String aroonUp, String aroonDown) {
        this.symbol = symbol;
        this.aroonUp = aroonUp;
        this.aroonDown = aroonDown;
    }

    public static AroonIndicator newInstance(String symbol, String aroonUp, String aroonDown) {
       return new AroonIndicator(symbol,aroonUp,aroonDown);
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getAroonUp() {
        return aroonUp;
    }

    public void setAroonUp(String aroonUp) {
        this.aroonUp = aroonUp;
    }

    public String getAroonDown() {
        return aroonDown;
    }

    public void setAroonDown(String aroonDown) {
        this.aroonDown = aroonDown;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Symbol: ").append(getSymbol()).append(", ").append(", ")
                .append("Arron Up: ").append(getAroonUp()).append(", ")
                .append("Arronn Down: ").append(aroonDown);
        return sb.toString();
    }
}
