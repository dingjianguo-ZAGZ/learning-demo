package com.su.test.CAS;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TestAccount {
    public static void main(String[] args) {
        Account account1 = new AccountSafe(10000);
        Account.demo(account1);

        Account accountCAS = new AccountCAS(10000);
        Account.demo(accountCAS);
    }
}
class AccountCAS implements Account{
    private AtomicInteger balance;

    public AccountCAS(Integer balance) {
        this.balance = new AtomicInteger(balance);
    }

    @Override
    public int getBalance() {
        return balance.get();
    }

    @Override
    public void withdraw(int amount) {
        /*while (true){
            //现在的余额
            int pre = balance.get();
            //取款后金额
            int next = pre - amount;
            //同步到不同线程
            if(balance.compareAndSet(pre,next)){
                break;
            }
        }*/
        //使用原子整数操作简化
        balance.getAndAdd(-1*amount);
    }
}
interface Account{
    //获取余额
    int getBalance();
    //取款
    void withdraw(int amount);
    static void demo(Account account){
        List<Thread> ts = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            ts.add(new Thread(()->{
                account.withdraw(10);
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
//基于锁实现线程安全
class AccountSafe implements Account{
    private int balance;

    public AccountSafe(int balance) {
        this.balance = balance;
    }

    @Override
    public int getBalance() {
        synchronized (this){
            return balance;
        }
    }

    @Override
    public void withdraw(int amount) {
        synchronized (this){
            this.balance = balance - amount;
        }
    }
}
