package com.su.test;

import lombok.extern.slf4j.Slf4j;

import static com.su.test.Utils.Sleeper.sleep;

/**
 * 测试join
 */
@Slf4j(topic = "c.sync-")
public class TestJoin {
    static int r1 = 0;
    static int r2 = 0;
    public static void main(String[] args) throws InterruptedException {
        test3();
    }

    private static void test1() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            sleep(1);
            r1 = 10;
        }, "t1");
        Thread t2 = new Thread(() -> {
            sleep(2);
            r1 = 20;
        }, "t2");
        long start = System.currentTimeMillis();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long end = System.currentTimeMillis();
        log.debug("r1:{},r2:{},cost:{}",r1,r2,end-start);
    }

    /**
     * 有时效的join
     */
    private static void test2() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            sleep(1);
            r1 = 10;
        }, "t1");
        long start = System.currentTimeMillis();
        t1.start();
        //线程结束，join方法结束
        t1.join(1500);
        long end = System.currentTimeMillis();
        log.debug("r1:{},cost:{}",r1,end-start);
    }
    private static void test3() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            sleep(2);
            r1 = 10;
        }, "t1");
        long start = System.currentTimeMillis();
        t1.start();
        //join方法结束，线程结束
        t1.join(1500);
        long end = System.currentTimeMillis();
        log.debug("r1:{},cost:{}",r1,end-start);
    }

}
