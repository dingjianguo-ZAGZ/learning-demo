package com.su.test.RWL;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantReadWriteLock;

import static com.su.test.Utils.Sleeper.sleep;

public class TestReadWriteLock{
    public static void main(String[] args) {
        DataContainer dataContainer = new DataContainer();
        new Thread(()->{
            dataContainer.write();
        },"t1").start();
        sleep(0.5);
        new Thread(()->{
            dataContainer.write();
        },"t2").start();
    }
}
@Slf4j(topic = "c.DateContainer")
class DataContainer {
    private Object data;
    private ReentrantReadWriteLock rw = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock readLock = rw.readLock();
    private ReentrantReadWriteLock.WriteLock writeLock = rw.writeLock();
    public Object read(){
        log.debug("获取读锁");
        readLock.lock();
        //可重入锁，需要用try-finally保证资源的释放
        try {
            log.debug("读取");
            sleep(1);
            return data;
        }finally {
            log.debug("释放读锁");
            readLock.unlock();
        }
    }
    public void write(){
        log.debug("获取写锁");
        writeLock.lock();
        //可重入锁，需要用try-finally保证资源的释放
        try {
            log.debug("写入");
        }finally {
            log.debug("释放写锁");
            writeLock.unlock();
        }
    }
}
