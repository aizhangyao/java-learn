package com.aiz.jdk8.date_api;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * @author ZhangYao
 * @version 1.0
 * @className TestLocalDateTime
 * @description TestLocalDateTime
 * @date Create in 17:28 2023/4/26
 */
public class TestLocalDateTime {

    public static void main(String[] args) {
        LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);
        DayOfWeek dayOfWeek = sylvester.getDayOfWeek();
        // WEDNESDAY
        System.out.println(dayOfWeek);
        Month month = sylvester.getMonth();
        // DECEMBER
        System.out.println(month);
        long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
        // 1439
        System.out.println(minuteOfDay);


        Instant instant = sylvester.atZone(ZoneId.systemDefault()).toInstant();
        Date legacyDate = Date.from(instant);
        // Wed Dec 31 23:59:59 CST 2014
        System.out.println(legacyDate);


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy - HH:mm");
        LocalDateTime parsed = LocalDateTime.parse("十二月 03, 2014 - 07:13", formatter);
        String string = formatter.format(parsed);
        // 十二月 03, 2014 - 07:13
        System.out.println(string);
    }
}
