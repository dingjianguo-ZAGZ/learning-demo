package com.su.test.synchronization;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static com.su.test.Utils.Sleeper.sleep;

/**
 * 使用reentrantLock实现交替输出
 */
@Slf4j(topic = "c.circle2")
public class Circle2 {
    public static void main(String[] args) {
        AwaitSignal awaitSignal = new AwaitSignal(5);
        Condition a = awaitSignal.newCondition();
        Condition b = awaitSignal.newCondition();
        Condition c = awaitSignal.newCondition();
        //创建对应线程
        new Thread(()->{
            awaitSignal.print("a",a,b);
        }).start();
        new Thread(()->{
            awaitSignal.print("b",b,c);
        }).start();
        new Thread(()->{
            awaitSignal.print("c",c,a);
        }).start();

        //刚开始三个线程进入各自的休息室
        //有主线程启动
        sleep(1);
        awaitSignal.lock();
        try{
            //从a开始
            a.signal();
        }finally {
            awaitSignal.unlock();
        }
    }
}

/**
 * AwaitSignal 对象既是锁对象，有需要实现可重入
 */
class AwaitSignal extends ReentrantLock {
    int loopNumber;

    public AwaitSignal(int loopNumber) {
        this.loopNumber = loopNumber;
    }
    public void print(String s,Condition current,Condition next){
        for (int i = 0; i < loopNumber; i++) {
            this.lock();
            try{
                try {
                    //先进入专用的休息室等待
                    current.await();
                    //被唤醒后输出
                    System.out.print(s);
                    //唤醒下一个休息室中的线程
                    next.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }finally {
                this.unlock();
            }
        }
    }
}
