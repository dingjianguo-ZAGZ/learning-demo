package com.su.test.CAS;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 原子累加器
 */
@Slf4j(topic = "c.LongAdder")
public class TestLongAdder {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            demo(
                    ()->new AtomicLong(),
                    (adder)->adder.getAndIncrement()
            );
        }
        System.out.println("--------------------");
        for (int i = 0; i < 5; i++) {
            demo(
                    ()->new LongAdder(),
                    (adder)-> adder.increment()
            );
        }
    }
    public static <T> void demo(
            Supplier<T> adderSupplier,
            Consumer<T> action
    ){
        long start = System.nanoTime();
        ArrayList<Thread> ts = new ArrayList<>();
        T adder = adderSupplier.get();
        //创建4个线程进行累加
        for (int i = 0; i < 4; i++) {
            ts.add(new Thread(()->{
                for (int j = 0; j < 50000; j++) {
                    action.accept(adder);
                }
            }));
        }
        ts.forEach(Thread::start);
        for (Thread t : ts) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.nanoTime();
        System.out.println(adder + "cost:"+(end-start)/1000);
    }

}
