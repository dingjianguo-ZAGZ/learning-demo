package com.su.test;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;


/**
 * 两阶段终止
 */
@Slf4j(topic = "c.sync.")
public class TPInterrupt{
    private Thread thread;
    public static void main(String[] args) throws InterruptedException {
        TPInterrupt tpInterrupt = new TPInterrupt();
        tpInterrupt.start();
        sleep(3500);
        log.debug("stop");
        tpInterrupt.stop();
    }
    private void start(){
        thread = new Thread(()->{
            while (true){
                log.debug("开始");
                Thread current = Thread.currentThread();
                if(current.isInterrupted()){
                    log.debug("料理后事");
                    break;
                }
                try {
                    Thread.sleep(1000);
                    log.debug("保存结果");
                } catch (InterruptedException e) {
                    current.interrupt();//双阶段终止
                }
                //执行监控工作
            }
        },"监控线程");
        thread.start();
    }
    private void stop(){
        thread.interrupt();
    }
}
