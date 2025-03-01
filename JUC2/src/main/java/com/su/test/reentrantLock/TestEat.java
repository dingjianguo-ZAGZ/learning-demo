package com.su.test.reentrantLock;

import com.su.test.Utils.Sleeper;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用可重入锁解决哲学家进餐死锁问题
 * 破坏请求保持-获取不到，释放已有资源
 */
@Slf4j(topic = "c.eat")
public class TestEat {
    public static void main(String[] args) {
        Chopsticks c1 = new Chopsticks("1");
        Chopsticks c2= new Chopsticks("2");
        Chopsticks c3 = new Chopsticks("3");
        Chopsticks c4 = new Chopsticks("4");
        Chopsticks c5 = new Chopsticks("5");
        new Philosopher("p1",c1,c2).start();
        new Philosopher("p2",c2,c3).start();
        new Philosopher("p3",c3,c4).start();
        new Philosopher("p4",c4,c5).start();
        new Philosopher("p5",c5,c1).start();

    }
}

/**
 * 筷子类，筷子作为锁，同时可重入，使他继承ReentrantLock
 */
@Slf4j(topic = "c.chopsticks")
class Chopsticks extends ReentrantLock {
    String name;
    public Chopsticks(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "筷子{" +
                "name='" + name + '\'' +
                '}';
    }
}

/**
 * 哲学家类，获得两个筷子才能吃饭
 */
@Slf4j(topic = "c.philosopher")
class Philosopher extends Thread{
    Chopsticks left;
    Chopsticks right;

    public Philosopher(String name,Chopsticks left, Chopsticks right) {
        super(name);
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        while (true){
            //尝试获得左筷子
            if(left.tryLock()){
                //尝试获得右筷子
                try{
                    if(right.tryLock()){
                        //获得了两个筷子
                        //临界区
                        try{
                            eat();
                        }finally {
                            right.unlock();
                        }
                    }
                }finally {
                    //获得右手筷子失败
                    //释放左筷子
                    left.unlock();
                }
            }
        }
    }

    public void eat(){
        log.debug("eat");
        Sleeper.sleep(1);
    }
}
