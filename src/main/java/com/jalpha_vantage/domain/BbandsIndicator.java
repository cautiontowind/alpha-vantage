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
public class BbandsIndicator {
    private String symbol;
    private String realUpperBand;
    private String realLowerBand;
    private String realMiddleBand;
    private LocalDate date;

    protected BbandsIndicator(String symbol, String realLowerBand, String realMiddleBand, String realUpperBand, LocalDate date) {
        this.symbol = symbol;
        this.realUpperBand = realUpperBand;
        this.realLowerBand = realLowerBand;
        this.realMiddleBand = realMiddleBand;
        this.date = date;

    }

    public static BbandsIndicator newInstance(String symbol, String realLowerBand, String realMiddleBand, String realUpperBand, LocalDate date) {
        return new BbandsIndicator(symbol, realLowerBand, realMiddleBand, realUpperBand, date);
    }


}
