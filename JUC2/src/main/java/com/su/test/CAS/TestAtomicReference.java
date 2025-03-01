package com.su.test.CAS;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class TestAtomicReference {
    public static void main(String[] args) {
        AccountReference account = new AccountCASReference(new BigDecimal(10000));
        AccountReference.demo(account);
    }
}
class AccountCASReference implements AccountReference{
    private AtomicReference<BigDecimal> balance;

    public AccountCASReference(BigDecimal balance) {
        this.balance = new AtomicReference<>(balance);
    }

    @Override
    public BigDecimal getBalance() {
        return balance.get();
    }

    @Override
    public void withdraw(BigDecimal amount) {
        while (true){
            BigDecimal prev = balance.get();
            BigDecimal next = prev.subtract(amount);
            if(balance.compareAndSet(prev,next)){
                break;
            }
        }
    }
}
interface AccountReference{
    //获取余额
    BigDecimal getBalance();
    //取款
    void withdraw(BigDecimal amount);
    static void demo(AccountReference account){
        List<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            ts.add(new Thread(()->{
                account.withdraw(new BigDecimal(10));
            }));
        }
        long start = System.nanoTime();
        ts.forEach(Thread::start);
        for (Thread t : ts) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.nanoTime();
        System.out.println("余额："+account.getBalance() + " 历时："+(end-start)/1000000 + "ms");

    }
}