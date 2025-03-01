package com.su.test;

import lombok.extern.slf4j.Slf4j;

import static com.su.test.Utils.Sleeper.sleep;

/**
 * 解决notifyAll虚假唤醒
 */
@Slf4j(topic = "c.sync")
public class TestNotifyAll {
    static final Object room = new Object();
    static boolean hasCigarette = false;
    static boolean hasTakOut = false;
    public static void main(String[] args) {
        new Thread(()->{
            synchronized (room){
                log.debug("有烟吗？{}",hasCigarette);
                while (!hasCigarette){
                    log.debug("没烟，歇会。");
                    try {
                        room.wait();//使用锁对象的wait方法，释放锁
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                log.debug("有烟了吗,{}",hasCigarette);
                if(hasCigarette){
                    log.debug("可以干活了");
                }else {
                    log.debug("没干成");
                }
            }
        },"小南").start();
        new Thread(()->{
            synchronized (room){
                log.debug("外卖到了吗？{}",hasTakOut);
                while (!hasTakOut){
                    log.debug("没吃饭，歇会。");
                    try {
                        room.wait();//使用锁对象的wait方法，释放锁
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                log.debug("外卖到了吗,{}",hasTakOut);
                if(hasTakOut){
                    log.debug("可以干活了");
                }else {
                    log.debug("没干成");
                }
            }
        },"小女").start();
        sleep(1);
        new Thread(()->{
            synchronized (room){
                hasTakOut = true;
                log.debug("外卖到了");
                room.notifyAll();
            }
        },"送外卖").start();
    }
}
