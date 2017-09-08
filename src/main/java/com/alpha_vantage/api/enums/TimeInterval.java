package com.alpha_vantage.api.enums;

public enum TimeInterval {
    FIFFTEEN_MIN("15min"),
    THIRTY_MIN("30min"),
    SIXTY_MIN("60min"),
    DAILY("daily"),
    WEEKLY("weekly,"),
    MONTHLY("monthly");

    private final String name;

    public String getName(){
        return name;

    }

    TimeInterval(String name){
        this.name = name;
    }
}
