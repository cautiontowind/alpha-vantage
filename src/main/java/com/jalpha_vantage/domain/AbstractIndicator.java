package com.jalpha_vantage.domain;

import com.jalpha_vantage.enums.IndicatorType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class AbstractIndicator {
    private String symbol;
    private IndicatorType indicatorType;
    private String value;
    private LocalDate date;

    protected AbstractIndicator(String symbol, IndicatorType indicatorType, String value, LocalDate date) {
        this.symbol = symbol;
        this.indicatorType = indicatorType;
        this.value = value;
        this.date = date;
    }

    public static AbstractIndicator newInstance(String symbol, IndicatorType indicatorType, String value, LocalDate date) {
        return new AbstractIndicator(symbol, indicatorType, value, date);
    }


}
