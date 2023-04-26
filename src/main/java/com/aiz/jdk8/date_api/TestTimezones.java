package com.aiz.jdk8.date_api;

import java.time.ZoneId;

/**
 * @author ZhangYao
 * @version 1.0
 * @className TestTimezones
 * @description TestTimezones
 * @date Create in 17:23 2023/4/26
 */
public class TestTimezones {
    public static void main(String[] args) {
        System.out.println(ZoneId.getAvailableZoneIds());
        // prints all available timezone ids
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());
        System.out.println(zone2.getRules());
        // ZoneRules[currentStandardOffset=+01:00]
        // ZoneRules[currentStandardOffset=-03:00]
    }
}
