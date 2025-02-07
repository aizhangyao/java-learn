package com.other;

import org.junit.Test;

import java.util.Calendar;

/**
 * @author ZhangYao
 * @className TestTime
 * @description 测试日历类
 * @date Create in 21:30 2023/10/24
 */
public class TestTime {
    public static Calendar getNearestHalfHour(Calendar calendar) {
        int minute = calendar.get(Calendar.MINUTE);
        int targetMinute = (minute / 30) * 30;
        if (minute % 30 != 0) {
            targetMinute += 30;
        }
        calendar.set(Calendar.MINUTE, targetMinute);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    @Test
    public void test() {
        Calendar instance = Calendar.getInstance();
        instance.set(2023, Calendar.NOVEMBER, 24, 23, 56, 0);
        Calendar nearestHalfHour = getNearestHalfHour(instance);
        System.out.println(nearestHalfHour.getTime());
    }
}
