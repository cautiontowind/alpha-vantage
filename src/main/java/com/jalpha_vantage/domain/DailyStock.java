package com.jalpha_vantage.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
public class DailyStock extends Stock {
    private LocalDate date;

    protected DailyStock(String symbol, String open, String high, String low, String close, String volume, LocalDate date) {
        this.symbol = symbol;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.date = date;
    }

    protected DailyStock(String name, String symbol, String open, String high, String low, String close, String volume, String adjustedClose, String dividendAmount, String splitCoefficient, LocalDate date) {
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
