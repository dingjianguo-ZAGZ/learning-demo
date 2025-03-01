package com.su.test;

import lombok.extern.slf4j.Slf4j;

import static com.su.test.Utils.Sleeper.sleep;

/**
 * 烧水泡茶案例
 */
@Slf4j(topic = "c.sycn.")
public class MakeTea {
    //制作流程：洗茶壶，洗茶杯，洗茶壶，烧水，拿茶叶，泡茶
    //两个线程模拟两个人，并行工作
    public static void main(String[] args) {
        method2();
    }
    private static void method1(){
        Thread t1 = new Thread(() -> {
            log.debug("洗水壶");
            sleep(1);
            log.debug("烧开水");
            sleep(10);
        }, "小王");
        Thread t2 = new Thread(() -> {
            log.debug("洗茶壶");
            sleep(1);
            log.debug("洗茶杯");
            sleep(1);
            log.debug("拿茶叶");
            sleep(1);
            //等水烧开，泡茶
            try {
                t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.debug("泡茶");
        }, "小李");
        t1.start();
        t2.start();
    }
    //临界资源使用锁对象
    static String kettle = "冷水";
    static String tea = null;
    static boolean maked = false;
    static final Object lock = new Object();
    private static void method2(){
        new Thread(()->{
            log.debug("洗水壶");
            sleep(1);
            log.debug("烧开水");
            sleep(5);
            synchronized (lock){
                kettle = "开水";
                lock.notifyAll();
                while (tea == null){
                    try{
                        lock.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                if(!maked){
                    log.debug("拿{}泡{}",kettle,tea);
                    maked = true;
                }
            }
        },"小王").start();
        new Thread(()->{
            log.debug("洗茶壶");
            sleep(1);
            log.debug("洗茶杯");
            sleep(1);
            log.debug("拿茶叶");
            sleep(1);
            synchronized (lock){
                tea = "白茶";
                lock.notifyAll();
                while (kettle.equals("冷水")){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(!maked){
                    log.debug("拿{}泡{}",kettle,tea);
                    maked = true;
                }
            }
        },"小张").start();
    }
}
