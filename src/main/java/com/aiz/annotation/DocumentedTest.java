package com.aiz.annotation;

/**
 * @author zhangyao
 */
public class DocumentedTest {
    /**
     * 测试document
     */
    @MyDocumented
    public String test() {
        return "Java教程";
    }
}
