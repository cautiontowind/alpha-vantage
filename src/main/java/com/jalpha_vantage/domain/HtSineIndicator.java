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
public class HtSineIndicator {
    private String symbol;
    private String sine;
    private String leadSine;
    private LocalDate date;

    private HtSineIndicator(String symbol, String sine, String leadSine, LocalDate date) {
        this.symbol = symbol;
        this.sine = sine;
        this.leadSine = leadSine;
        this.date = date;
    }

    public static HtSineIndicator newInstance(String symbol, String sine, String leadSine, LocalDate date) {
        return new HtSineIndicator(symbol, sine, leadSine, date);
    }


}
