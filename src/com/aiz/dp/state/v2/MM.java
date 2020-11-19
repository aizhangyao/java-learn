package com.aiz.dp.state.v2;

/**
 * @ClassName MM
 * @Description TODO
 * @Author ZhangYao
 * @Date Create in 17:21 2020/11/19 0019
 * @Version 1.0
 */
public class MM {
    String name;
    MMState state;

    public void smile(){
        state.smile();
    }

    public void cry(){
        state.cry();
    }

    public void say(){
        state.say();
    }

}
