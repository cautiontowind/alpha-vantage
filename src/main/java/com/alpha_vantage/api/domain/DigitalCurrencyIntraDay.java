package com.alpha_vantage.api.domain;

public class DigitalCurrencyIntraDay extends DigitalCurrency{
    String priceA;
    String priceB;

    private DigitalCurrencyIntraDay(String symbol, String market, String priceA, String volumeA, String priceB, String volumeB){
        this.symbol = symbol;
        this.market = market;
        this.priceA = priceA;
        this.priceB = priceB;
        this.volumeA = volumeA;
        this.volumeB = volumeB;
    }

    public static DigitalCurrency newInstance(String symbol, String market, String priceA, String volumeA, String priceB, String volumeB) {
        return new DigitalCurrencyIntraDay(symbol, market, priceA, volumeA, priceB, volumeB);
    }

    public String getPriceA() {
        return priceA;
    }

    public void setPriceA(String priceA) {
        this.priceA = priceA;
    }

    public String getPriceB() {
        return priceB;
    }

    public void setPriceB(String priceB) {
        this.priceB = priceB;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Symbol: ").append(symbol).append(", ");
        sb.append("Market: ").append(market).append(", ");
        sb.append("Price A: ").append(priceA).append(", ");
        sb.append("Volume A: ").append(volumeA).append(", ");
        sb.append("Price B: ").append(priceB).append(", ");
        sb.append("Volume B: ").append(volumeB);
        return sb.toString();
    }

}
