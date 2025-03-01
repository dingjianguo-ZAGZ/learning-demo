package com.su.test;

import lombok.extern.slf4j.Slf4j;

import static com.su.test.Utils.Sleeper.sleep;

/**
 * 检测死锁
 */
@Slf4j(topic = "c.deadLock")
public class TestDeadLock {
    public static void main(String[] args) {
        test1();
    }
    public static void test1(){
        Object A = new Object();
        Object B = new Object();
        new Thread(()->{
            synchronized (A){
                log.debug("locked A");
                sleep(1);
                synchronized (B){
                    log.debug("locked B");
                    log.debug("操作...");
                }
            }
        },"t1").start();
        new Thread(()->{
            synchronized (B){
                log.debug("locked B");
                sleep(1);
                synchronized (A){
                    log.debug("locked A");
                    log.debug("操作...");
                }
            }
        },"t2").start();
    }
}
