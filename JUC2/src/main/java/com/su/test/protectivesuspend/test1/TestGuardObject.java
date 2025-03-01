package com.su.test.protectivesuspend.test1;

import lombok.extern.slf4j.Slf4j;

import static com.su.test.Utils.Sleeper.sleep;

/**
 * 设置超时的保护性暂停
 */
@Slf4j(topic = "c.sync")
public class TestGuardObject {
    private Object response;
    private final Object lock = new Object();
    public Object get(long outTime){
        synchronized (lock){
            //记录最初时间
            long begin = System.currentTimeMillis();
            //记录经历时间
            long passTime = 0;
            while (response == null){
                long waitTime = outTime - passTime;
                log.debug("wait time :{}",waitTime);
                if(waitTime <= 0){
                    log.debug("break....");
                    break;
                }
                try {
                    lock.wait(waitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //如果超时前被唤醒经历时间
                passTime = System.currentTimeMillis() - begin;
                log.debug("经历时间:{}，response == null {}",passTime,response == null);
            }
            return response;
        }
    }
    public void complete(Object response){
        synchronized (lock){
            this.response = response;
            log.debug("notify...");
            lock.notifyAll();
        }
    }
    //测试未超时
    public static void test1(){
        TestGuardObject guardObject = new TestGuardObject();
        new Thread(()->{
            sleep(1);
            guardObject.complete(null);
            sleep(1);
            guardObject.complete("54326");
        }).start();
        Object response = guardObject.get(1500);
        if(response != null){
            log.debug("get response [{}] lines",response.toString().length());
        }else {
            log.debug("can't get response");
        }
    }

    public static void main(String[] args) {
        test1();
    }
}
