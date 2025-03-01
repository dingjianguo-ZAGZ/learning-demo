package com.su.test;

import lombok.extern.slf4j.Slf4j;

import static com.su.test.Utils.Sleeper.sleep;

/**
 * 守护线程
 */
@Slf4j(topic = "c.sync.")
public class TestDaemon {
    public static void main(String[] args) {
        log.debug("main开始");
        Thread t1 = new Thread(() -> {
            log.debug("daemon开始");
            //主线程结束后，守护线程结束，后面的代码不会执行
            sleep(2);
            log.debug("daemon结束");
        }, "守护线程");
        //设置为守护线程
        t1.setDaemon(true);
        t1.start();
        sleep(1);
        log.debug("main结束");

    }
}
