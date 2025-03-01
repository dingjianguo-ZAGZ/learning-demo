package com.su.test;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * 转账测试
 */
@Slf4j(topic = "c.sync")
public class TestTransfer {
    public static void main(String[] args) throws InterruptedException {
        Account a = new Account(1000);
        Account b = new Account(1000);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                a.transfer(b, randomAmount());
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                b.transfer(a, randomAmount());
            }
        }, "t2");
        t1.start();
        t2.start();
        //等待两个转账线程结束后，统计余额
        t1.join();
        t2.join();
        log.debug("total:{}",a.getMoney()+b.getMoney());
    }
    private static Random random = new Random();
    public static int randomAmount(){
        return random.nextInt(100)+1;
    }

}
class Account{
    private int money;

    public Account(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    public void transfer(Account target,int amount){
        //转账时，收账用户和转账用户的余额都需要保护
        synchronized (Account.class){
            if(this.money >= amount){
                this.setMoney(this.money - amount);
                target.setMoney(target.getMoney() + amount);
            }
        }

    }
}
