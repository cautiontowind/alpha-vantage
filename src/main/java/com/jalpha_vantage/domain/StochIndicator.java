package com.jalpha_vantage.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class StochIndicator {
    private String symbol;
    private String slowK;
    private String slowD;
    private LocalDate date;

    protected StochIndicator(String symbol, String slowK, String slowD, LocalDate date) {
        this.symbol = symbol;
        this.slowK = slowK;
        this.slowD = slowD;
        this.date = date;
    }

    public static StochIndicator newInstance(String symbol, String slowK, String slowD, LocalDate date) {
        return new StochIndicator(symbol, slowK, slowD, date);
    }


}
