package com.su.NIO;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class fileChannel {
    public static void main(String[] args) throws Exception {
        //创建fileChannel
        RandomAccessFile aFile = new RandomAccessFile("E://a.txt","rw");
        FileChannel channel = aFile.getChannel();
        //创建buffer
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //从channel中读数据到buffer中
        int byteRead = channel.read(buf);
        while (byteRead != -1){
            System.out.println("读取了："+byteRead);
            buf.flip();
            while (buf.hasRemaining()){
                System.out.println((char) buf.get());
            }
            buf.clear();
            byteRead = channel.read(buf);
        }
        System.out.println("结束");
    }
}
