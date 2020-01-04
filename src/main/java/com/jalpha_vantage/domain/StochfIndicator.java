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
public class StochfIndicator {
    private String symbol;
    private String fastK;
    private String fastD;
    private LocalDate date;

    protected StochfIndicator(String symbol, String fastK, String fastD, LocalDate date) {
        this.symbol = symbol;
        this.fastK = fastK;
        this.fastD = fastD;
        this.date = date;
    }

    public static StochfIndicator newInstance(String symbol, String fastK, String fastD, LocalDate date) {
        return new StochfIndicator(symbol, fastK, fastD, date);
    }


}
