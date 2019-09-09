package com.jalpha_vantage;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Tester {
    public static void main(String[] args) {
        String val = "2019-09-09 11:30:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ZonedDateTime dateTime = LocalDateTime.parse(val, formatter).atZone(ZoneId.of("US/Eastern"));//.withZoneSameInstant(ZoneId.of("Europe/London"));
        System.out.println(dateTime.toLocalDateTime());

//        double val = +2.0;
//        System.out.println(val);
//        BigDecimal val = new BigDecimal("241.26843931");
//        System.out.println(val);
//
//        val = val.setScale(2, RoundingMode.CEILING);
//        System.out.println(val);
//        String formatPrice = String.format(Locale.ENGLISH,"%,.2f", val);
//        System.out.println(formatPrice);


    }
}
