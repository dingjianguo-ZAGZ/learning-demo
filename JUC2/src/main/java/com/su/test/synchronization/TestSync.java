package com.su.test.synchronization;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程同步控制
 */
@Slf4j(topic = "c.sync")
public class TestSync {
    static final Object lock = new Object();
    static boolean t2runned = false;
    static final ReentrantLock REENTRANT_LOCK = new ReentrantLock();
    static Condition LOCK = REENTRANT_LOCK.newCondition();
    public static void main(String[] args) {
        test3();
    }
    /**
     * 使用wait-notify实现线程同步
     */
    public static void test1(){
        new Thread(()->{
            synchronized (lock){
                while (!t2runned){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("1");
            }
        },"t1").start();
        new Thread(()->{
            synchronized (lock){
                log.debug("2");
                t2runned = true;
                lock.notify();
            }
        },"t2").start();
    }
    /**
     * 使用reentrantLock实现线程同步
     */
    public static void test2(){
        new Thread(()->{
            try{
                //获得锁
                REENTRANT_LOCK.lock();
                while (!t2runned) {
                    try {
                        LOCK.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("1");
            }finally {
                //t2没有运行
                REENTRANT_LOCK.unlock();
            }

        },"t1").start();
        new Thread(()->{

            try{
                REENTRANT_LOCK.lock();
                log.debug("2");
                t2runned = true;
                LOCK.signal();
            }finally {
                REENTRANT_LOCK.unlock();
            }
        },"t2").start();
    }
    /**
     * 使用park-unpark实现线程同步
     */
    public static void test3(){
        Thread t1 = new Thread(() -> {
            LockSupport.park();
            log.debug("1");
        }, "t1");
        Thread t2 = new Thread(() -> {
            log.debug("2");
            LockSupport.unpark(t1);
        }, "t2");
        t1.start();
        t2.start();
    }
}
