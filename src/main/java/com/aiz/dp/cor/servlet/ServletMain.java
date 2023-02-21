package com.aiz.dp.cor.servlet;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Main
 * @Description 责任链模式
 * @Author Yao
 * @Date Create in 11:07 下午 2021/4/1
 * @Version 1.0
 */
public class ServletMain {
    public static void main(String[] args) {
        Request request = new Request();
        request.str = "request";
        Response response = new Response();
        response.str = "response";

        //TODO 请参考https://javaee.github.io/javaee-spec/javadocs/
        // 中的javax.servlet.Filter&java.servlet.FilterChain
        System.out.println();

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
    boolean doFilter(Request request,Response response);
}

class Request{
    String str;
}

class Response{
    String str;
}


class HTMLFilter implements Filter{
    @Override
    public boolean doFilter(Request request,Response response) {

        return true;
    }
}

class SensitiveFilter implements Filter{
    @Override
    public boolean doFilter(Request request,Response response) {

        return false;
    }
}


class FilterChain implements Filter{
    List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter f){
        filters.add(f);
        return this;
    }

    public boolean doFilter(Request request,Response response){
        for (Filter filter : filters) {
            if(!filter.doFilter(request,response)) {
                return false;
            }
        }
        return true;
    }

}