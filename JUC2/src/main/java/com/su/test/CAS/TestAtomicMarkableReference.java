package com.su.test.CAS;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicMarkableReference;

import static com.su.test.Utils.Sleeper.sleep;

/**
 * 不知总修改过程，只获取是否修改
 */
@Slf4j(topic = "c.AtomicMarkableReference")
public class TestAtomicMarkableReference {
    public static void main(String[] args) {
        AtomicMarkableReference<Bag> ref = new AtomicMarkableReference<>(new Bag("满垃圾袋"), true);
        log.debug("主线程 start..");
        Bag prev = ref.getReference();
        log.debug("bag:{}",prev.toString());

        new Thread(()->{
            log.debug("打扫卫生，倒垃圾");
            prev.setMessage("空垃圾袋");
            ref.compareAndSet(prev,prev,true,false);
            log.debug(prev.toString());
        },"保洁阿姨").start();
        sleep(1);
        //尝试换垃圾袋
        log.debug("换垃圾袋：");
        boolean success = ref.compareAndSet(prev, new Bag("空垃圾袋"), true, false);
        log.debug("成功？ {}",success);
        log.debug(ref.getReference().toString());
    }
}
class Bag{
    private String message;

    public Bag(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    @Override
    public String toString() {
        return super.toString()+"Bag{" +
                "message='" + message + '\'' +
                '}';
    }
}
