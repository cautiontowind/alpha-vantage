package com.jalpha_vantage.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode
public class DailyStock extends Stock {
    private LocalDate date;

    protected DailyStock(String symbol, double open, double high, double low, double close, double volume, LocalDate date) {
        this.symbol = symbol;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.date = date;
    }

    protected DailyStock(String name, String symbol, double open, double high, double low, double close, double volume, double adjustedClose, double dividendAmount, double splitCoefficient, LocalDate date) {
        this.symbol = symbol;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.adjustedClose = adjustedClose;
        this.dividendAmount = dividendAmount;
        this.splitCoefficient = splitCoefficient;
        this.date = date;
    }

}
