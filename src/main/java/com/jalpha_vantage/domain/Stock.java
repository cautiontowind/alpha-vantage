package com.jalpha_vantage.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public abstract class Stock implements Serializable {
    protected String symbol;
    protected String open;
    protected String high;
    protected String low;
    protected String close;
    protected String volume;

    protected String adjustedClose;
    protected String dividendAmount;
    protected String splitCoefficient;

    protected Stock(){}




    public static DailyStock daily(String symbol, String open, String high, String low, String close, String volume, LocalDate date) {
        return new DailyStock(symbol, open, high, low, close, volume, date);
    }

    public static DailyStock daily(String name, String symbol, String open, String high, String low, String close, String volume, String adjustedClose, String dividendAmount, String splitCoefficient, LocalDate date) {
        return new DailyStock(name, symbol, open, high, low, close, volume, adjustedClose, dividendAmount, splitCoefficient, date);
    }


    public static IntraStock intraDay(String symbol, String open, String high, String low, String close, String volume, LocalDateTime date) {
        return new IntraStock(symbol, open, high, low, close, volume, date);
    }

    public static IntraStock intraDay(String name, String symbol, String open, String high, String low, String close, String volume, String adjustedClose, String dividendAmount, String splitCoefficient, LocalDateTime date) {
        return new IntraStock(name, symbol, open, high, low, close, volume, adjustedClose, dividendAmount, splitCoefficient, date);
    }


}
