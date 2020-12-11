package com.aiz.juc.c_002;

/**
 * @ClassName T
 * @Description 对某个对象加锁
 * @Author Administrator
 * @Date Create in 17:33 2020/12/10 0010
 * @Version 1.0
 */
public class T {
    private int count = 10;
    public void m(){
        synchronized (this){//任何线程想要执行下面的代码，必须先拿到this的锁
            count--;
            System.out.println(Thread.currentThread().getName()+"count="+count);
        }
    }
}
