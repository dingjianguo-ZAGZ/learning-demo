package com.su.test.synchronization;

import lombok.extern.slf4j.Slf4j;

/**
 * 循环输出
 */
@Slf4j(topic = "c.circle")
public class Circle {
    public static void main(String[] args) {
        WaitFlag wf = new WaitFlag(1,5);
        new Thread(()->{
            wf.print("a",1,2);
        }).start();
        new Thread(()->{
            wf.print("b",2,3);
        }).start();
        new Thread(()->{
            wf.print("c",3,1);
        }).start();
    }
}

/**
 * 等待标记类
 *  输出       等待标记         下一个标记
 *   a           1                2
 *   b           2                3
 *   c           3                1
 */
class WaitFlag{
    //标记
    private int flag;
    //循环次数
    private int loopNumber;

    public WaitFlag(int flag, int nextFlag) {
        this.flag = flag;
        this.loopNumber = nextFlag;
    }

    /**
     * 打印
     * @param s 线程打印字符
     * @param waitFlag 线程打印标记
     * @param nextFlag 线程打印字符的下一个字符的线程打印标记
     */
    public void print(String s,int waitFlag,int nextFlag){
        for (int i = 0; i < loopNumber; i++) {
            synchronized (this){
                while (flag != waitFlag){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(s);
                flag = nextFlag;
                this.notifyAll();
            }
        }
    }
}
