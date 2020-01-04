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
public class MamaIndicator {
    private String symbol;
    private String mama;
    private String fama;
    private LocalDate date;

    private MamaIndicator(String symbol, String mama, String fama, LocalDate date) {
        this.symbol = symbol;
        this.mama = mama;
        this.fama = fama;
        this.date = date;
    }

    public static MamaIndicator newInstance(String symbol, String mama, String fama, LocalDate date) {
        return new MamaIndicator(symbol, mama, fama, date);
    }



}
