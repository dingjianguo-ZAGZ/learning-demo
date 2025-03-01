package com.su.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static com.su.test.Utils.Sleeper.sleep;


/**
 * join实现同步
 */
@Slf4j(topic = "c.sync-")
public class TestSleep {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        test2();
    }
    static int result = 0;
    private static void test1() throws InterruptedException {
        log.debug("开始");
        Thread t1 = new Thread(() -> {
            log.debug("开始");
            sleep(1);
            log.debug("结束");
            result = 10;
        }, "t1");
        t1.start();
        t1.join();
        log.debug("结果为：{}",result);
    }
    private static void test2() throws ExecutionException, InterruptedException {
        log.debug("main开始");
        FutureTask<Integer> future = new FutureTask<>(() -> {
            log.debug("开始");
            sleep(2);
            log.debug("结束");
            return 10;
        });
        new Thread(future,"t1").start();
        log.debug("main结束,结果为{}",future.get());
    }
}
