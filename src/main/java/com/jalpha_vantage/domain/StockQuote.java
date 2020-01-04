package com.jalpha_vantage.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class StockQuote implements Serializable {
    String symbol;
    double open;
    double high;
    double low;
    double price;
    double previousClose;
    double change;
    double changeInPercent;
    double volume;
    LocalDate latestTradingDay;

    StockQuote(String symbol, double open, double high, double low, double price, double previousClose, double change, double changeInPercent, double volume, LocalDate latestTradingDay){
        this.symbol = symbol;
        this.open = open;
        this.high = high;
        this.low = low;
        this.price = price;
        this.previousClose = previousClose;
        this.change = change;
        this.changeInPercent = changeInPercent;
        this.volume = volume;
        this.latestTradingDay = latestTradingDay;
    }

    public static StockQuote newQuoteInstance(String symbol, double open, double high, double low, double price, double previousClose, double change, double changeInPercent, double volume, LocalDate latestTradingDay) {
        return new StockQuote(symbol, open, high, low, price, previousClose, change, changeInPercent, volume,latestTradingDay);
    }
}
