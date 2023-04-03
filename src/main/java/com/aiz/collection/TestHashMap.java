package com.aiz.collection;


import java.util.concurrent.ConcurrentHashMap;

public class TestHashMap {
    public static void main_1(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap();
        map.put("key", 1);
        // 修改key对应的value，追加上1

        // 之前的操作方式
        Integer oldValue = map.get("key");
        Integer newValue = oldValue + 1;
        map.put("key", newValue);
        System.out.println(map);

        // 现在的操作方式
        map.compute("key", (key, computeOldValue) -> {
            if (computeOldValue == null) {
                computeOldValue = 0;
            }
            return computeOldValue + 1;
        });
        System.out.println(map);
    }

    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap();
        map.compute("key", (k, v) -> {
            return map.compute("key", (key, value) -> {
                return 1111;
            });
        });
        System.out.println(map);
    }
}
