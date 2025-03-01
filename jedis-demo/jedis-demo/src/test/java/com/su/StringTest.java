package com.su;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.nio.channels.OverlappingFileLockException;

/**
 * redis测试
 */
public class StringTest{
    @Test
    public void init(){
        //初始化jedis
        Jedis jedis = new Jedis("192.168.66.102", 6379);
        String pong = jedis.ping();
        System.out.println(pong);
        jedis.set("k1","a");
        jedis.close();
    }

}

