package com.su.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

import static com.su.test.Utils.Sleeper.sleep;

/**
 * 测试park打断线程
 */
@Slf4j(topic = "c.sync")
public class TestPark {
    public static void main(String[] args) {
        test2();
    }
    private static void test1(){
        Thread t1 = new Thread(() -> {
            log.debug("parking");
            LockSupport.park();
            log.debug("unparking");
            log.debug("park打断状态：{}", Thread.currentThread().isInterrupted());//true,park打断，并且打断状态未被清除
        }, "t1");
        Thread thread = t1;
        t1.start();
        sleep(1);
        t1.interrupt();
    }
    private static void test2(){
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                log.debug("parking");
                LockSupport.park();
                log.debug("park打断状态：{}", Thread.currentThread().isInterrupted());//true,park打断，并且打断状态未被清除
            }
        }, "t2");
        t2.start();
        sleep(1);
        t2.interrupt();
    }
}
