package com.jalpha_vantage.domain;

public class Currency {
    String fromCurrencyCode;
    String fromCurrencyName;
    String toCurrencyCode;
    String toCurrencyName;
    String exchangeRate;
    String lastRefreshed;
    String timeZone;

    private Currency(String fromCurrencyCode, String fromCurrencyName, String toCurrencyCode, String toCurrencyName, String exchangeRate,
                     String lastRefreshed, String timeZone) {
        this.fromCurrencyCode = fromCurrencyCode;
        this.fromCurrencyName = fromCurrencyName;
        this.toCurrencyCode = toCurrencyCode;
        this.toCurrencyName = toCurrencyName;
        this.exchangeRate = exchangeRate;
        this.lastRefreshed = lastRefreshed;
        this.timeZone = timeZone;
    }

    public static Currency newCurrencyInstance(String fromCurrencyCode, String fromCurrencyName, String toCurrencyCode, String toCurrencyName, String exchangeRate,
                                               String lastRefreshed, String timeZone) {
        return new Currency(fromCurrencyCode, fromCurrencyName, toCurrencyCode, toCurrencyName, exchangeRate,
                lastRefreshed, timeZone);
    }

    public String getFromCurrencyCode() {
        return fromCurrencyCode;
    }

    public void setFromCurrencyCode(String fromCurrencyCode) {
        this.fromCurrencyCode = fromCurrencyCode;
    }

    public String getFromCurrencyName() {
        return fromCurrencyName;
    }

    public void setFromCurrencyName(String fromCurrencyName) {
        this.fromCurrencyName = fromCurrencyName;
    }

    public String getToCurrencyCode() {
        return toCurrencyCode;
    }

    public void setToCurrencyCode(String toCurrencyCode) {
        this.toCurrencyCode = toCurrencyCode;
    }

    public String getToCurrencyName() {
        return toCurrencyName;
    }

    public void setToCurrencyName(String toCurrencyName) {
        this.toCurrencyName = toCurrencyName;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getLastRefreshed() {
        return lastRefreshed;
    }

    public void setLastRefreshed(String lastRefreshed) {
        this.lastRefreshed = lastRefreshed;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("From_Currency Code: ").append(fromCurrencyCode).append(", ");
        sb.append("From_Currency Name: ").append(fromCurrencyName).append(", ");
        sb.append("To_Currency Code: ").append(toCurrencyCode).append(", ");
        sb.append("To_Currency Name: ").append(toCurrencyName).append(", ");
        sb.append("Exchange Rate: ").append(exchangeRate).append(", ");
        sb.append("Last Refreshed: ").append(lastRefreshed).append(", ");
        sb.append("Time Zone: ").append(timeZone);
        return sb.toString();
    }
}
