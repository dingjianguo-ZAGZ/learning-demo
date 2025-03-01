package com.su.test;

import lombok.extern.slf4j.Slf4j;

import static com.su.test.Utils.Sleeper.sleep;

/**
 * 测试wait-notify
 */
@Slf4j(topic = "c.sync")
public class TestWait {
    final static Object obj = new Object();

    public static void main(String[] args) {
        test2();
    }
    private static void test1(){
        Thread t1 = new Thread(() -> {
            synchronized (obj) {
                log.debug("执行");
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.debug("其他代码");
            }
        },"t1");
        Thread t2 = new Thread(() -> {
            synchronized (obj) {
                log.debug("执行");
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.debug("其他代码");
            }
        },"t2");
        t1.start();
        t2.start();
        sleep(2);
        log.debug("唤醒obj锁的其他线程");
        synchronized (obj){
            //obj.notify();
            obj.notifyAll();
        }
    }

    /**
     * 有限时间等待
     */
    private static void test2(){
        Thread t1 = new Thread(() -> {
            synchronized (obj) {
                log.debug("执行");
                try {
                    obj.wait(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.debug("其他代码");
            }
        },"t1");
        Thread t2 = new Thread(() -> {
            synchronized (obj) {
                log.debug("执行");
                try {
                    obj.wait(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.debug("其他代码");
            }
        },"t2");
        t1.start();
        t2.start();
        sleep(2);
        log.debug("唤醒obj锁的其他线程");
        synchronized (obj){
            //obj.notify();
            obj.notifyAll();
        }
    }
}

