package com.su.test.reentrantLock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import static com.su.test.Utils.Sleeper.sleep;

/**
 * 可重入，可打断，可超时锁
 */
@Slf4j(topic = "c.reenterLock")
public class TestReentrantLock {
    private static final ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        test3();
    }
    //测试可重入（不可重入锁，第二次获得锁，自己挡住自己）
    public static void test1(){
        lock.lock();
        //临界区使用try-finally
        try{
            log.debug("test1");
            method1();
        }finally {
            lock.unlock();
        }
    }
    public static void method1(){
        //锁重入
        lock.lock();
        try{
            log.debug("method1");
            method2();
        }finally {
            lock.unlock();
        }
    }
    public static void method2(){
        //锁重入
        lock.lock();
        try{
            log.debug("method2");
        }finally {
            lock.unlock();
        }
    }
    //测试可打断
    public static void test2(){
        Thread t1 = new Thread(() -> {
            try {
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.debug("等锁过程被打断");
                return;
            }
            //临界区,(获得锁)
            try {
                log.debug("获得了锁");
            } finally {
                lock.unlock();
            }
        }, "t1");
        //主线程获得锁
        lock.lock();
        log.debug("主线程获得锁");
        t1.start();//t1线程一直等待锁
        try {
            sleep(1);
            t1.interrupt();//打断，结束等待
            log.debug("执行打断");
        }finally {
            lock.unlock();
            log.debug("主线程释放锁");
        }

    }
    //测试可超时
    public static void test3(){
        Thread t1 = new Thread(() -> {
            log.debug("尝试获得锁");
            try {
                if (!lock.tryLock(2, TimeUnit.SECONDS)) {
                    log.debug("没有获得锁");
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.debug("获取不到锁");
                return;
            }
            try {
                log.debug("t1获得锁");

            } finally {
                lock.unlock();
            }

        }, "t1");
        lock.lock();
        log.debug("main 获得锁");
        t1.start();
        sleep(1);
        lock.unlock();
        log.debug("main 释放锁");

    }
}

