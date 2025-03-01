package com.su.test.CAS;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class TestUnsafeAccessor {
    public static void main(String[] args) {
        Account.demo(new MyAtomicInteger(10000));
    }
}
class UnsafeAccessor{
    public static Unsafe getUnsafe() {
        Field theUnsafe = null;
        Unsafe unsafe = null;
        try {
            theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return unsafe;
    }
}
class MyAtomicInteger implements Account{
    //需要保护的原子整数
    private volatile int value;
    //成员变量value的偏移地址
    private static final long valueOffset;
    //Unsafe 对象实现线程安全
    private static final Unsafe UNSAFE;
    static {
        UNSAFE = UnsafeAccessor.getUnsafe();
        try {
            valueOffset = UNSAFE.objectFieldOffset(MyAtomicInteger.class.getDeclaredField("value"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public int getValue(){
        return value;
    }
    public void decrement(int account){
        while (true){
            int prev = value;
            int next = prev - account;
            if (UNSAFE.compareAndSwapInt(this,valueOffset,prev,next)) {
                break;
            }
        }
    }

    @Override
    public int getBalance() {
        return getValue();
    }

    @Override
    public void withdraw(int amount) {
        decrement(amount);
    }

    public MyAtomicInteger(int value) {
        this.value = value;
    }
}
