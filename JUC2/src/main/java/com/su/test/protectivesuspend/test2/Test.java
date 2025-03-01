package com.su.test.protectivesuspend.test2;

import lombok.extern.slf4j.Slf4j;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import static com.su.test.Utils.Sleeper.sleep;

@Slf4j(topic = "c.test")
public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new People().start();
        }
        sleep(1);
        for (Integer id : mailBox.getIds()) {
            new Postman(id,"内容"+id).start();
        }
    }
}

/**
 * 居民类
 */
@Slf4j(topic = "c.People")
class People extends Thread{
    @Override
    public void run(){
        //收信
        GuardObject guardObject = mailBox.createGuardObject();
        log.debug("开始收信 id :{}",guardObject.getId());
        Object mail = guardObject.get(5000);
        log.debug("收到信 id：{}，内容为：{}",guardObject.getId(),mail);
    }
}
/**
 * 邮递员
 */
@Slf4j(topic = "c.Postman")
class Postman extends Thread{
    //信盒id
    private int id;
    //信
    private String mail;
    public Postman(int id,String mail){
        this.id = id;
        this.mail = mail;
    }
    @Override
    public void run(){
        //送信
        GuardObject guardObject = mailBox.getGuardObject(id);
        log.debug("送信：id：{}，内容为：{}",guardObject.getId(),mail);
        guardObject.complete(mail);
    }
}
/**
 * 信箱类
 * 解耦发送方和接收方
 */
class mailBox{
    private static int id = 1;
    private static Map<Integer,GuardObject> boxes = new Hashtable<>();
    //返回唯一id;
    private static synchronized int generateId(){
        return id++;
    }
    //根据id获取对象
    public static GuardObject getGuardObject(int id){
        //消息用完之后就清除
        return boxes.remove(id);
    }
    public static GuardObject createGuardObject(){
        GuardObject go = new GuardObject(generateId());
        boxes.put(go.getId(),go);
        return go;
    }
    //获取ID集合
    public static Set<Integer> getIds(){
        return boxes.keySet();
    }
}

/**
 * 保护对象
 */
class GuardObject{
    private int id;

    public GuardObject(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    private Object response;
    //获取信件
    public Object get(long time){
        synchronized (this){
            //开始时间
            long begin = System.currentTimeMillis();
            //经历时间
            long passedTime = 0;
            while (response == null){
                //这一轮循环应该等待时间
                long waitTime = time - passedTime;
                if(waitTime <= 0){
                    break;//超时
                }
                try {
                    this.wait(waitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //计算经过时间
                passedTime = System.currentTimeMillis() - begin;
            }
            return response;
        }

    }
    //产生结果
    public void complete(Object response){
        synchronized (this){
            this.response = response;
            //唤醒
            this.notifyAll();
        }
    }
}
