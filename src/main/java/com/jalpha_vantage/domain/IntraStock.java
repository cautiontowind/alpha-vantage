package com.jalpha_vantage.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
public class IntraStock extends Stock {
    private LocalDateTime date;

    protected IntraStock(String symbol, double open, double high, double low, double close, BigDecimal volume, LocalDateTime date) {
        this.symbol = symbol;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.date = date;
    }

    protected IntraStock(String name, String symbol, double open, double high, double low, double close, BigDecimal volume, double adjustedClose, double dividendAmount, double splitCoefficient, LocalDateTime date) {
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
