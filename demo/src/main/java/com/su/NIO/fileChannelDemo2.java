package com.su.NIO;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class fileChannelDemo2 {
    public static void main(String[] args) throws Exception{
        RandomAccessFile aFile = new RandomAccessFile("E://b.txt","rw");
        FileChannel channel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(1024);
        String newDate = "date su";
        buf.clear();
        buf.put(newDate.getBytes());
        buf.flip();
        while (buf.hasRemaining()){
            channel.write(buf);
        }
        channel.close();
    }
}
