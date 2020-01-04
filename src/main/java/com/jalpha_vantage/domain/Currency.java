package com.jalpha_vantage.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Currency {
    String fromCurrencyCode;
    String fromCurrencyName;
    String toCurrencyCode;
    String toCurrencyName;
    double exchangeRate;
    ZonedDateTime lastRefreshed;
    String timeZone;

    private Currency(String fromCurrencyCode, String fromCurrencyName, String toCurrencyCode, String toCurrencyName, double exchangeRate,
                     ZonedDateTime lastRefreshed, String timeZone) {
        this.fromCurrencyCode = fromCurrencyCode;
        this.fromCurrencyName = fromCurrencyName;
        this.toCurrencyCode = toCurrencyCode;
        this.toCurrencyName = toCurrencyName;
        this.exchangeRate = exchangeRate;
        this.lastRefreshed = lastRefreshed;
        this.timeZone = timeZone;
    }

    public static Currency newCurrencyInstance(String fromCurrencyCode, String fromCurrencyName, String toCurrencyCode, String toCurrencyName, double exchangeRate,
                                               ZonedDateTime lastRefreshed, String timeZone) {
        return new Currency(fromCurrencyCode, fromCurrencyName, toCurrencyCode, toCurrencyName, exchangeRate,
                lastRefreshed, timeZone);
    }


}
