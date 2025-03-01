package com.su.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServeSocketChannelDemo {
    public static void main(String[] args) throws Exception {
        //端口号
        int port = 8888;
        //buffer
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //ServeSocketChannel
        //1.开启
        ServerSocketChannel ssc = ServerSocketChannel.open();
        //绑定
        ssc.socket().bind(new InetSocketAddress(port));
        //设置非阻塞
        ssc.configureBlocking(false);
        //监听有新的连接传入
        while (true){
            System.out.println("等待连接");
            SocketChannel sc = ssc.accept();
            if(sc == null){
                //没有链接传入，在阻塞
                System.out.println("null");
                Thread.sleep(2000);
            }else {
                //有新连接传入
                System.out.println("传入的连接是："+sc.socket().getRemoteSocketAddress());
                buf.rewind();
                sc.write(buf);
                sc.close();
            }
        }
    }
}
