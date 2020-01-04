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
public class HtPhasorIndicator {
    private String symbol;
    private String quadrature;
    private String phase;
    private LocalDate date;
    private HtPhasorIndicator(String symbol, String quadrature, String phase, LocalDate date) {
        this.symbol = symbol;
        this.quadrature = quadrature;
        this.phase = phase;
        this.date = date;
    }

    public static HtPhasorIndicator newInstance(String symbol, String quadrature, String phase, LocalDate date) {
        return new HtPhasorIndicator(symbol, quadrature, phase, date);
    }


}
