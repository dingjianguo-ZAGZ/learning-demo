package com.su.test.visibility;

import com.su.test.product.Test;
import lombok.extern.slf4j.Slf4j;

import static com.su.test.Utils.Sleeper.sleep;

/**
 * 测试volatile
 */
@Slf4j(topic = "c.volatile")
public class TestVolatile {
    private static Thread thread;
    private static volatile boolean stop = false;
    public static void main(String[] args) {
        test1();
    }
    public static void test1(){
        thread = new Thread(()->{
            while (true){
                if(stop){
                    log.debug("料理后事");
                    break;
                }
                try{
                    Thread.sleep(1000);
                    log.debug("监控");
                }catch (InterruptedException e){

                }
            }
        },"监控线程");
        thread.start();
        sleep(3.5);
        log.debug("stop");
        stop = true;
        thread.interrupt();
    }
}
