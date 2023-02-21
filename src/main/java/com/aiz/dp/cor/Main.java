package com.aiz.dp.cor;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Main
 * @Description 责任链模式
 * @Author Yao
 * @Date Create in 11:07 下午 2021/4/1
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好：），<script>，欢迎访问aizhangyao.github.io，大家都是996 ");

        /**
         * 第一种普通做法
         */
//        // 处理msg
//        String r = msg.getMsg();
//        r = r.replace('<','[');
//        r = r.replace('>',']');
//        msg.setMsg(r);
//
//        //
//        r = r.replaceAll("996","955");
//        msg.setMsg(r);

        /**
         *
         */
        // 处理msg
//        new HTMLFilter().doFilter(msg);
//        new SensitiveFilter().doFilter(msg);

        /**
         *
         */
//        List<Filter> filters = new ArrayList<>();
//        filters.add(new HTMLFilter());
//        filters.add(new SensitiveFilter());
//        for (Filter filter : filters) {
//            filter.doFilter(msg);
//        }

        /**
         *
         */
        FilterChain fc = new FilterChain();
        fc.add(new HTMLFilter()).add(new SensitiveFilter());

        FilterChain fc2 = new FilterChain();
        fc2.add(new FaceFilter()).add(new URLFilter());

        fc.add(fc2);

        fc.doFilter(msg);

        System.out.println(msg);

    }
}

class Msg{
    String name;
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "msg='" + msg + '\'' +
                '}';
    }
}

interface Filter{
    boolean doFilter(Msg msg);
}

class HTMLFilter implements Filter{
    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replace('<','[');
        r = r.replace('>',']');
        msg.setMsg(r);
        return true;
    }
}

class SensitiveFilter implements Filter{
    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replaceAll("996","955");
        msg.setMsg(r);
        return false;
    }
}

class FaceFilter implements Filter{
    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replace("：）","^v^");
        msg.setMsg(r);
        return true;
    }
}

class URLFilter implements Filter{
    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replace("aizhangyao.com","https://aizhangyao.github.io/");
        msg.setMsg(r);
        return true;
    }
}

class FilterChain implements Filter{
    List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter f){
        filters.add(f);
        return this;
    }

    public boolean doFilter(Msg msg){
        for (Filter filter : filters) {
            if(!filter.doFilter(msg)) {
                return false;
            }
        }
        return true;
    }

}