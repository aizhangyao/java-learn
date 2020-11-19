package com.aiz.dp.state.thread;

/**
 * @ClassName _Thread
 * @Description TODO
 * @Author Administrator
 * @Date Create in 20:02 2020/11/19 0019
 * @Version 1.0
 */
public class _Thread {
    ThreadState_ state;
    void move(Action input){
        state.move(input);
    }
    void run(){
        state.run();
    }
}
