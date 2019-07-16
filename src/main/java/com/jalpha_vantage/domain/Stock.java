package com.jalpha_vantage.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public abstract class Stock implements Serializable {
    protected String symbol;
    protected double open;
    protected double high;
    protected double low;
    protected double close;
    protected BigDecimal volume;

    protected double adjustedClose;
    protected double dividendAmount;
    protected double splitCoefficient;

    protected Stock(){}




    public static DailyStock daily(String symbol, double open, double high, double low, double close, BigDecimal volume, LocalDate date) {
        return new DailyStock(symbol, open, high, low, close, volume, date);
    }

    public static DailyStock daily(String name, String symbol, double open, double high, double low, double close, BigDecimal volume, double adjustedClose, double dividendAmount, double splitCoefficient, LocalDate date) {
        return new DailyStock(name, symbol, open, high, low, close, volume, adjustedClose, dividendAmount, splitCoefficient, date);
    }


    public static IntraStock intraDay(String symbol, double open, double high, double low, double close, BigDecimal volume, LocalDateTime date) {
        return new IntraStock(symbol, open, high, low, close, volume, date);
    }

    public static IntraStock intraDay(String name, String symbol, double open, double high, double low, double close, BigDecimal volume, double adjustedClose, double dividendAmount, double splitCoefficient, LocalDateTime date) {
        return new IntraStock(name, symbol, open, high, low, close, volume, adjustedClose, dividendAmount, splitCoefficient, date);
    }


}
