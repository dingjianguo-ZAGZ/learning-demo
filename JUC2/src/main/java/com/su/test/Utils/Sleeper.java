package com.su.test.Utils;

/**
 * 线程睡眠工具类
 */
public class Sleeper {
    public static void sleep(double s){
        try {
            Thread.sleep((long) (s * 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
