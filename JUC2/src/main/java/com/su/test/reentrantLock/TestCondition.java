package com.su.test.reentrantLock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static com.su.test.Utils.Sleeper.sleep;

/**
 * 测试多个条件变量
 */
@Slf4j(topic = "c.condition")
public class TestCondition {
    static ReentrantLock lock = new ReentrantLock();
    static Condition waitCigaretteQueue = lock.newCondition();
    static Condition waitTakeOutQueue = lock.newCondition();
    static volatile boolean hasCigarette = false;
    static volatile boolean hasTakeOut = false;
    public static void main(String[] args) {
        new Thread(()->{
            try{
                lock.lock();
                while (!hasCigarette){
                    log.debug("没有烟，歇会。。。");
                    try {
                        waitCigaretteQueue.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("可以干活了");
            }finally {
                lock.unlock();
            }
        },"小南").start();
        new Thread(()->{
            try {
                lock.lock();
                while (!hasTakeOut){
                    log.debug("没吃饭，歇会。。。");
                    try {
                        waitTakeOutQueue.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("可以开始干活了");
            }finally {
                lock.unlock();
            }
        },"小女").start();
        sleep(1);
        sendCigarette();
        sleep(1);
        sendTakeOut();
    }
    public static void sendCigarette(){
        try{
            lock.lock();
            log.debug("烟送到了");
            hasCigarette = true;
            //唤醒等烟室的线程
            waitCigaretteQueue.signal();
        }finally {
            lock.unlock();
        }
    }
    public static void sendTakeOut(){
        try{
            lock.lock();
            log.debug("外卖送到了");
            hasCigarette = true;
            //唤醒外卖室的线程
            waitTakeOutQueue.signal();
        }finally {
            lock.unlock();
        }
    }


}
