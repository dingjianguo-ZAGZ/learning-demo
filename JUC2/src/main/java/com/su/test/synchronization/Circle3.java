package com.su.test.synchronization;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

/**
 * 使用park-unpark实现线程同步
 */
@Slf4j(topic = "c.circle3")
public class Circle3 {
    static Thread a;
    static Thread b;
    static Thread c;
    public static void main(String[] args) {
        Await await = new Await(5);
        a = new Thread(()->{
            await.print("a",b);
        });
        b = new Thread(()->{
            await.print("b", c);
        });
        c = new Thread(()->{
            await.print("c",a);
        });
        a.start();
        b.start();
        c.start();
        LockSupport.unpark(a);
    }
}
class Await{
    private int loopNumber;

    public Await(int loopNumber) {
        this.loopNumber = loopNumber;
    }
    public void print(String s,Thread next){
        for (int i = 0; i < loopNumber; i++) {
            LockSupport.park();
            System.out.print(s);
            LockSupport.unpark(next);
        }
    }
}
