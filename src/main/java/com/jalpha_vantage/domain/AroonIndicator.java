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
public class AroonIndicator {
    private String symbol;
    private String aroonDown;
    private String aroonUp;
    private LocalDate date;


    private AroonIndicator(String symbol, String aroonUp, String aroonDown, LocalDate date) {
        this.symbol = symbol;
        this.aroonUp = aroonUp;
        this.aroonDown = aroonDown;
        this.date = date;
    }

    public static AroonIndicator newInstance(String symbol, String aroonUp, String aroonDown, LocalDate date) {
        return new AroonIndicator(symbol, aroonUp, aroonDown, date);
    }


}
