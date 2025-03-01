package com.su.test;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/**
 * 买票练习
 */
@Slf4j(topic = "c.sync")
public class Sell {
    public static void main(String[] args) {
        Ticket ticket = new Ticket(2000);
        List<Thread> list = new ArrayList<>();
        //sell被多个线程共享，有线程安全问题
        List<Integer> sell = new Vector<>();
        for (int i = 0; i < 2000; i++) {
            Thread t = new Thread(() -> {
                int amount = ticket.sell(randomAmount());
                sell.add(amount);//记录一共卖出的票数
            });
            list.add(t);
            t.start();
        }
        //当所有买票线程结束后，统计买票总数和余票总数
        list.forEach((t)->{
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        log.debug("卖票总数：{}",sell.stream().mapToInt(c->c).sum());
        log.debug("剩余票数：{}",ticket.getCount());
    }
    //random本身为线程安全，不用加锁
    static Random random = new Random();
    public static int randomAmount(){
        return random.nextInt(5)+1;
    }
}
class Ticket{
    //出售票数
    private int count;

    public Ticket(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
    //买票
    public synchronized int sell(int amount){
        if(this.count >= amount){
            count -= amount;
            return amount;
        }else {
            return 0;
        }
    }
}
