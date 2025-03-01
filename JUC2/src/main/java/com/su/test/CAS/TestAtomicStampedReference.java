package com.su.test.CAS;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicStampedReference;

import static com.su.test.Utils.Sleeper.sleep;

/**
 * 保证变量没有被其他线程修改过
 */
@Slf4j(topic = "c.AtomicStampedReference")
public class TestAtomicStampedReference {
    static AtomicStampedReference<String> ref = new AtomicStampedReference<>("A", 0);
    public static void main(String[] args) {
        //获取值
        String prev = ref.getReference();
        //获取版本号
        int stamp = ref.getStamp();
        log.debug("{}",stamp);
        other();
        sleep(1);
        log.debug("{}",stamp);
        //改为C
        log.debug("change A->C:{}",ref.compareAndSet(prev,"C",stamp,stamp+1));

    }
    public static void other(){
        new Thread(()->{
            int stamp = ref.getStamp();
            //修改为 B
            stamp = ref.getStamp();
            log.debug("{}",stamp);
            log.debug("change A->B:{}",ref.compareAndSet(ref.getReference(),"B",stamp,stamp+1));
        },"t1").start();
        sleep(0.5);
        new Thread(()->{
            int stamp = ref.getStamp();
            log.debug("{}",stamp);
            //修改为 B
            log.debug("change B->A:{}",ref.compareAndSet(ref.getReference(),"B",stamp,stamp+1));
        },"t2").start();
    }
}
