package com.su.test.visibility;

import lombok.extern.slf4j.Slf4j;

import static com.su.test.Utils.Sleeper.sleep;

/**
 * 测试犹豫（balking）模式
 */
@Slf4j(topic = "c.balking")
public class TestBalking {
    private Thread monitorThread;
    //在非synchronized块，保证可见性
    private volatile boolean starting = false;
    private volatile boolean stop = false;
    public static void main(String[] args) {
        TestBalking balking = new TestBalking();
        balking.start();
        balking.start();
        balking.start();
    }
    //启动监控线程
    public void start(){
        //synchronized 包含越少的代码越好
        synchronized (this){
            if(starting){ //true
                return;
            }
            starting = true;
        }

        monitorThread = new Thread(()->{
            while (!stop){
                log.debug("监控线程监控");
                sleep(2);
            }
            //此时，只有一个启动线程，所以不存在互斥
            log.debug("监控线程已经停止");
            starting = false;
        });
        stop = true;
        log.debug("监控线程已经启动");
        monitorThread.start();
    }
    public void stop(){
        stop = true;
        monitorThread.interrupt();
    }
}
