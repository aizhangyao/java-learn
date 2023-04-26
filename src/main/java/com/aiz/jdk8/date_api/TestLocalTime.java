package com.aiz.jdk8.date_api;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 * @author ZhangYao
 * @version 1.0
 * @className TestLocalTime
 * @description TestLocalTime
 * @date Create in 17:23 2023/4/26
 */
public class TestLocalTime {
    public static void main(String[] args) {
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");

        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);
        // false
        System.out.println(now1.isBefore(now2));
        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);
        // -4
        System.out.println(hoursBetween);
        // -299
        System.out.println(minutesBetween);


        LocalTime late = LocalTime.of(23, 59, 59);
        // 23:59:59
        System.out.println(late);
        DateTimeFormatter germanFormatter =
                DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(Locale.GERMAN);
        LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
        // 13:37
        System.out.println(leetTime);
    }
}
