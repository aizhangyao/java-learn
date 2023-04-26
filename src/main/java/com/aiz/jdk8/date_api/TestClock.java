package com.aiz.jdk8.date_api;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;

/**
 * @author ZhangYao
 * @version 1.0
 * @className TestClock
 * @description TestClock
 * @date Create in 17:12 2023/4/26
 */
public class TestClock {
    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        Instant instant = clock.instant();
        // legacy java.util.Date
        Date legacyDate = Date.from(instant);
    }
}
