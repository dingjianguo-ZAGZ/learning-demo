package com.su.test.CAS;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicInt {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(0);

        System.out.println(i.incrementAndGet());//++i
        System.out.println(i.getAndIncrement());//i++

        System.out.println(i.getAndDecrement());//i--
        System.out.println(i.decrementAndGet());//--i

        System.out.println(i.getAndAdd(3));//加
        System.out.println(i.addAndGet(4));//减
        System.out.println("-------------");
        System.out.println(i.updateAndGet(value->value*5));//立即更新
        System.out.println(i.getAndUpdate(value->value*5));//获取后更新

    }
}
