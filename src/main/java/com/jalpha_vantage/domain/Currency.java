package com.jalpha_vantage.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class Currency {
    String fromCurrencyCode;
    String fromCurrencyName;
    String toCurrencyCode;
    String toCurrencyName;
    double exchangeRate;
    LocalDateTime lastRefreshed;
    String timeZone;

    private Currency(String fromCurrencyCode, String fromCurrencyName, String toCurrencyCode, String toCurrencyName, double exchangeRate,
                     LocalDateTime lastRefreshed, String timeZone) {
        this.fromCurrencyCode = fromCurrencyCode;
        this.fromCurrencyName = fromCurrencyName;
        this.toCurrencyCode = toCurrencyCode;
        this.toCurrencyName = toCurrencyName;
        this.exchangeRate = exchangeRate;
        this.lastRefreshed = lastRefreshed;
        this.timeZone = timeZone;
    }

    public static Currency newCurrencyInstance(String fromCurrencyCode, String fromCurrencyName, String toCurrencyCode, String toCurrencyName, double exchangeRate,
                                               LocalDateTime lastRefreshed, String timeZone) {
        return new Currency(fromCurrencyCode, fromCurrencyName, toCurrencyCode, toCurrencyName, exchangeRate,
                lastRefreshed, timeZone);
    }


}
