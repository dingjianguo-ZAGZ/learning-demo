package com.su.test.protectivesuspend.test1;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * 保护性暂停
 */
@Slf4j(topic = "c.sync")
public class GuardObject {
    public static void main(String[] args) {
        GuardObject guardObject = new GuardObject();
        StringBuilder response = new StringBuilder();
        new Thread(()->{
            //子线程执行读取
            try {
                BufferedReader bf = new BufferedReader(new FileReader("E:/b.txt"));
                while (bf.readLine() != null){
                    System.out.println(bf.readLine());
                    response.append(bf.readLine());
                }
                log.debug("读取完毕");
                guardObject.complete(response);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
        log.debug("等待中");
        Object o = guardObject.get();
        log.debug("读取内容为大小：{}",o.toString().length());
    }
    private Object response;
    private final Object lock = new Object();
    //获取值
    public Object get(){
        synchronized (lock){
            //条件不满足时，等待
            while (response == null){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return response;
        }
    }
    //填入值
    public void complete(Object response){
        synchronized (lock){
            this.response = response;
            //唤醒获取值的线程
            lock.notifyAll();
        }
    }
}
