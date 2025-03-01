package com.su.test;

import lombok.extern.slf4j.Slf4j;

import static com.su.test.Utils.Sleeper.sleep;

/**
 * 测试打断
 */
@Slf4j(topic = "c.sync-")
public class TestInterrupt {
    public static void main(String[] args) {
        test1();
    }

    /**
     * 打断sleep,wait,join的线程
     */
    private static void test1(){
        Thread t1 = new Thread(() -> {
            sleep(2);
        }, "t1");
        t1.start();
        sleep(1);
        t1.interrupt();
        log.debug("打断状态：{}",t1.isInterrupted());
    }
    private static void test2(){
        Thread t2 = new Thread(() -> {
            while (true) {
                Thread current = Thread.currentThread();
                boolean interrupted = current.isInterrupted();
                if (interrupted) {
                    log.debug("打断状态：{}", interrupted);
                    break;//跳出while循环
                }
            }
        }, "t2");
        t2.start();
        sleep(1);
        t2.interrupt();
    }
}
