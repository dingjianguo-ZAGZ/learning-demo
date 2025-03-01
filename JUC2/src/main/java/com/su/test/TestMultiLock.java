package com.su.test;

import com.su.test.Utils.Sleeper;
import lombok.extern.slf4j.Slf4j;

/**
 * 多把锁
 */
@Slf4j(topic = "c.TestMultiLock")
public class TestMultiLock {
    public static void main(String[] args) {
        house house = new house();
        new Thread(()->{
            house.sleep();
        },"小南").start();
        new Thread(()->{
            house.study();
        },"小女").start();
    }
}
@Slf4j(topic = "c.house")
class house{
    private final Object bedroom = new Object();
    private final Object studyRoom = new Object();
    //学习
    public void study(){
        synchronized (studyRoom){
            log.debug("学习2小时");
            Sleeper.sleep(2);
        }
    }
    //睡觉
    public void sleep(){
        synchronized (bedroom){
            log.debug("睡觉1小时");
            Sleeper.sleep(1);
        }
    }
}
