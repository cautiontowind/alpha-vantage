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
public class MacdIndicator {
    private String symbol;
    private String macd;
    private String macdSignal;
    private String macdHist;
    private LocalDate date;

    protected MacdIndicator(String symbol, String macd, String macdSignal, String macdHist, LocalDate date) {
        this.symbol = symbol;
        this.macd = macd;
        this.macdSignal = macdSignal;
        this.macdHist = macdHist;
        this.date = date;
    }

    public static MacdIndicator newInstance(String symbol, String macd, String macdSignal, String macdHist, LocalDate date) {
        return new MacdIndicator(symbol, macd, macdSignal, macdHist, date);
    }



}
