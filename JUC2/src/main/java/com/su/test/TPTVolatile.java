package com.su.test;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

/**
 * 利用停止标记，解决睡眠中打断
 */
@Slf4j(topic = "c.sync.")
public class TPTVolatile {
    private Thread thread;
    private volatile boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        TPTVolatile t = new TPTVolatile();
        t.start();
        sleep(3500);
        t.stop();
        log.debug("结束");
    }
    private void start(){
        thread = new Thread(()->{
            while (true){
                if(stop){
                    log.debug("料理后事");
                    break;
                }
                try {
                    sleep(1000);
                    log.debug("保存结果");
                } catch (InterruptedException e) {

                }
                //执行监控操作
            }
        },"监控线程");
        thread.start();
    }
    private void stop(){
        stop = true;
        thread.interrupt();
    }
}
