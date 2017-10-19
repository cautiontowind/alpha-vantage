package com.zirxin.jalpha_vantage.domain;

public class DigitalCurrencyDaily extends DigitalCurrency {
    String openA;
    String openB;
    String highA;
    String highB;
    String lowA;
    String lowB;
    String closeA;
    String closeB;

    private DigitalCurrencyDaily(String symbol, String market, String openA, String highA, String lowA, String closeA, String volumeA,
                                 String openB, String highB, String lowB, String closeB, String volumeB) {
        this.symbol = symbol;
        this.market = market;
        this.openA = openA;
        this.highA = highA;
        this.lowA = lowA;
        this.closeA = closeA;
        this.volumeA = volumeA;
        this.volumeB = volumeB;
        this.openB = openB;
        this.highB = highB;
        this.lowB = lowB;
        this.closeB = closeB;
    }

    public static DigitalCurrencyDaily newInstance(String symbol, String market, String openA, String highA, String lowA, String closeA, String volumeA,
                                                   String openB, String highB, String lowB, String closeB, String volumeB) {
        return new DigitalCurrencyDaily(symbol, market, openA, highA, lowA, closeA, volumeA, openB, highB, lowB, closeB, volumeB);
    }

    public String getOpenA() {
        return openA;
    }

    public void setOpenA(String openA) {
        this.openA = openA;
    }

    public String getOpenB() {
        return openB;
    }

    public void setOpenB(String openB) {
        this.openB = openB;
    }

    public String getHighA() {
        return highA;
    }

    public void setHighA(String highA) {
        this.highA = highA;
    }

    public String getHighB() {
        return highB;
    }

    public void setHighB(String highB) {
        this.highB = highB;
    }

    public String getLowA() {
        return lowA;
    }

    public void setLowA(String lowA) {
        this.lowA = lowA;
    }

    public String getLowB() {
        return lowB;
    }

    public void setLowB(String lowB) {
        this.lowB = lowB;
    }

    public String getCloseA() {
        return closeA;
    }

    public void setCloseA(String closeA) {
        this.closeA = closeA;
    }

    public String getCloseB() {
        return closeB;
    }

    public void setCloseB(String closeB) {
        this.closeB = closeB;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Symbol: ").append(symbol).append(", ");
        sb.append("Market: ").append(market).append(", ");
        sb.append("Open A: ").append(openA).append(", ");
        sb.append("High A: ").append(highA).append(", ");
        sb.append("Low A: ").append(lowA).append(", ");
        sb.append("Close A: ").append(closeA).append(", ");
        sb.append("Volume A: ").append(volumeA).append(", ");
        sb.append("Volume B: ").append(volumeB).append(", ");
        sb.append("Open B: ").append(openB).append(", ");
        sb.append("High B: ").append(highB).append(", ");
        sb.append("Low B: ").append(lowB);
        return sb.toString();
    }
}
